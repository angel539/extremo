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
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.*;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.diff.IDiffProcessor;
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
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
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;

import com.google.common.primitives.Ints;

import comparator.utils.Tuple;

public class MMComparatorMatchesMatrix {
	private Comparison comp;
	private Map<Tuple<File, File>, List<Match>> matchesPerModel = new HashMap<Tuple<File, File>, List<Match>>();

	public MMComparatorMatchesMatrix() throws IOException { 	
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
	
	IDiffProcessor diffProcessor = new DiffBuilder() {
		@Override
		public void attributeChange(Match match, EAttribute attribute, Object value, DifferenceKind kind, DifferenceSource source) {
			if (attribute != EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE && attribute != EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL) {
				super.attributeChange(match, attribute, value, kind, source);
			}
		}
	};

	IDiffEngine diffEngine = new DefaultDiffEngine(diffProcessor) {
		@Override
		protected FeatureFilter createFeatureFilter() {
			return new FeatureFilter() {
				@Override
				protected boolean isIgnoredReference(Match match, EReference reference) {
					if(
							reference == EcorePackage.Literals.ECLASS__EOPERATIONS || 
							reference == EcorePackage.Literals.EOPERATION__EEXCEPTIONS ||
							reference == EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE || 
							reference == EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL
					){
						return true;
					}
					else return super.isIgnoredReference(match, reference);
				}
				
				@Override
				public boolean checkForOrderingChanges(EStructuralFeature feature) {
					return false;
				}
			};
		}
		
		@Override
		protected void computeSingleValuedAttributeDifferences(Match match, EAttribute attribute) {}
		@Override
		protected void computeMultiValuedFeatureDifferencesTwoWay(Match match, EStructuralFeature feature, boolean checkOrdering) {};
		@Override
		protected void computeSingleValuedReferenceDifferencesTwoWay(Match match, EReference reference) {};
		@Override
		protected void computeContainmentDifferencesTwoWay(Match match, EReference reference, boolean checkOrdering) {};
	};
	
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
		setComparison(EMFCompare.builder().setMatchEngineFactoryRegistry(registry).setDiffEngine(diffEngine).build().compare(scope));
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
	
	public void generateMatchEntry(File x, File y){
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
		
		getMatchesPerModel().put(new Tuple<File, File>(x, y), matchingEObjects);	
	}
	
	public void generateStatsMatches() throws IOException{
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
		
		for(Entry<Tuple<File, File>, List<Match>> entry : getMatchesPerModel().entrySet()){
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
			
			List<Match> eObjects = entry.getValue();
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

        FileOutputStream fileOut = new FileOutputStream("logs/exact-emfcompare/stats/short-stats-matches-matrix.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}
	
	public void generateFilesMatches(){
		OpenOption[] options = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
		
		for(Entry<Tuple<File, File>, List<Match>> entry : this.matchesPerModel.entrySet()){
			Tuple<File, File> tuple = entry.getKey();
			String fileNameX = FilenameUtils.removeExtension(tuple.x.getName());
			String fileNameY = FilenameUtils.removeExtension(tuple.y.getName());
			Path file = Paths.get("logs/exact-emfcompare/matches-matrix/" + fileNameX + "-" + fileNameY + ".txt");
			
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
	
	public Map<Tuple<File, File>, List<Match>> getMatchesPerModel() {
		return matchesPerModel;
	}

	public void setMatchesPerModel(Map<Tuple<File, File>, List<Match>> matchesPerModel) {
		this.matchesPerModel = matchesPerModel;
	}
	
	public static void main(String[] args) throws IOException {
		MMComparatorMatchesMatrix comparator = new MMComparatorMatchesMatrix();
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		List<File> experimentalGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));		
		
		// control with control
		for(File x : controlGroup){
			for(File y : controlGroup){
				if(!y.equals(x) && x.getName().compareTo(y.getName()) < 0){
					comparator.compare(x, y);
					comparator.generateMatchEntry(x, y);
				}
			}
			
			for(File y : experimentalGroup){
				comparator.compare(x, y);
				comparator.generateMatchEntry(x, y);
			}
		}
		
		for(File x : experimentalGroup){
			for(File y : experimentalGroup){
				if(!y.equals(x) && x.getName().compareTo(y.getName()) < 0){
					comparator.compare(x, y);
					comparator.generateMatchEntry(x, y);
				}
			}
		}
		
		comparator.generateStatsMatches();
		comparator.generateFilesMatches();
	}
}
