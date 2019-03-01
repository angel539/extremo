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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

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

import comparator.exact.emfcompare.StatMatch;

import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;

public class FlattenedMMComparatorUnmatchesModelZero {
	private static String[] columns = {"Model", "Unmatches", "EClasses", "EAttributes", "EReferences", "ERest"};
	
	private Comparison comp;
	private Map<File, List<Match>> matchesPerModel = new HashMap<File, List<Match>>();
	
	public FlattenedMMComparatorUnmatchesModelZero() throws IOException { 	
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
	
	public void generateMatchEntry(File model){
		List<Match> matches = getComparison().getMatches();
		List<Match> matchingEObjects = new ArrayList<Match>();
		
		for(Match match : matches){
			if(match.getLeft() == null || match.getRight() == null){
				matchingEObjects.add(match);
			}
				
			Iterable<Match> submatches = match.getAllSubmatches();

			submatches.forEach(
				e -> {
					if(e.getLeft() == null || e.getRight() == null){
						matchingEObjects.add(e);
					}
				}
			);		
		}
		
		getMatchesPerModel().put(model, matchingEObjects);
	}

	public static void main(String[] args) throws IOException {
		FlattenedMMComparatorUnmatchesModelZero comparator = new FlattenedMMComparatorUnmatchesModelZero();
		Flattener flattener = new Flattener();
		
		File mm000 = new File("ecores/000.ecore");
		Resource rFlattened000 = flattener.flatten(mm000);
		
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		for(File mmControl : controlGroup){
			Resource rFlattenedMMControl = flattener.flatten(mmControl);
			comparator.compare(rFlattened000, rFlattenedMMControl);
			comparator.generateMatchEntry(mmControl);
		}
		
		List<File> experimentGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));
		for(File mmExperiment : experimentGroup){
			Resource rFlattenedMMExperiment = flattener.flatten(mmExperiment);
			comparator.compare(rFlattened000, rFlattenedMMExperiment);	
			comparator.generateMatchEntry(mmExperiment);
		}
		
		comparator.generateStatsMatches();
		comparator.generateFilesMatches();
	}
	
	public void generateStatsMatches() throws IOException{
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

        FileOutputStream fileOut = new FileOutputStream("logs/stats/short-stats-unmatches-flattened-model-zero.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	public void generateFilesMatches(){
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		for(Entry<File, List<Match>> entry : this.matchesPerModel.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			Path file = Paths.get("logs/unmatches-flattened/" + fileNameWithoutExtension + ".txt");
			
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
	
	public Map<File, List<Match>> getMatchesPerModel() {
		return matchesPerModel;
	}

	public void setMatchesPerModel(Map<File, List<Match>> matchesPerModel) {
		this.matchesPerModel = matchesPerModel;
	}
}
