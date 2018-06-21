package uam.extremo.queries.predicatebasedsearch.types;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.ModelTypeParamValue;
import semanticmanager.NamedElement;
import semanticmanager.SearchParamValue;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class DataPropertyIsTypeOf extends ExtensiblePredicateBasedSearchImpl {
	NamedElement descriptor = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		ModelTypeParamValue modelTypeOption = (ModelTypeParamValue) getOptionValue("descriptor", inputs);
		descriptor = modelTypeOption.getValue();
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if((descriptor != null) 
					&& (descriptor instanceof DataProperty)){
			for (NamedElement d : namedElement.getDescriptors()) {
				if(d.equals(descriptor)) return true;
			}
		}
		
		return false;
	}
}
