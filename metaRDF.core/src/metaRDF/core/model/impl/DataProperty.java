package metaRDF.core.model.impl;

import metaRDF.core.model.Datatype;
import metaRDF.core.model.IDataProperty;

public class DataProperty implements IDataProperty{
	String name;
	String uri;
	Datatype range;
	boolean isFromSuper;
	String description;
	
	public DataProperty(String name, String uri, Datatype type, boolean isFromSuper, String description){
		this.name = name;
		this.uri = uri;
		this.range = type;
		this.isFromSuper = isFromSuper;
		this.description = description;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return uri;
	}

	@Override
	public Datatype getRange() {
		// TODO Auto-generated method stub
		return range;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + uri + ", " + range + "]";
	}

	@Override
	public boolean isFromSuper() {
		return isFromSuper;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUri(String uri) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setComment(String comment) {
		// TODO Auto-generated method stub
		
	}		
}