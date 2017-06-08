package uam.extremo.queries.customsearch;

import semanticmanager.AtomicSearchResult;
import semanticmanager.DataProperty;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class AttrsOverloadedSearch extends ExtensibleCustomSearchImpl {	
	@Override
	public void search(SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			Object option = atomicSearchResult.getOptionValue("resource");
			Object maxAttrsOption = atomicSearchResult.getOptionValue("maxattrs");
			
			int maxAttrs = Integer.parseInt((String) maxAttrsOption);
			
			if(option instanceof Resource){
				Resource resource = (Resource) option;
				result.getApplyOnElements().add(resource);
				preorder(atomicSearchResult, resource, maxAttrs);
			}
		}
	}
	
	public synchronized void preorder(AtomicSearchResult result, Resource resource, int maxAttrs){
        preorderHelper(result, resource, maxAttrs);
    }
     
    private void preorderHelper(AtomicSearchResult result, ResourceElement node, int maxAttrs)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;
			long count = semanticNode.getProperties().stream().
					filter(p -> p instanceof DataProperty).count();
			
			if(count >= maxAttrs){
				result.getElements().add(semanticNode);
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement, maxAttrs);
        }
    }
}
