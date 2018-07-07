package uam.extremo.queries.predicatebasedsearch;

import uam.extremo.core.NamedElement;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.impl.ExtensiblePredicateBasedSearchImpl;

public class AbstractClassUniqueChildSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) namedElement;

			if(semanticNode.isAbstract() && semanticNode.getSubs().size() == 1){
				return true;
			}
		}
		
		return false;
	}
}
