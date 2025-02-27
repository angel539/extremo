/*******************************************************************************
 * Copyright (c) 2018 Universidad Autónoma de Madrid (Spain).
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 3.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-3.0
 *
 * Contributors:
 * 				Ángel Mora Segura - implementation
 * 				Patrick Neubauer  - implementation
 ******************************************************************************/
package uam.extremo.extensions.assistants;

import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import at.ac.tuwien.big.xmltext.generator.MultiEcoreToGenericEcoreTransformer;
import semanticmanager.impl.ExtensibleFormatAssistantImpl;
import semanticmanager.Constraint;
import semanticmanager.ConstraintInterpreter;
import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.SemanticNode;
import semanticmanager.Type;

/**
 * @author pneubaue
 */
public class XsdAssistant extends ExtensibleFormatAssistantImpl {
	File file;
	semanticmanager.Resource semanticResource = null;
	TreeIterator<EObject> modelAll = null;
	
	String extension;
	
	Map<EObject, SemanticNode> correspondance = new HashMap<EObject, SemanticNode>();
	ResourceSet resourceSet = new ResourceSetImpl(); 
	
	MultiEcoreToGenericEcoreTransformer transformer = new MultiEcoreToGenericEcoreTransformer();

	semanticmanager.Resource lastResource = null;
	
	Map<String, Constraint> constraints = new HashMap<String, Constraint>();
	
	private static String OCLUri = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
	ConstraintInterpreter constraintInterpreter = null;
	
	@Override
	public boolean loadAndValidate(semanticmanager.Resource semanticResource, ConstraintInterpreter constraintInterpreter) {
		boolean isImmediateRedo = semanticResource == lastResource;
		this.semanticResource = semanticResource;	
		lastResource = semanticResource;
		
		this.constraintInterpreter = constraintInterpreter;
		
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
					transformer = new MultiEcoreToGenericEcoreTransformer();
					transformer.addXsdEcore(file.getAbsolutePath());
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
		
		if(modelAll != null){
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
									(semanticmanager.Resource) semanticResource.getDescriptors().get(semanticResource.getDescriptors().size() - 1), 
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
					guardSemanticNode(semanticResource, semanticNode);
					correspondance.put(obj, semanticNode);
				}
			}
		}	
	}

	private void xsdElementsToSemanticNodes() {
		// Load XML Schema file via XMLText and transform it to Ecore Metamodel
		List<Resource> genericEcoreResourceList = transformer.getResult();
		for (Resource sRes: genericEcoreResourceList) {
			modelAll = sRes.getAllContents();

			if(modelAll != null){
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
						
						EClass eClass = (EClass) obj;
						String name = eClass.getName();
						
						SemanticNode semanticNode = 
								createSemanticNodeWithoutDescriptor(
										obj, //original object as id
										name, 
										name,
										eClass.isAbstract()); // the name is used as a description label too
											
						addSemanticNodeToResource(semanticResource, semanticNode);
						guardSemanticNode(semanticResource, semanticNode);
						// Constraints
						for(EAnnotation annotation : eClass.getEAnnotations()){
							if(annotation.getSource().equals(OCLUri)){
								for(Entry<String, String> entry : annotation.getDetails().entrySet()){
									if(! constraints.containsKey(entry.getKey())){
										Constraint constraint = createConstraint(
												"OCL", 
												entry.getKey(), 
												entry.getValue().trim()
										);
										addConstraintToElement(semanticNode, constraint);
										constraints.put(entry.getKey(), constraint);
									}
								}
							}
						}
					}
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
									(SemanticNode) parent.getDescriptors().get(parent.getDescriptors().size() - 1),
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
					
					// Constraints
					for(EAnnotation annotation : attr.getEAnnotations()){
						if(annotation.getSource().equals(OCLUri)){
							for(Entry<String, String> entry : annotation.getDetails().entrySet()){
								if(! constraints.containsKey(entry.getKey())){
									Constraint constraint = createConstraint(
											"OCL", 
											entry.getKey(), 
											entry.getValue().trim()
									);
									addConstraintToElement(dataProperty, constraint);
									constraints.put(entry.getKey(), constraint);
								}
							}
						}										
					}
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
									(SemanticNode) parent.getDescriptors().get(parent.getDescriptors().size() - 1),
									eReference.getName()
							);
					
					if(descriptor != null){
						Object eReferenceValue = eobject.eGet(eReference);
						
						if(eReferenceValue instanceof EObject[]){
							for(EObject reference : (EObject[]) eReferenceValue){
								SemanticNode range = correspondance.get(reference);
								
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
				SemanticNode range = searchSemanticNodeByName(semanticResource, reference.getEReferenceType().getName());
				
				if(range != null){
					SemanticNode rangeSemanticNode = (SemanticNode) range;
					
					ObjectProperty objectProperty = 
							createObjectProperty(
									reference, 
									reference.getName(), 
									reference.getLowerBound(), 
									reference.getUpperBound(), 
									rangeSemanticNode);
					
					addObjectPropertyToNode(parent, objectProperty);
					
					// Constraints
					for(EAnnotation annotation : reference.getEAnnotations()){
						if(annotation.getSource().equals(OCLUri)){
							for(Entry<String, String> entry : annotation.getDetails().entrySet()){
								if(! constraints.containsKey(entry.getKey())){
									Constraint constraint = createConstraint(
											"OCL", 
											entry.getKey(), 
											entry.getValue().trim()
									);
									addConstraintToElement(objectProperty, constraint);
									constraints.put(entry.getKey(), constraint);
								}
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
				SemanticNode range = searchSemanticNodeByName(semanticResource, superclass.getName());
				
				if(range != null){
					SemanticNode semanticNodeRange = (SemanticNode) range;
					addSuperClassToNode(parent, semanticNodeRange);
				}
			}
		}
	}

	@Override
	public void toSuper(DataProperty parent) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void toSuper(ObjectProperty parent) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void toInverseOf(ObjectProperty parent) {
		// TODO Auto-generated method stub	
	}
}
