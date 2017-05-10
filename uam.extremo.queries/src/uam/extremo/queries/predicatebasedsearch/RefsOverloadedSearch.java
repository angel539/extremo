package uam.extremo.queries.predicatebasedsearch;

import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;

public class RefsOverloadedSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
			int maxRefs = (int) getOptionValueKey("maxrefs", inps);
			
			long count = semanticNode.getProperties().stream().
					filter(p -> p instanceof ObjectProperty).count();
			
			if(maxRefs <= count){
				return true;
			}
		}
		
		return false;
	}
}
