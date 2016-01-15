package metaRDF.core.model.impl;

import java.util.ArrayList;
import java.util.List;

import metaRDF.core.model.IRepository;
import metaRDF.core.model.IResource;

public class Repository implements IRepository {
	private String name;
	private String description;
	private String uri;
	private List<IResource> resources;
	
	public Repository(String name, String description, String uri){
		super();
		this.name = name;
		this.description = description;
		this.uri = uri;
		resources = new ArrayList<IResource>();
	}
	
	public Repository(){
		super();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		//firePropertyChange("name", this.name, this.name = name);
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
		//firePropertyChange("description", this.description, this.description = description);
	}

	@Override
	public String getURI() {
		return uri;
	}

	@Override
	public void setURI(String uri) {
		this.uri = uri;
		//firePropertyChange("uri", this.uri, this.uri = uri);
	}

	@Override
	public List<IResource> getResources() {
		return resources;
	}

	@Override
	public void setResources(List<IResource> resources) {
		this.resources = resources;
		//firePropertyChange("resources", this.resources, this.resources = resources);
	}

	@Override
	public void addResources(List<IResource> resources) {
		this.resources.addAll(resources);
	}

	@Override
	public void addResource(IResource resource) {
		resources.add(resource);
	}
	
	@Override
	public IResource createResource(String name, String description, String uri){
		SemanticResource resource = new SemanticResource(name, description, uri);
		resources.add(resource);
		return resource;
	}
	
	@Override
	public String toString() {
		String repositoryString = "repository";
		repositoryString = repositoryString + " @name=" + getName();
		repositoryString = repositoryString + " @description=" + getDescription();
		repositoryString = repositoryString + " @uri=" + getURI();
		
		String resourcesString = "\n";
		for(IResource resource : resources){
			resourcesString = resourcesString + resource.toString() + "\n";
		}
		
		return repositoryString + resourcesString;
	}
}

