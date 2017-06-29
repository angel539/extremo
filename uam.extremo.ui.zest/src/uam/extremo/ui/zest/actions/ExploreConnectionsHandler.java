package uam.extremo.ui.zest.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import semanticmanager.Repository;
//import uam.extremo.ui.zest.views.inheritance.ConnectionsGraphViewPart;

public class ExploreConnectionsHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection != null & selection instanceof IStructuredSelection) {	
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object firstselection = strucSelection.getFirstElement();
			
			if (firstselection != null && firstselection instanceof Repository) {
				Repository repository = (Repository) firstselection;
				
				IWorkbenchPage wp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IViewPart viewPart = wp.findView("uam.extremo.ui.zest.views.InheritanceGraphViewPart");
				
				/*if (viewPart instanceof ConnectionsGraphViewPart) {
					ConnectionsGraphViewPart graphViewPart = (ConnectionsGraphViewPart) viewPart;
					graphViewPart.setModel(repository);
				}*/
			}
		}
		
		return null;
	}
}
