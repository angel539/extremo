/**
 * 
 */
package uam.extremo.assistant.xsd;

import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import at.ac.tuwien.big.xmltext.EcoreToGenericEcoreTransformer;
import org.eclipse.emf.ecore.resource.Resource;

import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;

import semanticmanager.*;

/**
 * @author pneubaue
 *
 */
public class XsdAssistant extends FormatAssistant implements IFormatAssistant {
	File file;
	semanticmanager.Resource semanticResource = null;
	TreeIterator<EObject> modelAll = null;
	
	String extension;
	
	Map<EObject, SemanticNode> correspondance = new HashMap<EObject, SemanticNode>();
	ResourceSet resourceSet = new ResourceSetImpl(); 
	
	EcoreToGenericEcoreTransformer transformer = new EcoreToGenericEcoreTransformer();

	semanticmanager.Resource lastResource = null;
	
	@Override
	public boolean load(semanticmanager.Resource semanticResource) {
		boolean isImmediateRedo = semanticResource == lastResource;
		this.semanticResource = semanticResource;	
		lastResource = semanticResource;
		
		
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
			case "xsd":
				if (!isImmediateRedo) {
					transformer = new EcoreToGenericEcoreTransformer();
					transformer.setXsdEcore(file.getAbsolutePath());
				}
				xsdElementsToSemanticNodes();
				break;
				
			//model
			case "xml":
				xmlObjectsToSemanticNodes();
				break;
	
			default:
				xmlObjectsToSemanticNodes();
				break;
		}
		
		return true;	
	}

	private void xmlObjectsToSemanticNodes() {
		Resource genericEcoreResource = transformer.loadXml(file.getAbsolutePath());
		modelAll = genericEcoreResource.getAllContents();		
		
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

	private void xsdElementsToSemanticNodes() {
		// Load XML Schema file via XMLText and transform it to Ecore Metamodel
		Resource genericEcoreResource = transformer.getResult();
		modelAll = genericEcoreResource.getAllContents();

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

	@Override
	public void toDataProperty(SemanticNode parent) {
		switch (extension) {
		//metamodel
		case "xsd":
			xsdAttributesToDataProperties(parent);
			break;
			
		//model
		case "xml":
			xmlAttributesToDataProperties(parent);
			break;

		default:
			xmlAttributesToDataProperties(parent);
			break;
		}
	}

	private void xmlAttributesToDataProperties(SemanticNode parent) {
		if(parent.getTrace() != null && parent.getTrace() instanceof EObject){
			EObject eobject = (EObject) parent.getTrace();
			
			List<EStructuralFeature> structuralFeatures = eobject.eClass().getEAllStructuralFeatures();
			
			for(EStructuralFeature structuralFeature : structuralFeatures){	
				if(structuralFeature instanceof EAttribute){
					EAttribute eAttribute = (EAttribute) structuralFeature;
					
					DataProperty descriptor = 
							searchDataPropertyByName(
									(SemanticNode) parent.getDescriptor(), 
									eAttribute.getName()
							);
					
					if(descriptor != null){
						Object eAttrValue = eobject.eGet(eAttribute);
						
						
						String value = "";
						if(eAttrValue != null) value = eAttrValue.toString();
						
						DataProperty dataProperty = 
								createDataProperty(
										descriptor, //descriptor
										value //value
								);
						
						
						addDataPropertyToNode(parent, dataProperty);
					}
				}
			}
		}
	}

	private void xsdAttributesToDataProperties(SemanticNode parent) {
		if(parent.getTrace() != null && parent.getTrace() instanceof EClass){
			EClass eClass = (EClass) parent.getTrace(); 

			for(EAttribute attr : eClass.getEAllAttributes()){				
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
									attr.getLowerBound(), 
									attr.getUpperBound(),
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

	@Override
	public void toObjectProperty(SemanticNode parent) {
		switch (extension) {
		//metamodel
		case "xsd":
			xsdReferencesToObjectProperties(parent);
			break;
			
		//model
		case "xml":
			xmlReferencesToObjectProperties(parent);
			break;

		default:
			xmlReferencesToObjectProperties(parent);
			break;
	}
	}

	private void xmlReferencesToObjectProperties(SemanticNode parent) {
		if(parent.getTrace() != null && parent.getTrace() instanceof EObject){
			EObject eobject = (EObject) parent.getTrace();
			
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
						Object eReferenceValue = eobject.eGet(eReference);
						
						/*if(eReferenceValue instanceof EObject[]){
							for(EObject reference : (EObject[]) eReferenceValue){
								SemanticNode range = correspondance.get(reference);
								
								ObjectProperty objectProperty = 
										createObjectProperty(
												descriptor, //descriptor
												range //value
										);
								
								addObjectPropertyToNode(parent, objectProperty);
							}
						}*/
						if(eReferenceValue instanceof EList){							
							for(Object reference : (EList) eReferenceValue){
								if (reference instanceof EObject) {
									EObject referenceObject = (EObject) reference;
									
									SemanticNode range = correspondance.get(referenceObject);
									
									ObjectProperty objectProperty = 
											createObjectProperty(
													reference, // trace
													"", // name
													descriptor, //descriptor
													range //value
											);
									
									addObjectPropertyToNode(parent, objectProperty);	
								}		
							}
						}
						else{
							if(eReferenceValue instanceof EObject){
								SemanticNode range = correspondance.get(eReferenceValue);
								
								ObjectProperty objectProperty = 
										createObjectProperty(
												eReferenceValue, // trace
												"", // name
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

	private void xsdReferencesToObjectProperties(SemanticNode parent) {
		if(parent.getTrace() != null && parent.getTrace() instanceof EClass){
			EClass eClass = (EClass) parent.getTrace();
			
			for(EReference reference : eClass.getEAllReferences()){
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

	@Override
	public void toSuper(SemanticNode parent) {
		switch (extension) {
			//metamodel
			case "xsd":
				xsdSuperToSemanticNodes(parent);
				break;
	
			default:
				break;
		}
	}
	
	private void xsdSuperToSemanticNodes(SemanticNode parent) {
		if(parent.getTrace() != null && parent.getTrace() instanceof EClass){
			EClass eClass = (EClass) parent.getTrace();
			
			for(EClass superclass : eClass.getESuperTypes()){
				SemanticNode range = semanticNodeFromName(semanticResource, superclass.getName());
				addSuperClassToNode(parent, range);
			}
		}
	}

}
