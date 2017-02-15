package uam.extremo.ui.views.constraints;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import semanticmanager.RepositoryManager;

public class ConstraintValidationViewAdapterFactoryContentProvider extends AdapterFactoryContentProvider {	
	private RepositoryManager repositoryManager;
	private TreeViewer viewer;

	public ConstraintValidationViewAdapterFactoryContentProvider(TreeViewer viewer, AdapterFactory adapterFactory) {
		super(adapterFactory);
		this.setViewer(viewer);
	}
	
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		this.setViewer((TreeViewer) v);
		
		if (repositoryManager != null)
			repositoryManager = (RepositoryManager) newInput;
	}

	public void dispose() {
	}
	
	public Object[] getElements(Object parent) {
		if (parent.equals(repositoryManager)) {
			return getChildren(repositoryManager);
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

	public TreeViewer getViewer() {
		return viewer;
	}

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}
}