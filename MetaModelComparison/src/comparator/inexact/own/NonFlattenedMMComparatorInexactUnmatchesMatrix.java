package comparator.inexact.own;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.primitives.Ints;

import comparator.MMComparator;
import comparator.utils.Tuple;

public class NonFlattenedMMComparatorInexactUnmatchesMatrix extends MMComparator{
	private Map<Tuple<File, File>, List<ENamedElement>> unmatchesLeft = new HashMap<Tuple<File, File>, List<ENamedElement>>();
	private Map<Tuple<File, File>, List<ENamedElement>> unmatchesRight = new HashMap<Tuple<File, File>, List<ENamedElement>>();
	
	public NonFlattenedMMComparatorInexactUnmatchesMatrix() throws IOException {
		super();
	}
	
	@Override
	public void compare(File file1, File file2){
		Resource left = this.loadModel(file1, null);
		Resource right = this.loadModel(file2, null);
		
		List<ENamedElement> unmatchesLeft = new ArrayList<ENamedElement>();
		List<ENamedElement> unmatchesRight = new ArrayList<ENamedElement>();
		
		Map<ENamedElement, ENamedElement> matches = new HashMap<ENamedElement, ENamedElement>();
		
		TreeIterator<EObject> rightTreeIterator = right.getAllContents();
		rightTreeIterator.forEachRemaining(
			rightElement -> {
				if(rightElement instanceof ENamedElement && !(rightElement instanceof EPackage)){
					ENamedElement rightENamedElement = (ENamedElement) rightElement;
				
					TreeIterator<EObject> leftTreeIterator = left.getAllContents();
					leftTreeIterator.forEachRemaining(
						leftElement -> {
							if(leftElement instanceof ENamedElement && !(leftElement instanceof EPackage)){
								ENamedElement leftENamedElement = (ENamedElement) leftElement;
								if(leftENamedElement instanceof EReference && rightENamedElement instanceof EReference){
									EReference leftElementReference = (EReference) leftENamedElement;
									EReference rightElementReference = (EReference) rightENamedElement;
									
									if(inexactMatch(leftElementReference.getName(), rightElementReference.getName())
													&& inexactMatch(leftElementReference.getEContainingClass().getName(), rightElementReference.getEContainingClass().getName())){
										EClass domainLeft = leftElementReference.getEReferenceType();
										EClass domainRight = rightElementReference.getEReferenceType();
										if(domainLeft != null && domainRight != null
												&& inexactMatch(domainLeft.getName(), domainRight.getName())){
											if(!matches.containsValue(rightElementReference))
												matches.put(leftElementReference, rightElementReference);
										}
									}
								}
								else{
									if(leftENamedElement instanceof EAttribute && rightENamedElement instanceof EAttribute){
										EAttribute leftElementAttribute = (EAttribute) leftENamedElement;
										EAttribute rightElementAttribute = (EAttribute) rightENamedElement;
										
										if(inexactMatch(leftElementAttribute.getName(), rightElementAttribute.getName())
												&& inexactMatch(leftElementAttribute.getEContainingClass().getName(), rightElementAttribute.getEContainingClass().getName())){
											if(!matches.containsValue(rightElementAttribute))
												matches.put(leftElementAttribute, rightElementAttribute);
										}
									}
									else{
										if(!(leftENamedElement instanceof EStructuralFeature) && !(rightENamedElement instanceof EStructuralFeature)){
											if(inexactMatch(leftENamedElement.getName(), rightENamedElement.getName()) && leftENamedElement.getClass().getName().compareTo(rightENamedElement.getClass().getName()) == 0){
												if(!matches.containsValue(rightENamedElement))
													matches.put(leftENamedElement, rightENamedElement);
											}
										}
									}	
								}		
							}
						}
					);
				}
			}
		);
		
		List<ENamedElement> matchesLeft =new ArrayList<ENamedElement>(matches.keySet());
		TreeIterator<EObject> leftIterator = left.getAllContents();
		leftIterator.forEachRemaining(
			leftElement -> {
				if(leftElement instanceof ENamedElement && !(leftElement instanceof EPackage)){
					Optional<ENamedElement> optional = matchesLeft.stream()
			                .filter(e -> leftElement.equals(e))
			                .findFirst();
					
					if(!optional.isPresent()) {
						unmatchesRight.add((ENamedElement) leftElement);
					}
				}
			}
		);
		
		List<ENamedElement> matchesRight =new ArrayList<ENamedElement>(matches.values());
		TreeIterator<EObject> rightIterator = right.getAllContents();
		rightIterator.forEachRemaining(
			rightElement -> {
				if(rightElement instanceof ENamedElement && !(rightElement instanceof EPackage)){
					Optional<ENamedElement> optional = matchesRight.stream()
			                .filter(e -> rightElement.equals(e))
			                .findFirst();
					
					if(!optional.isPresent()) {
						unmatchesLeft.add((ENamedElement) rightElement);
					}
				}
			}
		);
		
		this.unmatchesLeft.put(new Tuple<File, File>(file1, file2), unmatchesLeft);
		this.unmatchesRight.put(new Tuple<File, File>(file1, file2), unmatchesRight);
	}
	
