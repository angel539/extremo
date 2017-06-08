package semanticmanager.impl;

import semanticmanager.DataModelType;
import semanticmanager.DataModelTypeSearchOption;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ExtensibleCustomSearch;
import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.Type;
import semanticmanager.impl.CustomSearchImpl;

public class ExtensibleCustomSearchImpl extends CustomSearchImpl implements ExtensibleCustomSearch {
	public void addPrimitiveTypeSearchOption(String id, String name, Type type) {
		PrimitiveTypeSearchOption searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createPrimitiveTypeSearchOption();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
	
	public void addDataModelTypeSearchOption(String id, String name, DataModelType type) {
		DataModelTypeSearchOption searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createDataModelTypeSearchOption();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
}
