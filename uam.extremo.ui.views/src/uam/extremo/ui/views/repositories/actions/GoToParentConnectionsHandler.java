package uam.extremo.ui.views.repositories.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;

import uam.extremo.extensions.AssistantFactory;

import semanticmanager.NamedElement;

public class GoToParentConnectionsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		NamedElement drawnElement = AssistantFactory.getInstance().getDrawnElement();
		
		if(drawnElement != null){
			EObject parent = drawnElement.eContainer();
			if(parent != null && parent instanceof NamedElement){
				NamedElement toDrawElement = (NamedElement) parent;
				drawnElement.setDrawn(false);
				toDrawElement.setDrawn(true);
				AssistantFactory.getInstance().setDrawnElement(toDrawElement);
			}
		}
				
		return null;
	}
}
