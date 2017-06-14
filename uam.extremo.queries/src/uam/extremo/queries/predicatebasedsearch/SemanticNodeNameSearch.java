package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.PrimitiveTypeSearchResultOptionValue;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;
import semanticmanager.Service;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class SemanticNodeNameSearch extends ExtensiblePredicateBasedSearchImpl {	
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof SemanticNode) {		
			SearchResultOptionValue option = getOptionValue("name", inps);
			
			if(option instanceof PrimitiveTypeSearchResultOptionValue){
				PrimitiveTypeSearchResultOptionValue primitiveOption = (PrimitiveTypeSearchResultOptionValue) option;
				Object optionvalue = primitiveOption.getValue();
				
				if((optionvalue != null) && (optionvalue instanceof String)){
					String valuefieldString = (String) optionvalue;
					
					if(primitiveOption.getCalls() != null){
						Service service = primitiveOption.getCalls();
						return callService(service, ((SemanticNode) namedElement).getName(), valuefieldString);
					}
					else{		
						if(((SemanticNode) namedElement).getName().compareTo(valuefieldString) == 0)
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
