package uam.extremo.queries.customsearch;

import semanticmanager.AtomicSearchResult;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class NumberOfChildrenSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			Object option = atomicSearchResult.getOptionValue("resource");
			Object childrenOption = atomicSearchResult.getOptionValue("children");
			
			int children = Integer.parseInt((String) childrenOption);
			
			if(option instanceof Resource){
				Resource resource = (Resource) option;
				result.getApplyOnElements().add(resource);
				preorder(atomicSearchResult, resource, children);
			}
		}
	}
	
	public synchronized void preorder(AtomicSearchResult result, Resource resource, int children){
        preorderHelper(result, resource, children);
    }
     
    private void preorderHelper(AtomicSearchResult result, ResourceElement node, int children)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;
			long count = semanticNode.getSubs().stream().count();
			
			if(count >= children){
				result.getElements().add(semanticNode);
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement, children);
        }
    }
}
