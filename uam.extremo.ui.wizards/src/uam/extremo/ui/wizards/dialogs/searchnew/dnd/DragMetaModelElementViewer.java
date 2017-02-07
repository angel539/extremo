package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import java.util.List;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.Constraint;
import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import uam.extremo.ui.wizards.Activator;

public class DragMetaModelElementViewer extends TreeViewer{
	List<Resource> resources = null;
	IStructuredSelection selection = null;
	
	public void refresh(List<Resource> resources) {
		if(resources != null){
			this.resources = resources;
			setInput(resources);
			refresh();
			expandAll();
		}
	}
	
	public DragMetaModelElementViewer(Composite parent, List<Resource> resources) {
		super(parent);
		this.resources = resources;
		
		int operations = DND.DROP_COPY| DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
		addDragSupport(operations, transferTypes , new NamedElementDragListener(this));
		
		TreeViewFilter filter = new TreeViewFilter();
		ViewerFilter[] filters = {filter};
		setFilters(filters);
		
		setContentProvider(new TreeViewContentProvider(resources));
		setLabelProvider(new DelegatingStyledCellLabelProvider(new TreeViewLabelProvider()));
		
		setInput(resources);
	}
	
	class TreeViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();

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
			
			if(element instanceof Constraint){
				Constraint constraint = (Constraint) element;
				StyledString styledString = new StyledString(constraint.getKey());
				styledString.append(" (" + constraint.getValue().toString() + ")", StyledString.COUNTER_STYLER);

				return styledString;
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
					StyledString styledString = new StyledString(property.getValue());
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
			
			if(element instanceof Constraint) return Activator.getImageDescriptor("icons/constraint.png").createImage();
			
			if(element instanceof ObjectProperty) return Activator.getImageDescriptor("icons/det_pane_right.gif").createImage();
			if(element instanceof DataProperty) return Activator.getImageDescriptor("icons/attribute.png").createImage();
        	
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
}
