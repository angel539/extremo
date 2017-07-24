package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.SearchParamValue;
import semanticmanager.Service;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class ObjectPropertyName extends ExtensiblePredicateBasedSearchImpl {
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
		if (namedElement instanceof ObjectProperty) {
			if((name != null) && (name instanceof String)){
				String valuefieldString = (String) name;
				if(service != null){
					return callService(service, ((ObjectProperty) namedElement).getName(), valuefieldString);
				}
				else{		
					if(((ObjectProperty) namedElement).getName().compareTo(valuefieldString) == 0)
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
