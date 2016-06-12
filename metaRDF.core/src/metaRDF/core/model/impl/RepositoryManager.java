package metaRDF.core.model.impl;

import java.util.ArrayList;
import java.util.List;

import metaRDF.core.model.IRepository;
import metaRDF.core.model.IRepositoryManager;

public class RepositoryManager implements IRepositoryManager{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9001070073707776398L;
	private static RepositoryManager INSTANCE = null;
	private List<IRepository> repositories;
	
	public RepositoryManager(){
		super();
		this.repositories = new ArrayList<IRepository>();
	}
	
	public Repository addRepository(String id, String name, String description){
		Repository semanticRepository = new Repository(id, name, description);
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
    
    @Override
    public String toString() {
    	String managerString = "";
    	for(IRepository repository : repositories){
    		managerString = managerString + repository.toString() + "\n";	
    	}
    	return managerString;
    }

	@Override
	public void addRepository(IRepository repository) {
		if(this.repositories == null) this.repositories = new ArrayList<IRepository>();
		this.repositories.add(repository);
	}
}
