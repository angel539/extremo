package uam.extremo.ui.wizards.dialogs.searchnew;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.ScrolledComposite;
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
import semanticmanager.SearchResult;
import semanticmanager.Type;
import uam.extremo.ui.wizards.*;
import uam.extremo.ui.wizards.dialogs.searchnew.treeviewer.SearchTableViewer;

import org.eclipse.swt.widgets.Control;

public class SearchConfigurationSelectorWizardPage extends WizardPage {
	private CCombo comboSearchType;
	
	private List<SearchConfiguration> searchConfigurations;
	
	private SearchConfiguration searchConfigurationSelected = null;
	private Map<SearchOption, String> values;
	private Map<SearchOption, SearchTableViewer> listValues;
	private SearchResult searchResult;
	
	public SearchConfigurationSelectorWizardPage(String pageName, String pageDescription, List<SearchConfiguration> searchConfigurations, SearchResult searchResult) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/searchBig.png"));
		
		this.searchConfigurations = searchConfigurations;
		this.searchResult = searchResult;
	}

	@Override
	public void createControl(Composite parent) {
		final ScrolledComposite scrollcontainer = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		scrollcontainer.setExpandHorizontal(true);
		scrollcontainer.setExpandVertical(true);
		
        final Composite container = new Composite(scrollcontainer, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        container.setLayout(new GridLayout(1, true));
		scrollcontainer.setContent(container);
        
		/*
		 * Select the search among the extension points
		 */
        final Composite selectorContainer = new Composite(container, SWT.NONE);
        selectorContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        selectorContainer.setLayout(new GridLayout(5, true));
        
	    Label typeLabel = new Label(selectorContainer, SWT.NONE);
	    typeLabel.setText("Search Type");
	    typeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
	    
	    comboSearchType = new CCombo(selectorContainer, SWT.NONE);
	    comboSearchType.setText("Select search type");
	    comboSearchType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));	    
	    
		for(SearchConfiguration searchConfiguration : searchConfigurations){
			String name = ((SearchConfiguration) searchConfiguration).getName();
			comboSearchType.add(name);
			comboSearchType.setData(searchConfiguration);
		}
		
		scrollcontainer.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		/*
		 * Create the new composite with the contents provided by the extension point as options.
		 */
		final Composite selectionContainer = new Composite(container, SWT.NONE);
		selectionContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		selectionContainer.setLayout(new GridLayout(5, true));
		
		/*
		 * Depends on the options... 
		 */
		
		
	    comboSearchType.addSelectionListener(new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
	    		for(Control child : selectionContainer.getChildren()) child.dispose();
	    			
	    		/*
	    		 * Search selection can change
	    		 */
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
	   
	    			//Map<SearchOption, SearchTableViewer> listValues = new LinkedHashMap<SearchOption, SearchTableViewer>(); 
		    		
		    		for(SearchOption searchOption : searchConfigurationSelected.getOptions()){		    			
		    			if(searchOption.getType().equals(Type.STRING)){
		    				createTextField(searchOption, values);	
		    			}
		    			
		    			if(searchOption.getType().equals(Type.BOOLEAN)){
		    				createCheckButton(searchOption, values);	
		    			}
		    			
		    			if(searchOption.getType().equals(Type.INT)){
		    				createIntegerField(searchOption, values);
		    			}
		    		}
		    		
		    		setValues(values);
		    		setListValues(listValues);
	    		}
	            scrollcontainer.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	            container.layout();
	            
	            setSearchConfigurationSelected(searchConfigurationSelected);
	            setControl(scrollcontainer);
	    	}

			private void createIntegerField(SearchOption searchOption, Map<SearchOption, String> values) {
				Label optionInteger = new Label(selectionContainer, SWT.NONE);
				optionInteger.setText(searchOption.getName());
				optionInteger.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			    
				Text optionIntegerField = new Text(selectionContainer, SWT.BORDER);
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
				optionIntegerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
				values.put(searchOption, optionIntegerField.getText());
			}

			private void createCheckButton(SearchOption searchOption, Map<SearchOption, String> values) {
				Label optionBoolean = new Label(selectionContainer, SWT.NONE);
				optionBoolean.setText(searchOption.getName());
				optionBoolean.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				
				
				Button optionBooleanField = new Button(selectionContainer, SWT.CHECK);
				optionBooleanField.setSelection(false);
				optionBooleanField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
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

			private void createTextField(SearchOption searchOption, Map<SearchOption, String> values) {				
				Label optionString = new Label(selectionContainer, SWT.NONE);
				optionString.setText(searchOption.getName());
				optionString.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				
				Text optionStringField = new Text(selectionContainer, SWT.BORDER);
				optionStringField.setText("");
				optionStringField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
				
				optionStringField.addKeyListener(new KeyListener() {
				      @Override
				      public void keyPressed(KeyEvent e) {
				      }
			
				      @Override
				      public void keyReleased(KeyEvent e) {
				    	  values.put(searchOption, String.valueOf(optionStringField.getText()));
				      }
			    });

				values.put(searchOption, optionStringField.getText());
			}
	    });
	    
        scrollcontainer.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        container.layout();
	    
	    setControl(scrollcontainer);
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

	public Map<SearchOption, SearchTableViewer> getListValues() {
		return listValues;
	}

	public void setListValues(Map<SearchOption, SearchTableViewer> listValues) {
		this.listValues = listValues;
	}
}
