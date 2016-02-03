package metaRDF.core.model.impl;

import metaRDF.core.model.IDataProperty;

public abstract class DataProperty implements IDataProperty{
	String name;
	String type;
	

	Object id;
	boolean isFromSuper;
	String description;
	
	public DataProperty(){
		
	}
	
	public DataProperty(Object id, String name, String type, boolean isFromSuper, String description){
		this.id = id;
		this.name = name;
		this.type = type;
		this.isFromSuper = isFromSuper;
		this.description = description;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Object getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + id + "]";
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
		this.name = name;
		
	}

	@Override
	public void setId(Object id) {
		this.id = id;	
	}

	@Override
	public void setDescription(String comment) {
		this.description = comment;
		
	}	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}