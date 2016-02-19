package metaRDF.core.model.impl;

import java.util.Comparator;
import metaRDF.core.model.IDataProperty;

public abstract class DataProperty implements IDataProperty{
	String name;
	String type;
	Object id;
	boolean isFromSuper;
	String description;
	
	int weight = 0;
	
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
	
	@Override
	public int getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
    public int compareTo(IDataProperty o) {
        return Comparators.WEIGHT.compare(this, o);
    }
	
	public static class Comparators {
	    public static final Comparator<IDataProperty> NAME = (IDataProperty o1, IDataProperty o2) -> o1.getName().compareTo(o2.getName());
	    public static final Comparator<IDataProperty> WEIGHT = (IDataProperty o1, IDataProperty o2) -> Integer.compare(o1.getWeight(), o2.getWeight());  
	}
}