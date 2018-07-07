package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import uam.extremo.core.NamedElement;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.impl.ExtensiblePredicateBasedSearchImpl;

public class NumberOfParentsSearch extends ExtensiblePredicateBasedSearchImpl {
	Object parentsValueField = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		parentsValueField = getOptionValueKey("parents", inputs);
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof SemanticNode) {	
			SemanticNode semanticNode = (SemanticNode) namedElement;
			
			if((parentsValueField != null) && (parentsValueField instanceof String)){
				int parents = Integer.parseInt((String) parentsValueField);
				
				long count = semanticNode.getSupers().stream().count();
				
				if(count >= parents){
					return true;
				}
			}
		}
		return false;
	}
}
