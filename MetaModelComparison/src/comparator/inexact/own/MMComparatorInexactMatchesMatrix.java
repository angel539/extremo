package comparator.inexact.own;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

public class MMComparatorInexactMatchesMatrix {
	private Comparison comp;

	public MMComparatorInexactMatchesMatrix() throws IOException { 	
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
	
	IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
	IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(fallBackMatcher, idFunction);
	
	IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
	IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
	
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

	public void compare (String mm1, String mm2) {
		Resource ecore1 = this.loadModel(new File(mm1), null);
		Resource ecore2 = this.loadModel(new File(mm2), null);
		
		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(customIDMatcher, comparisonFactory);
		matchEngineFactory.setRanking(50);
		registry.add(matchEngineFactory);

		IComparisonScope scope = new DefaultComparisonScope(ecore1, ecore2, null);
		this.comp = EMFCompare.builder().setDiffEngine(diffEngine).setMatchEngineFactoryRegistry(registry).build().compare(scope);
	}
	
	public void compare (File mm1, File mm2) {
		Resource ecore1 = this.loadModel(mm1, null);
		Resource ecore2 = this.loadModel(mm2, null);
		
		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(customIDMatcher, comparisonFactory);
		matchEngineFactory.setRanking(50);
		registry.add(matchEngineFactory);
		
		IComparisonScope scope = new DefaultComparisonScope(ecore1, ecore2, null);
		this.comp = EMFCompare.builder().setDiffEngine(diffEngine).setMatchEngineFactoryRegistry(registry).build().compare(scope);
	}
	
	public boolean areEqual() {
		return this.comp.getDifferences().size() == 0;
	}
	
	@Override
	public String toString() {
		String res = "";
		for (Diff f : this.comp.getDifferences()) 
			res += f.toString();
		
		return res;
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

	public static void main(String[] args) throws IOException {
		MMComparatorInexactMatchesMatrix comparator = new MMComparatorInexactMatchesMatrix();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("mmMatrixComparison");
		
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		List<File> experimentalGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));
		
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
        
		// control with control
		for(File x : controlGroup){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(x.getName());
			int rowNum = Optional.ofNullable(fileNameWithoutExtension).map(Ints::tryParse).orElse(0);
			Row row = sheet.createRow(rowNum);
			
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(x.getName());
			cell0.setCellStyle(modelNameStyle);
			
			Cell cell0RowHeader = rowHeader.createCell(rowNum);
			cell0RowHeader.setCellValue(x.getName());
			cell0RowHeader.setCellStyle(modelNameStyle);
			
			for(File y : controlGroup){
				if(!y.equals(x) && x.getName().compareTo(y.getName()) < 0){
					comparator.compare(x, y);
					comparator.shortStatsMatches(sheet, x, y, row);
				}
				else{
					String yFileNameWithoutExtension = FilenameUtils.removeExtension(y.getName());
					int cellNum = Optional.ofNullable(yFileNameWithoutExtension).map(Ints::tryParse).orElse(0);
					row.createCell(cellNum).setCellStyle(sameModelStyle);
				}
			}
			
			for(File y : experimentalGroup){
				comparator.compare(x, y);
				comparator.shortStatsMatches(sheet, x, y, row);
			}
		}
		
		for(File x : experimentalGroup){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(x.getName());
			int rowNum = Optional.ofNullable(fileNameWithoutExtension).map(Ints::tryParse).orElse(0);
			Row row = sheet.createRow(rowNum);
			
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(x.getName());
			cell0.setCellStyle(modelNameStyle);
			
			Cell cell0RowHeader = rowHeader.createCell(rowNum);
			cell0RowHeader.setCellValue(x.getName());
			cell0RowHeader.setCellStyle(modelNameStyle);
			
			for(File y : experimentalGroup){
				if(!y.equals(x) && x.getName().compareTo(y.getName()) < 0){
					comparator.compare(x, y);
					comparator.shortStatsMatches(sheet, x, y, row);
				}
				else{
					String yFileNameWithoutExtension = FilenameUtils.removeExtension(y.getName());
					int cellNum = Optional.ofNullable(yFileNameWithoutExtension).map(Ints::tryParse).orElse(0);
					
					if(y.equals(x)){
						row.createCell(cellNum).setCellStyle(sameModelStyle);
					}
					else{
						row.createCell(cellNum).setCellStyle(notNeededModelStyle);
					}
				}
			}
			
			for(File y : controlGroup){
				String yFileNameWithoutExtension = FilenameUtils.removeExtension(y.getName());
				int cellNum = Optional.ofNullable(yFileNameWithoutExtension).map(Ints::tryParse).orElse(0);
				row.createCell(cellNum).setCellStyle(notNeededModelStyle);
			}
		}
		
        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("short-stats-matches-matrix.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
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
	
	public void shortStatsMatches(Sheet sheet, File x, File y, Row row){
		List<String> eClasses = new ArrayList<String>();
		List<String> eAttributes = new ArrayList<String>();
		List<String> eReferences = new ArrayList<String>();
		List<String> eRest = new ArrayList<String>();
		
		List<Match> matches = this.comp.getMatches();
		for(Match match : matches){
			if(match.getLeft() != null && match.getRight() != null){
				if(match.getLeft() instanceof EClass){
					eClasses.add("left: " + match.getLeft() + " <--> " + " right: " + match.getRight());
				}
				else{
					if(match.getLeft() instanceof EAttribute){
						eAttributes.add("left: " + match.getLeft() + " <--> " + " right: " + match.getRight());
					}
					else{
						if(match.getLeft() instanceof EReference){
							eReferences.add("left: " + match.getLeft() + " <--> " + " right: " + match.getRight());
						}
						else{
							eRest.add("left: " + match.getLeft() + " <--> " + " right: " + match.getRight());
						}
					}
				}
			}
				
			
			Iterable<Match> submatches = match.getAllSubmatches();
			submatches.forEach(
				e -> {
					if(e.getLeft() != null && e.getRight() != null){
						if(e.getLeft() instanceof EClass){
							eClasses.add("left: " + e.getLeft() + " <--> " + " right: " + e.getRight());
						}
						else{
							if(e.getLeft() instanceof EAttribute){
								eAttributes.add("left: " + e.getLeft() + " <--> " + " right: " + e.getRight());
							}
							else{
								if(e.getLeft() instanceof EReference){
									eReferences.add("left: " + e.getLeft() + " <--> " + " right: " + e.getRight());
								}
								else{
									eRest.add("left: " + e.getLeft() + " <--> " + " right: " + e.getRight());
								}
							}
						}
					}
				}
			);			
		}
		
		int sizeEClasses = eClasses.size();
		int sizeEAttributes = eAttributes.size();
		int sizeEReferences = eReferences.size();
		int sizeERest = eRest.size();
		
		List<String> total = new ArrayList<String>();
		total.add("EClasses: " + sizeEClasses);
		total.addAll(eClasses);
		total.add("EAttributes: " + sizeEAttributes);
		total.addAll(eAttributes);
		total.add("EReferences: " + sizeEReferences);
		total.addAll(eReferences);
		total.add("ERest: " + sizeERest);
		total.addAll(eRest);
		
		String fileNameWithoutExtension = FilenameUtils.removeExtension(y.getName());
		int columnNum = Optional.ofNullable(fileNameWithoutExtension).map(Ints::tryParse).orElse(0);
        row.createCell(columnNum).setCellValue(sizeEClasses + sizeEAttributes + sizeEReferences + sizeERest);
        
        Path file = Paths.get("logs/matches-matrix/" + FilenameUtils.removeExtension(x.getName()) + "-" + FilenameUtils.removeExtension(y.getName()) + ".txt");
		try {
			Files.write(file, total, Charset.forName("UTF-8"));
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
