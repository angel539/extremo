package uam.extremo.ui.wizards.dialogs.changeToResource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import semanticmanager.Resource;
import uam.extremo.ui.wizards.*;

public class SelectResourceDescriptorForResourceWizardPage extends WizardPage {
	private Composite container;
	private Table table = null;
	private Resource resource = null;
	
	public SelectResourceDescriptorForResourceWizardPage(String pageName, String pageDescription, Resource resource) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/folder.png"));
		this.resource = resource;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    
	    final ScrolledComposite composite = new ScrolledComposite(container, SWT.MULTI | SWT.V_SCROLL);
	    composite.setLayout(layout);
	    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    
		table = new Table(composite, SWT.CHECK | SWT.FULL_SELECTION | SWT.MULTI);
		composite.setContent(table);
	    composite.setExpandHorizontal(true);
	    composite.setExpandVertical(true);
	    composite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
	    tc1.setText("Name");
	    tc1.setWidth(150);
	    
	    TableColumn tc2 = new TableColumn(table, SWT.LEFT);
	    tc2.setText("Path");
	    tc2.setWidth(350);
	    
	    if(resource != null){
	    	for(Resource descriptor : resource.getRepositoryFrom().getResources()){
	    		if(!descriptor.equals(resource)){
	    			TableItem itemNew = new TableItem(table, SWT.CHECK);
		    		itemNew.setData(descriptor);
		    		itemNew.setChecked(false);
		    		itemNew.setText(new String[]{descriptor.getName(), descriptor.getUri()});
	    		}
	    	}	
	    }
	    
	    table.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				for(TableItem item : table.getItems()){
					if(!table.getItem(event.index).equals(item)){
						item.setChecked(false);
					}
				}
			}
	    });
		
	    table.setSortColumn(tc1);
	    table.setTouchEnabled(true);
    	table.setHeaderVisible(true);
	    
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
