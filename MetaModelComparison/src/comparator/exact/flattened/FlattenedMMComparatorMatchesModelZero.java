package comparator.exact.flattened;

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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.*;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.eobject.IdentifierEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.*;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.xmi.impl.*;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.xml.XMLLayout;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.base.Function;
import com.google.common.primitives.Ints;

import comparator.exact.flattened.StatMatchFlattened;

import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;

public class FlattenedMMComparatorMatchesModelZero {
	private static String[] columns = {"Model", "Matches", "EClasses", "EAttributes", "EReferences", "ERest"};
	
	private Comparison comp;
	//private Map<File, List<Match>> matchesPerModel = new HashMap<File, List<Match>>();
	private Map<File, Map<ENamedElement, ENamedElement>> matchesPerModel = new HashMap<File, Map<ENamedElement, ENamedElement>>();
	
	public FlattenedMMComparatorMatchesModelZero() throws IOException { 	
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		BasicConfigurator.configure(new FileAppender(new XMLLayout(), "log.xml"));
	}
	
	Function<EObject, String> idFunction = new Function<EObject, String>() {
		public String apply(EObject input) {
			if(input instanceof ENamedElement){
				return ((ENamedElement) input).getName();
			}
			return null;
		}
	};
	
	public void compare (String mm1, String mm2) {
		Resource ecore1 = this.loadModel(new File(mm1), null);
		Resource ecore2 = this.loadModel(new File(mm2), null);
		
		IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(fallBackMatcher, idFunction);
		
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
		
		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(customIDMatcher, comparisonFactory);
		matchEngineFactory.setRanking(50);
		registry.add(matchEngineFactory);
		
		IComparisonScope scope = new DefaultComparisonScope(ecore1, ecore2, null);
		setComparison(EMFCompare.builder().setMatchEngineFactoryRegistry(registry).build().compare(scope));
	}
	
	public void compare (File mm1, File mm2) {
		Resource ecore1 = this.loadModel(mm1, null);
		Resource ecore2 = this.loadModel(mm2, null);
		
		IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(fallBackMatcher, idFunction);
		
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
		
		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(customIDMatcher, comparisonFactory);
		matchEngineFactory.setRanking(50);
		registry.add(matchEngineFactory);
		
		IComparisonScope scope = new DefaultComparisonScope(ecore1, ecore2, null);
		setComparison(EMFCompare.builder().setMatchEngineFactoryRegistry(registry).build().compare(scope));
	}
	
	public void compare (Resource r1, Resource r2){
		IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(fallBackMatcher, idFunction);
		
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
		
		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(customIDMatcher, comparisonFactory);
		matchEngineFactory.setRanking(50);
		registry.add(matchEngineFactory);
		
		IComparisonScope scope = new DefaultComparisonScope(r1, r2, null);
		setComparison(EMFCompare.builder().setMatchEngineFactoryRegistry(registry).build().compare(scope));
	}
	
	public Map<ENamedElement, ENamedElement> simpleComparisonFlattened(Resource left, Resource right){
		Map<ENamedElement, ENamedElement> matches = new HashMap<ENamedElement, ENamedElement>();
		
		TreeIterator<EObject> rightTreeIterator = right.getAllContents();
		rightTreeIterator.forEachRemaining(
			rightElement -> {
				if(rightElement instanceof ENamedElement && !(rightElement instanceof EPackage)){
					ENamedElement rightElementEClass = (ENamedElement) rightElement;
				
					TreeIterator<EObject> leftTreeIterator = left.getAllContents();
					leftTreeIterator.forEachRemaining(
						leftElement -> {
							if(leftElement instanceof ENamedElement && !(leftElement instanceof EPackage)){
								ENamedElement leftElementEClass = (ENamedElement) leftElement;
								
								if((leftElementEClass.getName().compareTo(rightElementEClass.getName()) == 0) 
										&& (leftElementEClass.eClass().getInstanceTypeName().compareTo(rightElementEClass.eClass().getInstanceTypeName()) == 0)){
									matches.put(leftElementEClass, rightElementEClass);
								}
							}
						}
					);
				}
			}
		);
		
		return matches;
	}
	
	private Resource loadModel(File model, EPackage p) {		
		URI uri = URI.createFileURI(model.getPath());
		ResourceSet rs = new ResourceSetImpl();
		if (p!=null) {
			rs.getPackageRegistry().put(p.getNsURI(), p);
		}
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
		Resource resource = rs.getResource(uri, true);
		return resource;
	}
	
