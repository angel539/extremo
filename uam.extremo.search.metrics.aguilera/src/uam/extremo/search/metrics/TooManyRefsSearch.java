package uam.extremo.search.metrics;

import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SimpleSearchConfigurationImpl;

public class TooManyRefsSearch extends SimpleSearchConfigurationImpl {
	@Override
	public void search(SearchResult search) {
		int refs = (int) search.getOptionValue("morethanrefs");
		
		SemanticGroup semanticGroup = search.createSemanticGroup("class_with_more_than_a_number_refs", "A class with more than a number of references");

		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){
					long count = semanticNode.getProperties().stream().
							filter(p -> p instanceof ObjectProperty).count();
					
					if(count > refs){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}
	}

	public static void main(String [] args){
		TooManyRefsSearch too = new TooManyRefsSearch();
		too.search(null);
	}
}
