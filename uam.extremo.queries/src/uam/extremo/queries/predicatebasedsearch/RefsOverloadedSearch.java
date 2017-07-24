package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

public class RefsOverloadedSearch extends ExtensiblePredicateBasedSearchImpl {
	Object maxRefsValueField = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		maxRefsValueField = getOptionValueKey("maxrefs", inputs);
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof SemanticNode) {	
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
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
