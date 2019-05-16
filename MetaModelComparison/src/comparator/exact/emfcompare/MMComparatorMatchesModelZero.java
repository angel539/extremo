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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Optional;

import org.eclipse.emf.compare.*;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.primitives.Ints;

public class MMComparatorMatchesModelZero extends MMComparatorEMFCompare{
	private static String[] columns = {"Model", "Matches", "EClasses", "EAttributes", "EReferences", "ERest"};
	private Map<File, List<Match>> matchesPerModel = new HashMap<File, List<Match>>();
	
	public MMComparatorMatchesModelZero() throws IOException {
		super();
	}
	
	@Override
	protected void generateMatchEntry(File x, File y){
		List<Match> matches = getComparison().getMatches();
		List<Match> matchingEObjects = new ArrayList<Match>();
		
		for(Match match : matches){
			if(match.getLeft() != null && match.getRight() != null){
				if(!(match.getLeft() instanceof EPackage))
					matchingEObjects.add(match);
			}
				
			Iterable<Match> submatches = match.getAllSubmatches();

			submatches.forEach(
				e -> {
					if(e.getLeft() != null && e.getRight() != null){
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
		
		for(Entry<File, List<Match>> entry : this.matchesPerModel.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			int rowNum = Optional.ofNullable(fileNameWithoutExtension).map(Ints::tryParse).orElse(0);
			
			Row row = sheet.createRow(rowNum);
			Cell modelNameCell = row.createCell(0);
			modelNameCell.setCellValue(entry.getKey().getName());
			modelNameCell.setCellStyle(modelNameStyle);
			
			List<Match> eObjects = entry.getValue();
			long count = eObjects.size();
			long countClasses = eObjects.stream().filter(e -> e.getRight() instanceof EClass).count();
			long countAttributes = eObjects.stream().filter(e -> e.getRight() instanceof EAttribute).count();
			long countReferences = eObjects.stream().filter(e -> e.getRight() instanceof EReference).count();
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

        FileOutputStream fileOut = new FileOutputStream("logs/exact-emfcompare/stats/emf-compare-matching-model-zero.xlsx");
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
			Path file = Paths.get("logs/exact-emfcompare/matches/" + fileNameWithoutExtension + ".txt");
			
			try {
				Map<EClass, List<EObject>> mapping = entry.getValue().stream().collect(Collectors.groupingBy(match -> match.getRight().eClass(), Collectors.toList()));
				
				for(Entry<EClass, List<EObject>> mapEObjects: mapping.entrySet()){
					List<StatMatch> lines = mapEObjects.getValue().stream().map(e -> new StatMatch(mapEObjects.getKey().getInstanceTypeName(), (Match) e, false)).collect(Collectors.toList());
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
	public void match() throws IOException {
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
