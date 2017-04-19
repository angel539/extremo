package semanticmanager.queries;

import semanticmanager.dataModel.Type;

public interface ExtensibleCustomSearch extends CustomSearch {
	void addSearchOption(String id, String name, Type type);
	void search(SearchResult search);
}
