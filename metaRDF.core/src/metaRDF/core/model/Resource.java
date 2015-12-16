package metaRDF.core.model;

import java.util.List;

public interface Resource {
	String getName();
	void setName(String name);
	
	String getDescription();
	void setDescription(String description);
	
	String getURI();
	void setURI(String uri);
	
	List<SemanticClass> getClasses();
	void setClasses(List<SemanticClass> classes);
	void addClasses(List<SemanticClass> classes);
	void addClass(SemanticClass clazz);
	
	boolean isAlive();
}