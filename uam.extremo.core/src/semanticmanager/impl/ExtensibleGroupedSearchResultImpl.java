package uam.extremo.core.impl;

import uam.extremo.core.DataProperty;
import uam.extremo.core.ExtensibleGroupedSearchResult;
import uam.extremo.core.ModelTypeParamValue;
import uam.extremo.core.NamedElement;
import uam.extremo.core.ObjectProperty;
import uam.extremo.core.PrimitiveTypeParamValue;
import uam.extremo.core.Resource;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.SemanticGroup;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.impl.GroupedSearchResultImpl;

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
		for(SearchParamValue value : getValues()){
			if (value instanceof PrimitiveTypeParamValue) {
				PrimitiveTypeParamValue stringValue = (PrimitiveTypeParamValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){
						return stringValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
			
			if (value instanceof ModelTypeParamValue) {
				ModelTypeParamValue dataModelValue = (ModelTypeParamValue) value;
				
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