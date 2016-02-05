package metardf.ui.dnd;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.part.ViewPart;

import metardf.ui.views.entities.EntityView;
import metardf.ui.views.entities.model.TreeParent;

public abstract class ResourceViewAction extends Action implements IResourceViewActionContribution{
	protected ViewPart view = null;
	
	public ViewPart getView(){
		return view;
	}
	
	public void setView(ViewPart view){
		this.view = view;
	}
	
	@Override
	public final void run(){
		execute();
	}
	
	protected TreeViewer getViewer(){
		return ((EntityView) this.view).getViewer();
	}
	
	protected TreeParent getRoot(){
		return ((EntityView) this.view).getRoot();
	}
	
	protected void showMessage(String message) {
		MessageDialog.openInformation(
			getViewer().getControl().getShell(),
			"Entities",
			message);
	}
}
