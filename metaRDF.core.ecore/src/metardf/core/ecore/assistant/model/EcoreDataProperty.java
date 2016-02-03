package metardf.core.ecore.assistant.model;

import org.eclipse.emf.ecore.EAttribute;

import metaRDF.core.model.impl.DataProperty;

public class EcoreDataProperty extends DataProperty{
	EAttribute id = null;
	String idString = null;
	
	public EcoreDataProperty(){
		super();
	}
	
	public EcoreDataProperty(EAttribute id, String name, String type, boolean isFromSuper, String description) {
		super(id, name, type, isFromSuper, description);
		this.id = id;
	}

	@Override
	public String toString() {
		return "[" + getName() + ", " + getId() + "]";
	}

	@Override
	public String getIdToString() {
		idString = id.getName();
		return idString;
	}

	@Override
	public void setIdToString(String idString) {
		this.idString = idString;
	}	
}