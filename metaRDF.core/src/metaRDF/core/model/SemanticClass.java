package metaRDF.core.model;

import java.util.List;

public interface SemanticClass extends SemanticElement{
	String getLabel();
	void setLabel(String label);
	
	List<SemanticClass> getSuperclasses();
	void setSuperclasses(List<SemanticClass> superclasses);
	void addSuperclasses(List<SemanticClass> superclasses);
	
	List<SemanticClass> getSubclasses();
	void setSubclasses(List<SemanticClass> subclasses);
	void addSubclasses(List<SemanticClass> subclasses);
	
	List<IDataProperty> getProperties();
	void setProperties(List<IDataProperty> properties);
	void addProperties(List<IDataProperty> properties);
	
	List<IObjectProperty> getReferences();
	void setReferences(List<IObjectProperty> references);
	void addReferences(List<IObjectProperty> references);
}
