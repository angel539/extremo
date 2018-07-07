package uam.extremo.ui.views.actions.compositesearch;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import uam.extremo.core.CompositeSearchConfiguration;
import uam.extremo.core.ConnectionType;
import uam.extremo.core.ExtendedSemanticmanagerFactory;
import uam.extremo.core.RepositoryManager;
import uam.extremo.core.SimpleSearchConfiguration;

public class OrCompositeSearchConfigurationHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection != null & selection instanceof IStructuredSelection) {	
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			Object firstselection = strucSelection.getFirstElement();
			
			if (firstselection != null) {
				if(firstselection instanceof SimpleSearchConfiguration){
					SimpleSearchConfiguration simpleSearchConfiguration = (SimpleSearchConfiguration) firstselection;
					
					EObject container = simpleSearchConfiguration.eContainer();	
					if (container instanceof CompositeSearchConfiguration) {
						CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration) container;
						
						CompositeSearchConfiguration newComposition = ExtendedSemanticmanagerFactory.eINSTANCE.createCompositeSearchConfiguration();
						newComposition.setType(ConnectionType.OR);
						
						compositeSearchConfiguration.getChildren().add(newComposition);
					}
					else{
						if (container instanceof RepositoryManager) {
							RepositoryManager repositoryManager = (RepositoryManager) container;
							//CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration) container;
							CompositeSearchConfiguration newComposition = ExtendedSemanticmanagerFactory.eINSTANCE.createCompositeSearchConfiguration();
							newComposition.setType(ConnectionType.OR);
							
							repositoryManager.getConfigurations().add(newComposition);
						}
					}
				}
				else{
					if (firstselection instanceof CompositeSearchConfiguration) {
						CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration) firstselection;
						
						CompositeSearchConfiguration newComposition = ExtendedSemanticmanagerFactory.eINSTANCE.createCompositeSearchConfiguration();
						newComposition.setType(ConnectionType.OR);
						
						compositeSearchConfiguration.getChildren().add(newComposition);
					}
				}
			}
		}
		
		return null;
	}
}