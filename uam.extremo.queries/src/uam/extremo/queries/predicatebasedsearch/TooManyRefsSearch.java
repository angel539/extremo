package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class TooManyRefsSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof SemanticNode) {			
			Object moreThanRefs = getOptionValueKey("morethanrefs", inps);
			
			if((moreThanRefs != null) && (moreThanRefs instanceof String)){
				int refs = Integer.getInteger((String) moreThanRefs);
				SemanticNode semanticNode = (SemanticNode) namedElement;
				
				long count = semanticNode.getProperties().stream().
						filter(p -> p instanceof ObjectProperty).count();
				
				if(count > refs){
					return true;
				}
			}
			return false;
		}
		
		return false;
	}
}
