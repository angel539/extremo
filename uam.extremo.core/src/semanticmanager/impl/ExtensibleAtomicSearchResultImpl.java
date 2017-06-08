package semanticmanager.impl;

import semanticmanager.DataModelTypeSearchResultOptionValue;
import semanticmanager.ExtensibleAtomicSearchResult;
import semanticmanager.PrimitiveTypeSearchResultOptionValue;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.impl.AtomicSearchResultImpl;

public class ExtensibleAtomicSearchResultImpl extends AtomicSearchResultImpl implements ExtensibleAtomicSearchResult {
	public Object getOptionValue(String key) {
		for(SearchResultOptionValue value : getValues()){
			if (value instanceof PrimitiveTypeSearchResultOptionValue) {
				PrimitiveTypeSearchResultOptionValue stringValue = (PrimitiveTypeSearchResultOptionValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){
						return stringValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
			
			if (value instanceof DataModelTypeSearchResultOptionValue) {
				DataModelTypeSearchResultOptionValue dataModelValue = (DataModelTypeSearchResultOptionValue) value;
				
				try{
					if(dataModelValue.getOption().getId().equals(key)){
						return dataModelValue.getValue();
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
