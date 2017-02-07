package uam.extremo.search.metrics;

import semanticmanager.DataProperty;
import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SearchConfigurationImpl;

public class TooManyAttrsSearch extends SearchConfigurationImpl {
	@Override
	public void search(SearchResult search) {
		int morethanattrs = (int) search.getOptionValue("morethanattrs");
		
		SemanticGroup semanticGroup = search.createSemanticGroup("class_with_more_than_a_number_attrs", "A class with more than a number of attributes");

		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){
					long count = semanticNode.getProperties().stream().
							filter(p -> p instanceof DataProperty).count();
					
					if(count > morethanattrs){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}
	}
}
