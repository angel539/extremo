package metardf.repository;

import java.util.List;

public abstract class RDF2EcoreElementFinder {
	List<String> RDFrepositories;
	SearchType searchType;
	
	public RDF2EcoreElementFinder(SearchType type) {
		
	}

	public void setSearchType(SearchType searchType) {
	}
	
	public void addRepositories(List<String> repositories){
		
	}
}
