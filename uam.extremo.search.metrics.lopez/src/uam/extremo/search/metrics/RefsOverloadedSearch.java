package uam.extremo.search.metrics;

import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SimpleSearchConfigurationImpl;

public class RefsOverloadedSearch extends SimpleSearchConfigurationImpl {
	@Override
	public void search(SearchResult search) {
		int maxRefs = (int) search.getOptionValue("maxrefs");
		
		SemanticGroup semanticGroup = search.createSemanticGroup("no_class_refs_overloaded", "No class refers to too many others.");

		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){
					long count = semanticNode.getProperties().stream().
							filter(p -> p instanceof ObjectProperty).count();
					
					if(maxRefs <= count){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}
	}

}
