package uam.extremo.search.metrics;

import semanticmanager.impl.ExtensibleCustomSearchImpl;
import semanticmanager.SearchResult;

public class MoreThanNumberChildrenSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult search) {
		/*int children = (int) search.getOptionValue("morethanchildren");
		
		SemanticGroup semanticGroup = search.createSemanticGroup("more_than_a_number_of_children", "A class with more than a number of children");
	
		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){					
					if(semanticNode.getSubs().size() > children){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}*/
	}
}
