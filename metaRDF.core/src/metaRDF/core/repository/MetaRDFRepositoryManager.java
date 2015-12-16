package metaRDF.core.repository;

import java.util.ArrayList;
import java.util.List;

import metaRDF.core.model.Repository;
import metaRDF.core.model.RepositoryManager;

public class MetaRDFRepositoryManager implements RepositoryManager{
	private static MetaRDFRepositoryManager INSTANCE = null;
	private List<Repository> repositories;
	
	public MetaRDFRepositoryManager(){
		super();
		this.repositories = new ArrayList<Repository>();
	}
	
	public MetaRDFRepository addRepository(String name, String description, String uri){
		MetaRDFRepository semanticRepository = new MetaRDFRepository(name, description, uri);
		repositories.add(semanticRepository);
		return semanticRepository;
	}
	
	@Override
	public List<Repository> getRepositories() {
		return repositories;
	}

	@Override
	public void setRepositories(List<Repository> repositories) {
		this.repositories = repositories;	
	}
	
    private static void createInstance() {
    	 if (INSTANCE == null) {
             synchronized(MetaRDFRepositoryManager.class) {
                 if (INSTANCE == null) { 
                     INSTANCE = new MetaRDFRepositoryManager();
                 }
             }
         }
    }

    public static MetaRDFRepositoryManager getInstance() {
        if (INSTANCE == null){
        	createInstance();
        }
        return INSTANCE;
    }
    
    public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException(); 
    }
}
