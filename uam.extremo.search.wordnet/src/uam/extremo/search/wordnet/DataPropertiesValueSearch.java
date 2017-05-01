package uam.extremo.search.wordnet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import semanticmanager.ExtensibleGroupedSearchResult;

import semanticmanager.impl.ExtensibleCustomSearchImpl;
import uam.extremo.search.wordnet.stemmer.LangUtils;

import semanticmanager.*;

public class DataPropertiesValueSearch extends ExtensibleCustomSearchImpl{
	private WordnetSearchExpansionTree expansionTree;

	public DataPropertiesValueSearch(){
		expansionTree = new WordnetSearchExpansionTree();
	}
	
	@Override
	public void search(SearchResult search) {
		
		/*
		
		if((search.getOptionValue("valuefield") != null) && (search.getOptionValue("valuefield") instanceof String)){
			
			String valueField = (String) search.getOptionValue("valuefield");
			
			List<NamedElement> namedElements = new ArrayList<NamedElement>();
			
			if(search.getApplyOnElements().isEmpty()){
				for(Resource resource : search.getResources()){
					for(SemanticNode semanticNode : resource.getNodes()){
						for(Property property : semanticNode.getProperties()){
							if(property instanceof DataProperty){
								DataProperty dataProperty = (DataProperty) property;
								namedElements.add(dataProperty);
							}
						}
					}
				}	
			}
			else{
				namedElements = search.getApplyOnElements();
			}
			
			expansionTree.expand(valueField);
			
			Map<String, Integer> searchList = (Map<String, Integer>) expansionTree.getOrderSearchesListByWeight();
			
			SemanticGroup dataPropertiesName = search.createSemanticGroup("descriptor = " + valueField, valueField);
			SemanticGroup dataPropertiesValue = search.createSemanticGroup("value = " + valueField, valueField);
			
			namedElements.forEach(
					element -> {
						if(element instanceof DataProperty){
							DataProperty dataProperty = (DataProperty) element;
							compareKeysByName(search, dataProperty, dataPropertiesName, searchList);
							compareKeysByValue(search, dataProperty, dataPropertiesValue, searchList);
						}
					}
			);
		}
		
		*/
	}

	/*
	
	private void compareKeysByName(ExtensibleGroupedSearchResult search, DataProperty dataProperty, SemanticGroup semanticGroup, Map<String, Integer> searchList) {
		if(dataProperty != null){
			for(Entry<String, Integer> word : searchList.entrySet()){
				if(dataProperty.getName().compareTo(word.getKey()) == 0){
					search.addNamedElementToSemanticGroup(semanticGroup, dataProperty);
				}
				
				List<String> wordInNameClass = LangUtils.cleanAndSeparateWords(dataProperty.getName());
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
	
	*/
}
