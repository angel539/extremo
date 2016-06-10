package metardf.core.extensions.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.DataProperty;
import metaRDF.core.model.impl.ObjectProperty;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;

public class ReflectiveUtils {
	public static Set<Class<? extends Object>> getAllClassInstances(){
		List<String> idPackages = new ArrayList<String>();
		for(IFormatAssistant assistant :  AssistantFactory.getInstance().getAssistances()){
			idPackages.add(((FormatAssistant)assistant).getId() + ".model");
		}
		
		Set<Class<? extends Object>> allClasses = null;
		
		for(String idPackage : idPackages){
			if(allClasses == null) allClasses = new HashSet<Class<? extends Object>>();
			Reflections reflections = new Reflections(idPackage);
			allClasses.addAll(reflections.getSubTypesOf(Object.class));
		}
		
		return allClasses;
	}
	
	public static Set<Class<? extends ISemanticElement>> getAllSemanticClassInstances(){
		//List<String> idPackages = new ArrayList<String>();	
		List<Class<? extends ISemanticElement>> registeredTypes = new ArrayList<Class<? extends ISemanticElement>>();
		
		for(IFormatAssistant assistant :  AssistantFactory.getInstance().getAssistances()){
			registeredTypes.addAll(assistant.getRegisteredTypes());
		}

		return new HashSet<Class<? extends ISemanticElement>>(registeredTypes);
		//Set<Class<? extends SemanticClass>> allClasses = null;
		
		/*for(String idPackage : idPackages){
			if(allClasses == null) allClasses = new HashSet<Class<? extends SemanticClass>>();
			
			Reflections reflections = new Reflections(idPackage);
			allClasses.addAll(reflections.getSubTypesOf(SemanticClass.class));
		}*/
		
		//return allClasses;
	}
	
	/*
	 * Set<Method> getters = getAllMethods(someClass,
      withModifier(Modifier.PUBLIC), withPrefix("get"), withParametersCount(0));

 //or
 Set<Method> listMethods = getAllMethods(List.class,
      withParametersAssignableTo(Collection.class), withReturnType(boolean.class));

 Set<Fields> fields = getAllFields(SomeClass.class, withAnnotation(annotation), withTypeAssignableTo(type));
	 */
	
	public static Set<Class<? extends ObjectProperty>> getAllObjectPropertyInstances(){
		List<String> idPackages = new ArrayList<String>();
		for(IFormatAssistant assistant :  AssistantFactory.getInstance().getAssistances()){
			idPackages.add(((FormatAssistant)assistant).getId() + ".model");
		}
		
		Set<Class<? extends ObjectProperty>> allClasses = null;
		
		for(String idPackage : idPackages){
			if(allClasses == null) allClasses = new HashSet<Class<? extends ObjectProperty>>();
			Reflections reflections = new Reflections(idPackage);
			allClasses.addAll(reflections.getSubTypesOf(ObjectProperty.class));
		}
		
		return allClasses;
	}
	
	public static Set<Class<? extends DataProperty>> getAllDataPropertyInstances(){
		List<String> idPackages = new ArrayList<String>();
		for(IFormatAssistant assistant :  AssistantFactory.getInstance().getAssistances()){
			idPackages.add(((FormatAssistant)assistant).getId() + ".model");
		}
		
		Set<Class<? extends DataProperty>> allClasses = null;
		
		for(String idPackage : idPackages){
			if(allClasses == null) allClasses = new HashSet<Class<? extends DataProperty>>();
			Reflections reflections = new Reflections(idPackage);
			allClasses.addAll(reflections.getSubTypesOf(DataProperty.class));
		}
		
		return allClasses;
	}
}
