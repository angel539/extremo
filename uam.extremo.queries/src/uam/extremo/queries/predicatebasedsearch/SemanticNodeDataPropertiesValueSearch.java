package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.Property;
import semanticmanager.SearchParamValue;
import semanticmanager.SemanticNode;
import semanticmanager.Service;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class SemanticNodeDataPropertiesValueSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchParamValue> inps) {
		if (namedElement instanceof SemanticNode) {		
			SearchParamValue option = getOptionValue("value", inps);
			
			if(option != null && option instanceof PrimitiveTypeParamValue){
				PrimitiveTypeParamValue primitiveOption = (PrimitiveTypeParamValue) option;
				Object optionvalue = primitiveOption.getValue();
				
				if((optionvalue != null) && (optionvalue instanceof String)){
					String valuefieldString = (String) optionvalue;
					SemanticNode semanticNode = (SemanticNode) namedElement; 
					
					for(Property property : semanticNode.getProperties()){
						if (property instanceof DataProperty) {
							DataProperty dataProperty = (DataProperty) property;
							if(dataProperty.getValue() == null) return false;
							
							if(primitiveOption.getCalls() != null){
								Service service = primitiveOption.getCalls();
								return callService(service, dataProperty.getValue(), valuefieldString);
							}
							else{		
								if(dataProperty.getValue().compareTo(valuefieldString) == 0)
									return true;
								else
									return false;
							}
						}
					}
				}
			}
			return false;
		}
		
		return false;
	}
}
