package metardf.ui.views.searchtree;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IViewSite;

import metardf.ui.views.searchtree.model.*;

public class SearchTreeViewContentProvider implements IStructuredContentProvider, ITreeContentProvider {	
	private TreeParent invisibleRoot;
	private IViewSite iViewSite;

	public SearchTreeViewContentProvider(TreeParent invisibleRoot, IViewSite iViewSite) {
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