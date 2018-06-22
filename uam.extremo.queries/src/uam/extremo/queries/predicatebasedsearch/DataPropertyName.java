package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.SearchParamValue;
import semanticmanager.Service;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class DataPropertyName extends ExtensiblePredicateBasedSearchImpl {
	Service service = null;
	Object name = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		PrimitiveTypeParamValue primitiveOption = (PrimitiveTypeParamValue) getOptionValue("name", inputs);
		service = primitiveOption.getCalls();
		name = primitiveOption.getValue();
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof DataProperty) {
			if((name != null) && (name instanceof String)){
				String valuefieldString = (String) name;
				if(service != null){
					return callService(service, ((DataProperty) namedElement).getName(), valuefieldString);
				}
				else{		
					if(((DataProperty) namedElement).getName().compareTo(valuefieldString) == 0)
						return true;
					else
						return false;
				}
			}
			
			return false;
		}
		return false;
	}
}
