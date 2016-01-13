package metaRDF.core.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;

public class SemanticClass implements ISemanticClass{
	String uri;
	String name;
	String label;
	String comment;
	List<ISemanticClass> superclasses;
	List<ISemanticClass> subclasses;
	List<IDataProperty> properties;
	List<IObjectProperty> references;
	
	public SemanticClass(String name, String uri, String label, String description){
		this.name = name;
		this.uri = uri;
		this.label = label;
		this.comment = description;
	}
	
	public SemanticClass() {
	}

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return uri;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getLabel() {
		String clean = label.toString().replace('_', ' ').replace('.', ' ');
		String[] spplited = StringUtils.splitByWholeSeparator(clean, null, 0);
		String joinedCapitalize = "";
		for(String s : spplited) joinedCapitalize = joinedCapitalize + WordUtils.capitalize(s);
		
		String[] wordList = StringUtils.splitByCharacterTypeCamelCase(joinedCapitalize);
		
		String parsedName = "";
		for(String s : wordList) parsedName = parsedName + s + " ";
		return parsedName;
		//return label;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return comment;
	}

	@Override
	public List<IDataProperty> getProperties() {
		// TODO Auto-generated method stub
		return properties;
	}

	@Override
	public List<IObjectProperty> getReferences() {
		// TODO Auto-generated method stub
		return references;
	}

	@Override
	public List<ISemanticClass> getSuperclasses() {
		// TODO Auto-generated method stub
		return superclasses;
	}

	@Override
	public List<ISemanticClass> getSubclasses() {
		// TODO Auto-generated method stub
		return subclasses;
	}
	
	@Override
	public void setProperties(List<IDataProperty> properties) {
		this.properties = properties;
	}
	
	@Override
	public void addProperties(List<IDataProperty> properties) {
		if (this.properties == null) this.properties = new ArrayList<IDataProperty>();
		this.properties.addAll(properties);
	}

	@Override
	public void setReferences(List<IObjectProperty> references) {
		this.references = references;
	}

	@Override
	public void addReferences(List<IObjectProperty> references) {
		if (this.references == null) this.references = new ArrayList<IObjectProperty>();
		this.references.addAll(references);
	}
	
	@Override
	public void setSuperclasses(List<ISemanticClass> superclasses) {
		this.superclasses = superclasses;
	}
	
	@Override
	public void addSuperclasses(List<ISemanticClass> superclasses) {
		if (this.superclasses == null) this.superclasses = new ArrayList<ISemanticClass>();
		this.superclasses.addAll(superclasses);
	}

	@Override
	public void setSubclasses(List<ISemanticClass> subclasses) {
		this.subclasses = subclasses;
	}
	
	@Override
	public void addSubclasses(List<ISemanticClass> subclasses) {
		if (this.subclasses == null) this.subclasses = new ArrayList<ISemanticClass>();
		this.subclasses.addAll(subclasses);
	}

	@Override
	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}
}
