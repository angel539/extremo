package uam.extremo.ui.wizards.dialogs.searchnew;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.wizard.Wizard;

import semanticmanager.NamedElement;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchOption;
import semanticmanager.SearchResult;
import semanticmanager.SearchResultOptionNamedElementListValue;
import semanticmanager.SearchResultOptionStringValue;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticmanagerFactory;


public class SearchWizardDialog extends Wizard {
	SearchWizardPage searchPage;
	List<SearchConfiguration> searchConfigurations;
	SearchResult searchResult;
	
	public SearchWizardDialog(List<SearchConfiguration> searchConfigurations, SearchResult searchResult) {
		super();
		setNeedsProgressMonitor(true);
		this.searchConfigurations = searchConfigurations;
		this.searchResult = searchResult;
	}
	
	@Override
	public String getWindowTitle() {
	    return "Searching...";
	}
	
	public void addPages(){	
		searchPage = new SearchWizardPage("Search", "Apply a search over the repositories", searchConfigurations, searchResult);	
		addPage(searchPage);			
	}

	@Override
	public boolean performFinish() {
		SearchConfiguration searchConfigurationSelected = searchPage.getSearchConfigurationSelected();
		searchResult.setConfiguration(searchConfigurationSelected);
		
		Map<SearchOption, String> searchOptionStringValues = searchPage.getValues();
		for(java.util.Map.Entry<SearchOption, String> entry : searchOptionStringValues.entrySet()){
			SearchResultOptionStringValue searchResultOptionValue = SemanticmanagerFactory.eINSTANCE.createSearchResultOptionStringValue();
			searchResultOptionValue.setOption(entry.getKey());
			searchResultOptionValue.setValue(entry.getValue());
			searchResult.getValues().add(searchResultOptionValue);
		}
		
		Map<SearchOption, List<NamedElement>> searchOptionListValues = searchPage.getListValues();
		for(java.util.Map.Entry<SearchOption, List<NamedElement>> entry : searchOptionListValues.entrySet()){
			SearchResultOptionNamedElementListValue searchResultOptionValue = SemanticmanagerFactory.eINSTANCE.createSearchResultOptionNamedElementListValue();
			searchResultOptionValue.setOption(entry.getKey());
			searchResultOptionValue.getValue().addAll(entry.getValue());
			searchResult.getValues().add(searchResultOptionValue);
		}
		
		return true;
	}
}
