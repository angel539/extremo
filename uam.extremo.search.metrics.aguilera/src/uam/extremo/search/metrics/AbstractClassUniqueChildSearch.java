package uam.extremo.search.metrics;

import semanticmanager.impl.ExtensibleCustomSearchImpl;
import semanticmanager.SearchResult;

public class AbstractClassUniqueChildSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult search) {
		/*SemanticGroup semanticGroup = search.createSemanticGroup("abstract_class_unique_class", "An abstract class with a unique child");
	
		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){
					if(semanticNode.isAbstract() && semanticNode.getSubs().size() == 1){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}*/
	}
}
