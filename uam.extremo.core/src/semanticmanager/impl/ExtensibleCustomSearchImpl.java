package semanticmanager.impl;

import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ExtensibleCustomSearch;
import semanticmanager.SearchOption;
import semanticmanager.Type;

public class ExtensibleCustomSearchImpl extends CustomSearchImpl implements ExtensibleCustomSearch {
	public void addSearchOption(String id, String name, Type type) {
		SearchOption searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createSearchOption();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
}
