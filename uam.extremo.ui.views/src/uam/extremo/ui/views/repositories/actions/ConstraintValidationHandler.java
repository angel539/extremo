 package uam.extremo.ui.views.repositories.actions;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import semanticmanager.Constraint;
import semanticmanager.NamedElement;
import uam.extremo.extensions.AssistantFactory;

public class ConstraintValidationHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		AssistantFactory.getInstance().putAllResourceToNotActive();
		
		List<Constraint> constraints = new ArrayList<Constraint>();
		
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			
			for (Iterator<Object> iterator = strucSelection.iterator(); iterator.hasNext();) {
				Object element = iterator.next();
				
				if(element instanceof NamedElement){
					constraints.addAll(((NamedElement) element).getConstraints());
				}
			}
		 }
				
		for (Constraint constraint : constraints) {
			AssistantFactory.getInstance().validateConstraint(constraint);
		}
		
		return null;
	}
}