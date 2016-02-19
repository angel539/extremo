package metardf.ui.views.entities.model;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;

public class TreeObject implements IAdaptable {
	protected String name = "";
	private TreeParent parent;
	
	public TreeObject(String name){
		this.name = name;
	}
	
	private ISemanticElement element;
	
	public ISemanticElement getSemanticElement() {
		return element;
	}

	public void setSemanticElement(ISemanticElement element) {
		this.element = element;
	}
	
	public TreeObject(Object element){
		if(element instanceof ISemanticElement){
			this.name = this.name + ((ISemanticElement) element).getName();
			this.element = (ISemanticElement) element;
		}
		
		/*if(element instanceof ISemanticClass){
			if(((ISemanticClass) element).getProperties()!=null) this.name = this.name + " [attr:" + ((ISemanticClass) element).getProperties().size() + "]";
			if(((ISemanticClass) element).getReferences()!=null) this.name = this.name + " [ref:" + ((ISemanticClass) element).getReferences().size() + "]";		
			if(((ISemanticClass) element).getSuperclasses()!=null) this.name = this.name + " [supers:" + ((ISemanticClass) element).getSuperclasses().size() + "]";		
			if(((ISemanticClass) element).getSubclasses()!=null) this.name = this.name + " [subs:" + ((ISemanticClass) element).getSubclasses().size() + "]";		
		}*/
		
		if(element instanceof IDataProperty){
			this.name = this.name + " : " + ((IDataProperty) element).getType();
		}
		
		if(element instanceof IObjectProperty){
			this.name = this.name + " : " + ((IObjectProperty) element).getRangeAsSemanticClass().getName();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
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
}
