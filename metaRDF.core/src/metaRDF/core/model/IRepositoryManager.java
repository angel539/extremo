package metaRDF.core.model;

import java.util.List;

public interface IRepositoryManager{
	List<IRepository> getRepositories();
	void addRepository(IRepository repository);
	IRepository addRepository(String uri, String name, String description);
	void setRepositories(List<IRepository> repositories);
}
