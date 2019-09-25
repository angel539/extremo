package uam.extremo.ui.views.modeltraversals;
 
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import semanticmanager.Repository;
import uam.extremo.ui.wizards.search.SearchWizardDialog;

public class SearchSemanticNodesHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection != null & selection instanceof IStructuredSelection) {	
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object firstselection = strucSelection.getFirstElement();

			if (firstselection != null) {
				Repository repository = getRepositoryFrom((EObject) firstselection);
				
				WizardDialog wizardDialog = new WizardDialog(null, new SearchWizardDialog(repository));
				if (wizardDialog.open() == Window.OK) {
					MessageDialog.openConfirm(null, 
							"Search entities", 
							"A query has been applied for the repository " + 
							repository.getName());
				}
				else{
					MessageDialog.openInformation(null, "Search entities", "Searching could not be called");
				}
			}
			else{
				MessageDialog.openInformation(null, "Search entities", "Repository must be selected");
			}
		}
		
		return null;
	}
	
	private Repository getRepositoryFrom(EObject namedElementSelected){
		if(namedElementSelected instanceof Repository)
			return (Repository) namedElementSelected;
		else
			return getRepositoryFrom(namedElementSelected.eContainer());
	}
}