package metardf.ui.wizards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import metardf.ui.Activator;

public class ResourceListWizardPage extends WizardPage {
	private Composite container;
	private Table table = null;
	private String dir = null;
	//private String comboSelection = null;
	
	public ResourceListWizardPage(String pageName, String pageDescription, String dir) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/folder.png"));
		this.dir = dir;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    layout.numColumns = 1;	    
	    
		table = new Table(container, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
	    tc1.setText("Name");
	    tc1.setWidth(150);
	    
	    
	    TableColumn tc2 = new TableColumn(table, SWT.LEFT);
	    tc2.setText("Path");
	    tc2.setWidth(350);
	    
	    if(dir != null){
	    	File dirFile = new File(dir);
	    	
	    	if(dirFile.isDirectory()){
	    		List<File> ficheros = getFilesForFolder(dirFile);
	    		
				if(ficheros!=null){
					for(File file : ficheros){
						TableItem item = new TableItem(table, SWT.CHECK);
			    		item.setData(file);
			    		item.setChecked(true);
				    	item.setText(new String[]{file.getName(), file.getAbsolutePath()});
					}
				}
	    	}
			
	    }
		
	    table.setSortColumn(tc1);
	    table.setTouchEnabled(true);
    	table.setHeaderVisible(true);
	    
	    GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
	    if(table != null) table.setLayoutData(gd);
	    setControl(container);
	    setPageComplete(true);
	}
	
	public List<File> getFilesForFolder(final File folder) {
		List<File> files = new ArrayList<File>();
	    
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            files.addAll(getFilesForFolder(fileEntry));
	        } else {
	        	files.add(fileEntry);
	        }
	    }
		
		return files;
	}

	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
