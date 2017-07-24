package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

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
