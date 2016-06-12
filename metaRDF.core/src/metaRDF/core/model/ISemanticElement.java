package metaRDF.core.model;

import java.io.Serializable;

public interface ISemanticElement extends Serializable{
	String getName();
	void setName(String name);
	
	Object getId();
	void setId(Object id);
	String getDescription();
	
	void setDescription(String comment);
	
	int getWeight();
	void setWeight(int weight);
}
