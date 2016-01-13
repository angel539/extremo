package metardf.ui.dnd;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.part.ViewPart;

import metaRDF.core.model.ISemanticClass;
import metardf.ui.views.entities.EntityView;

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
	
	protected void addEntity(ISemanticClass entity){
		if(this.view instanceof EntityView) ((EntityView) this.view).defineEntity(entity);
	}
	
	protected TreeViewer getViewer(){
		return ((EntityView) this.view).getViewer();
	}
}
