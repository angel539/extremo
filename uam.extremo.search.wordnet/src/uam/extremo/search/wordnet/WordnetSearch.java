package uam.extremo.search.wordnet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import semanticmanager.ExtensibleGroupedSearchResult;
import semanticmanager.*;
import semanticmanager.impl.ExtensibleCustomSearchImpl;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import uam.extremo.search.wordnet.stemmer.LangUtils;

public class WordnetSearch extends ExtensibleCustomSearchImpl{
	private WordnetSearchExpansionTree expansionTree;

	public WordnetSearch(){
		expansionTree = new WordnetSearchExpansionTree();
	}
	
	@Override
	public void search(SearchResult search) {
		
		/*
		
		if((search.getOptionValue("searchfield") != null) && (search.getOptionValue("searchfield") instanceof String)){
			String searchField = (String) search.getOptionValue("searchfield");
			List<NamedElement> namedElements = new ArrayList<NamedElement>();
			
			if(search.getApplyOnElements().isEmpty()){
				for(Resource resource : search.getResources()){
					namedElements.addAll(resource.getNodes());
				}	
			}
			else{
				namedElements = search.getApplyOnElements();
			}
			
			expansionTree.expand(searchField);
			Map<String, Integer> searchList = (Map<String, Integer>) expansionTree.getOrderSearchesListByWeight();
			
			SemanticGroup resources = search.createSemanticGroup(searchField + " in resources", searchField + " in resources");
			SemanticGroup nodes = search.createSemanticGroup(searchField + " in semantic nodes", searchField + " in semantic nodes");
			SemanticGroup dataProperties = search.createSemanticGroup(searchField + " in data properties", searchField + " in data properties");
			SemanticGroup references = search.createSemanticGroup(searchField + " in references", searchField + " in references");
			
			namedElements.forEach(
					element -> {
						if(element instanceof Resource){
							Resource resource = (Resource) element;
							
							resource.eAllContents().forEachRemaining(
								content -> {
									compareKeys(search, content, resources, searchList);
								}
							);							
						}
						if(element instanceof SemanticNode){
							SemanticNode semanticNode = (SemanticNode) element;
							
							semanticNode.eAllContents().forEachRemaining(
									content -> {
										compareKeys(search, content, nodes, searchList);
									}
								);
						}
						if(element instanceof DataProperty){
							compareKeys(search, element, dataProperties, searchList);
						}
						if(element instanceof ObjectProperty){
							compareKeys(search, element, resources, searchList);
							compareKeys(search, ((ObjectProperty) element).getRange(), references, searchList);
						}
					}
			);
		}
		
		*/
	}

	/*
	
	private void compareKeys(ExtensibleGroupedSearchResult search, Object element, SemanticGroup semanticGroup, Map<String, Integer> searchList) {
		if((element != null) && (element instanceof NamedElement)){
			NamedElement namedElement = (NamedElement) element;
			
			for(Entry<String, Integer> word : searchList.entrySet()){
				if(namedElement.getName().compareTo(word.getKey()) == 0){
					search.addNamedElementToSemanticGroup(semanticGroup, namedElement);
				}
				
				List<String> wordInNameClass = LangUtils.cleanAndSeparateWords(namedElement.getName());
				for(String wordInName : wordInNameClass){	
					if(wordInName.compareTo(word.getKey()) == 0){
						search.addNamedElementToSemanticGroup(semanticGroup, namedElement);
					}
					else{
						if(LangUtils.haveTheSameStem(wordInName, word.getKey())){
							search.addNamedElementToSemanticGroup(semanticGroup, namedElement);
						}
					}
				}
			}
		}
	}
	
	*/
}
