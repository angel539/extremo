package uam.extremo.ui.views.actions.ecore.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
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

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Property;
import semanticmanager.ResourceElement;
import semanticmanager.SemanticNode;
import uam.extremo.ui.views.extensions.actions.ExtensibleViewPartActionContribution;

public class CreateEcoreTreeStructure extends ExtensibleViewPartActionContribution {
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
		                		(((NamedElement)object).getDescriptors().isEmpty())){
			                IPath path = editorInput instanceof FileEditorInput 
							        ? ((FileEditorInput) editorInput).getPath()
									        : null;
							        
							if(path != null){
								ResourceSet resourceSet = new ResourceSetImpl();
								
								org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createFileURI(path.toOSString());
								resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap(). put( "ecore", new XMIResourceFactoryImpl());
								
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
									
									EPackage newPackage = null;
									if((mainPackage != null) && (mainPackage instanceof EPackage)){
										newPackage = (EPackage) mainPackage;
									}
									else{
									    newPackage = createPackage(semanticResource.getName(), semanticResource.getName(), "http://" + semanticResource.getName());
									}
									
								    Map<SemanticNode, EClass> relation = new HashMap<SemanticNode, EClass>();
								    
									for(ResourceElement resourceElement : semanticResource.getResourceElements()){
										if(resourceElement instanceof SemanticNode){
											SemanticNode semanticNode = (SemanticNode) resourceElement;
											EClass eClassNew = createEClass(newPackage,
													semanticNode);
											newPackage.getEClassifiers().add(eClassNew);
										    relation.put(semanticNode, eClassNew);
										       
											for(Property property : semanticNode.getProperties()){
												if(property instanceof DataProperty){
													createEAttribute(eClassNew, (DataProperty) property);
												}
											}
										}					
									}
									
									for(ResourceElement resourceElement : semanticResource.getResourceElements()){
										if (resourceElement instanceof SemanticNode) {
											SemanticNode semanticNode = (SemanticNode) resourceElement;
											
											EClass eClassSource = relation.get(semanticNode);
											for(Property property : semanticNode.getProperties()){
												if(property instanceof ObjectProperty){
													ObjectProperty objectProperty = (ObjectProperty) property;
													EClass eClassTarget = relation.get(objectProperty.getRange());
													
													if(eClassTarget != null){
														createEReference(eClassSource, (ObjectProperty) property, eClassTarget);
													}
												}
											}		
										}					
									}
									resource.getContents().add(newPackage);
								}	
									
								if(object instanceof semanticmanager.SemanticNode){
									semanticmanager.SemanticNode semanticNode = (semanticmanager.SemanticNode) object;
									
								    EPackage newPackage = null;
									if((mainPackage != null) && (mainPackage instanceof EPackage)){
										newPackage = (EPackage) mainPackage;
									}
									else{
									    newPackage = createPackage(semanticNode.getResourceFrom().getName(), semanticNode.getResourceFrom().getName(), "http://" + semanticNode.getResourceFrom().getName());
									}
								    
								    EClass eClassNew = createEClass(newPackage,
											semanticNode);
								    newPackage.getEClassifiers().add(eClassNew);
								       
									for(Property property : semanticNode.getProperties()){
										if(property instanceof DataProperty){
											createEAttribute(eClassNew, (DataProperty) property);
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
	
	protected static void saveResource(Resource resource) {
		try {
			resource.save(null);
		}
		catch (IOException ioe) {
			MessageDialog.openError(null, "Creating Ecore Tree Structure", ioe.getMessage());
		}
	}
}