package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import uam.extremo.core.DataProperty;
import uam.extremo.core.NamedElement;
import uam.extremo.core.PrimitiveTypeParamValue;
import uam.extremo.core.Property;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.Service;
import uam.extremo.core.impl.ExtensiblePredicateBasedSearchImpl;

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
