package uam.extremo.queries.customsearch;

import java.util.Objects;

import uam.extremo.core.GroupedSearchResult;
import uam.extremo.core.NamedElement;
import uam.extremo.core.ObjectProperty;
import uam.extremo.core.Resource;
import uam.extremo.core.ResourceElement;
import uam.extremo.core.SearchResult;
import uam.extremo.core.SemanticGroup;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.SemanticmanagerFactory;
import uam.extremo.core.impl.ExtensibleCustomSearchImpl;

public class InRefsOverloadedSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof GroupedSearchResult) {
			GroupedSearchResult groupedSearchResult = (GroupedSearchResult) result;
			Object maxRefsOption = groupedSearchResult.getOptionValue("maxrefs");
			
			int maxRefs = Integer.parseInt((String) maxRefsOption);
			
			for(NamedElement namedElement : groupedSearchResult.getApplyOnElements()){
				if (namedElement instanceof Resource) {
					Resource resource = (Resource) namedElement;
					
					SemanticGroup group = SemanticmanagerFactory.eINSTANCE.createSemanticGroup();
					group.setName(resource.getName());
					preorder(resource, group, resource, maxRefs);
				}
			}
		}
	}
	
	public synchronized void preorder(Resource resource, SemanticGroup group, Resource node, int maxRefs){
        preorderHelper(resource, group, node, maxRefs);
    }
     
    private void preorderHelper(Resource resource, SemanticGroup group, ResourceElement node, int maxRefs)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;
			
        	int counter = 0;
        	inRefsCounter(resource, semanticNode, counter);
			
			if(counter >= maxRefs){
				group.getElements().add(semanticNode);
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(resource, group, resourceElement, maxRefs);
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
