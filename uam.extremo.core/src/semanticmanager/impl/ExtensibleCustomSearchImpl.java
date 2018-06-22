package semanticmanager.impl;

import semanticmanager.DataModelType;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ExtensibleCustomSearch;
import semanticmanager.ModelTypeParam;
import semanticmanager.PrimitiveTypeParam;
import semanticmanager.Type;
import semanticmanager.impl.CustomSearchImpl;

public class ExtensibleCustomSearchImpl extends CustomSearchImpl implements ExtensibleCustomSearch {
	public void addPrimitiveTypeSearchOption(String id, String name, Type type) {
		PrimitiveTypeParam searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createPrimitiveTypeParam();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
	
	public void addDataModelTypeSearchOption(String id, String name, DataModelType type) {
		ModelTypeParam searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createModelTypeParam();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
}
