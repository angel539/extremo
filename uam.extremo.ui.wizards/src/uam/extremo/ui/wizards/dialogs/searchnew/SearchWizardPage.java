package uam.extremo.ui.wizards.dialogs.searchnew;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import semanticmanager.SearchOption;
import semanticmanager.Type;
import uam.extremo.ui.wizards.*;
import org.eclipse.swt.widgets.Control;

public class SearchWizardPage extends WizardPage {
	private CCombo comboSearchType;
	
	private List<SearchConfiguration> searchConfigurations;
	
	private SearchConfiguration searchConfigurationSelected;
	private Map<SearchOption, String> values; 
	
	public SearchWizardPage(String pageName, String pageDescription, List<SearchConfiguration> searchConfigurations) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/searchBig.png"));
		this.searchConfigurations = searchConfigurations;
	}

	@Override
	public void createControl(Composite parent) {	
		final Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(1, false));
	    
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        
        final Composite selectorContainer = new Composite(container, SWT.NONE);
        GridLayout layoutSelector = new GridLayout(2, true);
        selectorContainer.setLayout(layoutSelector);
	    
	    Label typeLabel = new Label(selectorContainer, SWT.NONE);
	    typeLabel.setText("Search Type");
	    
	    comboSearchType = new CCombo(selectorContainer, SWT.NONE);
	    comboSearchType.setText("Select search type");
	    
		for(SearchConfiguration searchConfiguration : searchConfigurations){
			String name = ((SearchConfiguration) searchConfiguration).getName();
			comboSearchType.add(name);
			comboSearchType.setData(searchConfiguration);
		}
		
		final Composite selectionContainer = new Composite(container, SWT.NONE);
		GridLayout layoutSelection = new GridLayout(2, true);
		selectionContainer.setLayout(layoutSelection);
		
	    comboSearchType.addSelectionListener(new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
	    		for(Control child : selectionContainer.getChildren()) child.dispose();
	    			
	    		SearchConfiguration searchConfigurationSelected = null;
	    		loop:
	    		for(SearchConfiguration searchConfiguration : searchConfigurations){
	    			if(comboSearchType.getText().equals(searchConfiguration.getName())){
	    				searchConfigurationSelected = searchConfiguration;
	    				break loop;
	    			}
	    		}
	    		
	    		if(searchConfigurationSelected != null){
	    			Map<SearchOption, String> values = new LinkedHashMap<SearchOption, String>(); 
		    		
		    		for(SearchOption searchOption : searchConfigurationSelected.getOptions()){		    			
		    			if(searchOption.getType().equals(Type.STRING)){
		    				Label optionString = new Label(selectionContainer, SWT.NONE);
		    				optionString.setText(searchOption.getName());
		    				
		    				Text optionStringField = new Text(selectionContainer, SWT.BORDER | SWT.SINGLE);
		    				optionStringField.setLayoutData(gd);
		    				optionStringField.setText("");
		    				optionStringField.addKeyListener(new KeyListener() {
		    				      @Override
		    				      public void keyPressed(KeyEvent e) {
		    				      }
		    			
		    				      @Override
		    				      public void keyReleased(KeyEvent e) {
		    				    	  values.put(searchOption, String.valueOf(optionStringField.getText()));
		    				      }
		    			    });
		    				
		    				optionStringField.setLayoutData(gd);
		    				values.put(searchOption, optionStringField.getText());
		    			}
		    			if(searchOption.getType().equals(Type.BOOLEAN)){
		    				Label optionBoolean = new Label(selectionContainer, SWT.NONE);
		    				optionBoolean.setText(searchOption.getName());
		    				
		    				Button optionBooleanField = new Button(selectionContainer, SWT.CHECK);
		    				optionBooleanField.setSelection(false);
		    				
		    				optionBooleanField.addKeyListener(new KeyListener() {
		    				      @Override
		    				      public void keyPressed(KeyEvent e) {
		    				      }
		    			
		    				      @Override
		    				      public void keyReleased(KeyEvent e) {
		    				    	  values.put(searchOption, String.valueOf(optionBooleanField.getSelection()));
		    				      }
		    			    });
		    				values.put(searchOption, String.valueOf(optionBooleanField.getSelection()));
		    			}
		    			if(searchOption.getType().equals(Type.INT)){
		    				Label optionInteger = new Label(selectionContainer, SWT.NONE);
		    				optionInteger.setText(searchOption.getName());
		    			    
		    				Text optionIntegerField = new Text(selectionContainer, SWT.BORDER | SWT.SINGLE);
		    				optionIntegerField.setLayoutData(gd);
		    				optionIntegerField.setText("");
		    				optionIntegerField.addKeyListener(new KeyListener() {
		    				      @Override
		    				      public void keyPressed(KeyEvent e) {
		    				      }
		    			
		    				      @Override
		    				      public void keyReleased(KeyEvent e) {
		    				    	  values.put(searchOption, String.valueOf(optionIntegerField.getText()));
		    				      }
		    			    });
		    				
		    				values.put(searchOption, optionIntegerField.getText());
		    			}
		    		}
		    		
		    		setValues(values);
	    		}
	    		
	    		setSearchConfigurationSelected(searchConfigurationSelected);
	    		selectionContainer.layout(true, true);
	    		container.layout(true, true);
	    		setControl(container);
	    	}
	    });
	    
	    setControl(container);
	    setPageComplete(true);
	}

	public SearchConfiguration getSearchConfigurationSelected() {
		return searchConfigurationSelected;
	}

	public void setSearchConfigurationSelected(SearchConfiguration searchConfigurationSelected) {
		this.searchConfigurationSelected = searchConfigurationSelected;
	}

	public Map<SearchOption, String> getValues() {
		return values;
	}

	public void setValues(Map<SearchOption, String> values) {
		this.values = values;
	}
}
