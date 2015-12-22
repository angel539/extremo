package metaRDF.core.model;

import java.util.List;

public interface ISemanticClass extends ISemanticElement{
	String getLabel();
	void setLabel(String label);
	
	List<ISemanticClass> getSuperclasses();
	void setSuperclasses(List<ISemanticClass> superclasses);
	void addSuperclasses(List<ISemanticClass> superclasses);
	
	List<ISemanticClass> getSubclasses();
	void setSubclasses(List<ISemanticClass> subclasses);
	void addSubclasses(List<ISemanticClass> subclasses);
	
	List<IDataProperty> getProperties();
	void setProperties(List<IDataProperty> properties);
	void addProperties(List<IDataProperty> properties);
	
	List<IObjectProperty> getReferences();
	void setReferences(List<IObjectProperty> references);
	void addReferences(List<IObjectProperty> references);
}
