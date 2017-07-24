package semanticmanager;

import org.eclipse.emf.common.util.EList;

public interface ExtensiblePredicateBasedSearch extends PredicateBasedSearch {
	void addPrimitiveTypeSearchOption(String id, String name, Type type);
	void addDataModelTypeSearchOption(String id, String name, DataModelType type);
	void init(EList<SearchParamValue> inputs);
	boolean matches(NamedElement namedElement);
	Object getOptionValueKey(String key, EList<SearchParamValue> inps);
}
