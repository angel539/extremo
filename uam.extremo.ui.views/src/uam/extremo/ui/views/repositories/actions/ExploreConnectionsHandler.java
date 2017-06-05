package uam.extremo.ui.views.repositories.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import semanticmanager.NamedElement;
import uam.extremo.extensions.AssistantFactory;

public class ExploreConnectionsHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			
			Object object = strucSelection.getFirstElement();
			
			if(object instanceof NamedElement){
				NamedElement toDrawElement = (NamedElement) object;
				NamedElement drawnElement = AssistantFactory.getInstance().getDrawnElement();
				
				if(drawnElement == null){
					toDrawElement.setDrawn(true);
					AssistantFactory.getInstance().setDrawnElement(toDrawElement);
				}
				
				if(drawnElement != null && !drawnElement.equals(toDrawElement)){
					drawnElement.setDrawn(false);
					toDrawElement.setDrawn(true);
					
					AssistantFactory.getInstance().setDrawnElement(toDrawElement);
				}
			}
		}
		
		return null;
	}
}
