package uam.extremo.ui.wizards.dialogs.searchnew;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import semanticmanager.DataModelType;
import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.SearchOption;
import semanticmanager.SemanticNode;
import semanticmanager.SimpleSearchConfiguration;
import semanticmanager.Type;
import uam.extremo.ui.wizards.Activator;
import uam.extremo.ui.wizards.dialogs.searchnew.dnd.RepositoryTreeViewer;
import uam.extremo.ui.wizards.dialogs.searchnew.treeviewer.SearchTableViewer;

public class SearchConfigurationSelectorWizardPage extends WizardPage {
	private CCombo comboSearchType;
	
	private List<SimpleSearchConfiguration> searchConfigurations;
	private SimpleSearchConfiguration searchConfigurationSelected = null;
	private NamedElement namedElementSelected = null;
	
	private Map<SearchOption, Object> values;
	private Map<SearchOption, SearchTableViewer> listValues;
	private Repository repository;
	private RepositoryTreeViewer repositoryTreeViewer;
	
	public SearchConfigurationSelectorWizardPage(
			String pageName, 
			String pageDescription, 
			List<SimpleSearchConfiguration> searchConfigurations,
			Repository repository) {
		super(pageName);
		
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/searchBig.png"));
		
		this.searchConfigurations = searchConfigurations;
		this.repository = repository;
	}
	