	@Override
	protected void generateStatsMatches() throws IOException{
		Workbook workbook = new XSSFWorkbook();
		Sheet unmatchesLeftSheet = workbook.createSheet("unMatchesLeft");
		Sheet unmatchesRightSheet = workbook.createSheet("unMatchesRight");
		
		Row rowHeaderLeftSheet = unmatchesLeftSheet.createRow(0);
		Row rowHeaderRightSheet = unmatchesRightSheet.createRow(0);
		
		Font modelNameFont = workbook.createFont();
	    modelNameFont.setBold(true);
	    modelNameFont.setFontHeightInPoints((short) 12);
	    modelNameFont.setColor(IndexedColors.BLACK.getIndex());
	    
		CellStyle modelNameStyle = workbook.createCellStyle();
		modelNameStyle.setFillForegroundColor(IndexedColors.TAN.getIndex());
		modelNameStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		modelNameStyle.setFont(modelNameFont);
		
	    CellStyle sameModelStyle = workbook.createCellStyle();
	    sameModelStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
	    sameModelStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
	    CellStyle notNeededModelStyle = workbook.createCellStyle();
	    notNeededModelStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	    notNeededModelStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
	    int maxRowLeft = 1;
	    int maxColumnLeft = 1;
	    
		for(Entry<Tuple<File, File>, List<ENamedElement>> entry : this.unmatchesLeft.entrySet()){
			Tuple<File, File> tuple = entry.getKey();
			List<ENamedElement> eObjects = entry.getValue();
			
			String fileNameX = FilenameUtils.removeExtension(tuple.x.getName());
			int rowNum = Optional.ofNullable(fileNameX).map(Ints::tryParse).orElse(0);
			
			String fileNameY = FilenameUtils.removeExtension(tuple.y.getName());
			int columnNum = Optional.ofNullable(fileNameY).map(Ints::tryParse).orElse(0);
			
			// left
			if(rowHeaderLeftSheet.getCell(columnNum) == null){
				Cell modelNameCell = rowHeaderLeftSheet.createCell(columnNum);
				modelNameCell.setCellValue(tuple.y.getName());
				modelNameCell.setCellStyle(modelNameStyle);
			}
			
			Row rowLeft = null;
			if(unmatchesLeftSheet.getRow(rowNum) == null) rowLeft = unmatchesLeftSheet.createRow(rowNum);
			else rowLeft = unmatchesLeftSheet.getRow(rowNum);
			
			if(rowLeft.getCell(0) == null){
				Cell modelNameCell = rowLeft.createCell(0);
				modelNameCell.setCellValue(tuple.x.getName());
				modelNameCell.setCellStyle(modelNameStyle);
			}
			
			long countLeft = eObjects.stream().count();
			rowLeft.createCell(columnNum).setCellValue(countLeft);
			
			if(rowNum > maxRowLeft) maxRowLeft = rowNum;
			if(columnNum > maxColumnLeft) maxColumnLeft = columnNum;
		}
		
		for(int i = 1; i <= maxRowLeft; i++){
			for(int j = 1; j <= maxColumnLeft; j++){
				if(i == j){
					Row rowLeft = null;
					if(unmatchesLeftSheet.getRow(i) == null) rowLeft = unmatchesLeftSheet.createRow(i);
					else rowLeft = unmatchesLeftSheet.getRow(i);
					rowLeft.createCell(j).setCellStyle(sameModelStyle);
				}
				else{
					if(i > j){
						Row rowLeft = null;
						if(unmatchesLeftSheet.getRow(i) == null) rowLeft = unmatchesLeftSheet.createRow(i);
						else rowLeft = unmatchesLeftSheet.getRow(i);
						rowLeft.createCell(j).setCellStyle(notNeededModelStyle);
					}
				}
			}
		}
		
		int maxRowRight = 1;
		int maxColumnRight = 1;
		
		for(Entry<Tuple<File, File>, List<ENamedElement>> entry : this.unmatchesRight.entrySet()){
			Tuple<File, File> tuple = entry.getKey();
			List<ENamedElement> eObjects = entry.getValue();
			
			String fileNameX = FilenameUtils.removeExtension(tuple.x.getName());
			int rowNum = Optional.ofNullable(fileNameX).map(Ints::tryParse).orElse(0);
			
			String fileNameY = FilenameUtils.removeExtension(tuple.y.getName());
			int columnNum = Optional.ofNullable(fileNameY).map(Ints::tryParse).orElse(0);
			
			// right
			if(rowHeaderRightSheet.getCell(columnNum) == null){
				Cell modelNameCell = rowHeaderRightSheet.createCell(columnNum);
				modelNameCell.setCellValue(tuple.y.getName());
				modelNameCell.setCellStyle(modelNameStyle);
			}
			
			Row rowRight = null;
			if(unmatchesRightSheet.getRow(rowNum) == null) rowRight = unmatchesRightSheet.createRow(rowNum);
			else rowRight = unmatchesRightSheet.getRow(rowNum);
			
			if(rowRight.getCell(0) == null){
				Cell modelNameCell = rowRight.createCell(0);
				modelNameCell.setCellValue(tuple.x.getName());
				modelNameCell.setCellStyle(modelNameStyle);
			}
			
			long countRight = eObjects.stream().count();
			rowRight.createCell(columnNum).setCellValue(countRight);
			
			if(rowNum > maxRowRight) maxRowRight = rowNum;
			if(columnNum > maxColumnRight) maxColumnRight = columnNum;
		}
		
		for(int i = 1; i <= maxRowRight; i++){
			for(int j = 1; j <= maxColumnRight; j++){
				if(i == j){					
					Row rowRight = null;
					if(unmatchesRightSheet.getRow(i) == null) rowRight = unmatchesRightSheet.createRow(i);
					else rowRight = unmatchesRightSheet.getRow(i);
					rowRight.createCell(j).setCellStyle(sameModelStyle);
				}
				else{
					if(i > j){
						Row rowRight = null;
						if(unmatchesRightSheet.getRow(i) == null) rowRight = unmatchesRightSheet.createRow(i);
						else rowRight = unmatchesRightSheet.getRow(i);
						rowRight.createCell(j).setCellStyle(notNeededModelStyle);
					}
				}
			}
		}
		
        FileOutputStream fileOut = new FileOutputStream("logs/inexact-nonflattened/stats/inexact-unmatches-matrix.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	@Override
	public void match() throws IOException {
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		List<File> experimentalGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));
		
		// control with control
		for(File x : controlGroup){
			for(File y : controlGroup){
				if(!y.equals(x) && x.getName().compareTo(y.getName()) < 0){
					compare(x, y);
				}
			}
					
			for(File y : experimentalGroup){
				compare(x, y);
			}
		}
		
		for(File x : experimentalGroup){
			for(File y : experimentalGroup){
				if(!y.equals(x) && x.getName().compareTo(y.getName()) < 0){
					compare(x, y);
				}
			}
		}
		
		generateStatsMatches();
		generateFilesMatches();
	}

