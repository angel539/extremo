package semanticmanager.queries;

import semanticmanager.dataModel.NamedElement;
import semanticmanager.dataModel.Type;

public interface ExtensiblePredicateBasedSearch extends PredicateBasedSearch {
	void addSearchOption(String id, String name, Type type);
	boolean matches(NamedElement namedElement);
}
