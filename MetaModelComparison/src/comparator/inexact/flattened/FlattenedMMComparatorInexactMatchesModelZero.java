package comparator.inexact.flattened;

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

public class FlattenedMMComparatorInexactMatchesModelZero extends MMComparator{
	private static String[] columns = {"Model", "Matches", "EClasses", "EAttributes", "EReferences", "ERest"};
	private Map<File, Map<ENamedElement, ENamedElement>> matchesPerModel = new HashMap<File, Map<ENamedElement, ENamedElement>>();
	
	public FlattenedMMComparatorInexactMatchesModelZero() throws IOException {
		super();
	}
	
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
		
		this.matchesPerModel.put(file2, matches);
	}

	
	@Override
	protected void generateStatsMatches() throws IOException{
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("mmComparison");
		
		Font modelNameFont = workbook.createFont();
        modelNameFont.setBold(true);
        modelNameFont.setFontHeightInPoints((short) 12);
        modelNameFont.setColor(IndexedColors.BLACK.getIndex());
		
        CellStyle modelNameStyle = workbook.createCellStyle();
		modelNameStyle.setFillForegroundColor(IndexedColors.TAN.getIndex());
		modelNameStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		modelNameStyle.setFont(modelNameFont);
		
		// Create a Row
		Row headerRow = sheet.createRow(0);
		// Create cells
		for(int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(modelNameStyle);
		}
		
		for(Entry<File, Map<ENamedElement, ENamedElement>> entry : this.matchesPerModel.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			int rowNum = Optional.ofNullable(fileNameWithoutExtension).map(Ints::tryParse).orElse(0);
			
			Row row = sheet.createRow(rowNum);
			Cell modelNameCell = row.createCell(0);
			modelNameCell.setCellValue(entry.getKey().getName());
			modelNameCell.setCellStyle(modelNameStyle);
			
			Map<ENamedElement, ENamedElement> eObjects = entry.getValue();
			List<ENamedElement> valueSet = new ArrayList<ENamedElement>(eObjects.values()); // matches on the right
			
			long count = valueSet.size();
			long countClasses = valueSet.stream().filter(e -> e instanceof EClass).count();
			long countAttributes = valueSet.stream().filter(e -> e instanceof EAttribute).count();
			long countReferences = valueSet.stream().filter(e -> e instanceof EReference).count();
			long countRest = count - countClasses - countAttributes - countReferences;
			
			row.createCell(1).setCellValue(count);
	        row.createCell(2).setCellValue(countClasses);
	        row.createCell(3).setCellValue(countAttributes);
	        row.createCell(4).setCellValue(countReferences);
	        row.createCell(5).setCellValue(countRest);
		}
		
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream("logs/inexact-flattened/stats/inexact-flattened-model-zero.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	@Override
	protected void generateFilesMatches(){
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		
		for(Entry<File, Map<ENamedElement, ENamedElement>> entry : this.matchesPerModel.entrySet()){
			Map<ENamedElement, ENamedElement> eObjects = entry.getValue();
			List<ENamedElement> keySet = new ArrayList<ENamedElement>(eObjects.keySet());
			
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			Path file = Paths.get("logs/inexact-flattened/matches/" + fileNameWithoutExtension + ".txt");
			
			try {
				Map<EClass, List<EObject>> mapping = keySet.stream().collect(Collectors.groupingBy(match -> match.eClass(), Collectors.toList()));
				
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
	public void match() throws IOException {
		File mm000 = new File("ecores/flattened/000.ecore");
		
		List<File> flattenedModels = getFilesForFolder(new File("ecores/flattened/"));
		for(File flattenedModel : flattenedModels){
			if(!flattenedModel.equals(mm000)) compare(mm000, flattenedModel);
		}
		
		generateStatsMatches();
		generateFilesMatches();
	}
	
	
	public Map<File, Map<ENamedElement, ENamedElement>> getMatchesPerModel() {
		return matchesPerModel;
	}

	public void setMatchesPerModel(Map<File, Map<ENamedElement, ENamedElement>> matchesPerModel) {
		this.matchesPerModel = matchesPerModel;
	}

	@Override
	protected void generateMatchEntry(File x, File y) throws IOException{}
}
