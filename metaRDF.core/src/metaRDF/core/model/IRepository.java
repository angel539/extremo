package metaRDF.core.model;

import java.io.Serializable;
import java.util.List;

public interface IRepository extends Serializable{
	String getName();
	void setName(String name);
	
	String getDescription();
	void setDescription(String description);
	
	String getUri();
	void setUri(String uri);
	
	List<IResource> getResources();
	void setResources(List<IResource> resources);
	void addResources(List<IResource> resources);
	void addResource(IResource resource);
	IResource createResource(String uri, String name, String description);
}
