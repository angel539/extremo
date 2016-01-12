package metaRDF.core.model.impl;

import java.util.List;

import metaRDF.core.model.IObjectProperty;

public class ObjectProperty implements IObjectProperty{
	String name;
	String uri;
	List<String> ranges;
	boolean isFromSuper;
	String description;
	
	public ObjectProperty(String name, String uri, List<String> ranges, boolean isFromSuper, String description){
		this.name = name;
		this.uri = uri;
		this.ranges = ranges;	
		this.isFromSuper = isFromSuper;
		this.description = description;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getURI() {
		return uri;
	}

	@Override
	public List<String> getRanges() {
		return ranges;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + uri + ", " + ranges.toString() + "]";
	}

	@Override
	public boolean isFromSuper() {
		// TODO Auto-generated method stub
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
	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public void setComment(String comment) {
		// TODO Auto-generated method stub
		
	}
}
