package uam.extremo.queries.customsearch;

import semanticmanager.GroupedSearchResult;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

public class IsolatedClassesSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof GroupedSearchResult) {
			GroupedSearchResult groupedSearchResult = (GroupedSearchResult) result;
			
			for(NamedElement namedElement : groupedSearchResult.getApplyOnElements()){
				if (namedElement instanceof Resource) {
					Resource resource = (Resource) namedElement;
					
					SemanticGroup group = SemanticmanagerFactory.eINSTANCE.createSemanticGroup();
					group.setName(resource.getName());
					preorder(resource, group, resource);	
				}
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
	
	public synchronized void preorder(Resource resource, SemanticGroup group, Resource node){
        preorderHelper(resource, group, node);
    }
     
    private void preorderHelper(Resource resource, SemanticGroup group, ResourceElement resourceElement){
        if(resourceElement == null)
            return;
        
        if(resourceElement instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) resourceElement;
			
			long count = semanticNode.getProperties().stream().
					filter(p -> p instanceof ObjectProperty).count();
			
			long incommingRefs = incommingReferencesCounter(resource, semanticNode);
			int supers = semanticNode.getSupers().size();
			
			if(count == 0 && incommingRefs == 0 && supers == 0){
				group.getElements().add(semanticNode);
			}
        }
        
        if(resourceElement instanceof Resource){
        	for(ResourceElement rE : ((Resource) resourceElement).getResourceElements())
        		preorderHelper(resource, group, rE);
        }
    }
}
