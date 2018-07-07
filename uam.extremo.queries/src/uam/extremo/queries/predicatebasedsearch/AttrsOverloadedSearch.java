package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import uam.extremo.core.DataProperty;
import uam.extremo.core.NamedElement;
import uam.extremo.core.PrimitiveTypeParamValue;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.impl.ExtensiblePredicateBasedSearchImpl;

public class AttrsOverloadedSearch extends ExtensiblePredicateBasedSearchImpl {
	Object optionvalue = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		PrimitiveTypeParamValue maxAttrsValueField = (PrimitiveTypeParamValue) getOptionValue("maxattrs", inputs);
		PrimitiveTypeParamValue primitiveOption = (PrimitiveTypeParamValue) maxAttrsValueField;
		optionvalue = primitiveOption.getValue();
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof SemanticNode) {	
			SemanticNode semanticNode = (SemanticNode) namedElement;

			if((optionvalue != null) && (optionvalue instanceof String)){
				int maxAttrs = Integer.parseInt((String) optionvalue);
				
				long count = semanticNode.getProperties().stream().
						filter(p -> p instanceof DataProperty).count();
				
				if(count >= maxAttrs){
					return true;
				}
			}
		}
		
		return false;
	}
}
