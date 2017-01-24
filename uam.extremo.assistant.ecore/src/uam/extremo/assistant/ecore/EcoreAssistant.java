package uam.extremo.assistant.ecore;
import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import semanticmanager.*;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;

import org.apache.commons.io.FilenameUtils;

public class EcoreAssistant extends FormatAssistant implements IFormatAssistant {
	File file;
	semanticmanager.Resource semanticResource = null;
	TreeIterator<EObject> modelAll = null;
	
	String extension;
	
	Map<EObject, SemanticNode> correspondance = new HashMap<EObject, SemanticNode>();
	ResourceSet resourceSet = new ResourceSetImpl(); 
	
	@Override
	public boolean load(semanticmanager.Resource semanticResource) {
		this.semanticResource = semanticResource;
		
		file = new File((String) semanticResource.getUri());
		
		if(file == null){
			return false;
		}
		if(file.isDirectory()){
			return false;
		}
		if(!file.exists()){
			return false;
		}
		
		extension = FilenameUtils.getExtension(file.getAbsolutePath());
		
		switch (extension) {
			//metamodel
			case "ecore":
				ecoreClassesToSemanticNodes();
				break;
				
			//model
			case "xmi":
				xmiObjectsToSemanticNodes();
				break;
	
			default:
				xmiObjectsToSemanticNodes();
				break;
		}
		
		return true;	
	}


	private void ecoreClassesToSemanticNodes(){
		Resource resource = null;
		
		try{
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());		
			
			final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(resourceSet.getPackageRegistry());
			resourceSet.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA,
				    extendedMetaData);	
			
			URI fileURI = URI.createFileURI(file.getAbsolutePath());
			resource = resourceSet.getResource(fileURI, true);
		    resource.load(null);
			
