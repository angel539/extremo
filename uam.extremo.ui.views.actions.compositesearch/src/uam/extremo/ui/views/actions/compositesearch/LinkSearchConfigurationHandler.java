package uam.extremo.ui.views.actions.compositesearch;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import uam.extremo.core.CompositeSearchConfiguration;
import uam.extremo.ui.wizards.dialogs.link.LinkWizardDialog;

public class LinkSearchConfigurationHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection != null & selection instanceof IStructuredSelection) {	
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object firstselection = strucSelection.getFirstElement();

			if (firstselection != null) {
				if(firstselection instanceof CompositeSearchConfiguration){
					CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration) firstselection;
				
					WizardDialog wizardDialog = new WizardDialog(null, new LinkWizardDialog(compositeSearchConfiguration));
					if (wizardDialog.open() == Window.OK) {
						MessageDialog.openConfirm(null, 
								"Link search configuration", 
								"A query has been linked to a composite search configuration ");
					}
					else{
						MessageDialog.openInformation(null, "Search entities", "Searching could not be called");
					}
				}
				
			}
			else{
				MessageDialog.openInformation(null, "Search entities", "Repository must be selected");
			}
		}
		
		return null;
	}
}