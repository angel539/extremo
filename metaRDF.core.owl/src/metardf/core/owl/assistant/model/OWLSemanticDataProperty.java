package metardf.core.owl.assistant.model;

import metaRDF.core.model.Datatype;
import metaRDF.core.model.impl.DataProperty;

public class OWLSemanticDataProperty extends DataProperty{
	Datatype range;
	String id;
	
	public OWLSemanticDataProperty(String id, String name, String type, boolean isFromSuper, String description) {
		super(id, name, type, isFromSuper, description);
		this.id = id;
	}
	
	public Datatype getRange() {
		return range;
	}

	public void setRange(Datatype range) {
		this.range = range;
	}

	@Override
	public String toString() {
		return "[" + getName() + ", " + getId() + ", " + range + "]";
	}

	@Override
	public String getIdToString() {
		// TODO Auto-generated method stub
		return this.id;
	}		
}