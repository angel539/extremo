package semanticmanager.impl;

import semanticmanager.DataModelTypeSearchResultOptionValue;
import semanticmanager.DataProperty;
import semanticmanager.ExtensibleGroupedSearchResult;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.PrimitiveTypeSearchResultOptionValue;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import semanticmanager.impl.GroupedSearchResultImpl;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticGroup;

public class ExtensibleGroupedSearchResultImpl extends GroupedSearchResultImpl implements ExtensibleGroupedSearchResult {	
	public void addNamedElementToSemanticGroup(SemanticGroup semanticGroup, NamedElement namedElement) {
		if (namedElement instanceof Resource) {
			Resource resource = (Resource) namedElement;
			addResourceToSemanticGroup(semanticGroup, resource);
		}
		
		if (namedElement instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) namedElement;
			addSemanticNodeToSemanticGroup(semanticGroup, semanticNode);
		}
		
		if (namedElement instanceof DataProperty) {
			DataProperty dataProperty = (DataProperty) namedElement;
			addDataPropertyToSemanticGroup(semanticGroup, dataProperty);
		}
		
		if (namedElement instanceof ObjectProperty) {
			ObjectProperty objectProperty = (ObjectProperty) namedElement;
			addObjectPropertyToSemanticGroup(semanticGroup, objectProperty);
		}
	}

	public void addResourceToSemanticGroup(SemanticGroup semanticGroup, Resource resource) {
		semanticGroup.getElements().add(resource);
	}

	public void addSemanticNodeToSemanticGroup(SemanticGroup semanticGroup, SemanticNode semanticNode) {
		semanticGroup.getElements().add(semanticNode);
	}

	public void addDataPropertyToSemanticGroup(SemanticGroup semanticGroup, DataProperty dataProperty) {
		semanticGroup.getElements().add(dataProperty);
	}

	public void addObjectPropertyToSemanticGroup(SemanticGroup semanticGroup, ObjectProperty objectProperty) {
		semanticGroup.getElements().add(objectProperty);
	}

	public Object getOptionValue(String key) {
		for(SearchResultOptionValue value : getValues()){
			if (value instanceof PrimitiveTypeSearchResultOptionValue) {
				PrimitiveTypeSearchResultOptionValue stringValue = (PrimitiveTypeSearchResultOptionValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){
						return stringValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
			
			if (value instanceof DataModelTypeSearchResultOptionValue) {
				DataModelTypeSearchResultOptionValue dataModelValue = (DataModelTypeSearchResultOptionValue) value;
				
				try{
					if(dataModelValue.getOption().getId().equals(key)){
						return dataModelValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
		}
		return null;
	}
}