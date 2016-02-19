package metaRDF.core.model;

public interface ISemanticElement{
	String getName();
	void setName(String name);
	
	Object getId();
	void setId(Object id);
	
	String getIdToString();
	void setIdToString(String idString);
	String getDescription();
	
	void setDescription(String comment);
	
	int getWeight();
	void setWeight(int weight);
}
