package uam.extremo.assistant.ecore;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import semanticmanager.*;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;

public class EcoreAssistant extends FormatAssistant implements IFormatAssistant {
	File ecoreFile;
	semanticmanager.Resource semanticResource = null;
	TreeIterator<EObject> ecoreAll = null;
	
	@Override
	public boolean load(semanticmanager.Resource semanticResource) {
		this.semanticResource = semanticResource;
		
		ecoreFile = new File((String) semanticResource.getUri());
		
		if(ecoreFile == null){
			return false;
		}
		if(ecoreFile.isDirectory()){
			return false;
		}
		if(!ecoreFile.exists()){
			return false;
		}
		
		Resource resource = null;
		try{
			ResourceSet resourceSet = new ResourceSetImpl(); 
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());		
			URI fileURI = URI.createFileURI(ecoreFile.getAbsolutePath());
			resource = resourceSet.getResource(fileURI, true);
			resourceSet.getAllContents().next();
			ecoreAll = resource.getAllContents();
		}catch(Exception e){
			semanticResource.setAlive(false);
		}
		
		if((ecoreAll != null) && (semanticResource.isAlive())){
			while(ecoreAll.hasNext()){
				EObject obj = ecoreAll.next();
				
				if((obj != null) && (obj instanceof EClass)){
					String name = ((EClass) obj).getName();
					String description = ((EClass) obj).getEAnnotations().toString();
					
					SemanticNode semanticNode = createSemanticNode(obj, name, description, false, null);
					addSemanticNodeToResource(semanticResource, semanticNode);
				}
			}
		}
		
		return true;
	}
	
	@Override
	public void toDataProperty(SemanticNode parent) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId(); 

			for(EAttribute attr : eClass.getEAttributes()){
				try{
					String name = attr.getName();
					Type type = defineStringType();
					
					if(attr.getEType().equals(EcorePackage.eINSTANCE.getEInt())){
						type = defineIntType();
					}
					
					if(attr.getEType().equals(EcorePackage.eINSTANCE.getEFloat())){
						type = defineFloatType();
					}
					
					if(attr.getEType().equals(EcorePackage.eINSTANCE.getEDouble())){
						type = defineDoubleType();
					}
					
					if(attr.getEType().equals(EcorePackage.eINSTANCE.getEBoolean())){
						type = defineBooleanType();
					}
					
					createDataProperty((EAttribute) attr, name, "", type);
				}
				catch(Exception e){
					System.out.println("can't form a attribute" + attr.getName());
				}
			}
		}
	}
	
	@Override
	public void toDataProperty(SemanticNode parent, boolean supers, boolean equivs) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId(); 

			for(EAttribute attr : eClass.getEAttributes()){
				try{
					String name = attr.getName();
					Type type = defineStringType();
					
					if(attr.getEType().equals(EcorePackage.eINSTANCE.getEInt())){
						type = defineIntType();
					}
					
					if(attr.getEType().equals(EcorePackage.eINSTANCE.getEFloat())){
						type = defineFloatType();
					}
					
					if(attr.getEType().equals(EcorePackage.eINSTANCE.getEDouble())){
						type = defineDoubleType();
					}
					
					if(attr.getEType().equals(EcorePackage.eINSTANCE.getEBoolean())){
						type = defineBooleanType();
					}
					
					createDataProperty((EAttribute) attr, name, "", type);
				}
				catch(Exception e){
					System.out.println("can't form a attribute" + attr.getName());
				}
			}
		}
	}

	@Override
	public void toObjectProperty(SemanticNode parent) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			for(EReference reference : eClass.getEReferences()){
				SemanticNode range = semanticNodeFromId(semanticResource, reference.getEContainingClass());
				ObjectProperty objectProperty = createObjectProperty(reference, reference.getName(), range);
				addObjectPropertyToNode(parent, objectProperty);
			}
		}
	}
	
	@Override
	public void toObjectProperty(SemanticNode parent, boolean supers, boolean equivs) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			for(EReference reference : eClass.getEReferences()){
				SemanticNode range = semanticNodeFromId(semanticResource, reference.getEContainingClass());
				ObjectProperty objectProperty = createObjectProperty(reference, reference.getName(), range);
				addObjectPropertyToNode(parent, objectProperty);
			}
		}
	}

	@Override
	public List<SemanticNode> getSiblings(SemanticNode name) {
		return null;
	}

	@Override
	public List<SemanticNode> getRelatedClasses(SemanticNode name, boolean supers, boolean equivs) {
		return null;
	}

	@Override
	public void toSuper(SemanticNode parent) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			for(EClass superclass : eClass.getESuperTypes()){
				SemanticNode range = semanticNodeFromId(semanticResource, superclass);
				addSuperClassToNode(parent, range);
			}
		}
	}
	
	@Override
	public void toSuper(SemanticNode parent, boolean direct) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			for(EClass superclass : eClass.getESuperTypes()){
				SemanticNode range = semanticNodeFromId(semanticResource, superclass);
				addSuperClassToNode(parent, range);
			}
		}
	}

	@Override
	public void toSub(SemanticNode parent) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			List<EClass> candidates = new ArrayList<EClass>();
			
			while(ecoreAll.hasNext()){
				EObject obj = ecoreAll.next();
				
				if(obj instanceof EClass){
					List<EClass> superclasses;
					superclasses = ((EClass) obj).getESuperTypes();
					//else superclasses = ((EClass) obj).getEAllSuperTypes();
					
					for(EClass superclass : superclasses){
						if(superclass.equals(eClass)){
							candidates.add((EClass)obj);
						}
					}
				}
			}
			
			for(EClass subclass : candidates){
				SemanticNode range = semanticNodeFromId(semanticResource, subclass);
				addSubClassToNode(parent, range);
			}
		}
	}
	
	@Override
	public void toSub(SemanticNode parent, boolean direct) {
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
			
			for(EClass subclass : candidates){
				SemanticNode range = semanticNodeFromId(semanticResource, subclass);
				addSubClassToNode(parent, range);
			}
		}
	}

	@Override
	public List<ObjectProperty> getPath(SemanticNode entityA, SemanticNode entityB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectProperty getInverseProperty(SemanticNode parent, ObjectProperty property) {
		// TODO Auto-generated method stub
		return null;
	}
}
