package semanticmanager.impl;

import semanticmanager.ExtensibleAtomicSearchResult;
import semanticmanager.SearchResultOptionValue;

public class ExtensibleAtomicSearchResultImpl extends AtomicSearchResultImpl implements ExtensibleAtomicSearchResult {
	public Object getOptionValue(String key) {
		for(SearchResultOptionValue value : getValues()){
			if (value instanceof SearchResultOptionValue) {
				SearchResultOptionValue stringValue = (SearchResultOptionValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){
						return stringValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
		}
		return null;
	}
}
