package uam.extremo.ui.wizards.dialogs.searchnew;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import semanticmanager.SearchConfiguration;
import semanticmanager.SearchOption;
import semanticmanager.SimpleSearchConfiguration;
import semanticmanager.Type;
import uam.extremo.ui.wizards.Activator;
import uam.extremo.ui.wizards.dialogs.searchnew.treeviewer.SearchTableViewer;

public class NewSearchConfigurationSelectorWizardPage extends WizardPage{
	QueryCatalogueTreeViewer queryCatalogueTableTreeViewer;
	
	private Map<SearchOption, String> values;
	private Map<SearchOption, SearchTableViewer> listValues;
	
	public NewSearchConfigurationSelectorWizardPage(String pageName, String description) {
		super(pageName);
		
		setTitle(pageName);
		setDescription(description);
		setImageDescriptor(Activator.getImageDescriptor("icons/searchBig.png"));
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
        
		queryCatalogueTableTreeViewer = new QueryCatalogueTreeViewer(
				container);

		final Composite selectionContainer = new Composite(container, SWT.NONE);
		selectionContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		selectionContainer.setLayout(new GridLayout(5, true));
		
		queryCatalogueTableTreeViewer.addSelectionChangedListener(
				new ISelectionChangedListener() {
		   public void selectionChanged(SelectionChangedEvent event) {
			   
			   if(event.getSelection() instanceof IStructuredSelection) {
		           IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		           
		           if((selection != null) 
		        		   && (selection instanceof SearchConfiguration)){
		        	   
		        	   System.out.println(selection.toString());
		        	   
		        	   SearchConfiguration searchConfiguration = (SearchConfiguration) selection;
		        	   //Map<SearchOption, String> values = new LinkedHashMap<SearchOption, String>(); 
		    			
		        	   if (searchConfiguration instanceof SimpleSearchConfiguration) {
							SimpleSearchConfiguration simpleSearchConfiguration = (SimpleSearchConfiguration) searchConfiguration;
							
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
						}
		    			
			    		setValues(values);
			    		setListValues(listValues);
		    		}
		    		
		            scrollcontainer.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		           
		            selectionContainer.layout();
		            selectorContainer.layout();
		            container.layout();
		            setControl(scrollcontainer);
		       }
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
        selectorContainer.layout();
        container.layout();
	    
	    setControl(scrollcontainer);
	    setPageComplete(true);
	}
	
	@Override
	public IWizardPage getNextPage() {
		return super.getNextPage();
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
