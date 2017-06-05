package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class AttrsOverloadedSearch extends ExtensiblePredicateBasedSearchImpl {	
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof SemanticNode) {			
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
			Object maxAttrsOption = getOptionValueKey("maxrefs", inps);
			
			if((maxAttrsOption != null) && (maxAttrsOption instanceof String)){
				int maxAttrs = Integer.getInteger((String) maxAttrsOption);
			
				long count = semanticNode.getProperties().stream().
						filter(p -> p instanceof DataProperty).count();
				
				if(count >= maxAttrs){
					return true;
				}
			}
			
			return false;	
		}
		
		return false;
	}
}
