package uam.extremo.search.metrics;

import semanticmanager.impl.ExtensibleCustomSearchImpl;
import semanticmanager.SearchResult;

public class TooManyRefsSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult search) {
		/*int refs = (int) search.getOptionValue("morethanrefs");
		
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
		}*/
	}

	/*public static void main(String [] args){
		TooManyRefsSearch too = new TooManyRefsSearch();
		too.search(null);
	}*/
}
