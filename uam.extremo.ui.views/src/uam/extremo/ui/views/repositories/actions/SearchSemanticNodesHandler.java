 package uam.extremo.ui.views.repositories.actions;
import java.util.Iterator;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticmanagerFactory;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.wizards.dialogs.searchnew.SearchWizardDialog;

public class SearchSemanticNodesHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		AssistantFactory.getInstance().putAllResourceToNotActive();
		
		SearchResult searchResult = SemanticmanagerFactory.eINSTANCE.createSearchResult();
		
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			
			for (Iterator<Object> iterator = strucSelection.iterator(); iterator.hasNext();) {
				Object element = iterator.next();
				
				if(element instanceof Repository){
					Repository repository = (Repository) element;
					
					for(Resource resource : repository.getResources()){
						resource.setActive(true);
						searchResult.getResources().add(resource);
					}
				}
				
				if(element instanceof Resource){
					Resource resource = (Resource) element;
					
					if(!searchResult.getResources().contains(resource)){
						resource.setActive(true);
						searchResult.getResources().add(resource);
					}
				}
			}
		 }
		
		
		WizardDialog wizardDialog = new WizardDialog(null, new SearchWizardDialog(AssistantFactory.getInstance().getSearches(), searchResult));
		if (wizardDialog.open() == Window.OK) {
			search(searchResult);
		}
		else{
			MessageDialog.openError(null, "Search entities", "Searching could not be called");
		}
		
		return null;
	}
	
	private static boolean search(SearchResult search){
		AssistantFactory.getInstance().search(search);
		return true;
	}
}