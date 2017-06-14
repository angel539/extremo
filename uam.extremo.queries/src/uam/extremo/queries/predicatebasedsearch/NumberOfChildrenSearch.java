package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class NumberOfChildrenSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof SemanticNode) {	
			SemanticNode semanticNode = (SemanticNode) namedElement;
				
			Object childrenValueField = getOptionValueKey("children", inps);
			
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
