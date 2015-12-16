package metardf.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import metaRDF.core.model.Repository;
import metaRDF.core.repository.MetaRDFRepositoryManager;
import metardf.ui.Activator;

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
	    
	    if((MetaRDFRepositoryManager.getInstance()!=null) && (MetaRDFRepositoryManager.getInstance().getRepositories() != null) && (MetaRDFRepositoryManager.getInstance().getRepositories().size() > 0)){
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
	    
	    	for(Repository repository : MetaRDFRepositoryManager.getInstance().getRepositories()){
	    		TableItem item = new TableItem(table, SWT.NONE);
	    		item.setData(repository);
		    	item.setText(new String[]{repository.getName(), repository.getDescription(), repository.getURI()});
	    	}
	    	
	    	table.setHeaderVisible(true);
	    }
	    
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
