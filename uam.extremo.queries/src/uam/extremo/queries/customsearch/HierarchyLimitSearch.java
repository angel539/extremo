package uam.extremo.queries.customsearch;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import semanticmanager.AtomicSearchResult;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class HierarchyLimitSearch extends ExtensibleCustomSearchImpl {	
	@Override
	public void search(SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			Object option = atomicSearchResult.getOptionValue("resource");
			Object maxDepthOption = atomicSearchResult.getOptionValue("maxdepth");
			
			int maxDepth = Integer.parseInt((String) maxDepthOption);
			
			if(option instanceof Resource){
				Resource resource = (Resource) option;
				result.getApplyOnElements().add(resource);
				preorder(atomicSearchResult, resource, maxDepth);
			}
		}
	}
	
	public synchronized void preorder(AtomicSearchResult result, Resource resource, int maxAttrs){
        preorderHelper(result, resource, maxAttrs);
    }
     
    private void preorderHelper(AtomicSearchResult result, ResourceElement node, int maxDepth)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;
			
			int depthcount = depth(semanticNode);
			
			if(maxDepth > depthcount){
				result.getElements().add(semanticNode);
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement, maxDepth);
        }
    }
	
	private int depth(SemanticNode node){
		if (node.getSupers() == null) {
			return 1;
		}
		else {
			Optional optionalInteger = node.getSupers().stream().collect(
					Collectors.maxBy(
						new Comparator<SemanticNode>() {
							public int compare(SemanticNode node1, SemanticNode node2) {
								int depth1 = (depth(node1) + 1);
								int depth2 = (depth(node2) + 1);
								
								if(depth1 > depth2) 
									return depth1;
								else 
									return depth2;
							}
						}
					)
			);
			
			Integer resultInteger = optionalInteger.isPresent() ? (int) optionalInteger.get() : 0;
			return resultInteger;
		}
	}	
}
