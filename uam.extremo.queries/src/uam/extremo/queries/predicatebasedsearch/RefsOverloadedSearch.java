package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

public class RefsOverloadedSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchParamValue> inps) {
		if (namedElement instanceof SemanticNode) {	
			SemanticNode semanticNode = (SemanticNode) namedElement;
				
			Object maxRefsValueField = getOptionValueKey("maxrefs", inps);
			
			if((maxRefsValueField != null) && (maxRefsValueField instanceof String)){
				int maxRefs = Integer.parseInt((String) maxRefsValueField);
				
				long count = semanticNode.getProperties().stream().
						filter(p -> p instanceof ObjectProperty).count();
				
				if(count >= maxRefs){
					return true;
				}
			}
		}
		return false;
	}
}
