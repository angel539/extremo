package uam.extremo.queries.customsearch;

import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

import java.util.ArrayList;
import java.util.List;

import semanticmanager.GroupedSearchResult;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;

public class SplitNodesSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof GroupedSearchResult) {
			GroupedSearchResult groupedSearchResult = (GroupedSearchResult) result;
			Object option = groupedSearchResult.getOptionValue("resource");
			if(option instanceof Resource){
				Resource resource = (Resource) option;
				result.getApplyOnElements().add(resource);
				preorder(groupedSearchResult, resource);
			}
		}	
	}
	
	public List<SemanticNode> getAllSubs(SemanticNode node){
		List<SemanticNode> nonvisited = new ArrayList<SemanticNode>();
		List<SemanticNode> subs = new ArrayList<SemanticNode>();
			
		nonvisited.addAll(node.getSubs());
			
		while(!nonvisited.isEmpty()){
			SemanticNode sn = nonvisited.get(0);
			
			if(!subs.contains(sn)){
				subs.add(sn);
				nonvisited.addAll(sn.getSubs());
			}
			nonvisited.remove(sn);
		}
			
		return subs;
	}
	
	public synchronized void preorder(GroupedSearchResult result, Resource resource){
        preorderHelper(result, resource);
    }
     
    private void preorderHelper(GroupedSearchResult result, ResourceElement node)
    {
        if(node == null)
            return;
        
        if(node instanceof SemanticNode){
        	SemanticNode semanticNode = (SemanticNode) node;
			if(semanticNode.getSupers() == null || semanticNode.getSupers().size() == 0){
				if((semanticNode.getSubs() != null) && (semanticNode.getSubs().size() > 0)){
					SemanticGroup group = SemanticmanagerFactory.eINSTANCE.createSemanticGroup();
					group.getElements().addAll(getAllSubs(semanticNode));
					result.getGroups().add(group);
				}
			}
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(result, resourceElement);
        }
    }

}
