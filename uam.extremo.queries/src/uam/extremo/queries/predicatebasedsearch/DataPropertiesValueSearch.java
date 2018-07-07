package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import uam.extremo.core.DataProperty;
import uam.extremo.core.NamedElement;
import uam.extremo.core.PrimitiveTypeParamValue;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.Service;
import uam.extremo.core.impl.ExtensiblePredicateBasedSearchImpl;

public class DataPropertiesValueSearch extends ExtensiblePredicateBasedSearchImpl{
	Object optionvalue = null;
	Service service = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		PrimitiveTypeParamValue primitiveOption = (PrimitiveTypeParamValue) getOptionValue("valuefield", inputs);
		service = primitiveOption.getCalls();
		optionvalue = primitiveOption.getValue();
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof DataProperty) {		
				if((optionvalue != null) && (optionvalue instanceof String)){
					String valuefieldString = (String) optionvalue;
					
					if(((DataProperty) namedElement).getValue() == null || ((DataProperty) namedElement).getValue().compareTo("") == 0)
						return false;
					
					if(service != null){						
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
}
