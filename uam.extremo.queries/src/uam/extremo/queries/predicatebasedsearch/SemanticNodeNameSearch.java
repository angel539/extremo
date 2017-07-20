package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.SemanticNode;
import semanticmanager.Service;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

public class SemanticNodeNameSearch extends ExtensiblePredicateBasedSearchImpl {	
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchParamValue> inps) {
		if (namedElement instanceof SemanticNode) {		
			SearchParamValue option = getOptionValue("name", inps);
			
			if(option instanceof PrimitiveTypeParamValue){
				PrimitiveTypeParamValue primitiveOption = (PrimitiveTypeParamValue) option;
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
