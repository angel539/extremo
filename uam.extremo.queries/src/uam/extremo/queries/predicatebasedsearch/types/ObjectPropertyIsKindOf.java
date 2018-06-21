package uam.extremo.queries.predicatebasedsearch.types;

import org.eclipse.emf.common.util.EList;

import semanticmanager.ModelTypeParamValue;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.SearchParamValue;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class ObjectPropertyIsKindOf extends ExtensiblePredicateBasedSearchImpl {
	NamedElement descriptor = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		ModelTypeParamValue modelTypeOption = (ModelTypeParamValue) getOptionValue("descriptor", inputs);
		descriptor = modelTypeOption.getValue();
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if((descriptor != null) 
					&& (descriptor instanceof ObjectProperty)){
			return preorder((ObjectProperty) namedElement, (ObjectProperty) descriptor);
		}
		
		return false;
	}
	
	public synchronized boolean preorder(ObjectProperty node, ObjectProperty nodeToCompare){
        return preorderHelper(node, nodeToCompare);
    }
	
    private boolean preorderHelper(ObjectProperty node, ObjectProperty nodeToCompare){
        if(node == null)
            return false;
	
		if(node.equals(nodeToCompare)) return true;
        
        	for(NamedElement descriptor : node.getDescriptors()){
        		if(descriptor instanceof ObjectProperty){
        			return preorderHelper((ObjectProperty) descriptor, nodeToCompare);
        		}
        }
    
    		return false;
    }
}
