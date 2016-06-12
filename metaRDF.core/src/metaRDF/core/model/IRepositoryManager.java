package metaRDF.core.model;

import java.io.Serializable;
import java.util.List;

public interface IRepositoryManager extends Serializable{
	List<IRepository> getRepositories();
	void addRepository(IRepository repository);
	IRepository addRepository(String uri, String name, String description);
	void setRepositories(List<IRepository> repositories);
}
