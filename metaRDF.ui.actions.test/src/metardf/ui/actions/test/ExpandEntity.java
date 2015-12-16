package metardf.ui.actions.test;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import metardf.ui.extensions.ResourceViewAction;

public class ExpandEntity extends ResourceViewAction {

	public ExpandEntity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		ISelection selection = getViewer().getSelection();
		Object obj = ((IStructuredSelection)selection).getFirstElement();
		
		
		if(obj instanceof EntityParent){
			if(!isOnTheTree((EntityParent) obj)){
				expandEntity(((EntityParent) obj));
				viewer.refresh();
			}
			else{
				showMessage("Entity " + ((EntityParent)obj).getName() + " is already expanded on the list");
			}
		}
	}

}
