package uam.extremo.search.metrics;

import java.util.Objects;

import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SearchConfigurationImpl;

public class InRefsOverloadedSearch extends SearchConfigurationImpl {	
	@Override
	public void search(SearchResult search) {
		int maxRefs = (int) search.getOptionValue("maxrefs");
		
		SemanticGroup semanticGroup = search.createSemanticGroup("no_class_in_refs_overloaded", "No class is referred from too many others.");
	
		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				
				for(SemanticNode semanticNode : resource.getNodes()){
					long counter = 0;
					
					for(SemanticNode pointer : resource.getNodes()){
						counter += semanticNode.getProperties().stream().
													filter(p -> p instanceof ObjectProperty && Objects.equals(((ObjectProperty) p).getRange(), pointer)).
													count();
					}
					
					if(maxRefs <= counter){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}
	}

}
