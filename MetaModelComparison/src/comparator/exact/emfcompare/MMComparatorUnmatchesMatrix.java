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
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.compare.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.primitives.Ints;

import comparator.utils.Tuple;

public class MMComparatorUnmatchesMatrix extends MMComparatorEMFCompare{
	private Map<Tuple<File, File>, List<Match>> matchesPerModel = new HashMap<Tuple<File, File>, List<Match>>();
	
	public MMComparatorUnmatchesMatrix() throws IOException {
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
		
		getMatchesPerModel().put(new Tuple<File, File>(x, y), matchingEObjects);
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
		
	    int maxRow = 1;
	    int maxColumn = 1;
	    
		for(Entry<Tuple<File, File>, List<Match>> entry : getMatchesPerModel().entrySet()){
			Tuple<File, File> tuple = entry.getKey();
			List<Match> eObjects = entry.getValue();
			
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
			
			long countLeft = eObjects.stream().filter(e -> e.getLeft() != null).count();
			rowLeft.createCell(columnNum).setCellValue(countLeft);
			
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
			
			long countRight = eObjects.stream().filter(e -> e.getRight() != null).count();
			rowRight.createCell(columnNum).setCellValue(countRight);
			
			if(rowNum > maxRow) maxRow = rowNum;
			if(columnNum > maxColumn) maxColumn = columnNum;
		}
		
		for(int i = 1; i <= maxRow; i++){
			for(int j = 1; j <= maxColumn; j++){
				if(i == j){
					Row rowLeft = null;
					if(unmatchesLeftSheet.getRow(i) == null) rowLeft = unmatchesLeftSheet.createRow(i);
					else rowLeft = unmatchesLeftSheet.getRow(i);
					rowLeft.createCell(j).setCellStyle(sameModelStyle);
					
					Row rowRight = null;
					if(unmatchesRightSheet.getRow(i) == null) rowRight = unmatchesRightSheet.createRow(i);
					else rowRight = unmatchesRightSheet.getRow(i);
					rowRight.createCell(j).setCellStyle(sameModelStyle);
				}
				else{
					if(i > j){
						Row rowLeft = null;
						if(unmatchesLeftSheet.getRow(i) == null) rowLeft = unmatchesLeftSheet.createRow(i);
						else rowLeft = unmatchesLeftSheet.getRow(i);
						rowLeft.createCell(j).setCellStyle(notNeededModelStyle);
						
						Row rowRight = null;
						if(unmatchesRightSheet.getRow(i) == null) rowRight = unmatchesRightSheet.createRow(i);
						else rowRight = unmatchesRightSheet.getRow(i);
						rowRight.createCell(j).setCellStyle(notNeededModelStyle);
					}
				}
			}
		}

        FileOutputStream fileOut = new FileOutputStream("logs/exact-emfcompare/stats/emf-compare-unmatches-matrix.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	@Override
	protected void generateFilesMatches(){
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		for(Entry<Tuple<File, File>, List<Match>> entry : this.matchesPerModel.entrySet()){
			Tuple<File, File> tuple = entry.getKey();
			String fileNameX = FilenameUtils.removeExtension(tuple.x.getName());
			String fileNameY = FilenameUtils.removeExtension(tuple.y.getName());
			Path file = Paths.get("logs/exact-emfcompare/unmatches-matrix/" + fileNameX + "-" + fileNameY + ".txt");
			
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
	
	public Map<Tuple<File, File>, List<Match>> getMatchesPerModel() {
		return matchesPerModel;
	}

	public void setMatchesPerModel(Map<Tuple<File, File>, List<Match>> matchesPerModel) {
		this.matchesPerModel = matchesPerModel;
	}
	
	public void match() throws IOException {
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		List<File> experimentalGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));
		
		// control with control
		for(File x : controlGroup){
			for(File y : controlGroup){
				if(!y.equals(x) && x.getName().compareTo(y.getName()) < 0){
					compare(x, y);
					generateMatchEntry(x, y);
				}
			}
					
			for(File y : experimentalGroup){
				compare(x, y);
				generateMatchEntry(x, y);
			}
		}
		
		for(File x : experimentalGroup){
			for(File y : experimentalGroup){
				if(!y.equals(x) && x.getName().compareTo(y.getName()) < 0){
					compare(x, y);
					generateMatchEntry(x, y);
				}
			}
		}
		
		generateStatsMatches();
		generateFilesMatches();
	}
}