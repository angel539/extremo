package uam.extremo.queries.predicatebasedsearch;

import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticNode;

public class HierarchyLimitSearch extends ExtensiblePredicateBasedSearchImpl {	
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps) {
		if (namedElement instanceof SemanticNode) {
			int maxDepth = (int) getOptionValueKey("maxdepth", inps);
			
			SemanticNode semanticNode = (SemanticNode) namedElement;
			int depthcount = depth(semanticNode);
			
			if(maxDepth > depthcount){
				return true;
			}
		}
		
		return false;
	}
	
	private int depth(SemanticNode node){
		if (node.getSupers() == null) {
			return 1;
		}
		else {
			Optional optionalInteger = node.getSupers().stream().collect(
					Collectors.maxBy(
						new Comparator<SemanticNode>() {
							public int compare(SemanticNode node1, SemanticNode node2) {
								int depth1 = (depth(node1) + 1);
								int depth2 = (depth(node2) + 1);
								
								if(depth1 > depth2) 
									return depth1;
								else 
									return depth2;
							}
						}
					)
			);
			
			Integer resultInteger = optionalInteger.isPresent() ? (int) optionalInteger.get() : 0;
			return resultInteger;
		}
	}	
}
