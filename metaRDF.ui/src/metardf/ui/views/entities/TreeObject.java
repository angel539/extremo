package metardf.ui.views.entities;

import org.eclipse.core.runtime.IAdaptable;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.IProperty;
import metaRDF.core.model.ISemanticElement;
import metardf.ui.views.entities.EntityView.TreeParent;

public class TreeObject implements IAdaptable {
	private String name;
	private TreeParent parent;
	private ISemanticElement element;
	
	public ISemanticElement getElement() {
		return element;
	}

	public void setElement(ISemanticElement element) {
		this.element = element;
	}

	public TreeObject(String name){
		this.name = name;
	}
	
	public TreeObject(Object object) {
		if(object instanceof IDataProperty){
			if(((IDataProperty) object).isFromSuper()){
				if(((IDataProperty) object).getRange() == null) this.name = ((IProperty) object).getName() + " (super)";
				else this.name = ((IProperty) object).getName() + " : " + ((IDataProperty) object).getRange().toString() + " (super)";
			}
			else{
				this.name = ((IProperty) object).getName();
			}	
		}else{
			if(object instanceof IObjectProperty){
				if(((IObjectProperty) object).isFromSuper()){
					this.name = ((IProperty) object).getName() + " : " + ((IObjectProperty) object).getRanges() + " (super)";
				}
				else{
					this.name = ((IProperty) object).getName() + " : " + ((IObjectProperty) object).getRanges();
				}	
			}
			else{
				this.name = object.toString();
			}
		}
		
		if(object instanceof ISemanticElement) this.element = (ISemanticElement) object;
	}
	
	public String getName() {
		return name;
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
}
