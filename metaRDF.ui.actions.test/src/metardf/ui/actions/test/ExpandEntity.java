package metardf.ui.actions.test;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import metaRDF.core.model.ISemanticClass;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.IFormatAssistant;
import metardf.ui.dnd.ResourceViewAction;
import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.TreeObject;
import metardf.ui.views.entities.model.TreeParent;

public class ExpandEntity extends ResourceViewAction {
	public ExpandEntity() {
	}

	@Override
	public void execute() {
		ISelection selection = getViewer().getSelection();
		Object obj = ((IStructuredSelection)selection).getFirstElement();
		
		if(obj instanceof EntityParent){
			if(!isOnTheTree((EntityParent) obj)){
				expandEntity(((EntityParent) obj));
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
	
	private void expandEntity(EntityParent entity){
		for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){			
			((ISemanticClass) entity.getSemanticElement()).addProperties(assistant.getDataProperties(entity.getSemanticElement().getId(), true, true));
			entity.drawProperties();
			((ISemanticClass) entity.getSemanticElement()).addReferences(assistant.getObjectProperties(entity.getSemanticElement().getId(), true, true));
			entity.drawReferences();
			((ISemanticClass) entity.getSemanticElement()).addSuperclasses(assistant.getSuper(entity.getSemanticElement().getId(), false));
			entity.drawSuperClasses();
			((ISemanticClass) entity.getSemanticElement()).addSubclasses(assistant.getSub(entity.getSemanticElement().getId(), false));
			entity.drawSubclasses();
		}
		
	}
}
