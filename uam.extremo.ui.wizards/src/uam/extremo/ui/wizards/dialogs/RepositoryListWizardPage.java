package uam.extremo.ui.wizards.dialogs;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import semanticmanager.Repository;
import uam.extremo.ui.wizards.*;

public class RepositoryListWizardPage extends WizardPage {
	private Composite container;
	private Table table = null;
	
	public RepositoryListWizardPage(String pageName, String pageDescription) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/folder.png"));
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    layout.numColumns = 1;	    
	    
	   /* Class<? extends IRepositoryManager> c;
		try {
			c = Class.forName("metardf.core").asSubclass(IRepositoryManager.class);
			IRepositoryManager repositoryManager = c.newInstance();
			if((repositoryManager!=null) && (repositoryManager.getRepositories() != null) && (repositoryManager.getRepositories().size() > 0)){
			    table = new Table(container, SWT.BORDER);
			    
			    TableColumn tc1 = new TableColumn(table, SWT.LEFT);
			    tc1.setText("Name");
			    tc1.setWidth(100);
			    
			    TableColumn tc2 = new TableColumn(table, SWT.LEFT);
			    tc2.setText("Description");
			    tc2.setWidth(200);
			    
			    TableColumn tc3 = new TableColumn(table, SWT.LEFT);
			    tc3.setText("URI or path");
			    tc3.setWidth(200);
		    
		    	for(Repository repository : repositoryManager.getRepositories()){
		    		TableItem item = new TableItem(table, SWT.NONE);
		    		item.setData(repository);
			    	item.setText(new String[]{repository.getName(), repository.getDescription(), repository.getUri()});
		    	}
		    	
		    	table.setHeaderVisible(true);
		    }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}  */
	    
	    
	    
	    
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    if(table != null) table.setLayoutData(gd);
	    setControl(container);
	    setPageComplete(true);
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
