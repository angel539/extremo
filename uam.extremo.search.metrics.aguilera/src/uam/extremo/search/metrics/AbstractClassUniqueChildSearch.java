package uam.extremo.search.metrics;

import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SimpleSearchConfigurationImpl;

public class AbstractClassUniqueChildSearch extends SimpleSearchConfigurationImpl {
	@Override
	public void search(SearchResult search) {
		SemanticGroup semanticGroup = search.createSemanticGroup("abstract_class_unique_class", "An abstract class with a unique child");
	
		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){
					if(semanticNode.isAbstract() && semanticNode.getSubs().size() == 1){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}
	}
}
