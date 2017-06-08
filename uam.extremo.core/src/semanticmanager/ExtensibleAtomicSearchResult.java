package semanticmanager;

import semanticmanager.AtomicSearchResult;
import semanticmanager.SearchConfiguration;

public interface ExtensibleAtomicSearchResult extends AtomicSearchResult {	
	SearchConfiguration getConfiguration();
	void setConfiguration(SearchConfiguration value);
	
	Object getOptionValue(String key);
}
