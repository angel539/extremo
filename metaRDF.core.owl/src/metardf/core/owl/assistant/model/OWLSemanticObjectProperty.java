package metardf.core.owl.assistant.model;

import java.util.List;

import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.impl.ObjectProperty;

public class OWLSemanticObjectProperty extends ObjectProperty{
	String id;
	OWLSemanticClass range;
	
	public OWLSemanticObjectProperty(){
		super();
	}
	
	public OWLSemanticObjectProperty(String id, OWLSemanticClass range, String name, boolean isFromSuper, String description) {
		super(id, range, name, isFromSuper, description);
		this.id = id;
		this.range = range;
	}

	List<String> ranges;

	public List<String> getRanges() {
		return ranges;
	}
	
	@Override
	public String toString() {
		String myString = "[" + getName();
		if(getId() != null) myString = myString + ", " + getId();
		if(ranges != null) myString = myString + ", " + ranges.toString();
		return myString + "]";
	}

	@Override
	public ISemanticClass getRange() {
		return this.range;
	}

	@Override
	public void setRange(ISemanticClass range) {
		this.range = (OWLSemanticClass) range;
	}

}
