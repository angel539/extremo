package semanticmanager;

import semanticmanager.CustomSearch;
import semanticmanager.DataModelType;
import semanticmanager.SearchResult;
import semanticmanager.Type;

public interface ExtensibleCustomSearch extends CustomSearch {
	void addPrimitiveTypeSearchOption(String id, String name, Type type);
	void addDataModelTypeSearchOption(String id, String name, DataModelType type);
	void search(SearchResult search);
}
