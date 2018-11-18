package uam.extremo.core.impl;

import uam.extremo.core.ExtensibleAtomicSearchResult;
import uam.extremo.core.ModelTypeParamValue;
import uam.extremo.core.PrimitiveTypeParamValue;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.impl.AtomicSearchResultImpl;

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
