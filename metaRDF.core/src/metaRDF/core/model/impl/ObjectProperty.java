package metaRDF.core.model.impl;

import java.util.Comparator;

import metaRDF.core.model.IObjectProperty;

public abstract class ObjectProperty implements IObjectProperty{
	String name;
	Object id;
	boolean isFromSuper;
	String description;
	Object range;
	
	private int weight = 0;
	
	public ObjectProperty(){
		
	}
	
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
		if(id == null) return "[" + name + "]";
		else return "[" + name + ", " + id.toString() + "]";
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
	
	@Override
	public int getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
    public int compareTo(IObjectProperty o) {
        return Comparators.WEIGHT.compare(this, o);
    }
	
	public static class Comparators {
	    public static final Comparator<IObjectProperty> NAME = (IObjectProperty o1, IObjectProperty o2) -> o1.getName().compareTo(o2.getName());
	    public static final Comparator<IObjectProperty> WEIGHT = (IObjectProperty o1, IObjectProperty o2) -> Integer.compare(o1.getWeight(), o2.getWeight());  
	}
}
