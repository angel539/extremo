package comparator.counters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import com.google.common.primitives.Ints;

public class BasicMetricCounter{
	private static String[] columns = {"Model", "EClasses", "EAttributes", "EReferences", "ERest"};
	
	Map<File, List<ENamedElement>> instances = new HashMap<File, List<ENamedElement>>();
	public BasicMetricCounter() throws IOException {super();}
	
	protected void loadModel(File model, EPackage p) throws IOException {		
		URI uri = URI.createFileURI(model.getPath());
		ResourceSet rs = new ResourceSetImpl();
		if (p!=null) {
			rs.getPackageRegistry().put(p.getNsURI(), p);
		}
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
		Resource resource = rs.getResource(uri, true);
		resource.load(null);
		
		TreeIterator<EObject> modelAll = resource.getAllContents();
		List<ENamedElement> flattened = new ArrayList<ENamedElement>();
		modelAll.forEachRemaining(
			e -> {
				if(e instanceof ENamedElement && !(e instanceof EPackage)) flattened.add((ENamedElement) e);
			}
		);
		instances.put(model, flattened);
	}
	
	protected void generateStatsMatches() throws IOException{
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("mmCounter");
		
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
		
		for(Entry<File, List<ENamedElement>> entry : this.instances.entrySet()){
			String fileNameWithoutExtension = FilenameUtils.removeExtension(entry.getKey().getName());
			int rowNum = Optional.ofNullable(fileNameWithoutExtension).map(Ints::tryParse).orElse(0);
			
			Row row = sheet.createRow(rowNum);
			Cell modelNameCell = row.createCell(0);
			modelNameCell.setCellValue(entry.getKey().getName());
			modelNameCell.setCellStyle(modelNameStyle);
			
			List<ENamedElement> eObjects = entry.getValue();
			long count = eObjects.size();
			long countClasses = eObjects.stream().filter(e -> e instanceof EClass).count();
			long countAttributes = eObjects.stream().filter(e -> e instanceof EAttribute).count();
			long countReferences = eObjects.stream().filter(e -> e instanceof EReference).count();
			long countRest = count - countClasses - countAttributes - countReferences;
			System.out.println(modelNameCell + " " + countAttributes);
			
			row.createCell(1).setCellValue(count);
	        row.createCell(2).setCellValue(countClasses);
	        row.createCell(3).setCellValue(countAttributes);
	        row.createCell(4).setCellValue(countReferences);
	        row.createCell(5).setCellValue(countRest);
		}
		
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream("logs/counters.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        // Closing the workbook
        workbook.close();
	}

	public void counter() throws IOException {
		File mm000 = new File("ecores/000.ecore");
		loadModel(mm000, null);
		
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		for(File mmControl : controlGroup){
			loadModel(mmControl, null);
		}
		
		List<File> experimentGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));
		for(File mmExperiment : experimentGroup){
			loadModel(mmExperiment, null);
		}
		
		generateStatsMatches();
	}
	
	protected static List<File> getFilesForFolder(final File folder) {
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
	
	public static void main(String[] args) throws IOException{	
		(new BasicMetricCounter()).counter();
	}
}
