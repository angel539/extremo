package semanticmanager.queries.impl;
import semanticmanager.dataModel.DataProperty;
import semanticmanager.dataModel.NamedElement;
import semanticmanager.dataModel.ObjectProperty;
import semanticmanager.dataModel.Resource;
import semanticmanager.dataModel.SemanticNode;
import semanticmanager.queries.ExtensibleGroupedSearchResult;
import semanticmanager.queries.SearchConfiguration;
import semanticmanager.queries.SearchResultOptionValue;
import semanticmanager.queries.SemanticGroup;

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
			if (value instanceof SearchResultOptionValue) {
				SearchResultOptionValue stringValue = (SearchResultOptionValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){
						return stringValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public SearchConfiguration getConfiguration() {
		return null;
	}

	@Override
	public void setConfiguration(SearchConfiguration value) {
	}
}