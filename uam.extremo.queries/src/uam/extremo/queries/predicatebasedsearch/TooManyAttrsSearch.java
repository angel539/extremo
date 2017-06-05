package uam.extremo.queries.predicatebasedsearch;

import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;

public class TooManyAttrsSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		/*if (namedElement instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
			int morethanattrs = (int) getOptionValueKey("morethanattrs", inps);
			
			long count = semanticNode.getProperties().stream().
					filter(p -> p instanceof DataProperty).count();
			
			if(count > morethanattrs){
				return true;
			}
		}*/
		
		return false;
	}
}
