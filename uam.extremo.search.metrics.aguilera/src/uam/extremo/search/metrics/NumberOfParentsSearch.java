package uam.extremo.search.metrics;

import semanticmanager.impl.ExtensibleCustomSearchImpl;
import semanticmanager.SearchResult;

public class NumberOfParentsSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult search) {
		/*int parents = (int) search.getOptionValue("morethanparents");
		
		SemanticGroup semanticGroup = search.createSemanticGroup("more_than_a_number_of_parents", "A class with more than a number of parents");
	
		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){					
					if(semanticNode.getSupers().size() > parents){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}*/
	}
}
