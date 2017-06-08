package uam.extremo.queries.customsearch;

import java.util.Objects;

import semanticmanager.AtomicSearchResult;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class InRefsOverloadedSearch extends ExtensibleCustomSearchImpl {
	Resource resource = null;
	
	@Override
	public void search(SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			Object option = atomicSearchResult.getOptionValue("resource");
			Object maxRefsOption = atomicSearchResult.getOptionValue("maxrefs");
			
			int maxRefs = Integer.parseInt((String) maxRefsOption);
			
			if(option instanceof Resource){
				resource = (Resource) option;
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
			
        	int counter = 0;
        	inRefsCounter(resource, semanticNode, counter);
			
			if(counter >= maxRefs){
				result.getElements().add(semanticNode);
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement, maxRefs);
        }
    }
    
    public synchronized void inRefsCounter(ResourceElement node, SemanticNode semanticNode, int counter){
    	inRefsCounterHelper(node, semanticNode, counter);
    }
     
    private void inRefsCounterHelper(ResourceElement node, SemanticNode pointer, int counter){
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	counter += ((SemanticNode) node).getProperties().stream().
					filter(p -> p instanceof ObjectProperty && Objects.equals(((ObjectProperty) p).getRange(), pointer)).
					count();
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		inRefsCounterHelper(resourceElement, pointer, counter);
        }
    }
}
