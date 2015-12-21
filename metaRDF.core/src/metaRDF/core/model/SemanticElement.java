package metaRDF.core.model;

public interface SemanticElement {
	String getName();
	void setName(String name);
	
	String getURI();
	void setUri(String uri);
	
	String getDescription();
	void setComment(String comment);
	
	String toString();	
}
