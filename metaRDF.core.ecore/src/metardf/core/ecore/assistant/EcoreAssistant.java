package metardf.core.ecore.assistant;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.SemanticResource;
import metaRDF.core.utils.LangUtils;
import metardf.core.ecore.assistant.model.EcoreDataProperty;
import metardf.core.ecore.assistant.model.EcoreObjectProperty;
import metardf.core.ecore.assistant.model.EcoreSemanticClass;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public class EcoreAssistant extends FormatAssistant implements IFormatAssistant {
	File ecore;
	SemanticResource semanticResource = null;
	TreeIterator<EObject> ecoreAll;
	
	@Override
	public boolean load(SemanticResource semanticResource) {
		this.semanticResource = semanticResource;
		ecore = new File((String) semanticResource.getId());
		if(ecore.isDirectory()){
			return false;
		}
		if(!ecore.exists()){
			return false;
		}
		return true;
	}

	@Override
	public List<ISemanticClass> getClassesLike(String... names) {
		Resource resource = null;
		List<ISemanticClass> classes = new ArrayList<ISemanticClass>();
		
		if(ecore != null && ecore.exists()){
			try{
				ResourceSet resourceSet = new ResourceSetImpl(); 
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl()); 			//EcorePackage ecorePackage = EcorePackage.eINSTANCE;		
				URI fileURI = URI.createFileURI(ecore.getAbsolutePath());
				resource = resourceSet.getResource(fileURI, true);
				resourceSet.getAllContents().next();
				ecoreAll = resource.getAllContents();
			}catch(Exception e){
				semanticResource.setAlive(false);
			}
			
		}
		
		if((ecoreAll != null)&&(semanticResource.isAlive())){
			Map<String, List<String>> definitions = LangUtils.getSynomins(names);
			
			List<String> words = new ArrayList<String>();
			
			for (Entry<String, List<String>> definition : definitions.entrySet()){
				words.addAll(definition.getValue());
			}
			
			words = LangUtils.cleanRepeated(words);
			
			while(ecoreAll.hasNext()){
				EObject obj = ecoreAll.next();
				
				for(String word : words){
					if(obj instanceof EClass){
						if(((EClass) obj).getName().compareTo(word) == 0){
							EcoreSemanticClass semanticClass = new EcoreSemanticClass((EClass) obj, ((EClass) obj).getName(), ((EClass) obj).getName());
							classes.add((ISemanticClass) semanticClass);
						}
					}
				}
			}
		}
		
		return classes;
	}
	
	@Override
	public List<IDataProperty> getDataProperties(Object parent, boolean supers, boolean equivs) {
		if(parent instanceof EClass){
			List<IDataProperty> properties = new ArrayList<IDataProperty>();
			
			for(EAttribute attr : ((EClass) parent).getEAttributes()){
				properties.add((IDataProperty) new EcoreDataProperty(attr, attr.getName(), attr.getEType().getName(), false, attr.getName()));
			}
			
			if(supers){
				for(EClass superclass : ((EClass) parent).getEAllSuperTypes()){
					properties.addAll(getDataProperties(superclass, true, equivs));
				}
			}
			return properties;
		}
		
		return null;
	}

	@Override
	public List<IObjectProperty> getObjectProperties(Object parent, boolean supers, boolean equivs) {
		if(parent instanceof EClass){
			List<IObjectProperty> properties = new ArrayList<IObjectProperty>();
			
			for(EReference reference : ((EClass) parent).getEReferences()){
				EcoreObjectProperty property = new EcoreObjectProperty(reference, reference.getEReferenceType(), reference.getName(), false, reference.getName());
				properties.add((IObjectProperty) property);
			}
			
			if(supers){
				for(EClass superclass : ((EClass) parent).getEAllSuperTypes()){
					properties.addAll(getObjectProperties(superclass, true, equivs));
				}
			}
			return properties;
		}
	
		return null;
	}

	@Override
	public List<ISemanticClass> getSiblings(Object name) {
		return null;
	}

	@Override
	public List<ISemanticClass> getRelatedClasses(Object name, boolean supers, boolean equivs) {
		return null;
	}

	@Override
	public List<ISemanticClass> getSuper(Object name, boolean direct) {
		if(name instanceof EClass){
			List<ISemanticClass> superclasses = new ArrayList<ISemanticClass>();
			
			for(EClass superclass : ((EClass) name).getESuperTypes()){
				EcoreSemanticClass semanticClass = new EcoreSemanticClass(superclass, superclass.getName(), superclass.getName());
				superclasses.add((ISemanticClass) semanticClass);
			}
			
			return superclasses;
		}
		return null;
	}

	@Override
	public List<ISemanticClass> getSub(Object parent, boolean direct) {
		if(parent instanceof EClass){
			List<EClass> candidates = new ArrayList<EClass>();
			
			while(ecoreAll.hasNext()){
				EObject obj = ecoreAll.next();
				
				if(obj instanceof EClass){
					List<EClass> superclasses;
					if(direct) superclasses = ((EClass) obj).getESuperTypes();
					else superclasses = ((EClass) obj).getEAllSuperTypes();
					
					for(EClass superclass : superclasses){
						if(superclass.equals(parent)){
							candidates.add((EClass)obj);
						}
					}
				}
			}
			
			List<ISemanticClass> subclasses = new ArrayList<ISemanticClass>();
			
			for(EClass subclass : candidates){
				EcoreSemanticClass semanticClass = new EcoreSemanticClass(subclass, subclass.getName(), subclass.getName());
				subclasses.add((ISemanticClass) semanticClass);
			}
			
			return subclasses;
		}
		
		return null;
	}

	@Override
	public List<IObjectProperty> getPath(Object entityA, Object entityB) {
		return null;
	}

	@Override
	public IObjectProperty getInverseProperty(Object cl, Object property) {
		return null;
	}

	@Override
	public List<Class<? extends ISemanticElement>> getRegisteredTypes() {
		List<Class<? extends ISemanticElement>> types = new ArrayList<Class<? extends ISemanticElement>>();
		types.add(EcoreSemanticClass.class);
		types.add(EcoreObjectProperty.class);
		types.add(EcoreDataProperty.class);
		return types;
	}
}
