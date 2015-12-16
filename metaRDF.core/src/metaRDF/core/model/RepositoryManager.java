package metaRDF.core.model;

import java.util.List;

public interface RepositoryManager{
	List<Repository> getRepositories();
	Repository addRepository(String name, String description, String uri);
	void setRepositories(List<Repository> repositories);
}
