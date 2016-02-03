package metardf.ui.views.entities.model;

import metaRDF.core.model.IDataProperty;

public class DataPropertyObject extends TreeObject {
	String name;
	
	public DataPropertyObject(String name) {
		super(name);
	}

	public DataPropertyObject(IDataProperty attribute) {
		super(attribute.getName() + " : " + attribute.getType());
	}
}
