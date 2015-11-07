package metardf.core;

public class EntitiesRepositoryManager {
	String repository;
	
	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public EntitiesRepositoryManager(String repository){
		super();
		this.repository = repository;
	}
}
