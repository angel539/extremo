package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class ChildrenLimitSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
			Object moreThanChildren = getOptionValueKey("maxchildren", inps);
			
			if((moreThanChildren != null) && (moreThanChildren instanceof String)){
				int maxChildren = Integer.getInteger((String) moreThanChildren);
			
				if(semanticNode.getSubs().size() < maxChildren){
					return true;
				}
			}
			return false;	
		}
		return false;
	}
}
