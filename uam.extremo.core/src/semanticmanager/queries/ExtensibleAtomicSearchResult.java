package semanticmanager.queries;

public interface ExtensibleAtomicSearchResult extends AtomicSearchResult {	
	SearchConfiguration getConfiguration();
	void setConfiguration(SearchConfiguration value);
}
