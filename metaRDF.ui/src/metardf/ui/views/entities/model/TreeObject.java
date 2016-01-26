package metardf.ui.views.entities.model;

import org.eclipse.core.runtime.IAdaptable;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.IProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;

public class TreeObject implements IAdaptable {
	private String name = "";
	private TreeParent parent;
	ISemanticElement element;
	
	public ISemanticElement getSemanticElement() {
		return element;
	}

	public void setSemanticElement(ISemanticElement element) {
		this.element = element;
	}

	public TreeObject(String name){
		this.name = name;
	}
	
	public TreeObject(Object object) {
		if(object instanceof ISemanticElement){
			this.name = this.name + ((ISemanticElement) object).getName();
		}
		
		if(object instanceof ISemanticClass){
			if(((ISemanticClass) object).getProperties()!=null) this.name = this.name + " [attr:" + ((ISemanticClass) object).getProperties().size() + "]";
			if(((ISemanticClass) object).getReferences()!=null) this.name = this.name + " [ref:" + ((ISemanticClass) object).getReferences().size() + "]";		
			if(((ISemanticClass) object).getSuperclasses()!=null) this.name = this.name + " [supers:" + ((ISemanticClass) object).getSuperclasses().size() + "]";		
			if(((ISemanticClass) object).getSubclasses()!=null) this.name = this.name + " [subs:" + ((ISemanticClass) object).getSubclasses().size() + "]";		
		}
		
		if(object instanceof IObjectProperty){
			this.name = this.name + " : " + ((IObjectProperty) object).getRangeAsSemanticClass().getName();
		}
		
		if(object instanceof IDataProperty){
			this.name = this.name + " : " + ((IDataProperty) object).getType();
		}
		
		if((object instanceof IProperty) && (((IProperty) object).isFromSuper())){
			this.name = this.name + " (super)";
		}
		
		if(object instanceof ISemanticClass) this.element = (ISemanticClass) object;
		if(object instanceof IObjectProperty) this.element = (IObjectProperty) object;
		if(object instanceof IDataProperty) this.element = (IDataProperty) object;
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
