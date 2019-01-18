package uam.extremo.ui.extensions.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Property;
import semanticmanager.Resource;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import uam.extremo.ui.extensions.integration.ExtensibleViewPartActionContribution;

public class CreateEcoreTreeStructure extends ExtensibleViewPartActionContribution {
	Map<SemanticNode, EClass> mapping = new HashMap<SemanticNode, EClass>();
	
	@Override
	public void execute(IEditorPart editorPart, ISelection selection, String editorID) {
		if(selection instanceof TreeSelection){
			IEditorInput editorInput = editorPart == null ? null : editorPart.getEditorInput();
			
			if ((selection != null) && (editorInput != null)){
				if (selection instanceof IStructuredSelection) {
					if (selection instanceof ITreeSelection) {
		                TreeSelection treeSelection = (TreeSelection) selection;
		                
		                IPath path = editorInput instanceof FileEditorInput 
						        ? ((FileEditorInput) editorInput).getPath()
								        : null;
						        
						if(path != null){
							ResourceSet resourceSet = new ResourceSetImpl();
							
							org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createFileURI(path.toOSString());
							resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap(). put( "ecore", new XMIResourceFactoryImpl());
							
							EObject mainPackage = null;
							org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(uri, true);
							if(resource != null){
								mainPackage = resource.getContents().get(0);
							}
							else{
								resource = resourceSet.createResource(uri);
							}
							
							final EObject mainPackageFinal = mainPackage;
							final org.eclipse.emf.ecore.resource.Resource targetResource = resource; 
							
							Iterator<Object> iterator = treeSelection.iterator();
			                List<SemanticNode> enumeration = new ArrayList<SemanticNode>();
			                
							iterator.forEachRemaining(
			                	e -> {
			                		if(e instanceof Resource){
			                			resource2Package(targetResource, (Resource) e);
			                		}
			                		if(e instanceof SemanticGroup){
			                			semanticGroup2Package(targetResource, (SemanticGroup) e);
			                		}
			                		if ((e instanceof SemanticNode) 
			                				&& !((SemanticNode) e).getDescriptors().isEmpty() 
			                				&& ((SemanticNode) e).getDescribes().isEmpty() && ((SemanticNode) e).getProperties().isEmpty()){
			                			enumeration.add((SemanticNode) e);
			                		}else if(e instanceof SemanticNode){
			                			EClass eClassNew = semanticNode2Class(mainPackageFinal, (SemanticNode) e);
			                			if(eClassNew != null)
			                				mapping.put((SemanticNode) e, eClassNew);
			                		}
			                		
			                		if(e instanceof DataProperty){
			                			EClass container = mapping.get(((DataProperty) e).getSemanticNodeFrom());
			                			if(container != null){
			                				createEAttribute(
			                						container, (DataProperty) e);
			                			}
			                			else{
			                				EClass eClassNew = semanticNode2Class(mainPackageFinal, ((DataProperty) e).getSemanticNodeFrom());
			                				mapping.put(((DataProperty) e).getSemanticNodeFrom(), eClassNew);
			                			}
			                		}
			                		if(e instanceof ObjectProperty){
			                			EClass container = mapping.get(((ObjectProperty) e).getSemanticNodeFrom());
			                			if(container == null){
			                				EClass eClassNew = semanticNode2Class(mainPackageFinal, ((ObjectProperty) e).getSemanticNodeFrom());
			                				mapping.put(((ObjectProperty) e).getSemanticNodeFrom(), eClassNew);
			                			}
			                		}
			                	}
			                );
			                
			                objectProperty2EReference();
			                supers2ESuperClass();
			                instances2Enumeration(mainPackageFinal, enumeration);
			             
			                saveResource(resource);
							editorPart.isDirty();
							
							IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
							activePage.closeEditor(editorPart, false);
							
							try {
								activePage.openEditor(editorInput, editorID);
							}
							catch (PartInitException e) {
								MessageDialog.openError(null, "Ecore Tree Structure", e.getMessage());
							}
						}
		            }
		        }
		    }			
		}
	}
	
