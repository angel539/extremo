package uam.extremo.queries.customsearch;

import semanticmanager.AtomicSearchResult;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class AbstractClassUniqueChildSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			
			Object option = atomicSearchResult.getOptionValue("resource");
			if(option instanceof Resource){
				Resource resource = (Resource) option;
				result.getApplyOnElements().add(resource);
				preorder(atomicSearchResult, resource);
			}
		}
	}
	
	public synchronized void preorder(AtomicSearchResult result, Resource resource){
        preorderHelper(result, resource);
    }
     
    private void preorderHelper(AtomicSearchResult result, ResourceElement node)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;

			if(semanticNode.isAbstract() && semanticNode.getSubs().size() == 1){
				result.getElements().add(semanticNode);
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement);
        }
    }
}
