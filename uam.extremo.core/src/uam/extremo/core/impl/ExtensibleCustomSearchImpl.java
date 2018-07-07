package uam.extremo.core.impl;

import uam.extremo.core.DataModelType;
import uam.extremo.core.ExtendedSemanticmanagerFactory;
import uam.extremo.core.ExtensibleCustomSearch;
import uam.extremo.core.ModelTypeParam;
import uam.extremo.core.PrimitiveTypeParam;
import uam.extremo.core.Type;
import uam.extremo.core.impl.CustomSearchImpl;

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
