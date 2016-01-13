package metaRDF.core.model.impl;

import java.util.ArrayList;
import java.util.List;

import metaRDF.core.model.IRepository;
import metaRDF.core.model.IRepositoryManager;

public class RepositoryManager implements IRepositoryManager{
	private static RepositoryManager INSTANCE = null;
	private List<IRepository> repositories;
	
	public RepositoryManager(){
		super();
		this.repositories = new ArrayList<IRepository>();
	}
	
	public Repository addRepository(String name, String description, String uri){
		Repository semanticRepository = new Repository(name, description, uri);
		repositories.add(semanticRepository);
		return semanticRepository;
	}
	
	@Override
	public List<IRepository> getRepositories() {
		return repositories;
	}

	@Override
	public void setRepositories(List<IRepository> repositories) {
		this.repositories = repositories;	
	}
	
    private static void createInstance() {
    	 if (INSTANCE == null) {
             synchronized(RepositoryManager.class) {
                 if (INSTANCE == null) { 
                     INSTANCE = new RepositoryManager();
                 }
             }
         }
    }

    public static RepositoryManager getInstance() {
        if (INSTANCE == null){
        	createInstance();
        }
        return INSTANCE;
    }
    
    public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException(); 
    }
}
