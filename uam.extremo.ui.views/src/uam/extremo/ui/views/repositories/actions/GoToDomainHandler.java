package uam.extremo.ui.views.repositories.actions;
 
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import uam.extremo.core.NamedElement;
import uam.extremo.core.SemanticNode;
import uam.extremo.ui.views.repositories.RepositoryViewPart;

public class GoToDomainHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart view = page.findView("uam.extremo.ui.views.RepositoryView");
		
		if(view instanceof RepositoryViewPart){
			RepositoryViewPart viewPart = (RepositoryViewPart) view;
			Object firstSelection = ((IStructuredSelection) selection).getFirstElement();
			
			if(firstSelection != null && firstSelection instanceof SemanticNode){
				SemanticNode semanticNode = (SemanticNode) firstSelection;
				viewPart.goToDomain(semanticNode);
			}
		}
		
		return null;
	}
}