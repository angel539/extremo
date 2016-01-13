package metaRDF.core.model;

import java.util.List;

public interface IRepositoryManager{
	List<IRepository> getRepositories();
	IRepository addRepository(String name, String description, String uri);
	void setRepositories(List<IRepository> repositories);
}
