package uam.extremo.ui.wizards.semanticselector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IViewSite;

import semanticmanager.RepositoryManager;

public class EntityGroupSelectorViewContentProvider implements IStructuredContentProvider, ITreeContentProvider {	
	//private TreeParent invisibleRoot;
		private IViewSite iViewSite;
		private RepositoryManager repositoryManager;

		public EntityGroupSelectorViewContentProvider(RepositoryManager repositoryManager, IViewSite iViewSite) {
			super();
			this.repositoryManager = repositoryManager;
			this.iViewSite = iViewSite;
		}

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
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
				return ((EObject)parent).eContents().toArray();
			}
			return new Object[0];
		}
		
		public boolean hasChildren(Object parent) {
			if (parent instanceof EObject){
				if(((EObject) parent).eContents() == null || ((EObject) parent).eContents().size() == 0){
					return false;
				}
				else{
					return true;
				}
			}
			return false;
		}
		
		/*private void initialize() {
			invisibleRoot = new TreeParent("");
		}*/
}