	private void resource2Package(org.eclipse.emf.ecore.resource.Resource targetResource, Resource resource) {
		final EPackage newPackage = createPackage(resource.getName(), resource.getName(), "http://" + resource.getName());
		resource.eAllContents().forEachRemaining(
				e -> {
					if(e instanceof Resource){
						resource2Package(targetResource, (Resource) e);
						
					}
					if(e instanceof SemanticNode){
						semanticNode2Class(newPackage, (SemanticNode) e);
					}
				}
		);
		
		EPackage mainPackage = (EPackage) targetResource.getContents().stream().filter(e -> e instanceof EPackage).findFirst().get();
		if(mainPackage != null) mainPackage.getESubpackages().add(newPackage);
	}
	
	private void semanticGroup2Package(org.eclipse.emf.ecore.resource.Resource targetResource, SemanticGroup semanticGroup) {
		final EPackage newPackage = createPackage(semanticGroup.getName(), semanticGroup.getName(), "http://" + semanticGroup.getName());
		semanticGroup.getElements().forEach(
				e -> {
					if(e instanceof Resource){
						resource2Package(targetResource, (Resource) e);
						
					}
					if(e instanceof SemanticNode){
						EClass eClassNew = semanticNode2Class(newPackage, (SemanticNode) e);
						if(eClassNew != null)
            				mapping.put((SemanticNode) e, eClassNew);
					}
				}
		);
		
		EPackage mainPackage = (EPackage) targetResource.getContents().stream().filter(e -> e instanceof EPackage).findFirst().get();
		if(mainPackage != null) mainPackage.getESubpackages().add(newPackage);
	}
	
	private EClass semanticNode2Class(EObject container, SemanticNode semanticNode) {
		if(container instanceof EPackage){
			EClass eClassNew = createEClass((EPackage) container,
					semanticNode);
			for(Property property : semanticNode.getProperties()){
				if(property instanceof DataProperty){
					createEAttribute(eClassNew, (DataProperty) property);
				}
			}

			((EPackage) container).getEClassifiers().add(eClassNew);
			return eClassNew;
		}
		
		return null;
	}

	private void supers2ESuperClass(){			
		Set<Entry<SemanticNode, EClass>> entrySet = mapping.entrySet();
		Map<SemanticNode, EClass> temporal = new HashMap<SemanticNode, EClass>();
		
		for(Entry<SemanticNode, EClass> entry : entrySet){
			SemanticNode semanticNode = entry.getKey();
			semanticNode.getSupers().stream().
				forEach(
					superSemanticNode -> {
						EClass mappingSuperSemanticNode = mapping.get(superSemanticNode);
						if(mappingSuperSemanticNode != null){
							createESuperClassReference(
    									entry.getValue(), mappingSuperSemanticNode);
						}
						else{
							EClass inTemporal = temporal.get(superSemanticNode);
							if(inTemporal != null){
								createESuperClassReference(
    									entry.getValue(), inTemporal);
							}
							else{
								EClass newClass = semanticNode2Class(entry.getValue().getEPackage(), (SemanticNode) superSemanticNode);
								temporal.put((SemanticNode) superSemanticNode, newClass);
								if(newClass != null)
											createESuperClassReference(
													entry.getValue(), newClass);
							}
						}
					}
				);
		}
		
		mapping.putAll(temporal);
	}
	
	private void objectProperty2EReference(){
		Set<Entry<SemanticNode, EClass>> entrySet = mapping.entrySet();
		Map<SemanticNode, EClass> temporal = new HashMap<SemanticNode, EClass>();
		
		for(Entry<SemanticNode, EClass> entry : entrySet){
			SemanticNode semanticNode = entry.getKey();
			semanticNode.getProperties().stream().
				forEach(
					property -> {
						if(property instanceof ObjectProperty){
							SemanticNode range = ((ObjectProperty) property).getRange();
							EClass mappingRange = mapping.get(range);
							if(mappingRange != null){
								createEReference(
    									entry.getValue(), (ObjectProperty) property, mappingRange);
							}
							else{
								EClass inTemporal = temporal.get(range);
								if(inTemporal != null){
									createEReference(
	    									entry.getValue(), (ObjectProperty) property, inTemporal);
								}
								else{
									EClass newClass = semanticNode2Class(entry.getValue().getEPackage(), range);
									temporal.put((SemanticNode) range, newClass);
									if(newClass != null)
										createEReference(
											entry.getValue(), (ObjectProperty) property, newClass);
								}	
							}
						}
					}
				);
		}
		
		mapping.putAll(temporal);
	}
	
