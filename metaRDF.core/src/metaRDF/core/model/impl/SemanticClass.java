package metaRDF.core.model.impl;

import java.util.ArrayList;
import java.util.List;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;

public abstract class SemanticClass implements ISemanticClass{
	Object id;
	String name;
	String comment;
	List<ISemanticClass> superclasses;
	List<ISemanticClass> subclasses;
	List<IDataProperty> properties;
	List<IObjectProperty> references;
	
	public SemanticClass(Object id, String name, String description){
		this.name = name;
		this.id = id;
		this.comment = description;
	}
	
	public SemanticClass() {
	}

	@Override
	public Object getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}



	@Override
	public String getDescription() {
		return comment;
	}

	@Override
	public List<IDataProperty> getProperties() {
		return properties;
	}

	@Override
	public List<IObjectProperty> getReferences() {
		return references;
	}

	@Override
	public List<ISemanticClass> getSuperclasses() {
		return superclasses;
	}

	@Override
	public List<ISemanticClass> getSubclasses() {
		return subclasses;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setDescription(String comment) {
		this.comment = comment;
	}

	@Override
	public void setId(Object id) {
		this.id = id;
	}

	@Override
	public void setSuperclasses(List<ISemanticClass> superclasses) {
		this.superclasses = superclasses;
	}

	@Override
	public void addSuperclasses(List<ISemanticClass> superclasses) {
		if(this.superclasses == null) this.superclasses = new ArrayList<ISemanticClass>();
		this.superclasses.addAll(superclasses);
	}

	@Override
	public void setSubclasses(List<ISemanticClass> subclasses) {
		this.subclasses = subclasses;
	}

	@Override
	public void addSubclasses(List<ISemanticClass> subclasses) {
		if(this.subclasses == null) this.subclasses = new ArrayList<ISemanticClass>();
		this.subclasses.addAll(subclasses);
		
	}

	@Override
	public void setProperties(List<IDataProperty> properties) {
		this.properties = properties;
	}

	@Override
	public void addProperties(List<IDataProperty> properties) {
		if(this.properties == null) this.properties = new ArrayList<IDataProperty>();
		this.properties.addAll(properties);
		
	}

	@Override
	public void setReferences(List<IObjectProperty> references) {
		this.references = references;
	}

	@Override
	public void addReferences(List<IObjectProperty> references) {
		if(this.references == null) this.references = new ArrayList<IObjectProperty>();
		this.references.addAll(references);
	}
}
