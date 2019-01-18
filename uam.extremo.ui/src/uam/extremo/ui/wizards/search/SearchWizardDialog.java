package uam.extremo.ui.wizards.search;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ISetSelectionTarget;

import semanticmanager.*;
import uam.extremo.extensions.AssistantManager;

public class SearchWizardDialog extends Wizard{
	SearchConfigurationSelectorWizardPage searchPage = null;
	
	private List<SimpleSearchConfiguration> searchConfigurations;
	private List<Service> services;
	private Repository repository;
	
	public SearchWizardDialog(Repository repository){
		super();
		setNeedsProgressMonitor(true);
		this.repository = repository; 		
		this.searchConfigurations = AssistantManager.getInstance().getRepositoryManager().getConfigurations()
											.stream().filter(ssc -> ssc instanceof SimpleSearchConfiguration)
											.map (sc -> (SimpleSearchConfiguration) sc)
										    .collect(Collectors.toList());
		this.services = AssistantManager.getInstance().getRepositoryManager().getServices();		
		searchPage = new SearchConfigurationSelectorWizardPage("Search", "Select a search configuration from the query catalogue", searchConfigurations, services, repository);
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
		
		SearchResult searchResult;
		if (searchConfigurationSelected instanceof PredicateBasedSearch) {
			searchResult = SemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
		}
		else{
			CustomSearch customSearch = (CustomSearch) searchConfigurationSelected;
			
			if(customSearch.isGrouped()){
				searchResult = SemanticmanagerFactory.eINSTANCE.createGroupedSearchResult();
			}
			else{
				searchResult = SemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
			}
		}
		
		Map<SearchParam, Object> searchOptionStringValues = searchPage.getValues();
		Map<SearchParam, Service> searchOptionServiceCalled = searchPage.getServiceCalls();
		
		for(java.util.Map.Entry<SearchParam, Object> entry : searchOptionStringValues.entrySet()){
			if (entry.getKey() instanceof PrimitiveTypeParam) {
				PrimitiveTypeParamValue primitiveTypeSearchResultOptionValue = SemanticmanagerFactory.eINSTANCE.createPrimitiveTypeParamValue();
				primitiveTypeSearchResultOptionValue.setValue(entry.getValue().toString());	
				Service service = searchOptionServiceCalled.get(entry.getKey());
				primitiveTypeSearchResultOptionValue.setCalls(service);
				searchResult.getValues().add(primitiveTypeSearchResultOptionValue);
			}
			
			if (entry.getKey() instanceof ModelTypeParam) {
				ModelTypeParamValue dataModelTypeSearchResultOptionValue = SemanticmanagerFactory.eINSTANCE.createModelTypeParamValue();
				dataModelTypeSearchResultOptionValue.setValue((NamedElement) entry.getValue());
				searchResult.getValues().add(dataModelTypeSearchResultOptionValue);
			}
		}
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
					doFinish(monitor, repository, searchConfigurationSelected, searchResult);		
					monitor.done();
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
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();	
		IViewPart view = page.findView("uam.extremo.ui.views.SearchTree");
		
		if (view instanceof ISetSelectionTarget) {
			ISelection selection = new StructuredSelection(searchResult);
			((ISetSelectionTarget) view).selectReveal(selection);
		}
					
		return true;
	}
	
	public void doFinish(IProgressMonitor monitor, Repository repository, SimpleSearchConfiguration searchConfiguration, SearchResult searchResult){
		AssistantManager.getInstance().search(repository, searchConfiguration, searchResult);
	}
}