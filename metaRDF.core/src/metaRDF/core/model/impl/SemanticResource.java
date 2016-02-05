package metaRDF.core.model.impl;

import java.util.ArrayList;
import java.util.List;

import metaRDF.core.model.IResource;
import metaRDF.core.model.ISemanticClass;

public class SemanticResource implements IResource{	
	private Object id;
	private String name;
	private String description;
	private String assistant;
	private boolean isAlive = true;
	private List<ISemanticClass> classes;

	public SemanticResource(Object id, String name){
		super();
		this.name = name;
		this.id = id;
		this.classes = new ArrayList<ISemanticClass>();
	}


	@Override
	public List<ISemanticClass> getClasses() {
		return classes;
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
	public void addClasses(List<ISemanticClass> classes) {
		this.classes.addAll(classes);
	}

	@Override
	public void addClass(ISemanticClass clazz) {
		this.classes.add(clazz);
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
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
	public String toString() {
		String repositoryString = "resource";
		repositoryString = repositoryString + " @name=" + getName();
		repositoryString = repositoryString + " @description=" + getDescription();
		repositoryString = repositoryString + " @uri=" + getId();
		return repositoryString;
	}

	@Override
	public void setClasses(List<ISemanticClass> classes) {
		this.classes = classes;	
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getIdToString() {
		return getId().toString();
	}

	public String getAssistant() {
		return assistant;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}


	@Override
	public void setIdToString(String idString) {
	}


	@Override
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
