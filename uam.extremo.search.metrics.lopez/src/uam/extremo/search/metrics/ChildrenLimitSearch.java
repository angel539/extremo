package uam.extremo.search.metrics;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;

import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SearchResultOptionStringValue;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.impl.SearchConfigurationImpl;

public class ChildrenLimitSearch extends SearchConfigurationImpl {
	int maxChildren;
	
	@Override
	public void resolveOptions(EList<SearchResultOptionValue> values) {
		for(SearchResultOptionValue value : values){
			if (value instanceof SearchResultOptionStringValue) {
				SearchResultOptionStringValue stringValue = (SearchResultOptionStringValue) value;
				
				try{
					switch(stringValue.getOption().getId()){
						case "maxchildren":
							maxChildren = Integer.getInteger(stringValue.getValue());
							break;
							
						default:
							break;
					}
				}
				catch(Exception e){
					MessageDialog.openError(null, "Option Validation", "Options couldn't be validated for the search: " + e.getMessage());
				}
			}
			
		}
	}
	
	@Override
	public void search(SearchResult search) {
		SemanticGroup semanticGroup = search.createSemanticGroup("no_class_too_many_children", "No class has too many direct children.");
	
		for(Resource resource : search.getResources()){
			if(resource.isActive()){
				for(SemanticNode semanticNode : resource.getNodes()){					
					if(maxChildren > semanticNode.getSubs().size()){
						search.addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
					}
				}
			}
		}
	}
	
}
