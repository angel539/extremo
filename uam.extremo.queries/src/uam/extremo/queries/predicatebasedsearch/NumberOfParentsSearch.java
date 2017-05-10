package uam.extremo.queries.predicatebasedsearch;

import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;

public class NumberOfParentsSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
			int parents = (int) getOptionValueKey("morethanparents", inps);
			
			if(semanticNode.getSupers().size() > parents){
				return true;
			}
		}
		
		return false;
	}
}
