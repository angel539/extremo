 package uam.extremo.ui.views.repositories.actions;
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
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.wizards.dialogs.searchnew.SearchWizardDialog;

public class SearchSemanticNodesHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		AssistantFactory.getInstance().putAllResourceToNotActive();
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		
		if (selection != null & selection instanceof IStructuredSelection) {	
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object firstselection = strucSelection.getFirstElement();

			if (firstselection instanceof Repository) {
				Repository repository = (Repository) firstselection;
				
				WizardDialog wizardDialog = new WizardDialog(null, new SearchWizardDialog(repository));
				if (wizardDialog.open() == Window.OK) {
					MessageDialog.openConfirm(null, "Search entities", "Ok");
				}
				else{
					MessageDialog.openError(null, "Search entities", "Searching could not be called");
				}
			}
			else{
				MessageDialog.openError(null, "Search entities", "Repository must be selected");
			}
		}
		
		return null;
	}
}