package uam.extremo.queries.customsearch;

import semanticmanager.AtomicSearchResult;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class RefsOverloadedSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			Object option = atomicSearchResult.getOptionValue("resource");
			Object maxRefsOption = atomicSearchResult.getOptionValue("maxrefs");
			
			int maxRefs = Integer.parseInt((String) maxRefsOption);
			
			if(option instanceof Resource){
				Resource resource = (Resource) option;
				result.getApplyOnElements().add(resource);
				preorder(atomicSearchResult, resource, maxRefs);
			}
		}
	}
	
	public synchronized void preorder(AtomicSearchResult result, Resource resource, int maxRefs){
        preorderHelper(result, resource, maxRefs);
    }
     
    private void preorderHelper(AtomicSearchResult result, ResourceElement node, int maxRefs)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;
			long count = semanticNode.getProperties().stream().
					filter(p -> p instanceof ObjectProperty).count();
			
			if(count >= maxRefs){
				result.getElements().add(semanticNode);
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement, maxRefs);
        }
    }
}
