package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class DataPropertyName extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof DataProperty) {			
			Object valuefield = getOptionValueKey("name", inps);
			
			if((valuefield != null) && (valuefield instanceof String)){
				String valuefieldString = (String) valuefield;
				
				if(((DataProperty) namedElement).getName().compareTo(valuefieldString) == 0)
					return true;
				else
					return false;
			}
			return false;
		}
		return false;
	}
}
