package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.Service;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

public class DataPropertiesValueSearch extends ExtensiblePredicateBasedSearchImpl{	
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchParamValue> inps) {
		if (namedElement instanceof DataProperty) {		
			Object option = getOptionValue("valuefield", inps);
			
			if(option != null &&  option instanceof PrimitiveTypeParamValue){
				PrimitiveTypeParamValue primitiveOption = (PrimitiveTypeParamValue) option;
				Object optionvalue = primitiveOption.getValue();
				
				if((optionvalue != null) && (optionvalue instanceof String)){
					String valuefieldString = (String) optionvalue;
					
					if(((DataProperty) namedElement).getValue() == null || ((DataProperty) namedElement).getValue().compareTo("") == 0)
						return false;
					
					if(primitiveOption.getCalls() != null){						
						Service service = primitiveOption.getCalls();
						return callService(service, ((DataProperty) namedElement).getValue(), valuefieldString);
					}
					else{		
						if(((DataProperty) namedElement).getValue().compareTo(valuefieldString) == 0)
							return true;
						else
							return false;
					}
				}
			}
			return false;
		}
		return false;
	}
}
