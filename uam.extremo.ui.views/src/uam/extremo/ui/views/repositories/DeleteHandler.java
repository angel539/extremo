package uam.extremo.ui.views.repositories;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.core.commands.AbstractHandler;

public class DeleteHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection != null & selection instanceof IStructuredSelection) {	
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object firstselection = strucSelection.getFirstElement();

			if (firstselection != null && firstselection instanceof EObject) {
				EObject eObject = (EObject) firstselection;
				EcoreUtil.delete(eObject, true);
			}
		}
		
		return null;
	}
}
