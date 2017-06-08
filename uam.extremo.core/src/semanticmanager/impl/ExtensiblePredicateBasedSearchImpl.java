package semanticmanager.impl;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataModelType;
import semanticmanager.DataModelTypeSearchOption;
import semanticmanager.DataModelTypeSearchResultOptionValue;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ExtensiblePredicateBasedSearch;
import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.PrimitiveTypeSearchResultOptionValue;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.Type;
import semanticmanager.impl.PredicateBasedSearchImpl;

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
	
	public Object getOptionValueKey(String key, EList<SearchResultOptionValue> inps) {
		for(SearchResultOptionValue value : inps){
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
