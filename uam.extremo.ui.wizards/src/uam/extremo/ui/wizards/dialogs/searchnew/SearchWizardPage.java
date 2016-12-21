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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import semanticmanager.SearchConfiguration;
import semanticmanager.SearchOption;
import semanticmanager.Type;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.wizards.*;
import uam.extremo.ui.wizards.dialogs.searchnew.treeviewer.SearchTreeViewer;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

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
	    
	    
	    
	    
	    
	    
		for(SearchConfiguration searchConfiguration : searchConfigurations){
			String name = ((SearchConfiguration) searchConfiguration).getName();
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
		    				createTextField(searchOption, values);	
		    			}
		    			
		    			if(searchOption.getType().equals(Type.BOOLEAN)){
		    				createCheckButton(searchOption, values);	
		    			}
		    			
		    			if(searchOption.getType().equals(Type.INT)){
		    				createIntegerField(searchOption, values);
		    			}
		    			
		    			if(searchOption.getType().equals(Type.SEMANTIC_NODE)){
		    				createTreeViewer(searchOption, values);
		    			}
		    			
		    			if(searchOption.getType().equals(Type.DATA_PROPERTY)){
		    				
		    			}
		    			
		    			if(searchOption.getType().equals(Type.OBJECT_PROPERTY)){
		    				
		    			}
		    		}
		    		
		    		setValues(values);
	    		}
	            scrollcontainer.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	            container.layout();
	            
	            setSearchConfigurationSelected(searchConfigurationSelected);
	            setControl(scrollcontainer);
	    	}

			private void createTreeViewer(SearchOption searchOption, Map<SearchOption, String> values) {
				Label optionNamedElement = new Label(selectionContainer, SWT.NONE);
				optionNamedElement.setText(searchOption.getName());
				optionNamedElement.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				
				final Composite viewerContainer = new Composite(selectionContainer, SWT.NONE);
		        viewerContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		        viewerContainer.setLayout(new GridLayout(1, true));
		        SearchTreeViewer optionSemanticNodeField = new SearchTreeViewer(viewerContainer, AssistantFactory.getInstance().getRepositoryManager());
		        optionSemanticNodeField.getSelection();
				
				Label optionNamedElementValue = new Label(selectionContainer, SWT.NONE);
				optionNamedElementValue.setText(searchOption.getName() + " value");
				optionNamedElementValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				
				Text optionNamedElementValueField = new Text(selectionContainer, SWT.BORDER);
				optionNamedElementValueField.setText("");
				optionNamedElementValueField.addKeyListener(new KeyListener() {
				      @Override
				      public void keyPressed(KeyEvent e) {
				      }
			
				      @Override
				      public void keyReleased(KeyEvent e) {
				    	  values.put(searchOption, String.valueOf(optionNamedElementValueField.getText()));
				      }
			    });
				
				optionNamedElementValueField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
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
	    
	    
        // reset the minimum width and height so children can be seen - method 2
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
}
