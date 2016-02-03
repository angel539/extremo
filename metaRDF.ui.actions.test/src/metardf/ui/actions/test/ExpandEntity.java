package metardf.ui.actions.test;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import metaRDF.core.model.IRepository;
import metaRDF.core.model.IResource;
import metaRDF.core.model.impl.RepositoryManager;
import metaRDF.core.model.impl.SemanticResource;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;
import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.TreeObject;
import metardf.ui.views.entities.model.TreeParent;

public class ExpandEntity extends SearchEntity{
	public ExpandEntity() {
	}

	@Override
	public void execute() {
		ISelection selection = getViewer().getSelection();
		Object obj = ((IStructuredSelection)selection).getFirstElement();
		
		if(obj instanceof EntityParent){
			if(!isOnTheTree((EntityParent) obj)){
				RepositoryManager repositoryManager = RepositoryManager.getInstance();
				List<IFormatAssistant> assistances = AssistantFactory.getInstance().getAssistances();
				//searching
				for(IRepository repository : repositoryManager.getRepositories()){    
					for(IResource resource : repository.getResources()){
						if(resource instanceof SemanticResource){			
							for(IFormatAssistant assistant : assistances){
								if(((FormatAssistant)assistant).getNameExtension().compareTo(resource.getAssistant())==0){
									if((resource instanceof SemanticResource) && (assistant.load((SemanticResource) resource))){	
										defineEntity(assistant, ((EntityParent) obj).getSemanticElement());
									}
								}
							}
						}	
					}		
				}
				
				drawEntityParentContent((EntityParent) obj);
				getViewer().refresh();
			}
			else{
				showMessage("Entity " + ((EntityParent)obj).getName() + " is already expanded on the list");
			}
		}
	}

	private boolean isOnTheTree(EntityParent obj){
		boolean onTheTree = false;
		Object element = obj;
		
		while((((TreeParent) element).getParent() != getRoot()) && (!onTheTree)){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof EntityParent) && (child!=obj)){
					if(((EntityParent) child).getSemanticElement().getIdToString().compareTo(((EntityParent) obj).getSemanticElement().getIdToString())==0){
						onTheTree = true;
					}	
				}
			}
			element = ((TreeParent) element).getParent();
		}
		
		if(((TreeParent)element).getParent() == getRoot()){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof EntityParent) && (child!=obj)){
					if(((String) ((EntityParent) child).getSemanticElement().getId()).compareTo((String) ((EntityParent) obj).getSemanticElement().getId())==0){
						onTheTree = true;
					}
				}		
			}
		}
		
		return onTheTree;
	}
}
