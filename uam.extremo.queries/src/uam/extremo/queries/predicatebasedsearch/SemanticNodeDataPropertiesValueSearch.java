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
	Object optionvalue = null;
	Service service = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		PrimitiveTypeParamValue option = (PrimitiveTypeParamValue) getOptionValue("value", inputs);
		service = option.getCalls();
		optionvalue = option.getValue();
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof SemanticNode) {		
			if((optionvalue != null) && (optionvalue instanceof String)){
				String valuefieldString = (String) optionvalue;
				SemanticNode semanticNode = (SemanticNode) namedElement; 
				
				for(Property property : semanticNode.getProperties()){
					if (property instanceof DataProperty) {
						DataProperty dataProperty = (DataProperty) property;
						if(dataProperty.getValue() == null) return false;
						
						if(service != null){
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
			return false;
		}
		
		return false;
	}
}
