package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import uam.extremo.core.NamedElement;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.impl.ExtensiblePredicateBasedSearchImpl;

public class NumberOfChildrenSearch extends ExtensiblePredicateBasedSearchImpl {
	Object childrenValueField = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		childrenValueField = getOptionValueKey("children", inputs);
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof SemanticNode) {	
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
			if((childrenValueField != null) && (childrenValueField instanceof String)){
				int parents = Integer.parseInt((String) childrenValueField);
				
				long count = semanticNode.getSubs().stream().count();
				
				if(count >= parents){
					return true;
				}
			}
		}
		return false;
	}
}
