package uam.extremo.ui.views.actions.uml2.action;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import semanticmanager.SemanticNode;
import uam.extremo.ui.views.extensions.ExtremoViewPartAction;

public class CreateClass extends ExtremoViewPartAction {
	@Override
	public void execute(IEditorPart editorPart, ISelection selection, String editorID) {
		if(selection instanceof TreeSelection){
			TreeSelection treeSelection = (TreeSelection) selection;
			
			Object object = treeSelection.getFirstElement();
			if (object != null){
				if(object instanceof SemanticNode){
					SemanticNode semanticElement = (SemanticNode) object;
					
					if(semanticElement != null && semanticElement instanceof SemanticNode){
						IEditorInput editorInput = editorPart == null ? null : editorPart.getEditorInput();
						
						IPath path = editorInput instanceof FileEditorInput 
						        ? ((FileEditorInput)editorInput).getPath()
								        : null;
						
						if (path != null){
							ResourceSet resourceSet = new ResourceSetImpl();
							
							org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createFileURI(path.toOSString());
							Resource resource = resourceSet.getResource(uri, true);
							UMLResourcesUtil.init(resourceSet);
							
							EObject eobject = resource.getContents().get(0);
							if(eobject instanceof Model){
								createClass((Model)eobject,
										semanticElement.getName(), false);
								saveResource(resource);
								editorPart.isDirty();
								
								IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
								activePage.closeEditor(editorPart, false);
								
								if(editorID != null){
									try {
										IDE.openEditor(activePage, editorInput, editorID);
									} 
									catch (PartInitException e) {
										MessageDialog.openError(null, "Refresh editor", "Error refreshing the editor");
									}
								}			
							}
						}
					}
				}
			}
		}
	}
	
	protected static org.eclipse.uml2.uml.Class createClass(
			org.eclipse.uml2.uml.Package package_, String name,
			boolean isAbstract) {

		org.eclipse.uml2.uml.Class class_ = package_.createOwnedClass(name, isAbstract);

		return class_;
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