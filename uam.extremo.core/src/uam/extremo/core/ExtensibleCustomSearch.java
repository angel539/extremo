package uam.extremo.core;

import uam.extremo.core.CustomSearch;
import uam.extremo.core.DataModelType;
import uam.extremo.core.SearchResult;
import uam.extremo.core.Type;

public interface ExtensibleCustomSearch extends CustomSearch {
	void addPrimitiveTypeSearchOption(String id, String name, Type type);
	void addDataModelTypeSearchOption(String id, String name, DataModelType type);
	void search(SearchResult search);
}
