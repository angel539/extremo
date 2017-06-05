package uam.extremo.ui.wizards.dialogs.searchnew;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;

import semanticmanager.AtomicSearchResult;
import semanticmanager.CustomSearch;
import semanticmanager.DataModelTypeSearchOption;
import semanticmanager.DataModelTypeSearchResultOptionValue;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.NamedElement;
import semanticmanager.PredicateBasedSearch;
import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.PrimitiveTypeSearchResultOptionValue;
import semanticmanager.Repository;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchOption;
import semanticmanager.SearchResult;
import semanticmanager.SimpleSearchConfiguration;
import uam.extremo.extensions.AssistantFactory;

public class SearchWizardDialog extends Wizard{
	SearchConfigurationSelectorWizardPage searchPage = null;
	
	NamedElementSelectionWizardPage namedElementSelectionPage;
	List<SimpleSearchConfiguration> searchConfigurations;
	
	SearchResult searchResult;
	Repository repository;
	
	public SearchWizardDialog(Repository repository){
		super();
		setNeedsProgressMonitor(true);
		this.repository = repository;
		this.searchConfigurations = AssistantFactory.getInstance().getSearches()
											.stream().filter(ssc -> ssc instanceof SimpleSearchConfiguration)
										    .map (ssc -> (SimpleSearchConfiguration) ssc)
										    .collect(Collectors.toList());
		
		searchPage = new SearchConfigurationSelectorWizardPage("Search", "Select a search configuration from the query catalogue", searchConfigurations, repository);
	}
	
	@Override
	public String getWindowTitle() {
	    return "Searching...";
	}
	
	public void addPages(){
		addPage(searchPage);
	}
	
	@Override
	public boolean performFinish() {
		SimpleSearchConfiguration searchConfigurationSelected = searchPage.getSearchConfigurationSelected();
		NamedElement namedElementSelected = searchPage.getNamedElementSelected();
		
		if (searchConfigurationSelected instanceof PredicateBasedSearch) {
			PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfigurationSelected;
			searchResult = ExtendedSemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
			searchResult.setConfiguration(predicateBasedSearch);
			searchResult.getApplyOnElements().addAll(namedElementSelected.getDescribes());
		}
		else{
			// Custom Search
			CustomSearch customSearch = (CustomSearch) searchConfigurationSelected;
			
			if(customSearch.isGrouped()){
				searchResult = ExtendedSemanticmanagerFactory.eINSTANCE.createGroupedSearchResult();
				searchResult.setConfiguration(customSearch);
				searchResult.getApplyOnElements().add(namedElementSelected);
			}
			else{
				searchResult = ExtendedSemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
				searchResult.setConfiguration(customSearch);
				searchResult.getApplyOnElements().add(namedElementSelected);
			}
		}
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					Map<SearchOption, Object> searchOptionStringValues = searchPage.getValues();
					for(java.util.Map.Entry<SearchOption, Object> entry : searchOptionStringValues.entrySet()){
						if (entry.getKey() instanceof PrimitiveTypeSearchOption) {
							PrimitiveTypeSearchOption primitiveTypeSearchOption = (PrimitiveTypeSearchOption) entry.getKey();
							
							PrimitiveTypeSearchResultOptionValue primitiveTypeSearchResultOptionValue = ExtendedSemanticmanagerFactory.eINSTANCE.createPrimitiveTypeSearchResultOptionValue();
							primitiveTypeSearchResultOptionValue.setOption(primitiveTypeSearchOption);
							primitiveTypeSearchResultOptionValue.setValue((String) entry.getValue());
							searchResult.getValues().add(primitiveTypeSearchResultOptionValue);
						}
						
						if (entry.getKey() instanceof DataModelTypeSearchOption) {
							DataModelTypeSearchOption dataModelTypeSearchOption = (DataModelTypeSearchOption) entry.getKey();
							
							DataModelTypeSearchResultOptionValue dataModelTypeSearchResultOptionValue = ExtendedSemanticmanagerFactory.eINSTANCE.createDataModelTypeSearchResultOptionValue();
							dataModelTypeSearchResultOptionValue.setOption(dataModelTypeSearchOption);
							dataModelTypeSearchResultOptionValue.setValue((NamedElement) entry.getValue());
							searchResult.getValues().add(dataModelTypeSearchResultOptionValue);
						}
					}
					
					doFinish(monitor, searchResult, searchConfigurationSelected);									
				}
				finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		}
		catch (InterruptedException e) {
			return false;
		}
		catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		
		return true;
	}
	
	public void doFinish(IProgressMonitor monitor, 
			SearchResult searchResult, 
			SearchConfiguration searchConfigurationSelected){
		if (searchConfigurationSelected instanceof CustomSearch) {
			CustomSearch customSearch = (CustomSearch) searchConfigurationSelected;
			customSearch.search(searchResult);
		}
			
		if (searchConfigurationSelected instanceof PredicateBasedSearch) {
			PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfigurationSelected;
			
			if (searchResult instanceof AtomicSearchResult) {
					AtomicSearchResult atomicSearchResult = (AtomicSearchResult) searchResult;
					
					for(NamedElement namedElement : atomicSearchResult.getApplyOnElements()){
						boolean matches = predicateBasedSearch.matches(namedElement, searchResult.getValues());
						if(matches){
							atomicSearchResult.getElements().add(namedElement);
						}
					}		
			}	
		}
	}
}
