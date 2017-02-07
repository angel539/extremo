package uam.extremo.ui.wizards.dialogs.searchnew;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import semanticmanager.SearchConfiguration;
import semanticmanager.SearchOption;
import semanticmanager.SearchResult;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticmanagerFactory;
import uam.extremo.ui.wizards.dialogs.searchnew.dnd.NamedElementSelectionWizardPage;

public class SearchWizardDialog extends Wizard{
	SearchConfigurationSelectorWizardPage searchPage;
	
	List<SearchConfiguration> searchConfigurations;
	SearchResult searchResult;
	SearchConfiguration selectedConfiguration;
	NamedElementSelectionWizardPage namedElementSelectionWizardPage;
	
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
		searchPage = new SearchConfigurationSelectorWizardPage("Search", "Apply a search over the repositories", searchConfigurations, searchResult);
		namedElementSelectionWizardPage = new NamedElementSelectionWizardPage("Resource Selection", "", searchResult.getResources());
		
		addPage(searchPage);
		addPage(namedElementSelectionWizardPage);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if(page == searchPage){
			return namedElementSelectionWizardPage;
		}
		
		return null;
	}
	
	/*@Override
	public boolean performFinish() {
		SearchConfiguration searchConfigurationSelected = searchPage.getSearchConfigurationSelected();
		searchResult.setConfiguration(searchConfigurationSelected);
		
		Map<SearchOption, String> searchOptionStringValues = searchPage.getValues();
		for(java.util.Map.Entry<SearchOption, String> entry : searchOptionStringValues.entrySet()){
			SearchResultOptionValue searchResultOptionValue = SemanticmanagerFactory.eINSTANCE.createSearchResultOptionValue();
			searchResultOptionValue.setOption(entry.getKey());
			searchResultOptionValue.setValue(entry.getValue());
			searchResult.getValues().add(searchResultOptionValue);
		}
		
		searchResult.getApplyOnElements().addAll(namedElementSelectionWizardPage.getSelectedElements());
		
		return true;
	}*/
	
	@Override
	public boolean performFinish() {
		SearchConfiguration searchConfigurationSelected = searchPage.getSearchConfigurationSelected();
		searchResult.setConfiguration(searchConfigurationSelected);
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(monitor, searchResult, searchConfigurationSelected);									
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		
		return true;
	}
	
	public void doFinish(IProgressMonitor monitor, SearchResult searchResult, SearchConfiguration searchConfigurationSelected){
		monitor.beginTask("Generating models...", 1);
		
		Map<SearchOption, String> searchOptionStringValues = searchPage.getValues();
		for(java.util.Map.Entry<SearchOption, String> entry : searchOptionStringValues.entrySet()){
			SearchResultOptionValue searchResultOptionValue = SemanticmanagerFactory.eINSTANCE.createSearchResultOptionValue();
			searchResultOptionValue.setOption(entry.getKey());
			searchResultOptionValue.setValue(entry.getValue());
			searchResult.getValues().add(searchResultOptionValue);
		}
		
		searchResult.getApplyOnElements().addAll(namedElementSelectionWizardPage.getSelectedElements());
		
		monitor.worked(1);
	}
}
