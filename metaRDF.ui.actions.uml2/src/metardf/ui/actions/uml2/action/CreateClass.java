package metardf.ui.actions.uml2.action;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import metaRDF.core.model.ISemanticElement;
import metardf.ui.extensions.ExtremoViewPartAction;
import metardf.ui.views.entities.model.TreeObject;

public class CreateClass extends ExtremoViewPartAction {
	private static File outputDir;
	
	@Override
	public void execute(ISelection selection) {
		if(selection instanceof TreeSelection){
			TreeSelection treeSelection = (TreeSelection) selection;
			//ISubEditor subEditor = EclipsePartUtils.getActiveSubEditor();
			TreePath[] treePaths = ((TreeSelection) selection).getPaths();
			for(TreePath treePath : treePaths){
				//treePath.get
				System.out.println("path count " + treePath.getSegmentCount() + " treepath:: " + treePath.toString());
			}
			/* for each selected item, ask the editor to expand it. */
			for (Iterator<?> iter = treeSelection.iterator(); iter.hasNext();) {
				Object node = (Object) iter.next();
				System.out.println("el nodo es:: " + node);
				//subEditor.expandSubtree(node);
			}
			
			/* for now, return code is always null */
			
			
			Object object = treeSelection.getFirstElement();
			if (object != null){
				System.out.println("object: " + object.toString() + " la clase: " + object.getClass());
				if(object instanceof TreeObject){
					TreeObject treeObject = (TreeObject) object;
					ISemanticElement semanticElement = treeObject.getSemanticElement();

					IPath path = getCurrentEditorPath();
					        
					if (path != null){
						ResourceSet resourceSet = new ResourceSetImpl();
						
						org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createFileURI(path.toOSString());
						Resource resource = resourceSet.getResource(uri, true);
						
						UMLResourcesUtil.init(resourceSet);
						EObject eobject = resource.getContents().get(0); // get model
						if(eobject instanceof Model){
							org.eclipse.uml2.uml.Class supplierClass = createClass((Model)eobject,
									semanticElement.getName(), false);
							saveResource(resource);
						}
					}
				}
			}
		}
	}
	
	protected static Model createModel(String name) {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(name);
		return model;
	}
	
	protected static org.eclipse.uml2.uml.Class createClass(
			org.eclipse.uml2.uml.Package package_, String name,
			boolean isAbstract) {

		org.eclipse.uml2.uml.Class class_ = package_.createOwnedClass(name,
			isAbstract);

		return class_;
	}
	
	protected static void save(org.eclipse.uml2.uml.Package package_, URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet);
		
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(package_);

		try {
			resource.save(null);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
	
	protected static void saveResource(Resource resource) {
		try {
			resource.save(null);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
}
