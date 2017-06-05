package semanticmanager;

import org.eclipse.emf.common.util.EList;

import semanticmanager.NamedElement;
import semanticmanager.Type;

public interface ExtensiblePredicateBasedSearch extends PredicateBasedSearch {
	void addPrimitiveTypeSearchOption(String id, String name, Type type);
	void addDataModelTypeSearchOption(String id, String name, DataModelType type);
	boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps);
	Object getOptionValueKey(String key, EList<SearchResultOptionValue> inps);
}