	@Override
	public void createControl(Composite parent) {
		final Composite bigContainer = new Composite(parent, SWT.NONE);
		FillLayout bigContainerLayout = new FillLayout(SWT.HORIZONTAL);
		bigContainerLayout.marginHeight = 0;
		bigContainerLayout.marginWidth = 0;
		
		bigContainer.setLayout(bigContainerLayout);
		
		repositoryTreeViewer = new RepositoryTreeViewer(bigContainer, repository);
		repositoryTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
		   public void selectionChanged(SelectionChangedEvent event) {
		       if(event.getSelection().isEmpty()) {
		           return;
		       }
		       
		       if(event.getSelection() instanceof IStructuredSelection) {
		           IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		           Object elementSelected = selection.getFirstElement();
		           //
		           if (elementSelected instanceof NamedElement) {
						NamedElement namedElementSelected = (NamedElement) elementSelected;
						setNamedElementSelected(namedElementSelected);
						
						if (namedElementSelected instanceof Resource) {
							if((getSearchConfigurationSelected() != null) 
									&& (getSearchConfigurationSelected().getFilterBy().compareTo(DataModelType.RESOURCE) == 0)) 
										setPageComplete(true);
			    			else setPageComplete(false);
						}
						
						if (namedElementSelected instanceof SemanticNode) {
							if((getSearchConfigurationSelected() != null) 
									&& (getSearchConfigurationSelected().getFilterBy().compareTo(DataModelType.SEMANTIC_NODE) == 0)) 
										setPageComplete(true);
			    			else setPageComplete(false);
						}
						
						if (namedElementSelected instanceof DataProperty) {
							if((getSearchConfigurationSelected() != null) 
									&& (getSearchConfigurationSelected().getFilterBy().compareTo(DataModelType.DATA_PROPERTY) == 0)) 
										setPageComplete(true);
			    			else setPageComplete(false);
						}
						
						if (namedElementSelected instanceof ObjectProperty) {
							if((getSearchConfigurationSelected() != null) 
									&& (getSearchConfigurationSelected().getFilterBy().compareTo(DataModelType.OBJECT_PROPERTY) == 0)) 
										setPageComplete(true);
			    			else setPageComplete(false);
						}
		           }
		       }
		   }
		});

		
		final ScrolledComposite scrollcontainer = new ScrolledComposite(bigContainer, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		scrollcontainer.setExpandHorizontal(true);
		scrollcontainer.setExpandVertical(true);
		
        final Composite container = new Composite(scrollcontainer, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        container.setLayout(new GridLayout(1, true));
		scrollcontainer.setContent(container);
        
        final Composite selectorContainer = new Composite(container, SWT.NONE);
        selectorContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        selectorContainer.setLayout(new GridLayout(5, true));
        
        
        
		Label filterBy = new Label(selectorContainer, SWT.NONE);
		filterBy.setText("");
		
		Device device = Display.getCurrent();
		Color yellow = new Color(device, 255, 255, 0);
		filterBy.setBackground(yellow);
		
		filterBy.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
		
		
        
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
		
		Label description = new Label(selectorContainer, SWT.NONE);
		description.setText("");
		description.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
		
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
	    			if(searchConfigurationSelected.getDescription() != null)
	    				description.setText(searchConfigurationSelected.getDescription());
	    				filterBy.setText("This search must be applied over a " + searchConfigurationSelected.getFilterBy().getLiteral());
	    			
		    			SimpleSearchConfiguration simpleSearchConfiguration = (SimpleSearchConfiguration) searchConfigurationSelected;
		    			Map<SearchOption, Object> values = new LinkedHashMap<SearchOption, Object>(); 
		    			
			    		for(SearchOption searchOption : simpleSearchConfiguration.getOptions()){
			    			if (searchOption instanceof PrimitiveTypeSearchOption) {
								PrimitiveTypeSearchOption primitiveTypeSearchOption = (PrimitiveTypeSearchOption) searchOption;
								
								if(primitiveTypeSearchOption.getType().equals(Type.STRING)){
				    				createTextField(searchOption, values);	
				    			}
				    			
				    			if(primitiveTypeSearchOption.getType().equals(Type.BOOLEAN)){
				    				createCheckButton(searchOption, values);	
				    			}
				    			
				    			if(primitiveTypeSearchOption.getType().equals(Type.INT)){
				    				createNumericField(searchOption, values);
				    			}
				    			
				    			if(primitiveTypeSearchOption.getType().equals(Type.FLOAT)){
				    				createNumericField(searchOption, values);
				    			}
				    			
				    			if(primitiveTypeSearchOption.getType().equals(Type.DOUBLE)){
				    				createNumericField(searchOption, values);
				    			}
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
	            
	            
	    		
	    		if(searchConfigurationSelected.getFilterBy().compareTo(DataModelType.RESOURCE) == 0){
	    			if((getNamedElementSelected() != null) && (getNamedElementSelected() instanceof Resource)) setPageComplete(true);
	    			else setPageComplete(false);
	    		}
	    		
	    		if(searchConfigurationSelected.getFilterBy().compareTo(DataModelType.SEMANTIC_NODE) == 0){
	    			if((getNamedElementSelected() != null) && (getNamedElementSelected() instanceof SemanticNode)) setPageComplete(true);
	    			else setPageComplete(false);
	    		}
	    		
	    		if(searchConfigurationSelected.getFilterBy().compareTo(DataModelType.DATA_PROPERTY) == 0){
	    			if((getNamedElementSelected() != null) && (getNamedElementSelected() instanceof DataProperty)) setPageComplete(true);
	    			else setPageComplete(false);
	    		}
	    		
	    		if(searchConfigurationSelected.getFilterBy().compareTo(DataModelType.OBJECT_PROPERTY) == 0){
	    			if((getNamedElementSelected() != null) && (getNamedElementSelected() instanceof ObjectProperty)) setPageComplete(true);
	    			else setPageComplete(false);
	    		}
	            //setPageComplete(true);
	    	}

			private void createNumericField(SearchOption searchOption, Map<SearchOption, Object> values) {
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

			private void createCheckButton(SearchOption searchOption, Map<SearchOption, Object> values) {
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

			private void createTextField(SearchOption searchOption, Map<SearchOption, Object> values) {				
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
	    setPageComplete(false);
	}

	public Map<SearchOption, Object> getValues() {
		return values;
	}

	public void setValues(Map<SearchOption, Object> values) {
		this.values = values;
	}

	public Map<SearchOption, SearchTableViewer> getListValues() {
		return listValues;
	}

	public void setListValues(Map<SearchOption, SearchTableViewer> listValues) {
		this.listValues = listValues;
	}

	public SimpleSearchConfiguration getSearchConfigurationSelected() {
		return searchConfigurationSelected;
	}

	public void setSearchConfigurationSelected(SimpleSearchConfiguration searchConfigurationSelected) {
		this.searchConfigurationSelected = searchConfigurationSelected;
	}

	public NamedElement getNamedElementSelected() {
		return namedElementSelected;
	}

	public void setNamedElementSelected(NamedElement namedElementSelected) {
		this.namedElementSelected = namedElementSelected;
	}
}
