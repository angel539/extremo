package uam.extremo.queries.customsearch;

import semanticmanager.AtomicSearchResult;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class NumberOfParentsSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			Object option = atomicSearchResult.getOptionValue("resource");
			Object parentsOption = atomicSearchResult.getOptionValue("parents");
			
			int parents = Integer.parseInt((String) parentsOption);
			
			if(option instanceof Resource){
				Resource resource = (Resource) option;
				result.getApplyOnElements().add(resource);
				preorder(atomicSearchResult, resource, parents);
			}
		}
	}
	
	public synchronized void preorder(AtomicSearchResult result, Resource resource, int parents){
        preorderHelper(result, resource, parents);
    }
     
    private void preorderHelper(AtomicSearchResult result, ResourceElement node, int parents)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;
			long count = semanticNode.getSupers().stream().count();
			
			if(count >= parents){
				result.getElements().add(semanticNode);
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement, parents);
        }
    }
}
