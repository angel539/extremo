package uam.extremo.core;

import uam.extremo.core.AtomicSearchResult;
import uam.extremo.core.SearchConfiguration;

public interface ExtensibleAtomicSearchResult extends AtomicSearchResult {	
	SearchConfiguration getConfiguration();
	void setConfiguration(SearchConfiguration value);
	
	Object getOptionValue(String key);
}
