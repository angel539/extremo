package uam.extremo.ui.wizards.dialogs.searchnew;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import semanticmanager.CustomSearch;
import semanticmanager.DataProperty;
import semanticmanager.ModelTypeParam;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.PredicateBasedSearch;
import semanticmanager.PrimitiveTypeParam;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.SearchParam;
import semanticmanager.SemanticNode;
import semanticmanager.Service;
import semanticmanager.SimpleSearchConfiguration;
import semanticmanager.Type;
import uam.extremo.ui.wizards.Activator;

public class SearchConfigurationSelectorWizardPage extends WizardPage {
	private CCombo comboSearchType;
	
	private List<SimpleSearchConfiguration> searchConfigurations;
	private List<Service> services;
	private SimpleSearchConfiguration searchConfigurationSelected = null;
	
	private Map<SearchParam, Object> values;
	private Map<SearchParam, Service> serviceCalls;
	
	private Repository repositoryFrom;
	private NamedElement namedElement;

	Composite bigContainer = null;
	Composite selectorContainer = null;
	Composite selectionContainer = null;
	
	public SearchConfigurationSelectorWizardPage(
			String pageName, 
			String pageDescription, 
			List<SimpleSearchConfiguration> searchConfigurations,
			List<Service> services, 
			Repository repositoryFrom,
			NamedElement namedElement) {
		super(pageName);
		
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/searchBig.png"));
		
		this.searchConfigurations = searchConfigurations;
		this.services = services;
		this.repositoryFrom = repositoryFrom;
		this.namedElement = namedElement;
	}
	
	@Override
	public void createControl(Composite parent) {
		bigContainer = new Composite(parent, SWT.NONE);
		bigContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		bigContainer.setLayout(new GridLayout(1, true));
		
		/*
		 * Selector Container: Selects the simple search configuration to be applyed
		 */
		selectorContainer = new Composite(bigContainer, SWT.BORDER);
        selectorContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        selectorContainer.setLayout(new GridLayout(4, true));
		createSelectorControl(selectorContainer);
		
		/*
		 * Selection Container: Filled with the SearchOption (parameters)
		 */
		selectionContainer = new Composite(bigContainer, SWT.BORDER);
		selectionContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		selectionContainer.setLayout(new GridLayout(4, true));

		selectionContainer.layout();
		bigContainer.layout();
	    setControl(bigContainer);
	    setPageComplete(false);
	}
	
	/*
	 * Selector Container: Selects the simple search configuration to be applyed
	 */
	private void createSelectorControl(Composite parent){
        Label typeLabel = new Label(parent, SWT.NONE);
	    typeLabel.setText("Search Type");
	    typeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    
	    comboSearchType = new CCombo(parent, SWT.NONE);
	    comboSearchType.setText("Select search type");
	    comboSearchType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	    
		for(SimpleSearchConfiguration searchConfiguration : searchConfigurations){
			String name = ((SimpleSearchConfiguration) searchConfiguration).getName();
			comboSearchType.add(name);
			comboSearchType.setData(searchConfiguration);
		}
		
		Label descriptionLabel = new Label(parent, SWT.NONE);
		descriptionLabel.setText("Description");
		descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label description = new Label(parent, SWT.NONE);
		description.setText("");
		description.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		
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
	    			if(searchConfigurationSelected.getDescription() != null)
	    				description.setText(searchConfigurationSelected.getDescription());
	    			
	    			Device device = Display.getCurrent();
	    			Color yellow = new Color(device, 255, 255, 0);
	    			Label optionStringField = null;
	    			
	    			if(searchConfigurationSelected.getOptions().size() > 0){
	    				Label optionString = new Label(selectionContainer, SWT.NONE);
	    				optionString.setText("Options");
	    				optionString.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    				
	    				optionStringField = new Label(selectionContainer, SWT.BORDER);
	    				optionStringField.setText("This configuration needs (" + searchConfigurationSelected.getOptions().size() + ") options");
	    				optionStringField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	    				optionStringField.setBackground(yellow);
	    			}
	    			else{
	    				Label optionString = new Label(selectionContainer, SWT.NONE);
	    				optionString.setText("Options");
	    				optionString.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    				
	    				optionStringField = new Label(selectionContainer, SWT.BORDER);
	    				optionStringField.setText("This configuration needs no options");
	    				optionStringField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	    				optionStringField.setBackground(yellow);
	    			}	
	    			
	    			if (searchConfigurationSelected instanceof CustomSearch) {
						CustomSearch customSearch = (CustomSearch) searchConfigurationSelected;
						createSelectionFromSearch(customSearch);
						
						/*Composite buttonCompositionContainer = new Composite(parent, SWT.NONE);
						buttonCompositionContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
						buttonCompositionContainer.setLayout(new GridLayout(4, true));
						
						createButtonToComposeASearch(buttonCompositionContainer, customSearch);*/
					}
	    			else{
	    				PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfigurationSelected;
						createSelectionFromSearch(predicateBasedSearch);
						
						/*Composite buttonCompositionContainer = new Composite(parent, SWT.NONE);
						buttonCompositionContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
						buttonCompositionContainer.setLayout(new GridLayout(4, true));
						
						createButtonToComposeASearch(buttonCompositionContainer, predicateBasedSearch);*/
	    			}
	    		}
	    		
