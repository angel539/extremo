package metaRDF.core.model;

import java.util.List;

public interface Resource extends SemanticElement{	
	List<SemanticClass> getClasses();
	void setClasses(List<SemanticClass> classes);
	void addClasses(List<SemanticClass> classes);
	void addClass(SemanticClass clazz);
	
	boolean isAlive();
}