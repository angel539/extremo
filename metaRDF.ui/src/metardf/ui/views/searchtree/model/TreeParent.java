package metardf.ui.views.searchtree.model;

import java.util.ArrayList;

import metardf.ui.views.searchtree.model.TreeObject;

public class TreeParent extends TreeObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8313847398519152400L;
	private ArrayList<TreeObject> children;
	
	
	public TreeParent(Object object) {
		super(object);
		children = new ArrayList<TreeObject>();
	}
	
	public TreeParent(String name) {
		super(name);
		children = new ArrayList<TreeObject>();
	}
	public void addChild(TreeObject child) {
		children.add(child);
		child.setParent(this);
	}
	
	
	public void removeChild(TreeObject child) {
		children.remove(child);
		child.setParent(null);
	}
	public TreeObject [] getChildren() {
		return (TreeObject [])children.toArray(new TreeObject[children.size()]);
	}
	public boolean hasChildren() {
		return children.size()>0;
	}
}