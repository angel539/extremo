package comparator.exact.emfcompare;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

import org.eclipse.emf.compare.*;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.primitives.Ints;

public class MMComparatorUnmatchesModelZero extends MMComparatorEMFCompare{
	private static String[] columns = {"Model", "Unmatches", "EClasses", "EAttributes", "EReferences", "ERest"};
	private Map<File, List<Match>> matchesPerModel = new HashMap<File, List<Match>>();

	public MMComparatorUnmatchesModelZero() throws IOException {
		super();
	}
	
	@Override
	protected void generateMatchEntry(File x, File y){
		List<Match> matches = getComparison().getMatches();
		List<Match> matchingEObjects = new ArrayList<Match>();
		
		for(Match match : matches){
			if(match.getLeft() == null || match.getRight() == null){
				if(!(match.getLeft() instanceof EPackage))
					matchingEObjects.add(match);
			}
				
			Iterable<Match> submatches = match.getAllSubmatches();

			submatches.forEach(
				e -> {
					if(e.getLeft() == null || e.getRight() == null){
						if(!(e.getLeft() instanceof EPackage))
							matchingEObjects.add(e);
					}
				}
			);		
		}
		
		getMatchesPerModel().put(x, matchingEObjects);
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
		
		for(Entry<File, List<Match>> entry : this.matchesPerModel.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			int rowNum = Optional.ofNullable(fileNameWithoutExtension).map(Ints::tryParse).orElse(0);
			List<Match> eObjects = entry.getValue();
			
			//// left
			Row rowLeft = unmatchesLeftSheet.createRow(rowNum);
			Cell modelNameCellLeft = rowLeft.createCell(0);
			modelNameCellLeft.setCellValue(entry.getKey().getName());
			modelNameCellLeft.setCellStyle(modelNameStyle);
			
			long countLeft = eObjects.stream().filter(e -> e.getLeft() != null).count();
			long countClassesLeft = eObjects.stream().filter(e -> e.getLeft() != null && e.getLeft() instanceof EClass).count();
			long countAttributesLeft = eObjects.stream().filter(e -> e.getLeft() != null && e.getLeft() instanceof EAttribute).count();
			long countReferencesLeft = eObjects.stream().filter(e -> e.getLeft() != null && e.getLeft() instanceof EReference).count();
			long countRestLeft = countLeft - countClassesLeft - countAttributesLeft - countReferencesLeft;
			
			rowLeft.createCell(1).setCellValue(countLeft);
			rowLeft.createCell(2).setCellValue(countClassesLeft);
			rowLeft.createCell(3).setCellValue(countAttributesLeft);
			rowLeft.createCell(4).setCellValue(countReferencesLeft);
			rowLeft.createCell(5).setCellValue(countRestLeft);
	        
	        //// right
			Row rowRight = unmatchesRightSheet.createRow(rowNum);
			Cell modelNameCellRight = rowRight.createCell(0);
			modelNameCellRight.setCellValue(entry.getKey().getName());
			modelNameCellRight.setCellStyle(modelNameStyle);	
			
			long countRight = eObjects.stream().filter(e -> e.getRight() != null).count();
			long countClassesRight = eObjects.stream().filter(e -> e.getRight() != null && e.getRight() instanceof EClass).count();
			long countAttributesRight = eObjects.stream().filter(e -> e.getRight() != null && e.getRight() instanceof EAttribute).count();
			System.out.println(fileNameWithoutExtension + " " + eObjects.stream().filter(e -> e.getRight() != null && e.getRight() instanceof EAttribute).collect(Collectors.toList()));
			long countReferencesRight = eObjects.stream().filter(e -> e.getRight() != null && e.getRight() instanceof EReference).count();
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

        FileOutputStream fileOut = new FileOutputStream("logs/exact-emfcompare/stats/emf-compare-unmatches-model-zero.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	@Override
	protected void generateFilesMatches(){
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		for(Entry<File, List<Match>> entry : this.matchesPerModel.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			Path file = Paths.get("logs/exact-emfcompare/unmatches/" + fileNameWithoutExtension + ".txt");
			
			try {
				Map<EClass, List<Match>> mappingLeftNotNull = entry.getValue().stream().filter(matchFiltered -> matchFiltered.getLeft() != null).
						collect(Collectors.groupingBy(match -> match.getLeft().eClass(), Collectors.toList()));
				
				Map<EClass, List<Match>> mappingRightNotNull = entry.getValue().stream().filter(matchFiltered -> matchFiltered.getRight() != null).
																			collect(Collectors.groupingBy(match -> match.getRight().eClass(), Collectors.toList()));
				
				Map<EClass, List<Match>> mapping = Stream.of(mappingLeftNotNull, mappingRightNotNull)
				        .map(Map::entrySet)          // converts each map into an entry set
				        .flatMap(Collection::stream) // converts each set into an entry stream, then
				        .collect(
				            Collectors.toMap(        // collects into a map
				                Map.Entry::getKey,   // where each entry is based
				                Map.Entry::getValue,
				                (k1, k2) -> k1
				            )
				        );
				
				for(Entry<EClass, List<Match>> mapEObjects: mapping.entrySet()){
					List<StatMatch> lines = mapEObjects.getValue().stream().map(e -> new StatMatch(mapEObjects.getKey().getInstanceTypeName(), (Match) e, true)).collect(Collectors.toList());
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
	
	public Map<File, List<Match>> getMatchesPerModel() {
		return matchesPerModel;
	}

	public void setMatchesPerModel(Map<File, List<Match>> matchesPerModel) {
		this.matchesPerModel = matchesPerModel;
	}
	
	@Override
	public void match() throws IOException{
		File mm000 = new File("ecores/000.ecore");
		
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		for(File mmControl : controlGroup){
			compare(mm000, mmControl);
			generateMatchEntry(mmControl, null);
		}
		
		List<File> experimentGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));
		for(File mmExperiment : experimentGroup){
			compare(mm000, mmExperiment);	
			generateMatchEntry(mmExperiment, null);
		}
		
		generateStatsMatches();
		generateFilesMatches();
	}
}
