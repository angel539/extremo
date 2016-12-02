package uam.extremo.ui.wizards.dialogs.search;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import semanticmanager.SearchConfiguration;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.wizards.Activator;

public class SearchEntityWizardPage extends WizardPage {
	private CCombo comboSearchType; 
	
	private Label nameSourceLabel;
	private Label nameTargetLabel;
	private Text sourceSearch;
	private Text targetSearch;
	
	
	private Label supersLabelCheck;
	private Button superscheck;
	
	private Label equivsLabelCheck;
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
	    
	    Label typeLabel = new Label(container, SWT.NONE);
	    typeLabel.setText("Search Type");
	    
	    comboSearchType = new CCombo(container, SWT.NONE);
	    comboSearchType.setText("Select search type");
	    
	    //List<String> strings = new ArrayList<String>();
		for(SearchConfiguration assistant : AssistantFactory.getInstance().getSearches()){
			String name = ((SearchConfiguration) assistant).getName();
			comboSearchType.add(name);
			comboSearchType.setData(assistant);
		}
	    
	    comboSearchType.add("Simple search");
	    comboSearchType.add("Path search");
		
		/*c1.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        if (c1.getText().equals("Item One")) {
		          String newItems[] = { "A", "B", "C" };
		          c2.setItems(newItems);
		          c2.setEnabled(true);
		        } else if (c1.getText().equals("Item Two")) {
		          String newItems[] = { "A", "B", "C" };
		          c2.setItems(newItems);
		          c2.setEnabled(true);
		        } else {
		          c2.add("Not Applicable");
		          c2.setText("Not Applicable");
		        }
		      }
		    });*/
	    
	    comboSearchType.addSelectionListener(new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
	    		if (comboSearchType.getText().equals("Simple search")) {
	    			nameSourceLabel.setText("Search");
	    			
	    			nameTargetLabel.setEnabled(false);
	    			targetSearch.setEnabled(false);
	    			
	    			supersLabelCheck.setEnabled(true);
    				superscheck.setEnabled(true);
    				
    				equivsLabelCheck.setEnabled(true);
    				equivscheck.setEnabled(true);
	    		}
	    		else{
	    			if(comboSearchType.getText().equals("Path search")){
	    				nameSourceLabel.setText("From");
	    				nameTargetLabel.setText("To");
	    				
	    				nameTargetLabel.setEnabled(true);
	    				targetSearch.setEnabled(true);
	    				
	    				supersLabelCheck.setEnabled(false);
	    				superscheck.setSelection(false);
	    				superscheck.setEnabled(false);
	    				
	    				equivsLabelCheck.setEnabled(false);
	    				equivscheck.setSelection(false);
	    				equivscheck.setEnabled(false);
	    			}
	    		}
	    	}
	    });
	    
	    nameSourceLabel = new Label(container, SWT.NONE);
	    nameSourceLabel.setText("Search");
	    
	    sourceSearch = new Text(container, SWT.BORDER | SWT.SINGLE);
	    sourceSearch.setText("");
	    sourceSearch.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  if ((!sourceSearch.getText().isEmpty())) {
			          setPageComplete(true);
			        }
		      }
	    });
	    
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    sourceSearch.setLayoutData(gd);
	    
	    nameTargetLabel = new Label(container, SWT.NONE);
	    nameTargetLabel.setText("To");
	    
	    targetSearch = new Text(container, SWT.BORDER | SWT.SINGLE);
	    targetSearch.setText("");
	    targetSearch.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  if ((!targetSearch.getText().isEmpty())) {
			          setPageComplete(true);
			        }
		      }
	    });
	    
	    targetSearch.setLayoutData(gd);
	    
	    supersLabelCheck = new Label(container, SWT.NONE);
	    supersLabelCheck.setText("Also properties from super nodes");
	    superscheck = new Button(container, SWT.CHECK);
	    superscheck.setSelection(false);
	    
	    equivsLabelCheck = new Label(container, SWT.NONE);
	    equivsLabelCheck.setText("Also properties from equivalent nodes");
	    equivscheck = new Button(container, SWT.CHECK);
	    equivscheck.setSelection(false);
	    
	    /*Label onlySuperclassesLabelCheck = new Label(container, SWT.NONE);
	    onlySuperclassesLabelCheck.setText("Only Direct Superclasses");
	    onlyDirectSuperclasses = new Button(container, SWT.CHECK);
	    onlyDirectSuperclasses.setSelection(true);
	    
	    Label onlySubclassesLabelCheck = new Label(container, SWT.NONE);
	    onlySubclassesLabelCheck.setText("Only Direct Subclasses");
	    onlyDirectSubclasses = new Button(container, SWT.CHECK);
	    onlyDirectSubclasses.setSelection(true);*/
	    
	    /*Label showEntitiesCompactedLabelCheck = new Label(container, SWT.NONE);
	    showEntitiesCompactedLabelCheck.setText("Show entities only");
	    showEntitiesCompacted = new Button(container, SWT.CHECK);
	    showEntitiesCompacted.setSelection(true);*/
	    
	    setControl(container);
	    setPageComplete(false);
	}
	
	public String getSourceSearchField() {
		 return sourceSearch.getText();
	}
	
	public String getTargetSearchField() {
		 return targetSearch.getText();
	}
	
	public boolean isSupersSearch(){
		return superscheck.getSelection();
	}
	
	public boolean isEquivsSearch(){
		return equivscheck.getSelection();
	}
	
	/*public boolean isOnlyDirectSuperclasses(){
		return onlyDirectSuperclasses.getSelection();
	}
	
	public boolean isOnlyDirectSubclasses(){
		return onlyDirectSubclasses.getSelection();
	}
	
	public boolean isShowEntitiesCompacted(){
		return showEntitiesCompacted.getSelection();
	}*/
}
