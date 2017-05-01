package semanticmanager;

import semanticmanager.Type;

public interface ExtensibleCustomSearch extends CustomSearch {
	void addSearchOption(String id, String name, Type type);
	void search(SearchResult search);
}
