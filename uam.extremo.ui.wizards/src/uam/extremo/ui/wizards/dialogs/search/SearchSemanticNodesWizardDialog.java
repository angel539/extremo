package uam.extremo.ui.wizards.dialogs.search;

import org.eclipse.jface.wizard.Wizard;

import semanticmanager.Search;


public class SearchSemanticNodesWizardDialog extends Wizard {
	SearchEntityWizardPage searchPage;
	Search search;
	
	public SearchSemanticNodesWizardDialog(Search search) {
		super();
		setNeedsProgressMonitor(true);
		this.search = search;
	}
	
	@Override
	public String getWindowTitle() {
	    return "Searching...";
	}
	
	public void addPages(){	
		searchPage = new SearchEntityWizardPage("Search Entity", "Enter some words. The system will find you the best semantic classes hold in your repositories.");	
		addPage(searchPage);			
	}

	@Override
	public boolean performFinish() {
		search.setName(searchPage.getSourceSearchField());
		search.setSearchField(searchPage.getSourceSearchField());
		search.setSearchFieldTarget(searchPage.getTargetSearchField());
		search.setAllProperties(searchPage.isSupersSearch());
		search.setEquivalents(searchPage.isEquivsSearch());
		
		return true;
	}
}