	@Override
	protected void generateFilesMatches() throws IOException {
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		for(Entry<Tuple<File, File>, List<ENamedElement>> entry : this.unmatchesLeft.entrySet()){
			Tuple<File, File> tuple = entry.getKey();
			String fileNameX = FilenameUtils.removeExtension(tuple.x.getName());
			String fileNameY = FilenameUtils.removeExtension(tuple.y.getName());
			Path file = Paths.get("logs/inexact-nonflattened/unmatches-matrix/" + fileNameX + "-" + fileNameY + "-left" + ".txt");
			
			try {
				Map<EClass, List<EObject>> mapping = entry.getValue().stream().collect(Collectors.groupingBy(match -> match.eClass(), Collectors.toList()));
				
				for(Entry<EClass, List<EObject>> mapEObjects: mapping.entrySet()){
					List<StatMatchFlattened> lines = mapEObjects.getValue().stream().map(e -> new StatMatchFlattened(mapEObjects.getKey().getInstanceTypeName(), (ENamedElement) e, false)).collect(Collectors.toList());
					long counter = lines.stream().count();
					
					String[] info = {"####################", "Type: " + mapEObjects.getKey().getInstanceTypeName(), "Counter: " + counter, "####################", " "};
					Files.write(file, Arrays.asList(info), Charset.forName("UTF-8"), options);
					Files.write(file, lines.stream().map(e -> e.toString()).collect(Collectors.toList()), Charset.forName("UTF-8"), options);
					Files.write(file, Arrays.asList(), Charset.forName("UTF-8"), options);
				}	
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		for(Entry<Tuple<File, File>, List<ENamedElement>> entry : this.unmatchesRight.entrySet()){
			Tuple<File, File> tuple = entry.getKey();
			String fileNameX = FilenameUtils.removeExtension(tuple.x.getName());
			String fileNameY = FilenameUtils.removeExtension(tuple.y.getName());
			Path file = Paths.get("logs/inexact-nonflattened/unmatches-matrix/" + fileNameX + "-" + fileNameY + "-right" + ".txt");
			
			try {
				Map<EClass, List<EObject>> mapping = entry.getValue().stream().collect(Collectors.groupingBy(match -> match.eClass(), Collectors.toList()));
				
				for(Entry<EClass, List<EObject>> mapEObjects: mapping.entrySet()){
					List<StatMatchFlattened> lines = mapEObjects.getValue().stream().map(e -> new StatMatchFlattened(mapEObjects.getKey().getInstanceTypeName(), (ENamedElement) e, false)).collect(Collectors.toList());
					long counter = lines.stream().count();
					
					String[] info = {"####################", "Type: " + mapEObjects.getKey().getInstanceTypeName(), "Counter: " + counter, "####################", " "};
					Files.write(file, Arrays.asList(info), Charset.forName("UTF-8"), options);
					Files.write(file, lines.stream().map(e -> e.toString()).collect(Collectors.toList()), Charset.forName("UTF-8"), options);
					Files.write(file, Arrays.asList(), Charset.forName("UTF-8"), options);
				}	
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	protected void generateMatchEntry(File x, File y) throws IOException {		
	}
}
