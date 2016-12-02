package uam.extremo.ui.wizards.dialogs.searchnew;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.wizard.Wizard;

import semanticmanager.SearchConfiguration;
import semanticmanager.SearchOption;
import semanticmanager.SearchResult;
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
		searchPage = new SearchWizardPage("Search", "Apply a search over the repositories", searchConfigurations);	
		addPage(searchPage);			
	}

	@Override
	public boolean performFinish() {
		SearchConfiguration searchConfigurationSelected = searchPage.getSearchConfigurationSelected();
		searchResult.setConfiguration(searchConfigurationSelected);
		
		Map<SearchOption, String> searchOptionValues = searchPage.getValues();
		for(java.util.Map.Entry<SearchOption, String> entry : searchOptionValues.entrySet()){
			SearchResultOptionValue searchResultOptionValue = SemanticmanagerFactory.eINSTANCE.createSearchResultOptionValue();
			searchResultOptionValue.setOption(entry.getKey());
			searchResultOptionValue.setValue(entry.getValue());
			searchResult.getValues().add(searchResultOptionValue);
		}
		
		return true;
	}
}
