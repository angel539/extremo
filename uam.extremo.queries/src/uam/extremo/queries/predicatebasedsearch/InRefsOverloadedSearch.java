package uam.extremo.queries.predicatebasedsearch;

import java.util.Objects;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

public class InRefsOverloadedSearch extends ExtensiblePredicateBasedSearchImpl {
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof Resource) {
			int maxRefs = (int) getOptionValueKey("maxrefs", inps);
			
			Resource resource = (Resource) namedElement;
			
			for(SemanticNode semanticNode : resource.getNodes()){
				long counter = 0;
				
				for(SemanticNode pointer : resource.getNodes()){
					counter += semanticNode.getProperties().stream().
												filter(p -> p instanceof ObjectProperty && Objects.equals(((ObjectProperty) p).getRange(), pointer)).
												count();
				}
				
				if(counter >= maxRefs){
					return true;
				}
			}
		}
		
		return false;
	}
}
