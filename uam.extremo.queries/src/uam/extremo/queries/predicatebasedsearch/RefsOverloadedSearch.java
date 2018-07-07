package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import uam.extremo.core.NamedElement;
import uam.extremo.core.ObjectProperty;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.impl.ExtensiblePredicateBasedSearchImpl;

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
