package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import semanticmanager.NamedElement;

public class TreeViewContentProvider implements IStructuredContentProvider, ITreeContentProvider {	
	private List<NamedElement> namedElements;

	public TreeViewContentProvider(List<NamedElement> namedElements) {
		super();
		this.namedElements = namedElements;
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		System.out.println(newInput);
	}

	public void dispose() {
	}
	
	public Object[] getElements(Object parent) {
		if (parent.equals(namedElements)) {
			NamedElement[] resourcesArray = new NamedElement[namedElements.size()];
			resourcesArray = namedElements.toArray(resourcesArray);
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