package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class AbstractClassWithoutChildrenSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
			if(semanticNode.isAbstract() && semanticNode.getSubs().size() == 0){
				return true;
			}
		}
		
		return false;
	}
}
