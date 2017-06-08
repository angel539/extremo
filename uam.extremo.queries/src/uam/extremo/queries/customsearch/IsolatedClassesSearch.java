package uam.extremo.queries.customsearch;

import semanticmanager.AtomicSearchResult;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class IsolatedClassesSearch extends ExtensibleCustomSearchImpl {
	Resource resource = null;
	
	@Override
	public void search(SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			Object option = atomicSearchResult.getOptionValue("resource");
			
			if(option instanceof Resource){
				resource = (Resource) option;
				atomicSearchResult.getApplyOnElements().add(resource);
				preorder(atomicSearchResult, resource);
			}
		}
	}
	
	private long incommingReferencesCounter(Resource resource, SemanticNode node){
		int counter = 0;
		
		for(ResourceElement resourceElement : resource.getResourceElements()){
			if (resourceElement instanceof SemanticNode) {
				SemanticNode semanticNode = (SemanticNode) resourceElement;
				
				counter += semanticNode.getProperties().stream().
						filter(p -> p instanceof ObjectProperty && ((ObjectProperty) p).getRange().equals(node)).count();
			}
		}
		
		return counter;
	}
	
	public synchronized void preorder(AtomicSearchResult result, Resource resource){
        preorderHelper(result, resource);
    }
     
    private void preorderHelper(AtomicSearchResult result, ResourceElement resourceElement){
        if(resourceElement == null)
            return;
        
        if(resourceElement instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) resourceElement;
			
			long count = semanticNode.getProperties().stream().
					filter(p -> p instanceof ObjectProperty).count();
			
			long incommingRefs = incommingReferencesCounter(resource, semanticNode);
			int supers = semanticNode.getSupers().size();
			
			if(count == 0 && incommingRefs == 0 && supers == 0){
				result.getApplyOnElements().add(semanticNode);
			}
        }
        
        if(resourceElement instanceof Resource){
        	for(ResourceElement rE : ((Resource) resourceElement).getResourceElements())
        		preorderHelper(result, rE);
        }
    }
}
