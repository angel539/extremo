package uam.extremo.search.metrics;

import semanticmanager.impl.ExtensibleCustomSearchImpl;
import semanticmanager.SearchResult;

public class ChildrenLimitSearch extends ExtensibleCustomSearchImpl {	
	@Override
	public void search(SearchResult search) {
		/*int maxChildren = (int) search.getOptionValue("maxchildren");
		
		search.getApplyOnElements()
		
		SemanticGroup semanticGroup = search.createSemanticGroup("no_class_too_many_children", "No class has too many direct children.");
	
		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){					
					if(maxChildren > semanticNode.getSubs().size()){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}*/
	}
}
