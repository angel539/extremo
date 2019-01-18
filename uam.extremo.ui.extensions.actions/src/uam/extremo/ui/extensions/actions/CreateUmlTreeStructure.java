package uam.extremo.ui.extensions.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Property;
import semanticmanager.ResourceElement;
import semanticmanager.SemanticNode;
import uam.extremo.ui.extensions.integration.ExtensibleViewPartActionContribution;

public class CreateUmlTreeStructure extends ExtensibleViewPartActionContribution {
	@Override
	public void execute(IEditorPart editorPart, ISelection selection, String editorID) {
		if(selection instanceof TreeSelection){
			IEditorInput editorInput = editorPart == null ? null : editorPart.getEditorInput();
			
			if ((selection != null) && (editorInput != null)){
		        if (selection instanceof IStructuredSelection) {
		            if (selection instanceof ITreeSelection) {
		                TreeSelection treeSelection = (TreeSelection) selection;
		                Object object = treeSelection.getFirstElement();
		                
		                if((object instanceof NamedElement) && 
		                		(((NamedElement) object).getDescriptors().isEmpty())){
			                IPath path = editorInput instanceof FileEditorInput 
							        ? ((FileEditorInput) editorInput).getPath()
									        : null;
							        
							if(path != null){
								ResourceSet resourceSet = new ResourceSetImpl();
								org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createFileURI(path.toOSString());
								resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap(). put( "uml", new XMIResourceFactoryImpl());																
								
								EObject mainPackage = null;
								Resource resource = resourceSet.getResource(uri, true);
								if(resource != null){
									mainPackage = resource.getContents().get(0);
								}
								else{
									resource = resourceSet.createResource(uri);
								}
								
								if(object instanceof semanticmanager.Resource){
									semanticmanager.Resource semanticResource = (semanticmanager.Resource) object;
									
									org.eclipse.uml2.uml.Package newPackage = null;
									if((mainPackage != null) && (mainPackage instanceof org.eclipse.uml2.uml.Package)){
										newPackage = (org.eclipse.uml2.uml.Package) mainPackage;
									}
									else{
									    newPackage = createPackage(semanticResource.getName(), "http://" + semanticResource.getName());
									}
									
									Map<semanticmanager.Type, PrimitiveType> primitiveTypes = createPrimitiveTypes(newPackage);
								    Map<SemanticNode, org.eclipse.uml2.uml.Class> relation = new HashMap<SemanticNode, org.eclipse.uml2.uml.Class>();
								    
									for(ResourceElement resourceElement : semanticResource.getResourceElements()){
										if(resourceElement instanceof SemanticNode){
											SemanticNode semanticNode = (SemanticNode) resourceElement;
											
											org.eclipse.uml2.uml.Class eClassNew = createClass(newPackage,
													semanticNode);
										    relation.put(semanticNode, eClassNew);
										       
											for(Property property : semanticNode.getProperties()){
												if(property instanceof DataProperty){
													createAttribute(newPackage, eClassNew, (DataProperty) property, primitiveTypes.get(((DataProperty) property).getType()));
												}
											}
										}
									}
									
									for(ResourceElement resourceElement : semanticResource.getResourceElements()){
										
										if (resourceElement instanceof SemanticNode) {
											SemanticNode semanticNode = (SemanticNode) resourceElement;
											
											org.eclipse.uml2.uml.Class eClassSource = relation.get(semanticNode);
											
											for(Property property : semanticNode.getProperties()){
												if(property instanceof ObjectProperty){
													ObjectProperty objectProperty = (ObjectProperty) property;
													org.eclipse.uml2.uml.Class eClassTarget = relation.get(objectProperty.getRange());
													
													if(eClassTarget != null){
														createAssociation(eClassSource, (ObjectProperty) property, eClassTarget);
													}
												}
											}
										}
									}
									resource.getContents().add(newPackage);
								}	
									
								if(object instanceof semanticmanager.SemanticNode){
									semanticmanager.SemanticNode semanticNode = (semanticmanager.SemanticNode) object;
									
									org.eclipse.uml2.uml.Package newPackage = null;
									if((mainPackage != null) && (mainPackage instanceof EPackage)){
										newPackage = (org.eclipse.uml2.uml.Package) mainPackage;
									}
									else{
									    newPackage = createPackage(semanticNode.getResourceFrom().getName(), "http://" + semanticNode.getResourceFrom().getName());
									}
								    
									Map<semanticmanager.Type, PrimitiveType> primitiveTypes = createPrimitiveTypes(newPackage);
									org.eclipse.uml2.uml.Class eClassNew = createClass(newPackage,
											semanticNode);
								       
									for(Property property : semanticNode.getProperties()){
										if(property instanceof DataProperty){
											createAttribute(newPackage, eClassNew, (DataProperty) property, primitiveTypes.get(((DataProperty) property).getType()));
										}
									}
								    
									resource.getContents().add(newPackage);
								}
									
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
	}
	
	private void createAssociation(Class eClassSource, ObjectProperty property, Class eClassTarget) {
		Association association = eClassSource.createAssociation(
				true, 
				AggregationKind.COMPOSITE_LITERAL, 
				eClassSource.getName() + "_" + property.getName(), 
				1, 
				1, 
				eClassTarget, 
				true, 
				AggregationKind.NONE_LITERAL, 
				eClassTarget.getName() + "_" + property.getName(), 
				property.getLowerBound(), property.getUpperBound()
		);
	}

	protected static Map<semanticmanager.Type, PrimitiveType> createPrimitiveTypes(org.eclipse.uml2.uml.Package package_){
		Map<semanticmanager.Type, PrimitiveType> primitiveTypes = new HashMap<semanticmanager.Type, PrimitiveType>();
		
		PrimitiveType booleanType = (PrimitiveType) package_.createOwnedPrimitiveType(semanticmanager.Type.BOOLEAN.getLiteral());
		primitiveTypes.put(semanticmanager.Type.BOOLEAN, booleanType);
		
		PrimitiveType stringType = (PrimitiveType) package_.createOwnedPrimitiveType(semanticmanager.Type.STRING.getLiteral());
		primitiveTypes.put(semanticmanager.Type.STRING, stringType);
		
		PrimitiveType intType = (PrimitiveType) package_.createOwnedPrimitiveType(semanticmanager.Type.INT.getLiteral());
		primitiveTypes.put(semanticmanager.Type.INT, intType);
		
		PrimitiveType floatType = (PrimitiveType) package_.createOwnedPrimitiveType(semanticmanager.Type.FLOAT.getLiteral());
		primitiveTypes.put(semanticmanager.Type.FLOAT, floatType);
		
		PrimitiveType doubleType = (PrimitiveType) package_.createOwnedPrimitiveType(semanticmanager.Type.DOUBLE.getLiteral());
		primitiveTypes.put(semanticmanager.Type.DOUBLE, doubleType);
		
		return primitiveTypes;
	}
	
	private org.eclipse.uml2.uml.Package createPackage(final String name, final String uri){
		final org.eclipse.uml2.uml.Package epackage = UMLFactory.eINSTANCE.createPackage();
		epackage.setName(name);
		epackage.setURI(uri);
		return epackage;
	}
	
	protected static org.eclipse.uml2.uml.Class createClass(
			org.eclipse.uml2.uml.Package package_, SemanticNode semanticNode) {		
		org.eclipse.uml2.uml.Class class_ = package_.createOwnedClass(semanticNode.getName(), semanticNode.isAbstract());
		return class_;
	}
	
	protected static void createAttribute(org.eclipse.uml2.uml.Package package_,
			org.eclipse.uml2.uml.Class class_, DataProperty dataProperty, Type type) {
		class_.createOwnedAttribute(dataProperty.getName(), type, dataProperty.getLowerBound(), dataProperty.getUpperBound());		
	}
	
	protected static void saveResource(Resource resource) {
		try {
			resource.save(null);
		}
		catch (IOException ioe) {
			MessageDialog.openError(null, "Saving resource", ioe.getMessage());
		}
	}
}