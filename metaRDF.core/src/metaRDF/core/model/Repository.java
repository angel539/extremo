package metaRDF.core.model;

import java.util.List;

public interface Repository {
	String getName();
	void setName(String name);
	
	String getDescription();
	void setDescription(String description);
	
	String getURI();
	void setURI(String uri);
	
	List<Resource> getResources();
	void setResources(List<Resource> resources);
	void addResources(List<Resource> resources);
	void addResource(Resource resource);
	Resource createResource(String name, String description, String uri);
	
}
