package metardf.core.owl.assistant.model;

import java.util.List;

import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.impl.ObjectProperty;

public class OWLSemanticObjectProperty extends ObjectProperty{
	String id;
	
	public OWLSemanticObjectProperty(){
		super();
	}
	
	public OWLSemanticObjectProperty(String id, String range, String name, boolean isFromSuper, String description) {
		super(id, range, name, isFromSuper, description);
		this.id = id;
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
	public String getIdToString() {
		return this.id;
	}

	@Override
	public Object getRange() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISemanticClass getRangeAsSemanticClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRange(Object range) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRangeAsSemanticClass(ISemanticClass rangeSemanticClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIdToString(String idString) {
		this.id = idString;
	}

}
