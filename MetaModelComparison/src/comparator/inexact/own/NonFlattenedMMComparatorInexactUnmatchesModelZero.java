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
import java.util.Map.Entry;
import java.util.Optional;
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

public class NonFlattenedMMComparatorInexactUnmatchesModelZero extends MMComparator{
	private static String[] columns = {"Model", "Unmatches", "EClasses", "EAttributes", "EReferences", "ERest"};
	private Map<File, List<ENamedElement>> unmatchesLeft = new HashMap<File, List<ENamedElement>>();
	private Map<File, List<ENamedElement>> unmatchesRight = new HashMap<File, List<ENamedElement>>();
	
	public NonFlattenedMMComparatorInexactUnmatchesModelZero() throws IOException { 	
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
									EReference leftEReference = (EReference) leftENamedElement;
									EReference rightEReference = (EReference) rightENamedElement;
									
									if(inexactMatch(leftEReference.getName(), rightEReference.getName())
													&& inexactMatch(leftEReference.getEContainingClass().getName(), rightEReference.getEContainingClass().getName())){
										EClass domainLeft = leftEReference.getEReferenceType();
										EClass domainRight = rightEReference.getEReferenceType();
										if(domainLeft != null && domainRight != null
																		&& inexactMatch(domainLeft.getName(), domainRight.getName())){
											if(!matches.containsValue(rightEReference))
												matches.put(leftEReference, rightEReference);
										}
									}
								}
								else{
									if(leftENamedElement instanceof EAttribute && rightENamedElement instanceof EAttribute){
										EAttribute leftEAttribute = (EAttribute) leftENamedElement;
										EAttribute rightEAttribute = (EAttribute) rightENamedElement;
										
										if(inexactMatch(leftEAttribute.getName(), rightEAttribute.getName())
												&& inexactMatch(leftEAttribute.getEContainingClass().getName(), rightEAttribute.getEContainingClass().getName())){
											if(!matches.containsValue(rightEAttribute))
												matches.put(leftEAttribute, rightEAttribute);
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
		
		this.unmatchesLeft.put(file2, unmatchesLeft);
		this.unmatchesRight.put(file2, unmatchesRight);
	}
	
	@Override
	public void match() throws IOException {
		File mm000 = new File("ecores/000.ecore");
		
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		for(File mmControl : controlGroup){
			compare(mm000, mmControl);
		}
		
		List<File> experimentGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));
		for(File mmExperiment : experimentGroup){
			compare(mm000, mmExperiment);
		}
		
		generateStatsMatches();
		generateFilesMatches();
	}
	
