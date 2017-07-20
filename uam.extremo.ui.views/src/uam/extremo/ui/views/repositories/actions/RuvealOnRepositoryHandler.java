package uam.extremo.ui.views.repositories.actions;
 
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ISetSelectionTarget;

import uam.extremo.extensions.AssistantFactory;

public class RuvealOnRepositoryHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		AssistantFactory.getInstance().putAllResourceToNotActive();

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IViewPart view = page.findView("uam.extremo.ui.views.RepositoryView");
		
		if (view instanceof ISetSelectionTarget) {
			((ISetSelectionTarget) view).selectReveal(selection);
		}
		
		return null;
	}
}