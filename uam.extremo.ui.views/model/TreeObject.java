package metardf.ui.views.searchtree.model;

import org.eclipse.core.runtime.IAdaptable;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISearch;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.IClassifier;

public class TreeObject implements IAdaptable {
	private String name;
	private TreeParent parent;
	
	public TreeObject(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParent(TreeParent parent) {
		this.parent = parent;
	}
	public TreeParent getParent() {
		return parent;
	}
	public String toString() {
		return getName();
	}
	public <T> T getAdapter(Class<T> key) {
		return null;
	}
	
	public TreeObject(Object element){
		if(element instanceof ISearch){
			this.name = this.name + ((ISearch) element).getWeights();
		}
	}
}