	    		selectionContainer.layout();
	    		bigContainer.layout();
	    		setSearchConfigurationSelected(searchConfigurationSelected); 
	    	}
	    });
	}
	
	/*private void createButtonToComposeASearch(Composite parent, SimpleSearchConfiguration simpleSearchConfiguration){
		Label beforeLabel = new Label(parent, SWT.NONE);
		beforeLabel.setText("");
		beforeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Button button = new Button(parent, SWT.PUSH);
	    button.setText("Compose a query");
	    button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
	    
	    Label afterLabel = new Label(parent, SWT.NONE);
	    afterLabel.setText("");
	    afterLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    
	    button.addSelectionListener(new SelectionListener() {
	    	public void widgetSelected(SelectionEvent event) {
	    		Composite queryCompositionContainer = new Composite(parent, SWT.NONE);
	    		queryCompositionContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
	    		queryCompositionContainer.setLayout(new GridLayout(4, true));
	    		
	    		createCompositeSearchConfiguration(queryCompositionContainer, simpleSearchConfiguration);
	    		
	    		parent.layout();
	    		selectionContainer.layout();
	    		bigContainer.layout();
	    	}
	    	
	    	public void widgetDefaultSelected(SelectionEvent event) {
	    		Composite queryCompositionContainer = new Composite(parent, SWT.NONE);
	    		queryCompositionContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
	    		queryCompositionContainer.setLayout(new GridLayout(4, true));
	    		
	    		createCompositeSearchConfiguration(queryCompositionContainer, simpleSearchConfiguration);
	    		
	    		parent.layout();
	    		selectionContainer.layout();
	    		bigContainer.layout();
	    	}
	    });
	}*/
	
	/*private void createCompositeSearchConfiguration(Composite parent, SimpleSearchConfiguration simpleSearchConfiguration){
		Label typeLabel = new Label(parent, SWT.NONE);
	    typeLabel.setText("Search Type");
	    typeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    
	    CCombo comboSearchType = new CCombo(parent, SWT.NONE);
	    comboSearchType.setText("Select search type");
	    comboSearchType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	    
		for(SimpleSearchConfiguration searchConfiguration : searchConfigurations){
			String name = ((SimpleSearchConfiguration) searchConfiguration).getName();
			comboSearchType.add(name);
			comboSearchType.setData(searchConfiguration);
		}
		
		Label descriptionLabel = new Label(parent, SWT.NONE);
		descriptionLabel.setText("Description");
		descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label description = new Label(parent, SWT.NONE);
		description.setText("");
		description.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		
		comboSearchType.addSelectionListener(new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
	    		for(Control child : parent.getChildren()) child.dispose();
	    		
	    		SimpleSearchConfiguration searchConfigurationSelected = null;
	    		loop:
	    		for(SimpleSearchConfiguration searchConfiguration : searchConfigurations){
	    			if(comboSearchType.getText().equals(searchConfiguration.getName())){
	    				searchConfigurationSelected = searchConfiguration;
	    				break loop;
	    			}
	    		}
	    		
	    		if(searchConfigurationSelected != null){
	    			if(searchConfigurationSelected.getDescription() != null)
	    				description.setText(searchConfigurationSelected.getDescription());
	    			
	    			Device device = Display.getCurrent();
	    			Color yellow = new Color(device, 255, 255, 0);
	    			Label optionStringField = null;
	    			
	    			if(searchConfigurationSelected.getOptions().size() > 0){
	    				Label optionString = new Label(parent, SWT.NONE);
	    				optionString.setText("Options");
	    				optionString.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    				
	    				optionStringField = new Label(parent, SWT.BORDER);
	    				optionStringField.setText("This configuration needs (" + searchConfigurationSelected.getOptions().size() + ") options");
	    				optionStringField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	    				optionStringField.setBackground(yellow);
	    			}
	    			else{
	    				Label optionString = new Label(parent, SWT.NONE);
	    				optionString.setText("Options");
	    				optionString.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    				
	    				optionStringField = new Label(parent, SWT.BORDER);
	    				optionStringField.setText("This configuration needs no options");
	    				optionStringField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	    				optionStringField.setBackground(yellow);
	    			}	
	    			
	    			if (searchConfigurationSelected instanceof CustomSearch) {
						CustomSearch customSearch = (CustomSearch) searchConfigurationSelected;
						createSelectionFromSearch(customSearch);
						createButtonToComposeASearch(parent, customSearch);
					}
	    			else{
	    				PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfigurationSelected;
						createSelectionFromSearch(predicateBasedSearch);
						createButtonToComposeASearch(parent, predicateBasedSearch);
	    			}
	    		}
	    		
	    		selectionContainer.layout();
	    		bigContainer.layout();
	    		setSearchConfigurationSelected(searchConfigurationSelected); 
	    	}
	    });
	}*/
	
	private void createSelectionFromSearch(SimpleSearchConfiguration searchConfiguration) {
		Map<SearchParam, Object> values = new LinkedHashMap<SearchParam, Object>(); 
		Map<SearchParam, Service> serviceCalls = new LinkedHashMap<SearchParam, Service>();
		
		for(SearchParam searchOption : searchConfiguration.getOptions()){
			if (searchOption instanceof PrimitiveTypeParam) {
				PrimitiveTypeParam primitiveTypeSearchOption = (PrimitiveTypeParam) searchOption;
				
				if(primitiveTypeSearchOption.getType().equals(Type.STRING)){
    				createTextField(searchConfiguration, primitiveTypeSearchOption, 
    								values, serviceCalls,
    								services.stream().filter(s -> s.getFilterBy().equals(Type.STRING)).collect(Collectors.toList())
    								);	
    			}
    			
    			if(primitiveTypeSearchOption.getType().equals(Type.BOOLEAN)){
    				createCheckButton(searchConfiguration, primitiveTypeSearchOption, 
    								values, serviceCalls, 
    								services.stream().filter(s -> s.getFilterBy().equals(Type.BOOLEAN)).collect(Collectors.toList())
    								);	
    			}
    			
    			if(primitiveTypeSearchOption.getType().equals(Type.INT)){
    				createTextField(searchConfiguration, primitiveTypeSearchOption, 
    								values, serviceCalls,
    								services.stream().filter(s -> s.getFilterBy().equals(Type.INT)).collect(Collectors.toList())
    								);
    			}
    			
    			if(primitiveTypeSearchOption.getType().equals(Type.FLOAT)){
    				createTextField(searchConfiguration, primitiveTypeSearchOption, 
    								values, serviceCalls,
    								services.stream().filter(s -> s.getFilterBy().equals(Type.FLOAT)).collect(Collectors.toList())
    								);
    			}
    			
    			if(primitiveTypeSearchOption.getType().equals(Type.DOUBLE)){
    				createTextField(searchConfiguration, primitiveTypeSearchOption, 
    								values, serviceCalls,
    								services.stream().filter(s -> s.getFilterBy().equals(Type.DOUBLE)).collect(Collectors.toList())
    								);
    			}
			}
			else{
				ModelTypeParam dataModelTypeSearchOption = (ModelTypeParam) searchOption;
    			createComboBox(searchConfiguration, dataModelTypeSearchOption, values);
			}
		}
		
		setServiceCalls(serviceCalls);
		setValues(values);
	}
	
	private void createTextField(SimpleSearchConfiguration searchConfiguration, SearchParam searchOption, Map<SearchParam, Object> values, Map<SearchParam, Service> serviceCalls, List<Service> services) {				
		Label optionString = new Label(selectionContainer, SWT.NONE);
		optionString.setText(searchOption.getName());
		optionString.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Text optionStringField = new Text(selectionContainer, SWT.BORDER);
		optionStringField.setText("");
		optionStringField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		optionStringField.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  values.put(searchOption, String.valueOf(optionStringField.getText()));
		    	  
		    	  if(searchConfiguration instanceof CustomSearch){
		    		  if(searchConfiguration.getOptions().size() == values.size())
		    			  setPageComplete(true);
		    	  }
		    	  else{
		    		  PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfiguration;
		    		  if(predicateBasedSearch.getOptions().size() == values.size())
		    			  setPageComplete(true);
		    	  }
		      }
	    });
		
	    CCombo comboServices = new CCombo(selectionContainer, SWT.NONE);
	    comboServices.setText("Services");
	    comboServices.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1)); 
	    
	    for(Service service : services){
			String name = service.getName();
			comboServices.add(name);
			comboServices.setData(service);
		}
	    
	    comboServices.addSelectionListener(new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
	    		Service serviceSelected = null;
	    		
	    		loop:
	    		for(Service s : services){
	    			if(comboServices.getText().equals(s.getName())){
	    				serviceSelected = s;
	    				break loop;
	    			}
	    		}
	    		
	    		if(serviceSelected != null){
	    			serviceCalls.put(searchOption, serviceSelected);
	    		}
	    	}
	    });
	    
		serviceCalls.put(searchOption, null);
		selectionContainer.layout();
	}
	
	private void createCheckButton(SimpleSearchConfiguration searchConfiguration, SearchParam searchOption, Map<SearchParam, Object> values, Map<SearchParam, Service> serviceCalls, List<Service> services) {
		Label optionBoolean = new Label(selectionContainer, SWT.NONE);
		optionBoolean.setText(searchOption.getName());
		optionBoolean.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button optionBooleanField = new Button(selectionContainer, SWT.CHECK);
		optionBooleanField.setSelection(false);
		optionBooleanField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		optionBooleanField.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  values.put(searchOption, String.valueOf(optionBooleanField.getSelection()));
		    	  
		    	  if(searchConfiguration instanceof CustomSearch){
		    		  if(searchConfiguration.getOptions().size() == values.size())
		    			  setPageComplete(true);
		    	  }
		    	  else{
		    		  PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfiguration;
		    		  if(predicateBasedSearch.getOptions().size() == values.size())
		    			  setPageComplete(true);
		    	  }
		      }
	    });
		
		CCombo comboServices = new CCombo(selectionContainer, SWT.NONE);
	    comboServices.setText("Services");
	    comboServices.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1)); 
	    
	    for(Service service : services){
			String name = service.getName();
			comboServices.add(name);
			comboServices.setData(service);
		}
	    
	    comboServices.addSelectionListener(new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
	    		Service serviceSelected = null;
	    		
	    		loop:
	    		for(Service s : services){
	    			if(comboServices.getText().equals(s.getName())){
	    				serviceSelected = s;
	    				break loop;
	    			}
	    		}
	    		
	    		if(serviceSelected != null){
	    			serviceCalls.put(searchOption, serviceSelected);
	    		}
	    	}
	    });
		
		serviceCalls.put(searchOption, null);
		values.put(searchOption, String.valueOf(optionBooleanField.getSelection()));
		selectionContainer.layout();
	}
	
	private void createComboBox(SimpleSearchConfiguration searchConfiguration, ModelTypeParam searchOption, Map<SearchParam, Object> values) {
		Label typeLabel = new Label(selectionContainer, SWT.NONE);
	    typeLabel.setText(searchOption.getName());
	    typeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    
	    CCombo comboSearchOption = new CCombo(selectionContainer, SWT.NONE);
	    comboSearchOption.setText("Select value for " + searchOption.getName());
	    comboSearchOption.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	    
	    String optionLiteral = searchOption.getType().getLiteral();
	    List<NamedElement> namedElementDescriptors = new ArrayList<NamedElement>();
	    
	    repositoryFrom.eAllContents().forEachRemaining(
    		element -> {
    			if(element instanceof NamedElement){
    				NamedElement namedElement = (NamedElement) element;
    				
					if((optionLiteral.compareTo("Resource") == 0) && namedElement instanceof Resource){
						namedElementDescriptors.add(namedElement);
					}
					
					if((optionLiteral.compareTo("SemanticNode") == 0) && namedElement instanceof SemanticNode){
						namedElementDescriptors.add(namedElement);
					}
					
					if((optionLiteral.compareTo("DataProperty") == 0) && namedElement instanceof DataProperty){
						namedElementDescriptors.add(namedElement);
					}
					
					if((optionLiteral.compareTo("ObjectProperty") == 0) && namedElement instanceof ObjectProperty){
						namedElementDescriptors.add(namedElement);
					}
    			}
    		}
	    );
	    
	    for(NamedElement namedElementDescriptor : namedElementDescriptors){
			String name = namedElementDescriptor.getName();
			comboSearchOption.add(name);
			comboSearchOption.setData(namedElementDescriptor);
			
			if(namedElement != null && namedElement.equals(namedElementDescriptor)){
				comboSearchOption.setText(name);
				values.put(searchOption, namedElementDescriptor);
				
				if(searchConfiguration instanceof CustomSearch){
		    		  if(searchConfiguration.getOptions().size() == values.size())
		    			  setPageComplete(true);
		    	  }
		    	  else{
		    		  PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfiguration;
		    		  if(predicateBasedSearch.getOptions().size() == values.size())
		    			  setPageComplete(true);
		    	  }
			}
		}
	    
	    comboSearchOption.addSelectionListener(new SelectionAdapter() {
	    	public void widgetSelected(SelectionEvent e) {
	    		NamedElement namedElementDescriptorSelected = null;
	    		
	    		loop:
	    		for(NamedElement nE : namedElementDescriptors){
	    			if(comboSearchOption.getText().equals(nE.getName())){
	    				namedElementDescriptorSelected = nE;
	    				break loop;
	    			}
	    		}
	    		
	    		if(namedElementDescriptorSelected != null){
	    			values.put(searchOption, namedElementDescriptorSelected);
	    			
	    			if(searchConfiguration instanceof CustomSearch){
			    		  if(searchConfiguration.getOptions().size() == values.size())
			    			  setPageComplete(true);
			    	  }
			    	  else{
			    		  PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfiguration;
			    		  if(predicateBasedSearch.getOptions().size() == values.size())
			    			  setPageComplete(true);
			    	  }
	    		}
	    	}
	    });
	    
		selectionContainer.layout();
	}
	
	public Map<SearchParam, Object> getValues() {
		return values;
	}

	public void setValues(Map<SearchParam, Object> values) {
		this.values = values;
	}
	
	public Map<SearchParam, Service> getServiceCalls() {
		return serviceCalls;
	}

	public void setServiceCalls(Map<SearchParam, Service> serviceCalls) {
		this.serviceCalls = serviceCalls;
	}

	public SimpleSearchConfiguration getSearchConfigurationSelected() {
		return searchConfigurationSelected;
	}

	public void setSearchConfigurationSelected(SimpleSearchConfiguration searchConfigurationSelected) {
		this.searchConfigurationSelected = searchConfigurationSelected;
	}
}