	@Override
	protected void generateStatsMatches() throws IOException{
		Workbook workbook = new XSSFWorkbook();
		Sheet unmatchesLeftSheet = workbook.createSheet("unMatchesLeft");
		Sheet unmatchesRightSheet = workbook.createSheet("unMatchesRight");
		
		Font modelNameFont = workbook.createFont();
        modelNameFont.setBold(true);
        modelNameFont.setFontHeightInPoints((short) 12);
        modelNameFont.setColor(IndexedColors.BLACK.getIndex());
		
        CellStyle modelNameStyle = workbook.createCellStyle();
		modelNameStyle.setFillForegroundColor(IndexedColors.TAN.getIndex());
		modelNameStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		modelNameStyle.setFont(modelNameFont);
		
		// Create a Row
		Row headerRowLeft = unmatchesLeftSheet.createRow(0);
		// Create cells
		for(int i = 0; i < columns.length; i++) {
			Cell cell = headerRowLeft.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(modelNameStyle);
		}
		
		// Create a Row
		Row headerRowRight = unmatchesRightSheet.createRow(0);
		// Create cells
		for(int i = 0; i < columns.length; i++) {
			Cell cell = headerRowRight.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(modelNameStyle);
		}
		
		for(Entry<File, List<ENamedElement>> entry : this.unmatchesLeft.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			int rowNum = Optional.ofNullable(fileNameWithoutExtension).map(Ints::tryParse).orElse(0);
			List<ENamedElement> eObjects = entry.getValue();
			
			//// left
			Row rowLeft = unmatchesLeftSheet.createRow(rowNum);
			Cell modelNameCellLeft = rowLeft.createCell(0);
			modelNameCellLeft.setCellValue(entry.getKey().getName());
			modelNameCellLeft.setCellStyle(modelNameStyle);
			
			long countLeft = eObjects.stream().count();
			long countClassesLeft = eObjects.stream().filter(e -> e != null && e instanceof EClass).count();
			long countAttributesLeft = eObjects.stream().filter(e -> e != null && e instanceof EAttribute).count();
			long countReferencesLeft = eObjects.stream().filter(e -> e != null && e instanceof EReference).count();
			long countRestLeft = countLeft - countClassesLeft - countAttributesLeft - countReferencesLeft;
			
			rowLeft.createCell(1).setCellValue(countLeft);
			rowLeft.createCell(2).setCellValue(countClassesLeft);
			rowLeft.createCell(3).setCellValue(countAttributesLeft);
			rowLeft.createCell(4).setCellValue(countReferencesLeft);
			rowLeft.createCell(5).setCellValue(countRestLeft);
		}
		
		for(Entry<File, List<ENamedElement>> entry : this.unmatchesRight.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			int rowNum = Optional.ofNullable(fileNameWithoutExtension).map(Ints::tryParse).orElse(0);
			List<ENamedElement> eObjects = entry.getValue();
	        
	        //// right
			Row rowRight = unmatchesRightSheet.createRow(rowNum);
			Cell modelNameCellRight = rowRight.createCell(0);
			modelNameCellRight.setCellValue(entry.getKey().getName());
			modelNameCellRight.setCellStyle(modelNameStyle);
			
			long countRight = eObjects.stream().count();
			long countClassesRight = eObjects.stream().filter(e -> e != null && e instanceof EClass).count();
			long countAttributesRight = eObjects.stream().filter(e -> e != null && e instanceof EAttribute).count();
			long countReferencesRight = eObjects.stream().filter(e -> e != null && e instanceof EReference).count();
			long countRestRight = countRight - countClassesRight - countAttributesRight - countReferencesRight;
			
			rowRight.createCell(1).setCellValue(countRight);
			rowRight.createCell(2).setCellValue(countClassesRight);
			rowRight.createCell(3).setCellValue(countAttributesRight);
			rowRight.createCell(4).setCellValue(countReferencesRight);
			rowRight.createCell(5).setCellValue(countRestRight);
		}
		
        for(int i = 0; i < columns.length; i++) {
        	unmatchesLeftSheet.autoSizeColumn(i);
        	unmatchesRightSheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream("logs/inexact-nonflattened/stats/inexact-unmatches-model-zero.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	@Override
	protected void generateFilesMatches(){
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		for(Entry<File, List<ENamedElement>> entry : this.unmatchesLeft.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			Path file = Paths.get("logs/inexact-nonflattened/unmatches/" + fileNameWithoutExtension + "left" + ".txt");
			
			try {
				Map<EClass, List<EObject>> mapping = entry.getValue().stream().collect(Collectors.groupingBy(match -> match.eClass(), Collectors.toList()));
				
				for(Entry<EClass, List<EObject>> mapEObjects: mapping.entrySet()){
					List<StatMatchFlattened> lines = mapEObjects.getValue().stream().map(e -> new StatMatchFlattened(mapEObjects.getKey().getInstanceTypeName(), (ENamedElement) e, true)).collect(Collectors.toList());
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
		
		for(Entry<File, List<ENamedElement>> entry : this.unmatchesRight.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			Path file = Paths.get("logs/inexact-nonflattened/unmatches/" + fileNameWithoutExtension + "right" + ".txt");
			
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
		// TODO Auto-generated method stub
	}
}