	/*public void generateMatchEntry(File model){
		List<Match> matches = getComparison().getMatches();
		List<Match> matchingEObjects = new ArrayList<Match>();
		
		for(Match match : matches){
			if(match.getLeft() != null && match.getRight() != null){
				matchingEObjects.add(match);
			}
				
			Iterable<Match> submatches = match.getAllSubmatches();

			submatches.forEach(
				e -> {
					if(e.getLeft() != null && e.getRight() != null){
						matchingEObjects.add(e);
					}
				}
			);		
		}
		
		getMatchesPerModel().put(model, matchingEObjects);
	}*/


	public static void main(String[] args) throws IOException {
		FlattenedMMComparatorMatchesModelZero comparator = new FlattenedMMComparatorMatchesModelZero();
		
		Flattener flattener = new Flattener();
		File mm000 = new File("ecores/000.ecore");
		Resource rFlattened000 = flattener.flatten(mm000);
		
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		for(File mmControl : controlGroup){
			Resource rFlattenedMMControl = flattener.flatten(mmControl);
			Map<ENamedElement, ENamedElement> matches = comparator.simpleComparisonFlattened(rFlattened000, rFlattenedMMControl);
			comparator.getMatchesPerModel().put(mmControl, matches);
			//comparator.compare(rFlattened000, rFlattenedMMControl);
			//comparator.generateMatchEntryFlattened(mmControl);
		}
		
		List<File> experimentGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));
		for(File mmExperiment : experimentGroup){
			Resource rFlattenedMMExperiment = flattener.flatten(mmExperiment);
			Map<ENamedElement, ENamedElement> matches = comparator.simpleComparisonFlattened(rFlattened000, rFlattenedMMExperiment);
			comparator.getMatchesPerModel().put(mmExperiment, matches);
			//comparator.compare(rFlattened000, rFlattenedMMExperiment);
			//comparator.generateMatchEntry(mmExperiment);
		}
		
		comparator.generateStatsMatchesFlattened();
		comparator.generateFilesMatchesFlattened();
	}
	
	public void generateStatsMatchesFlattened() throws IOException{
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
			List<ENamedElement> keySet = new ArrayList<ENamedElement>(eObjects.keySet());
			
			long count = keySet.size();
			long countClasses = keySet.stream().filter(e -> e instanceof EClass).count();
			long countAttributes = keySet.stream().filter(e -> e instanceof EAttribute).count();
			long countReferences = keySet.stream().filter(e -> e instanceof EReference).count();
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

        FileOutputStream fileOut = new FileOutputStream("logs/stats/short-stats-flattened-model-zero.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	public void generateFilesMatchesFlattened(){
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		
		for(Entry<File, Map<ENamedElement, ENamedElement>> entry : this.matchesPerModel.entrySet()){
			Map<ENamedElement, ENamedElement> eObjects = entry.getValue();
			List<ENamedElement> keySet = new ArrayList<ENamedElement>(eObjects.keySet());
			
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			Path file = Paths.get("logs/matches-flattened/" + fileNameWithoutExtension + ".txt");
			
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
	
	/*public void generateStatsMatches() throws IOException{
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
		
		Row headerRow = sheet.createRow(0);
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

        FileOutputStream fileOut = new FileOutputStream("logs/stats/short-stats-flattened-model-zero.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
	}*/
	
	/*public void generateFilesMatches(){
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		for(Entry<File, List<Match>> entry : this.matchesPerModel.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			Path file = Paths.get("logs/matches-flattened/" + fileNameWithoutExtension + ".txt");
			
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
	}*/
	
	private static List<File> getFilesForFolder(final File folder) {
		List<File> files = new ArrayList<File>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				files.addAll(getFilesForFolder(fileEntry));
			}
			else {
				if(fileEntry.getName().endsWith(".ecore"))
					files.add(fileEntry);
			}
		}
		
		return files;
	}

	public Comparison getComparison() {
		return comp;
	}

	public void setComparison(Comparison comp) {
		this.comp = comp;
	}
	
	public Map<File, Map<ENamedElement, ENamedElement>> getMatchesPerModel() {
		return matchesPerModel;
	}

	public void setMatchesPerModel(Map<File, Map<ENamedElement, ENamedElement>> matchesPerModel) {
		this.matchesPerModel = matchesPerModel;
	}
}
