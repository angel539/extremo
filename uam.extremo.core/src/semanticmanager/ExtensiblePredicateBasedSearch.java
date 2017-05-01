package semanticmanager;

import semanticmanager.NamedElement;
import semanticmanager.Type;

public interface ExtensiblePredicateBasedSearch extends PredicateBasedSearch {
	void addSearchOption(String id, String name, Type type);
	boolean matches(NamedElement namedElement);
}