			resourceSet.getAllContents().next();
			modelAll = resource.getAllContents();
		}
		catch(Exception e){
			semanticResource.setAlive(false);
		}
		
		if((modelAll != null) && (semanticResource.isAlive())){
			while(modelAll.hasNext()){
				EObject obj = modelAll.next();
				
				if (obj instanceof EPackage) {
				    EPackage p = (EPackage) obj;
				    if(p.getNsURI() != null){
				    	resourceSet.getPackageRegistry().put(p.getNsURI(), p);
				    }
				    else{
				    	resourceSet.getPackageRegistry().put(p.getName(), p);
				    }
				}
				
				if((obj != null) && (obj instanceof EClass)){
					String name = ((EClass) obj).getName();
					String description = ((EClass) obj).getEAnnotations().toString();
									
					SemanticNode semanticNode = 
							createSemanticNode(
									obj, //original object as id
									name, 
									description, 
									null); //it is actually a descriptor element
										
					addSemanticNodeToResource(semanticResource, semanticNode);
				}
			}
		}
	}
	
	
	private void xmiObjectsToSemanticNodes() {
		Resource resource = null;
		try{
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(extension, new XMIResourceFactoryImpl());		
			
			URI fileURI = URI.createFileURI(file.getAbsolutePath());
			resource = resourceSet.getResource(fileURI, true);
			resourceSet.getAllContents().next();
			modelAll = resource.getAllContents();
		}
		catch(Exception e){
			semanticResource.setAlive(false);
		}
		
		int counter = 0;
		if((modelAll != null) && (semanticResource.isAlive())){
			while(modelAll.hasNext()){
				
				EObject obj = modelAll.next();
				counter++;
								
				if((obj != null) && (obj instanceof EObject)){
					EStructuralFeature structuralfeature = obj.eClass().getEStructuralFeature("name");
					
					String name = null;
					
					if(structuralfeature != null){
						Object nameObject = ((EObject) obj).eGet(structuralfeature);
						
						if(nameObject instanceof String){
							//There is a name?
							name = (String) nameObject;
						}
					}
					
					if(name == null){
						name = obj.eClass().getName().toLowerCase() + counter;
					}
					
					String description = ((EObject) obj).eClass().getEAnnotations().toString();
					
					SemanticNode conforms_to = 
							searchSemanticNodeByName(
									(semanticmanager.Resource) semanticResource.getDescriptor(), 
									obj.eClass().getName()
							);
					
					SemanticNode semanticNode = 
							createSemanticNode(
									obj, 
									name, 
									description, 
									conforms_to //the element descriptor
							);
					
					addSemanticNodeToResource(semanticResource, semanticNode);
					
					correspondance.put(obj, semanticNode);
				}
			}
		}
	}
	
	@Override
	public void toDataProperty(SemanticNode parent) {
		switch (extension) {
			//metamodel
			case "ecore":
				ecoreAttributesToDataProperties(parent);
				break;
				
			//model
			case "xmi":
				xmiAttributesToDataProperties(parent);
				break;
	
			default:
				xmiAttributesToDataProperties(parent);
				break;
		}
	}

	private void ecoreAttributesToDataProperties(SemanticNode parent) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId(); 
			
			for(EAttribute attr : eClass.getEAttributes()){				
				try{
					String name = attr.getName();
					Type type = defineStringType();
					Class<?> cl = (attr.getEType() != null)?attr.getEType().getInstanceClass():null;
					
					if (cl != null) {
						if(cl == Integer.class || cl == int.class || cl == short.class || cl == Short.class || cl == BigInteger.class || cl == byte.class || cl == Byte.class){
							type = defineIntType();
						}
						
						if(cl == Float.class || cl == float.class){
							type = defineFloatType();
						}
						
						if(cl == double.class || cl == Double.class){
							type = defineDoubleType();
						}
						
						if(cl == boolean.class || cl == Boolean.class){
							type = defineBooleanType();
						}
					}
					
					DataProperty dataProperty = 
							createDataProperty(
									(EAttribute) attr, 
									name, 
									"", 
									type //the type selected from the enum class
							);
										
					addDataPropertyToNode(parent, dataProperty);
				}
				catch(Exception e){
					return;
				}
			}
		}
	}
	
	private void xmiAttributesToDataProperties(SemanticNode parent) {
		if(parent.getId() != null && parent.getId() instanceof EObject){
			EObject eobject = (EObject) parent.getId();
			
			List<EAttribute> eAttributes = eobject.eClass().getEAllAttributes();
			
			for(EAttribute eAttribute : eAttributes){	
					DataProperty descriptor = 
							searchDataPropertyByName(
									(SemanticNode) parent.getDescriptor(), 
									eAttribute.getName()
							);
					
					if(descriptor != null){
						EDataType  eAttrValue = (EDataType) eobject.eGet(eAttribute, true);

						String value = "";
						if(eAttrValue != null){
							value = eAttrValue.toString();
						}
						
						DataProperty dataProperty = 
								createDataProperty(
										descriptor, //descriptor
										value //value
								);
						
						
						addDataPropertyToNode(parent, dataProperty);
					}
				//}
			}
		}
	}

	@Override
	public void toObjectProperty(SemanticNode parent) {
		switch (extension) {
			//metamodel
			case "ecore":
				ecoreReferencesToObjectProperties(parent);
				break;
				
			//model
			case "xmi":
				xmiReferencesToObjectProperties(parent);
				break;
	
			default:
				xmiReferencesToObjectProperties(parent);
				break;
		}
	}

	private void ecoreReferencesToObjectProperties(SemanticNode parent) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			for(EReference reference : eClass.getEReferences()){
				SemanticNode range = semanticNodeFromName(semanticResource, reference.getEReferenceType().getName());

				ObjectProperty objectProperty = 
						createObjectProperty(
								reference, 
								reference.getName(), 
								reference.getLowerBound(), 
								reference.getUpperBound(), 
								range);
				
				addObjectPropertyToNode(parent, objectProperty);
			}
		}
	}
	
	private void xmiReferencesToObjectProperties(SemanticNode parent) {
		if(parent.getId() != null && parent.getId() instanceof EObject){
			EObject eobject = (EObject) parent.getId();
			
			List<EStructuralFeature> structuralFeatures = eobject.eClass().getEAllStructuralFeatures();
			
			for(EStructuralFeature structuralFeature : structuralFeatures){	
				if(structuralFeature instanceof EReference){
					EReference eReference = (EReference) structuralFeature;
					
					ObjectProperty descriptor = 
							searchObjectPropertyByName(
									(SemanticNode) parent.getDescriptor(), 
									eReference.getName()
							);
					
					if(descriptor != null){
						Object eReferenceValue = eobject.eGet(eReference, true);

						if(eReferenceValue instanceof EObject[]){
							for(EObject reference : (EObject[]) eReferenceValue){
								SemanticNode range = correspondance.get(reference);
								
								ObjectProperty objectProperty = 
										createObjectProperty(
												descriptor, //descriptor
												range //value
										);
								
								addObjectPropertyToNode(parent, objectProperty);
							}
						}
						else{
							if(eReferenceValue instanceof EObject){
								SemanticNode range = correspondance.get(eReferenceValue);
								
								ObjectProperty objectProperty = 
										createObjectProperty(
												descriptor, //descriptor
												range //value
										);	
								addObjectPropertyToNode(parent, objectProperty);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void toSuper(SemanticNode parent) {
		switch (extension) {
			//metamodel
			case "ecore":
				ecoreSuperToSemanticNodes(parent);
				break;
	
			default:
				break;
		}	
	}
	
	private void ecoreSuperToSemanticNodes(SemanticNode parent) {
		if(parent.getId() != null && parent.getId() instanceof EClass){
			EClass eClass = (EClass) parent.getId();
			
			for(EClass superclass : eClass.getESuperTypes()){
				SemanticNode range = semanticNodeFromName(semanticResource, superclass.getName());
				addSuperClassToNode(parent, range);
			}
		}
	}
}
