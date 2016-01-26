package metaRDF.core.model.impl;

import metaRDF.core.model.IObjectProperty;

public abstract class ObjectProperty implements IObjectProperty{
	String name;
	Object id;
	boolean isFromSuper;
	String description;
	Object range;
	
	public ObjectProperty(Object id, Object range, String name, boolean isFromSuper, String description){
		this.name = name;
		this.id = id;
		this.range = range;
		this.isFromSuper = isFromSuper;
		this.description = description;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + id.toString() + "]";
	}

	@Override
	public boolean isFromSuper() {
		return isFromSuper;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void setDescription(String comment) {
		this.description = comment;	
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public void setId(Object id) {
		this.id = id;
	}
}
