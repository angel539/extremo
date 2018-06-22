package semanticmanager.impl;

import semanticmanager.ExtensibleAtomicSearchResult;
import semanticmanager.ModelTypeParamValue;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.SearchParamValue;
import semanticmanager.impl.AtomicSearchResultImpl;

public class ExtensibleAtomicSearchResultImpl extends AtomicSearchResultImpl implements ExtensibleAtomicSearchResult {
	public Object getOptionValue(String key) {
		for(SearchParamValue value : getValues()){
			if (value instanceof PrimitiveTypeParamValue) {
				PrimitiveTypeParamValue stringValue = (PrimitiveTypeParamValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){
						return stringValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
			
			if (value instanceof ModelTypeParamValue) {
				ModelTypeParamValue dataModelValue = (ModelTypeParamValue) value;
				
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
