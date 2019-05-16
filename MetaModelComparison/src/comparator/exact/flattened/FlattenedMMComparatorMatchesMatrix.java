package comparator.exact.flattened;

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

public class FlattenedMMComparatorMatchesMatrix extends MMComparator{
	public FlattenedMMComparatorMatchesMatrix() throws IOException {
		super();
	}
	
	private Map<Tuple<File, File>, Map<ENamedElement, ENamedElement>> matchesPerModel = new HashMap<Tuple<File, File>, Map<ENamedElement, ENamedElement>>();
	
	@Override
	public void compare(File file1, File file2){
		Resource left = this.loadModel(file1, null);
		Resource right = this.loadModel(file2, null);
		
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
									EReference leftEReference = (EReference) leftENamedElement;
									EReference rightEReference = (EReference) rightENamedElement;
									
									if((leftEReference.getName().compareTo(rightEReference.getName()) == 0)
														&& (leftEReference.getEContainingClass().getName().compareTo(rightEReference.getEContainingClass().getName()) == 0)){
										EClass domainLeft = leftEReference.getEReferenceType();
										EClass domainRight = rightEReference.getEReferenceType();
										if(domainLeft != null && domainRight != null
												&& domainLeft.getName().compareTo(domainRight.getName()) == 0){
											if(!matches.containsValue(rightEReference))
												matches.put(leftEReference, rightEReference);
										}
									}
								}
								else{
									if(leftENamedElement instanceof EAttribute && rightENamedElement instanceof EAttribute){
										EAttribute leftElementAttribute = (EAttribute) leftENamedElement;
										EAttribute rightElementAttribute = (EAttribute) rightENamedElement;
										
										if((leftElementAttribute.getName().compareTo(rightElementAttribute.getName()) == 0) 
														&& (leftElementAttribute.getEContainingClass().getName().compareTo(rightElementAttribute.getEContainingClass().getName()) == 0)){
											if(!matches.containsValue(rightElementAttribute))
												matches.put(leftElementAttribute, rightElementAttribute);
										}
									}
									else{
										if(!(leftENamedElement instanceof EStructuralFeature) && !(rightENamedElement instanceof EStructuralFeature)){
											if(leftENamedElement.getName().compareTo(rightENamedElement.getName()) == 0 && leftENamedElement.getClass().getName().compareTo(rightENamedElement.getClass().getName()) == 0){
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
		
		this.matchesPerModel.put(new Tuple<File, File>(file1, file2), matches);
	}
	
	@Override
	protected void generateStatsMatches() throws IOException{
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("mmComparison");
		
		Row rowHeader = sheet.createRow(0);
		
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
	    
	    int maxRow = 1;
	    int maxColumn = 1;
		
		for(Entry<Tuple<File, File>, Map<ENamedElement, ENamedElement>> entry : getMatchesPerModel().entrySet()){
			Tuple<File, File> tuple = entry.getKey();
			
			String fileNameX = FilenameUtils.removeExtension(tuple.x.getName());
			int rowNum = Optional.ofNullable(fileNameX).map(Ints::tryParse).orElse(0);
			
			String fileNameY = FilenameUtils.removeExtension(tuple.y.getName());
			int columnNum = Optional.ofNullable(fileNameY).map(Ints::tryParse).orElse(0);
			
			if(rowHeader.getCell(columnNum) == null){
				Cell modelNameCell = rowHeader.createCell(columnNum);
				modelNameCell.setCellValue(tuple.y.getName());
				modelNameCell.setCellStyle(modelNameStyle);
			}
			
			Row row = null;
			if(sheet.getRow(rowNum) == null) row = sheet.createRow(rowNum);
			else row = sheet.getRow(rowNum);
			
			Cell modelNameCell = row.createCell(0);
			modelNameCell.setCellValue(tuple.x.getName());
			modelNameCell.setCellStyle(modelNameStyle);
			
			List<ENamedElement> eObjects = new ArrayList<ENamedElement>(entry.getValue().keySet());
			long count = eObjects.size();
			row.createCell(columnNum).setCellValue(count);
			
			if(rowNum > maxRow) maxRow = rowNum;
			if(columnNum > maxColumn) maxColumn = columnNum;
		}
		
		for(int i = 1; i <= maxRow; i++){
			for(int j = 1; j <= maxColumn; j++){
				if(i == j){
					Row row = null;
					if(sheet.getRow(i) == null) row = sheet.createRow(i);
					else row = sheet.getRow(i);
					row.createCell(j).setCellStyle(sameModelStyle);
				}
				else{
					if(i > j){
						Row row = null;
						if(sheet.getRow(i) == null) row = sheet.createRow(i);
						else row = sheet.getRow(i);
						row.createCell(j).setCellStyle(notNeededModelStyle);
					}
				}
			}
		}

        FileOutputStream fileOut = new FileOutputStream("logs/exact-flattened/stats/exact-flattened-matches-matrix.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	@Override
	public void match() throws IOException {
		List<File> flattenedModelsX = getFilesForFolder(new File("ecores/flattened/"));
		List<File> flattenedModelsY = getFilesForFolder(new File("ecores/flattened/"));
		
		for(File x : flattenedModelsX) {
			if(x.getName().compareTo("000.ecore") != 0){
				for(File y : flattenedModelsY) {
					if(y.getName().compareTo("000.ecore") != 0){
						if(!y.equals(x) && x.getName().compareTo(y.getName()) < 0){
							compare(x, y);
						}
					}
				}
			}
		}
		
		generateStatsMatches();
		generateFilesMatches();
	}
	
	
	public Map<Tuple<File, File>, Map<ENamedElement, ENamedElement>> getMatchesPerModel() {
		return matchesPerModel;
	}

	public void setMatchesPerModel(Map<Tuple<File, File>, Map<ENamedElement, ENamedElement>> matchesPerModel) {
		this.matchesPerModel = matchesPerModel;
	}

	@Override
	protected void generateFilesMatches() throws IOException {
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		for(Entry<Tuple<File, File>, Map<ENamedElement, ENamedElement>> entry : this.matchesPerModel.entrySet()){
			Tuple<File, File> tuple = entry.getKey();
			String fileNameX = FilenameUtils.removeExtension(tuple.x.getName());
			String fileNameY = FilenameUtils.removeExtension(tuple.y.getName());
			Path file = Paths.get("logs/exact-flattened/matches-matrix/" + fileNameX + "-" + fileNameY + ".txt");
			
			try {
				Map<EClass, List<EObject>> mapping = entry.getValue().keySet().stream().collect(Collectors.groupingBy(match -> match.eClass(), Collectors.toList()));
				
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
