package semanticmanager.impl;

import org.eclipse.emf.common.util.EList;

import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ExtensiblePredicateBasedSearch;
import semanticmanager.SearchOption;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.Type;

public class ExtensiblePredicateBasedSearchImpl extends PredicateBasedSearchImpl implements ExtensiblePredicateBasedSearch {
	public void addSearchOption(String id, String name, Type type) {
		SearchOption searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createSearchOption();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
	
	public Object getOptionValueKey(String key, EList<SearchResultOptionValue> inps) {
		for(SearchResultOptionValue value : inps){
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
