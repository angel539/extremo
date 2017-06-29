package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

public class NumberOfParentsSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchParamValue> inps) {
		if (namedElement instanceof SemanticNode) {	
			SemanticNode semanticNode = (SemanticNode) namedElement;
				
			Object parentsValueField = getOptionValueKey("parents", inps);
			
			if((parentsValueField != null) && (parentsValueField instanceof String)){
				int parents = Integer.parseInt((String) parentsValueField);
				
				long count = semanticNode.getSupers().stream().count();
				
				if(count >= parents){
					return true;
				}
			}
		}
		return false;
	}
}
