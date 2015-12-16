package metaRDF.core.model;

import java.util.List;

public interface SemanticClass {
	String getUri();
	String getName();
	String getLabel();
	String getComment();
	
	List<SemanticClass> getSuperclasses();
	void setSuperclasses(List<SemanticClass> superclasses);
	void addSuperclasses(List<SemanticClass> superclasses);
	
	List<SemanticClass> getSubclasses();
	void setSubclasses(List<SemanticClass> subclasses);
	void addSubclasses(List<SemanticClass> subclasses);
	
	List<DataProperty> getProperties();
	void setProperties(List<DataProperty> properties);
	void addProperties(List<DataProperty> properties);
	
	List<ObjectProperty> getReferences();
	void setReferences(List<ObjectProperty> references);
	void addReferences(List<ObjectProperty> references);
}
