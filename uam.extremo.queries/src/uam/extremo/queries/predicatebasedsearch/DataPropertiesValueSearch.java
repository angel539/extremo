package uam.extremo.queries.predicatebasedsearch;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.ExtensibleGroupedSearchResult;
import semanticmanager.NamedElement;
import semanticmanager.SemanticGroup;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import uam.extremo.queries.services.stemmer.LangUtils;
import semanticmanager.SearchParamValue;

public class DataPropertiesValueSearch extends ExtensiblePredicateBasedSearchImpl{	
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchParamValue> inps) {
		if (namedElement instanceof DataProperty) {			
			Object valuefield = getOptionValueKey("valuefield", inps);
			
			if((valuefield != null) && (valuefield instanceof String)){
				String valuefieldString = (String) valuefield;
				
				if(((DataProperty) namedElement).getValue().compareTo(valuefieldString) == 0)
					return true;
				else
					return false;
			}
			return false;
		}
		return false;
	}
	
	private void compareKeysByValue(ExtensibleGroupedSearchResult search, DataProperty dataProperty, SemanticGroup semanticGroup, Map<String, Integer> searchList) {
		if(dataProperty != null){
			for(NamedElement describe : dataProperty.getDescribes()){
				if(describe instanceof DataProperty){
					DataProperty dataPropertyDescribed = (DataProperty) describe;
					
					for(Entry<String, Integer> word : searchList.entrySet()){
						if(dataPropertyDescribed.getValue().compareTo(word.getKey()) == 0){
							search.addNamedElementToSemanticGroup(semanticGroup, dataProperty);
						}
						
						List<String> wordInNameClass = LangUtils.cleanAndSeparateWords(dataPropertyDescribed.getValue());
						for(String wordInName : wordInNameClass){	
							if(wordInName.compareTo(word.getKey()) == 0){
								search.addNamedElementToSemanticGroup(semanticGroup, dataProperty);
							}
							else{
								if(LangUtils.haveTheSameStem(wordInName, word.getKey())){
									search.addNamedElementToSemanticGroup(semanticGroup, dataProperty);
								}
							}
						}
					}
				}	
			}
		}
	}
}
