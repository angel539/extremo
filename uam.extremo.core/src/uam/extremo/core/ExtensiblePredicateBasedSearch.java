package uam.extremo.core;

import org.eclipse.emf.common.util.EList;

import uam.extremo.core.DataModelType;
import uam.extremo.core.NamedElement;
import uam.extremo.core.PredicateBasedSearch;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.Type;

public interface ExtensiblePredicateBasedSearch extends PredicateBasedSearch {
	void addPrimitiveTypeSearchOption(String id, String name, Type type);
	void addDataModelTypeSearchOption(String id, String name, DataModelType type);
	void init(EList<SearchParamValue> inputs);
	boolean matches(NamedElement namedElement);
	Object getOptionValueKey(String key, EList<SearchParamValue> inps);
}
