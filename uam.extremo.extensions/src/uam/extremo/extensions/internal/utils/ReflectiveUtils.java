package uam.extremo.extensions.internal.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import uam.extremo.core.*;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;

public class ReflectiveUtils {
	public static Set<Class<? extends Object>> getAllClassInstances() throws IOException{
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
	
	public static Set<Class<? extends NamedElement>> getAllSemanticClassInstances(){
		//List<String> idPackages = new ArrayList<String>();	
		List<Class<? extends NamedElement>> registeredTypes = new ArrayList<Class<? extends NamedElement>>();
		
		/*for(IFormatAssistant assistant :  AssistantFactory.getInstance().getAssistans()){
			registeredTypes.addAll(assistant.getRegisteredTypes());
		}*/

		return new HashSet<Class<? extends NamedElement>>(registeredTypes);
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
	
	public static Set<Class<? extends ObjectProperty>> getAllObjectPropertyInstances() throws IOException{
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
	
	public static Set<Class<? extends DataProperty>> getAllDataPropertyInstances() throws IOException{
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
