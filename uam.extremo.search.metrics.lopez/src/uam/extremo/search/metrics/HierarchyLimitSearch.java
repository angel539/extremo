package uam.extremo.search.metrics;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SearchConfigurationImpl;

public class HierarchyLimitSearch extends SearchConfigurationImpl {	
	@Override
	public void search(SearchResult search) {
		int maxDepth = (int) search.getOptionValue("maxdepth");
		
		SemanticGroup semanticGroup = search.createSemanticGroup("no_class_too_deep", "No hierarchy is too deep.");
	
		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				
				for(SemanticNode semanticNode : resource.getNodes()){
					int depthcount = depth(semanticNode);
					
					if(maxDepth > depthcount){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}
	}
	
	private int depth(SemanticNode node){
		if (node.getSupers() == null) {
			return 1;
		}
		else {
			Optional optionalInteger = node.getSupers().stream().collect(
					Collectors.maxBy(
						new Comparator<SemanticNode>() {
							public int compare(SemanticNode node1, SemanticNode node2) {
								int depth1 = (depth(node1) + 1);
								int depth2 = (depth(node2) + 1);
								
								if(depth1 > depth2) 
									return depth1;
								else 
									return depth2;
							}
						}
					)
			);
			
			Integer resultInteger = optionalInteger.isPresent() ? (int) optionalInteger.get() : 0;
			
			return resultInteger;
		}
	}	
}
