package uam.extremo.ui.wizards.dialogs.searchnew.treeviewer;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import uam.extremo.ui.wizards.Activator;

public class SearchTreeViewer extends TreeViewer{
	public SearchTreeViewer(Composite parent, EObject root) {
		super(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE | SWT.FULL_SELECTION);
		setLabelProvider(new DelegatingStyledCellLabelProvider(new SearchTreeViewerLabelProvider()));
		setContentProvider(new SearchTreeViewerContentProvider(root));
		
		SearchTreeViewerFilter filter = new SearchTreeViewerFilter();
		ViewerFilter[] filters = {filter};
		setFilters(filters);
		
		setInput(root);
	}

	class SearchTreeViewerLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			if (element instanceof Repository) {
				Repository repositoryNode = (Repository) element;
				StyledString styledString = new StyledString(repositoryNode.getName());
				
				if (repositoryNode.getResources() != null) {
					styledString.append(" (" + repositoryNode.getResources().size() + ") ", StyledString.QUALIFIER_STYLER);
				}
				return styledString;
			}
			
			if (element instanceof Resource) {
				StyledString styledString = new StyledString(((Resource) element).getName());
				
				if(((Resource) element).getDescriptor() == null){
					styledString.append(" describes (" + ((Resource) element).getDescribes().size() + ") resources", StyledString.COUNTER_STYLER);
				}
				
				return styledString;
			}
			
			if(element instanceof SemanticNode){
				if(((SemanticNode) element).getDescriptor() == null){
					SemanticNode semanticNode = (SemanticNode) element;
					StyledString styledString = new StyledString(semanticNode.getName());
					
					if(semanticNode.getDescribes().size() > 0)
						styledString.append(" (" + semanticNode.getDescribes().size() + ") descriptions", StyledString.QUALIFIER_STYLER);
					
					if(semanticNode.getProperties().size() > 0)
						styledString.append(" (" + semanticNode.getProperties().size() + ") properties", StyledString.QUALIFIER_STYLER);
					
					styledString.append(" (" + semanticNode.getWeight() + ") pts", StyledString.COUNTER_STYLER);

					return styledString;
				}
				else{
					SemanticNode semanticNode = (SemanticNode) element;
					StyledString styledString = new StyledString(semanticNode.getName() + ":");
					styledString.append(" (" + semanticNode.getDescriptor().getName() + ")", StyledString.QUALIFIER_STYLER);
					return styledString;
				}
	    	}
			
			if(element instanceof DataProperty){
				if(((DataProperty) element).getDescriptor() == null){
					DataProperty property = (DataProperty) element;
					StyledString styledString = new StyledString(property.getName());
					if(property.getType() != null) styledString.append(" (" + property.getType().getLiteral() + ")", StyledString.QUALIFIER_STYLER);
					
					return styledString;
				}
				else{
					DataProperty property = (DataProperty) element;
					StyledString styledString = new StyledString(property.getValue() + ":");
					if(property.getType() != null) styledString.append(" (" + property.getType().getLiteral() + ")", StyledString.QUALIFIER_STYLER);
					
					return styledString;
				}
			}
			
			if(element instanceof ObjectProperty){
				ObjectProperty property = (ObjectProperty) element;
				StyledString styledString = new StyledString(property.getName());
				if(property.getRange() != null) styledString.append(" (" + property.getRange().getName() + ")", StyledString.QUALIFIER_STYLER);

				return styledString;
			}
			
			return null;
		}
		
		@Override
		public Image getImage(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			
			if(element instanceof Repository) return Activator.getImageDescriptor("icons/folder-icon_16.png").createImage();
        	
			if(element instanceof Resource){
				if(((Resource) element).getDescriptor() == null){
					return Activator.getImageDescriptor("icons/schema16.png").createImage();
				}
				else{
					if(((Resource) element).isAlive()) return Activator.getImageDescriptor("icons/3d_objects_16.png").createImage();
	        		else{
	        			return Activator.getImageDescriptor("icons/3d_objects_off_16.png").createImage();
	        		}
				}
        	}
			
			if(element instanceof SemanticNode){
				if(((SemanticNode) element).getDescriptor() == null){
					return Activator.getImageDescriptor("icons/class_obj.png").createImage();
				}
				else{
	        		return Activator.getImageDescriptor("icons/objects16.png").createImage();
				}
	    	}
			
			if(element instanceof ObjectProperty) return Activator.getImageDescriptor("icons/det_pane_right.gif").createImage();
			if(element instanceof DataProperty) return Activator.getImageDescriptor("icons/attribute.png").createImage();
        	
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	
	class SearchTreeViewerContentProvider implements IStructuredContentProvider, ITreeContentProvider {	
		private EObject root;

		public SearchTreeViewerContentProvider(EObject root) {
			super();
			this.root = root;
		}

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}
		
		public Object[] getElements(Object parent) {
			if (parent.equals(root)) {
				return getChildren(root);
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

	class SearchTreeViewerFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return element instanceof RepositoryManager || 
					element instanceof Repository || 
					element instanceof Resource ||
					element instanceof SemanticNode ||
					element instanceof DataProperty ||
					element instanceof ObjectProperty;
		}
	}
}
