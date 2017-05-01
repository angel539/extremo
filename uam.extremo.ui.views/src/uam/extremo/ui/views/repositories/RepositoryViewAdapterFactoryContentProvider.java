package uam.extremo.ui.views.repositories;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

import semanticmanager.RepositoryManager;

public class RepositoryViewAdapterFactoryContentProvider extends AdapterFactoryContentProvider {	
	private RepositoryManager repositoryManager;
	private TreeViewer viewer;

	public RepositoryViewAdapterFactoryContentProvider(TreeViewer viewer, AdapterFactory adapterFactory) {
		super(adapterFactory);
		this.setViewer(viewer);
	}
	
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		this.setViewer((TreeViewer) v);

		if (viewer != null) {
			viewer.getControl().removeDisposeListener(new DisposeListener() {
				@Override
				public void widgetDisposed(DisposeEvent e) {
				}
			});
		}
				
		this.viewer = (TreeViewer) viewer;
		
		if (this.viewer != null) {
			viewer.getControl().addDisposeListener(new DisposeListener() {
				@Override
				public void widgetDisposed(DisposeEvent e) {
					// add your data change listener
				}
			});
		}
		
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
	
	/*public Object [] getChildren(Object parent) {
		if (parent instanceof EObject) {
			EObject parentEObject = (EObject) parent;
			
			Object[] containments = parentEObject.eContents().toArray();
			Object[] crossReferences = parentEObject.eCrossReferences().toArray();
			
			Object[] containmentAll = ArrayUtils.addAll(containments, crossReferences);
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
	}*/

	public TreeViewer getViewer() {
		return viewer;
	}

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}
}