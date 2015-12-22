package metaRDF.core.model;

import java.util.List;

public interface IRepository {
	String getName();
	void setName(String name);
	
	String getDescription();
	void setDescription(String description);
	
	String getURI();
	void setURI(String uri);
	
	List<IResource> getResources();
	void setResources(List<IResource> resources);
	void addResources(List<IResource> resources);
	void addResource(IResource resource);
	IResource createResource(String name, String description, String uri);
	
}
