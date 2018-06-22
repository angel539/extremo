package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.SemanticNode;
import semanticmanager.Service;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

public class SemanticNodeNameSearch extends ExtensiblePredicateBasedSearchImpl {
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
		if (namedElement instanceof SemanticNode) {
			if((name != null) && (name instanceof String)){
				String valuefieldString = (String) name;
				if(service != null){
					return callService(service, ((SemanticNode) namedElement).getName(), valuefieldString);
				}
				else{		
					if(((SemanticNode) namedElement).getName().compareTo(valuefieldString) == 0)
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
