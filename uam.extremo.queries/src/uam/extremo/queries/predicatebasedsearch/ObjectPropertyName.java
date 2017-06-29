package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

public class ObjectPropertyName extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchParamValue> inps) {
		if (namedElement instanceof ObjectProperty) {			
			Object valuefield = getOptionValueKey("name", inps);
			
			if((valuefield != null) && (valuefield instanceof String)){
				String valuefieldString = (String) valuefield;
				
				if(((ObjectProperty) namedElement).getName().compareTo(valuefieldString) == 0)
					return true;
				else
					return false;
			}
			return false;
		}
		return false;
	}
}
