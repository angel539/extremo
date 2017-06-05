package semanticmanager.impl;

import semanticmanager.DataModelType;
import semanticmanager.DataModelTypeSearchOption;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ExtensiblePredicateBasedSearch;
import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.Type;

public class ExtensiblePredicateBasedSearchImpl extends PredicateBasedSearchImpl implements ExtensiblePredicateBasedSearch {
	public void addPrimitiveTypeSearchOption(String id, String name, Type type) {
		PrimitiveTypeSearchOption searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createPrimitiveTypeSearchOption();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
	
	public void addDataModelTypeSearchOption(String id, String name, DataModelType type) {
		DataModelTypeSearchOption searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createDataModelTypeSearchOption();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
	
	/*public String getOptionValueKey(String key, EList<SearchResultOptionValue> inps) {
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
	}*/
}
