package uam.extremo.ui.views.actions.ecore.action;

import java.io.IOException;


import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

import uam.extremo.ui.views.extensions.ExtremoViewPartAction;

import semanticmanager.SemanticNode;

public class CreateClass extends ExtremoViewPartAction {
	public CreateClass() {
	}

	@Override
	public void execute(IEditorPart editorPart, ISelection selection, String editorID) {
		if(selection instanceof TreeSelection){
			TreeSelection treeSelection = (TreeSelection) selection;
			
			if(!treeSelection.isEmpty()){
				TreePath[] paths = treeSelection.getPaths();
				
				for(TreePath path : paths){
					System.out.println(path.toString());
				}
			}
			
			Object object = treeSelection.getFirstElement();
			
			if (object != null){
				if(object instanceof SemanticNode){
					SemanticNode semanticElement = (SemanticNode) object;
					
					if(semanticElement != null){
						IEditorInput editorInput = editorPart == null ? null : editorPart.getEditorInput();
						
						if(editorInput != null){
							IPath path = editorInput instanceof FileEditorInput 
							        ? ((FileEditorInput)editorInput).getPath()
									        : null;
							
							if (path != null){
								ResourceSet resourceSet = new ResourceSetImpl();
								
								org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createFileURI(path.toOSString());
								resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap(). put( "ecore", new XMIResourceFactoryImpl());
								Resource resource = resourceSet.createResource(uri);
								
								EObject eobject = resource.getContents().get(0);
								if(eobject instanceof EPackage){
									createEClass((EPackage)eobject,
											semanticElement.getName(), false);
									saveResource(resource);
									editorPart.isDirty();
									
									IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
									activePage.closeEditor(editorPart, false);
									
									if(editorID != null){
										try {
											IDE.openEditor(activePage, editorInput, editorID);
										} catch (PartInitException e) {
											MessageDialog.openError(null, "Refresh editor", "Error refreshing the editor");										}
									}			
								}
							}
						}
					}
				}
			}
		}
	}
	
	protected static org.eclipse.emf.ecore.EClass createEClass(
			org.eclipse.emf.ecore.EPackage package_, String name,
			boolean isAbstract) {
		
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		eClass.setAbstract(isAbstract);
		
		package_.getEClassifiers().add(eClass);

		return eClass;
	}
	
	protected static void saveResource(Resource resource) {
		try {
			resource.save(null);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
	
	/*TreePath[] treePaths = ((TreeSelection) selection).getPaths();
	for(TreePath treePath : treePaths){
		System.out.println("path count " + treePath.getSegmentCount() + " treepath:: " + treePath.toString());
	}
	for (Iterator<?> iter = treeSelection.iterator(); iter.hasNext();) {
		Object node = (Object) iter.next();
		System.out.println("el nodo es:: " + node);
	}*/
	
	//Resource resource = resourceSet.getResource(uri, true);
	//ResourceUtil.init(resourceSet);
	//ResourceSet set = new ResourceSetImpl();
}