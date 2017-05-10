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
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import semanticmanager.SearchOption;
import semanticmanager.SimpleSearchConfiguration;
import semanticmanager.Type;
import uam.extremo.ui.wizards.Activator;
import uam.extremo.ui.wizards.dialogs.searchnew.treeviewer.SearchTableViewer;

public class SearchConfigurationSelectorWizardPage extends WizardPage {
	private CCombo comboSearchType;
	
	private List<SimpleSearchConfiguration> searchConfigurations;
	private SimpleSearchConfiguration searchConfigurationSelected = null;
	
	private Map<SearchOption, String> values;
	private Map<SearchOption, SearchTableViewer> listValues;
	
	public SearchConfigurationSelectorWizardPage(
			String pageName, 
			String pageDescription, 
			List<SimpleSearchConfiguration> searchConfigurations, 
			SimpleSearchConfiguration searchConfigurationSelected) {
		super(pageName);
		
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/searchBig.png"));
		
		this.searchConfigurations = searchConfigurations;
		this.searchConfigurationSelected = searchConfigurationSelected;
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
        
        final Composite selectorContainer = new Composite(container, SWT.NONE);
        selectorContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        selectorContainer.setLayout(new GridLayout(5, true));
        
	    Label typeLabel = new Label(selectorContainer, SWT.NONE);
	    typeLabel.setText("Search Type");
	    typeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
	    
	    comboSearchType = new CCombo(selectorContainer, SWT.NONE);
	    comboSearchType.setText("Select search type");
	    comboSearchType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));	    
	    
		for(SimpleSearchConfiguration searchConfiguration : searchConfigurations){
			String name = ((SimpleSearchConfiguration) searchConfiguration).getName();
			comboSearchType.add(name);
			comboSearchType.setData(searchConfiguration);
		}
		scrollcontainer.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		final Composite selectionContainer = new Composite(container, SWT.NONE);
		selectionContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		selectionContainer.setLayout(new GridLayout(5, true));
		
	    comboSearchType.addSelectionListener(new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
	    		for(Control child : selectionContainer.getChildren()) child.dispose();
	    		
	    		SimpleSearchConfiguration searchConfigurationSelected = null;
	    		
	    		loop:
	    		for(SimpleSearchConfiguration searchConfiguration : searchConfigurations){
	    			if(comboSearchType.getText().equals(searchConfiguration.getName())){
	    				searchConfigurationSelected = searchConfiguration;
	    				break loop;
	    			}
	    		}

	    		if(searchConfigurationSelected != null){
	    			SimpleSearchConfiguration simpleSearchConfiguration = (SimpleSearchConfiguration) searchConfigurationSelected;
	    			
	    			Map<SearchOption, String> values = new LinkedHashMap<SearchOption, String>(); 
	   
		    		for(SearchOption searchOption : simpleSearchConfiguration.getOptions()){
		    			if(searchOption.getType().equals(Type.STRING)){
		    				createTextField(searchOption, values);	
		    			}
		    			
		    			if(searchOption.getType().equals(Type.BOOLEAN)){
		    				createCheckButton(searchOption, values);	
		    			}
		    			
		    			if(searchOption.getType().equals(Type.INT)){
		    				createNumericField(searchOption, values);
		    			}
		    			
		    			if(searchOption.getType().equals(Type.FLOAT)){
		    				createNumericField(searchOption, values);
		    			}
		    			
		    			if(searchOption.getType().equals(Type.DOUBLE)){
		    				createNumericField(searchOption, values);
		    			}
		    		}
		    		
		    		setValues(values);
		    		setListValues(listValues);
	    		}
	    		
	            scrollcontainer.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	           
	            selectionContainer.layout();
	            selectorContainer.layout();
	            container.layout();
	            
	            setSearchConfigurationSelected(searchConfigurationSelected);
	            setControl(scrollcontainer);
	    	}

			private void createNumericField(SearchOption searchOption, Map<SearchOption, String> values) {
				Label optionInteger = new Label(selectionContainer, SWT.NONE);
				optionInteger.setText(searchOption.getName());
				optionInteger.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				
				Text optionIntegerField = new Text(selectionContainer, SWT.BORDER);
				optionIntegerField.setText("");
				optionIntegerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
				
				optionIntegerField.addKeyListener(new KeyListener() {
				      @Override
				      public void keyPressed(KeyEvent e) {
				      }
			
				      @Override
				      public void keyReleased(KeyEvent e) {
				    	  values.put(searchOption, String.valueOf(optionIntegerField.getText()));
				      }
			    });
				
				optionIntegerField.addVerifyListener(new VerifyListener() {
					@Override
					public void verifyText(VerifyEvent e) {
						 e.doit = e.text.matches("[0-9]+");
					     try {
					         new Integer(e.text);
					     }
					     catch (NumberFormatException nfe) {
					         e.doit = false;
					     }
					}
				});

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
      
        selectionContainer.layout();
        selectorContainer.layout();
        container.layout();
	    
	    setControl(scrollcontainer);
	    setPageComplete(true);
	}

	public SimpleSearchConfiguration getSearchConfigurationSelected() {
		return searchConfigurationSelected;
	}

	public void setSearchConfigurationSelected(SimpleSearchConfiguration searchConfigurationSelected) {
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
