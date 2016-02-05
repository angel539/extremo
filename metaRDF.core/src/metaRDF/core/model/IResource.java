package metaRDF.core.model;

import java.util.List;

public interface IResource extends ISemanticElement{	
	List<ISemanticClass> getClasses();
	void setClasses(List<ISemanticClass> classes);
	void addClasses(List<ISemanticClass> classes);
	void addClass(ISemanticClass clazz);
	
	String getAssistant();
	void setAssistant(String assistant);
	boolean isAlive();
	void setAlive(boolean isAlive);
	
	boolean isActive();
	void setActive(boolean isActive);
}