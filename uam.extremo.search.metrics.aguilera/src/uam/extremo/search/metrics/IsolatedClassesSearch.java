package uam.extremo.search.metrics;

import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SearchConfigurationImpl;

public class IsolatedClassesSearch extends SearchConfigurationImpl {
	@Override
	public void search(SearchResult search) {
		SemanticGroup semanticGroup = search.createSemanticGroup("no_class_refs_overloaded", "No class refers to too many others.");

		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){
					long count = semanticNode.getProperties().stream().
							filter(p -> p instanceof ObjectProperty).count();
					
					long incommingRefs = incommingReferencesCounter(resource, semanticNode);
					
					int supers = semanticNode.getSupers().size();
					
					if(count == 0 && incommingRefs == 0 && supers == 0){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}	
	}
	
	private long incommingReferencesCounter(Resource resource, SemanticNode node){
		int counter = 0;
		
		for(SemanticNode semanticNode : resource.getNodes()){
			counter += semanticNode.getProperties().stream().
					filter(p -> p instanceof ObjectProperty && ((ObjectProperty) p).getRange().equals(node)).count();
		}
		
		return counter;
	}
}
