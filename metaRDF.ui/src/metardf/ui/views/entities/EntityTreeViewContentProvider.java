package metardf.ui.views.entities;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IViewSite;
import metardf.ui.views.entities.EntityView.TreeParent;

public class EntityTreeViewContentProvider implements IStructuredContentProvider, ITreeContentProvider {	
	private TreeParent invisibleRoot;
	private IViewSite iViewSite;

	public EntityTreeViewContentProvider(TreeParent invisibleRoot, IViewSite iViewSite) {
		super();
		this.invisibleRoot = invisibleRoot;
		this.iViewSite = iViewSite;
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}
	
	public Object[] getElements(Object parent) {
		if (parent.equals(iViewSite)) {
			//if (invisibleRoot==null) initialize();
			return getChildren(invisibleRoot);
		}
		
		return getChildren(parent);
	}

	public Object getParent(Object child) {
		if (child instanceof TreeObject) {
			return ((TreeObject)child).getParent();
		}
		return null;
	}
	
	public Object [] getChildren(Object parent) {
		if (parent instanceof TreeParent) {
			return ((TreeParent)parent).getChildren();
		}
		return new Object[0];
	}
	
	public boolean hasChildren(Object parent) {
		if (parent instanceof TreeParent)
			return ((TreeParent)parent).hasChildren();
		return false;
	}
	
	/*private void initialize() {
		invisibleRoot = new TreeParent("");
	}*/
}