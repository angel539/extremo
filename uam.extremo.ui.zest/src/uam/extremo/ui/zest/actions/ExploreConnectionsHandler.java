package uam.extremo.ui.zest.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import uam.extremo.core.Resource;
import uam.extremo.ui.zest.resourceexplorer.ResourceExplorerViewPart;

public class ExploreConnectionsHandler extends AbstractHandler {
	public static final String GRAPH_VIEW_ID = "uam.extremo.ui.zest.views.InheritanceGraphViewPart";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection != null & selection instanceof IStructuredSelection) {	
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object firstselection = strucSelection.getFirstElement();
			
			if (firstselection != null && firstselection instanceof Resource) {
				Resource resource = (Resource) firstselection;
				
				try {
					IViewPart viewPart = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(GRAPH_VIEW_ID);
				
					if (viewPart instanceof ResourceExplorerViewPart) {
						ResourceExplorerViewPart resourceExplorerViewPart = (ResourceExplorerViewPart) viewPart;
						resourceExplorerViewPart.setModel(resource);
					}
				}
				catch (PartInitException e) {
				}
			}
		}
		
		return null;
	}
}
