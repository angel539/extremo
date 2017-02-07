package uam.extremo.search.metrics;

import semanticmanager.DataProperty;
import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SearchConfigurationImpl;

public class AttrsOverloadedSearch extends SearchConfigurationImpl {	
	@Override
	public void search(SearchResult search) {
		int maxAttrs = (int) search.getOptionValue("maxattrs");
		
		SemanticGroup semanticGroup = search.createSemanticGroup("no_class_overloaded", "No class is overloaded with attributes.");

		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){
					long count = semanticNode.getProperties().stream().
							filter(p -> p instanceof DataProperty).count();
					
					if(maxAttrs <= count){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}
	}
}