	private void instances2Enumeration(EObject mainPackageFinal, List<SemanticNode> instances){
		if(mainPackageFinal instanceof EPackage){
			Map<EList<NamedElement>, List<SemanticNode>> enumerations = 
					instances.stream().collect(Collectors.groupingBy(SemanticNode::getDescriptors));
			
			Set<Entry<EList<NamedElement>, List<SemanticNode>>> entrySet = enumerations.entrySet();
			
			for(Entry<EList<NamedElement>, List<SemanticNode>> entry : entrySet){
				String name = "";
				
				entry.getKey().forEach(e -> name.concat(e.getName()));
				createEnumeration(
						(EPackage) mainPackageFinal, name, entry.getValue());
			}
		}
	}
	
	protected static EEnum createEnumeration(
			org.eclipse.emf.ecore.EPackage package_, String name, List<SemanticNode> instances) {
		EEnum eEnumeration = EcoreFactory.eINSTANCE.createEEnum();
		eEnumeration.setName(name);
		
		for(int i = 0; i < instances.size(); i++){
			EEnumLiteral eEnumerationLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
			eEnumerationLiteral.setName(instances.get(i).getName());
			eEnumerationLiteral.setLiteral(instances.get(i).getName());
			eEnumerationLiteral.setValue(i);
			eEnumeration.getELiterals().add(eEnumerationLiteral);
		}
		
		package_.getEClassifiers().add(eEnumeration);
		return eEnumeration;
	}
	
	protected static org.eclipse.emf.ecore.EClass createEClass(
			org.eclipse.emf.ecore.EPackage package_, SemanticNode semanticNode) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(semanticNode.getName());
		eClass.setAbstract(semanticNode.isAbstract());
		package_.getEClassifiers().add(eClass);
		return eClass;
	}
	
	protected static void createEAttribute(
			org.eclipse.emf.ecore.EClass eclass_, DataProperty dataProperty) {
		final EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		eclass_.getEStructuralFeatures().add(eAttribute);
		
		eAttribute.setName(dataProperty.getName());
		eAttribute.setLowerBound(dataProperty.getLowerBound());
		eAttribute.setUpperBound(dataProperty.getUpperBound());
		
		switch(dataProperty.getType().getLiteral()){
			case "String":
				eAttribute.setEType(EcorePackage.Literals.ESTRING);
				break;
				
			case "Int":
				eAttribute.setEType(EcorePackage.Literals.EINT);
				break;
			
			case "Boolean":
				eAttribute.setEType(EcorePackage.Literals.EBOOLEAN);
				break;
			
			case "Float":
				eAttribute.setEType(EcorePackage.Literals.EFLOAT);
				break;
			
			case "Double":
				eAttribute.setEType(EcorePackage.Literals.EDOUBLE);
				break;
			
			default:
				break;
		}
	}
	
	
	
	protected static void createESuperClassReference(
				org.eclipse.emf.ecore.EClass source, org.eclipse.emf.ecore.EClass target) {
		source.getESuperTypes().add(target);
	}
	
	protected static void createEReference(
			org.eclipse.emf.ecore.EClass source, ObjectProperty objectProperty, org.eclipse.emf.ecore.EClass target) {
		final EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		source.getEStructuralFeatures().add(eReference);
	
		eReference.setName(objectProperty.getName());
		eReference.setEType(target);
		eReference.setLowerBound(objectProperty.getLowerBound());
		eReference.setUpperBound(objectProperty.getUpperBound());
	}
	
	private EPackage createPackage(final String name, final String prefix,
	           final String uri){
		final EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName(name);
		epackage.setNsPrefix(prefix);
		epackage.setNsURI(uri);
		return epackage;
	}
	
	protected static void saveResource(org.eclipse.emf.ecore.resource.Resource resource) {
		try {
			resource.save(null);
		}
		catch (IOException ioe) {
			MessageDialog.openError(null, "Creating Ecore Tree Structure", ioe.getMessage());
		}
	}
}