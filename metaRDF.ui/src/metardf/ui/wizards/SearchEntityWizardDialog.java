package metardf.ui.wizards;

import org.eclipse.jface.wizard.Wizard;
import metaRDF.core.model.impl.Search;

public class SearchEntityWizardDialog extends Wizard {
	SearchEntityWizardPage searchPage;
	Search search;
	
	public SearchEntityWizardDialog(Search search) {
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
		search.setSearchField(searchPage.getSearchField());
		search.setIsFromSupers(searchPage.isSupersSearch());
		search.setIsFromEquivs(searchPage.isEquivsSearch());
		
		search.setOnlyDirectSuperclasses(searchPage.isOnlyDirectSuperclasses());
		search.setOnlyDirectSubclasses(searchPage.isOnlyDirectSubclasses());
		search.setEntitiesCompacted(searchPage.isShowEntitiesCompacted());
		
		return true;
	}
}
