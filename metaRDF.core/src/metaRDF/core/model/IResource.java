package metaRDF.core.model;

import java.util.List;

public interface IResource extends ISemanticElement{	
	List<ISemanticClass> getClasses();
	void setClasses(List<ISemanticClass> classes);
	void addClasses(List<ISemanticClass> classes);
	void addClass(ISemanticClass clazz);
	
	boolean isAlive();
}