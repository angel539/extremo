package metaRDF.core.utils;

import java.util.ArrayList;
import java.util.HashSet;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.IClassifier;

public class SemanticModelUtils {
	public ISemanticClass joinClasses(ISemanticClass class1, ISemanticClass class2){
		if(class1.getProperties() != null){
			if(class2.getProperties() != null){
				class1.addProperties(class2.getProperties());
			}
		}
		else{
			if(class2.getProperties() != null) class1.setProperties(class2.getProperties());
		}
		
		if(class1.getReferences() != null){
			if(class2.getReferences() != null){
				class1.addReferences(class2.getReferences());
			}
		}
		else{
			if(class2.getReferences() != null) class1.setReferences(class2.getReferences());
		}
		
		if(class1.getSuperclasses() != null){
			if(class2.getSuperclasses() != null){
				class1.addSuperclasses(class2.getSuperclasses());
			}
		}
		else{
			if(class2.getSuperclasses() != null) class1.setSuperclasses(class2.getSuperclasses());
		}
		
		if(class1.getSubclasses() != null){
			if(class2.getSubclasses() != null){
				class1.addSubclasses(class2.getSubclasses());
			}
		}
		else{
			if(class2.getSubclasses() != null) class1.setSubclasses(class2.getSubclasses());
		}
		
		return class1;
	}
	
	public boolean compareSemanticElement(IClassifier element1, IClassifier element2){
		return element1.getName().equals(element2.getName());
	}
	
	/*public boolean compareObjectPropertiesPointer(IObjectProperty property1, IObjectProperty property2){
		return property1.getRangeAsSemanticClass().getName().
				equals(property2.getRangeAsSemanticClass().getName());
	}*/
	
	public boolean compareDataPropertyType(IDataProperty dataProperty1, IDataProperty dataProperty2){
		return dataProperty1.getType().equals(dataProperty2.getType());
	}
	
	public ArrayList<IClassifier> getUnique(ArrayList<IClassifier> list) {
		HashSet<IClassifier> hs = new HashSet<IClassifier>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		return list;
	}
	
	
}
