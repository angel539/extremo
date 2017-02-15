package uam.extremo.search.metrics;

import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SimpleSearchConfigurationImpl;

public class MoreThanNumberChildrenSearch extends SimpleSearchConfigurationImpl {
	@Override
	public void search(SearchResult search) {
		int children = (int) search.getOptionValue("morethanchildren");
		
		SemanticGroup semanticGroup = search.createSemanticGroup("more_than_a_number_of_children", "A class with more than a number of children");
	
		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){					
					if(semanticNode.getSubs().size() > children){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}
	}
}
