package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

public class AttrsOverloadedSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchParamValue> inps) {
		if (namedElement instanceof SemanticNode) {	
			SemanticNode semanticNode = (SemanticNode) namedElement;
				
			Object maxAttrsValueField = getOptionValueKey("maxattrs", inps);
			
			if((maxAttrsValueField != null) && (maxAttrsValueField instanceof String)){
				int maxAttrs = Integer.parseInt((String) maxAttrsValueField);
				
				long count = semanticNode.getProperties().stream().
						filter(p -> p instanceof DataProperty).count();
				
				if(count >= maxAttrs){
					return true;
				}
			}
		}
		return false;
	}
}
