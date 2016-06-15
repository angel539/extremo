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
	List<ISemanticClass> model = null;
	
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
	public List<ISemanticClass> getAllClasses() {
		Resource resource = null;
		
		List<ISemanticClass> classes = new ArrayList<ISemanticClass>();
		
		if(ecore != null && ecore.exists()){
			try{
				ResourceSet resourceSet = new ResourceSetImpl(); 
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());		
				URI fileURI = URI.createFileURI(ecore.getAbsolutePath());
				resource = resourceSet.getResource(fileURI, true);
				resourceSet.getAllContents().next();
				ecoreAll = resource.getAllContents();
			}catch(Exception e){
				semanticResource.setAlive(false);
			}
		}
		
		if((ecoreAll != null)&&(semanticResource.isAlive())){
			while(ecoreAll.hasNext()){
				EObject obj = ecoreAll.next();
				
				if((obj != null) && (obj instanceof EClass)){
					String name = ((EClass) obj).getName();
					String description = ((EClass) obj).getName() + " " + ((EClass) obj).getEAnnotations().toString();
					EcoreSemanticClass semanticClass = new EcoreSemanticClass((EClass) obj, name, description);
					classes.add((ISemanticClass) semanticClass);
				}
			}
		}
		
		this.model = classes;
		return classes;
	}
	
	
	/*@Override
	public List<ISemanticClass> getClassesLike(String... names) {
		Resource resource = null;
		List<ISemanticClass> classes = new ArrayList<ISemanticClass>();
		
		if(ecore != null && ecore.exists()){
			try{
				ResourceSet resourceSet = new ResourceSetImpl(); 
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
				EcorePackage ecorePackage = EcorePackage.eINSTANCE;		
				URI fileURI = URI.createFileURI(ecore.getAbsolutePath());
				resource = resourceSet.getResource(fileURI, true);
				resourceSet.getAllContents().next();
				ecoreAll = resource.getAllContents();
			}catch(Exception e){
				semanticResource.setAlive(false);
			}
			
		}
		
		if((ecoreAll != null)&&(semanticResource.isAlive())){
			iterator:
			while(ecoreAll.hasNext()){
				EObject obj = ecoreAll.next();
				if(obj instanceof EClass){
					for(String word : names){
						if(((EClass) obj).getName().compareTo(word) == 0){
							String name = ((EClass) obj).getName();
							String description = ((EClass) obj).getEAnnotations().toString();
							EcoreSemanticClass semanticClass = new EcoreSemanticClass((EClass) obj, name, description);
							semanticClass.setResourceFrom(semanticResource);
							classes.add((ISemanticClass) semanticClass);
							continue iterator;
						}
						
						List<String> wordInNameClass = LangUtils.cleanAndSeparateWords(((EClass) obj).getName());
						for(String wordInName : wordInNameClass){
							if(LangUtils.haveTheSameStem(wordInName, word)){
								String name = ((EClass) obj).getName();
								String description = ((EClass) obj).getEAnnotations().toString();
								EcoreSemanticClass semanticClass = new EcoreSemanticClass((EClass) obj, name, description);
								semanticClass.setResourceFrom(semanticResource);
								classes.add((ISemanticClass) semanticClass);
								continue iterator;
							}
						}
					}
				}
			}
		}
		
		return classes;
	}*/
	
	@Override
	public List<ISemanticClass> getClassesLike(Map<String, Integer> namesByRelevance) {
		Resource resource = null;
		List<ISemanticClass> classes = new ArrayList<ISemanticClass>();
		
		if(ecore != null && ecore.exists()){
			try{
				ResourceSet resourceSet = new ResourceSetImpl(); 
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
				//EcorePackage ecorePackage = EcorePackage.eINSTANCE;		
				URI fileURI = URI.createFileURI(ecore.getAbsolutePath());
				resource = resourceSet.getResource(fileURI, true);
				resourceSet.getAllContents().next();
				ecoreAll = resource.getAllContents();
			}catch(Exception e){
				semanticResource.setAlive(false);
			}
		}
		
		if((ecoreAll != null)&&(semanticResource.isAlive())){
			iterator:
			while(ecoreAll.hasNext()){
				EObject obj = ecoreAll.next();
				if(obj instanceof EClass){
					for(Entry<String, Integer> word : namesByRelevance.entrySet()){
						if(((EClass) obj).getName().compareTo(word.getKey()) == 0){
							String name = ((EClass) obj).getName();
							String description = ((EClass) obj).getEAnnotations().toString();
							EcoreSemanticClass semanticClass = new EcoreSemanticClass((EClass) obj, name, description);
							//semanticClass.setWeight(word.getValue() + 500);
							semanticClass.setResourceFrom(semanticResource);
							classes.add((ISemanticClass) semanticClass);
							continue iterator;
						}
						
						List<String> wordInNameClass = LangUtils.cleanAndSeparateWords(((EClass) obj).getName());
						for(String wordInName : wordInNameClass){
							
							if(wordInName.compareTo(word.getKey()) == 0){
								String name = ((EClass) obj).getName();
								String description = ((EClass) obj).getEAnnotations().toString();
								EcoreSemanticClass semanticClass = new EcoreSemanticClass((EClass) obj, name, description);
								//semanticClass.setWeight(word.getValue() + 300);
								semanticClass.setResourceFrom(semanticResource);
								classes.add((ISemanticClass) semanticClass);
								continue iterator;
							}else{
								if(LangUtils.haveTheSameStem(wordInName, word.getKey())){
									String name = ((EClass) obj).getName();
									String description = ((EClass) obj).getEAnnotations().toString();
									EcoreSemanticClass semanticClass = new EcoreSemanticClass((EClass) obj, name, description);
									//semanticClass.setWeight(word.getValue() + 100);
									semanticClass.setResourceFrom(semanticResource);
									classes.add((ISemanticClass) semanticClass);
									continue iterator;
								}
							}
						}
					}
				}
			}
		}
		
		return classes;
	}
	
	@Override
	public List<IDataProperty> getDataProperties(ISemanticClass parent, boolean supers, boolean equivs) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId(); 
			List<IDataProperty> properties = new ArrayList<IDataProperty>();
			
			for(EAttribute attr : eClass.getEAttributes()){
				try{
					properties.add((IDataProperty) new EcoreDataProperty((EAttribute) attr, attr.getName(), attr.getEType().getName(), false, attr.getName()));
				}
				catch(Exception e){
					System.out.println("can't form a attribute" + attr.getName());
				}
			}
			
			return properties;
		}
		
		return null;
	}

	@Override
	public List<IObjectProperty> getObjectProperties(ISemanticClass parent, boolean supers, boolean equivs) {
		List<IObjectProperty> properties = new ArrayList<IObjectProperty>();
		
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			for(EReference reference : eClass.getEReferences()){
				if(!reference.isContainment() && reference.getEOpposite() != null && reference.getEOpposite().isContainment()) continue;
				classes:
					
				for(ISemanticClass range : model){
					if(range.getName().equals(reference.getEReferenceType().getName())){
						EcoreObjectProperty property = new EcoreObjectProperty((EReference) reference, range, reference.getName(), false, reference.getName());
						properties.add((IObjectProperty) property);
						break classes;
					}
				}
			}
		}
		
		return properties;
	}

	@Override
	public List<ISemanticClass> getSiblings(ISemanticClass name) {
		return null;
	}

	@Override
	public List<ISemanticClass> getRelatedClasses(ISemanticClass name, boolean supers, boolean equivs) {
		return null;
	}

	@Override
	public List<ISemanticClass> getSuper(ISemanticClass parent, boolean direct) {
		List<ISemanticClass> superclasses = new ArrayList<ISemanticClass>();
		
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			for(EClass superclass : eClass.getESuperTypes()){
				if(model != null){
					for(ISemanticClass range : model){
						if(range.getName().equals(superclass.getName())){
							superclasses.add(range);
						}
					}
				}
			}
		}
		
		return superclasses;
	}

	@Override
	public List<ISemanticClass> getSub(ISemanticClass parent, boolean direct) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			List<EClass> candidates = new ArrayList<EClass>();
			
			while(ecoreAll.hasNext()){
				EObject obj = ecoreAll.next();
				
				if(obj instanceof EClass){
					List<EClass> superclasses;
					if(direct) superclasses = ((EClass) obj).getESuperTypes();
					else superclasses = ((EClass) obj).getEAllSuperTypes();
					
					for(EClass superclass : superclasses){
						if(superclass.equals(eClass)){
							candidates.add((EClass)obj);
						}
					}
				}
			}
			
			List<ISemanticClass> subclasses = new ArrayList<ISemanticClass>();
			
			for(EClass subclass : candidates){
				EcoreSemanticClass semanticClass = new EcoreSemanticClass((EClass) subclass, subclass.getName(), subclass.getName());
				subclasses.add((ISemanticClass) semanticClass);
			}
			
			return subclasses;
		}
		
		return null;
	}

	@Override
	public List<IObjectProperty> getPath(ISemanticClass entityA, ISemanticClass entityB) {
		return null;
	}

	@Override
	public IObjectProperty getInverseProperty(ISemanticClass cl, IObjectProperty property) {
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
