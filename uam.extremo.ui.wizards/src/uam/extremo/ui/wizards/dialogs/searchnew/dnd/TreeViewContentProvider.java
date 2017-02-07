package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import semanticmanager.Resource;

public class TreeViewContentProvider implements IStructuredContentProvider, ITreeContentProvider {	
	private List<Resource> resources;

	public TreeViewContentProvider(List<Resource> resources) {
		super();
		this.resources = resources;
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}
	
	public Object[] getElements(Object parent) {
		if (parent.equals(resources)) {
			Resource[] resourcesArray = new Resource[resources.size()];
			resourcesArray = resources.toArray(resourcesArray);
			return resourcesArray;
		}
		
		return getChildren(parent);
	}

	public Object getParent(Object child) {
		if (child instanceof EObject) {
			return ((EObject)child).eContainer();
		}
		return null;
	}
	
	public Object [] getChildren(Object parent) {
		if (parent instanceof EObject) {
			Object[] containmentAll = ArrayUtils.addAll(((EObject)parent).eContents().toArray(), ((EObject)parent).eCrossReferences().toArray());
			return containmentAll;
		}
		return new Object[0];
	}
	
	public boolean hasChildren(Object parent) {
		if (parent instanceof EObject){
			if((((EObject) parent).eContents() == null || ((EObject) parent).eContents().size() == 0) && (((EObject) parent).eCrossReferences() == null || ((EObject) parent).eCrossReferences().size() == 0)){
				return false;
			}
			else{
				return true;
			}
		}
		return false;
	}
}