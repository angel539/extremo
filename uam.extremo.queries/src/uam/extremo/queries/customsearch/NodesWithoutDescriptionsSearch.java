package uam.extremo.queries.customsearch;

import uam.extremo.core.GroupedSearchResult;
import uam.extremo.core.NamedElement;
import uam.extremo.core.Resource;
import uam.extremo.core.ResourceElement;
import uam.extremo.core.SearchResult;
import uam.extremo.core.SemanticGroup;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.SemanticmanagerFactory;
import uam.extremo.core.impl.ExtensibleCustomSearchImpl;

public class NodesWithoutDescriptionsSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof GroupedSearchResult) {
			GroupedSearchResult groupedSearchResult = (GroupedSearchResult) result;
			Object option = groupedSearchResult.getOptionValue("resource");
			
			if(option instanceof Resource){
				Resource resource = (Resource) option;
				for(NamedElement namedElement : groupedSearchResult.getApplyOnElements()){
					if (namedElement instanceof Resource && namedElement.equals(resource)) {
						Resource resourceSelected = (Resource) namedElement;
						
						SemanticGroup group1 = SemanticmanagerFactory.eINSTANCE.createSemanticGroup();
						group1.setName("Nodes with descriptions");
						
						SemanticGroup group2 = SemanticmanagerFactory.eINSTANCE.createSemanticGroup();
						group2.setName("Nodes without descriptions");
						preorder(groupedSearchResult, resourceSelected, group1, group2);
						
						groupedSearchResult.getGroups().add(group1);
						groupedSearchResult.getGroups().add(group2);	
					}
				}
			}
		}
	}
	
	public synchronized void preorder(GroupedSearchResult result, Resource resource, SemanticGroup group1, SemanticGroup group2){
        preorderHelper(result, resource, group1, group2);
    }
     
    private void preorderHelper(GroupedSearchResult result, ResourceElement node, SemanticGroup group1, SemanticGroup group2)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;

        	if(semanticNode.getDescribes() == null || semanticNode.getDescribes().isEmpty()){
        		group2.getElements().add(semanticNode);
        	}
        	else{
        		group1.getElements().add(semanticNode);
        	}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement, group1, group2);
        }
    }
}
