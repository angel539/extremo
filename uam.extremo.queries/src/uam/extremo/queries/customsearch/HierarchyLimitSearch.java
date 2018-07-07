package uam.extremo.queries.customsearch;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import uam.extremo.core.GroupedSearchResult;
import uam.extremo.core.NamedElement;
import uam.extremo.core.Resource;
import uam.extremo.core.ResourceElement;
import uam.extremo.core.SearchResult;
import uam.extremo.core.SemanticGroup;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.SemanticmanagerFactory;
import uam.extremo.core.impl.ExtensibleCustomSearchImpl;

public class HierarchyLimitSearch extends ExtensibleCustomSearchImpl {	
	@Override
	public void search(SearchResult result) {
		if (result instanceof GroupedSearchResult) {
			GroupedSearchResult groupedSearchResult = (GroupedSearchResult) result;
			
			Object maxDepthOption = groupedSearchResult.getOptionValue("maxdepth");
			int maxDepth = Integer.parseInt((String) maxDepthOption);
			
			for(NamedElement namedElement : groupedSearchResult.getApplyOnElements()){
				if (namedElement instanceof Resource) {
					Resource resource = (Resource) namedElement;
					
					SemanticGroup group = SemanticmanagerFactory.eINSTANCE.createSemanticGroup();
					group.setName(resource.getName());
					preorder(group, resource, maxDepth);
				}
			}
		}
	}
	
	public synchronized void preorder(SemanticGroup group, Resource resource, int maxDepth){
        preorderHelper(group, resource, maxDepth);
    }
     
    private void preorderHelper(SemanticGroup group, ResourceElement node, int maxDepth)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;
			
			int depthcount = depth(semanticNode);
			
			if(maxDepth > depthcount){
				group.getElements().add(semanticNode);
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(group, resourceElement, maxDepth);
        }
    }
	
	private int depth(NamedElement node){
		if (node.getSupers() == null) {
			return 1;
		}
		else {
			Optional optionalInteger = node.getSupers().stream().collect(
					Collectors.maxBy(
						new Comparator<NamedElement>() {
							public int compare(NamedElement node1, NamedElement node2) {
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
