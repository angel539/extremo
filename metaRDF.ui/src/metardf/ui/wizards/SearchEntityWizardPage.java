package metardf.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import metardf.ui.Activator;

public class SearchEntityWizardPage extends WizardPage {
	private Text search;
	private Button superscheck;
	private Button equivscheck;
	
	private Button onlyDirectSuperclasses;
	private Button onlyDirectSubclasses;
	private Button showEntitiesCompacted;
	
	private Composite container;
	
	public SearchEntityWizardPage(String pageName, String pageDescription) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/searchBig.png"));
	}

	@Override
	public void createControl(Composite parent) {		
		container = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    layout.numColumns = 2;
	    
	    Label nameLabel = new Label(container, SWT.NONE);
	    nameLabel.setText("Search");
	    
	    search = new Text(container, SWT.BORDER | SWT.SINGLE);
	    search.setText("");
	    search.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  if ((!search.getText().isEmpty())) {
			          setPageComplete(true);
			        }
		      }
	    });
	    
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    search.setLayoutData(gd);
	    
	    Label supersLabelCheck = new Label(container, SWT.NONE);
	    supersLabelCheck.setText("Get properties from supers");
	    superscheck = new Button(container, SWT.CHECK);
	    superscheck.setSelection(true);
	    
	    Label equivsLabelCheck = new Label(container, SWT.NONE);
	    equivsLabelCheck.setText("Get properties from equivalents");
	    equivscheck = new Button(container, SWT.CHECK);
	    equivscheck.setSelection(true);
	    
	    Label onlySuperclassesLabelCheck = new Label(container, SWT.NONE);
	    onlySuperclassesLabelCheck.setText("Only Direct Superclasses");
	    onlyDirectSuperclasses = new Button(container, SWT.CHECK);
	    onlyDirectSuperclasses.setSelection(true);
	    
	    Label onlySubclassesLabelCheck = new Label(container, SWT.NONE);
	    onlySubclassesLabelCheck.setText("Only Direct Subclasses");
	    onlyDirectSubclasses = new Button(container, SWT.CHECK);
	    onlyDirectSubclasses.setSelection(true);
	    
	    Label showEntitiesCompactedLabelCheck = new Label(container, SWT.NONE);
	    showEntitiesCompactedLabelCheck.setText("Entities Compacted");
	    showEntitiesCompacted = new Button(container, SWT.CHECK);
	    showEntitiesCompacted.setSelection(true);
	    
	    setControl(container);
	    setPageComplete(false);
	}
	
	public String getSearchField() {
		 return search.getText();
	}
	
	public boolean isSupersSearch(){
		return superscheck.getSelection();
	}
	
	public boolean isEquivsSearch(){
		return equivscheck.getSelection();
	}
	
	public boolean isOnlyDirectSuperclasses(){
		return onlyDirectSuperclasses.getSelection();
	}
	
	public boolean isOnlyDirectSubclasses(){
		return onlyDirectSubclasses.getSelection();
	}
	
	public boolean isShowEntitiesCompacted(){
		return showEntitiesCompacted.getSelection();
	}
}
