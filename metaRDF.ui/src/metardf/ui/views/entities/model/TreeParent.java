package metardf.ui.views.entities.model;

import java.util.ArrayList;
import java.util.List;

public class TreeParent extends TreeObject {
	private static final long serialVersionUID = 1517461293760864607L;
	
	private ArrayList<TreeObject> children;

	public TreeParent(Object object) {
		super(object);
		children = new ArrayList<TreeObject>();
	}
	
	public TreeParent(String name){
		super(name);
		children = new ArrayList<TreeObject>();
	}
	
	public void addChild(TreeObject child) {
		children.add(child);
		child.setParent(this);
	}
	
	public void addChildrenProperties(List<DataPropertyTreeObject> list) {
		children.addAll(list);
		list.forEach(c -> c.setParent(this));
		//child.setParent(this);
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