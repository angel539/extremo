package uam.extremo.ui.views.constraints;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.Constraint;
import semanticmanager.ConstraintInterpreter;
import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import uam.extremo.ui.views.Activator;

public class ConstraintValidationViewAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider implements IStyledLabelProvider{
	public ConstraintValidationViewAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		// TODO Auto-generated constructor stub
	}
	
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if(obj instanceof ConstraintInterpreter) return Activator.getImageDescriptor("icons/chain.png").createImage();
		if(obj instanceof Constraint) return Activator.getImageDescriptor("icons/check.png").createImage();
		
		if(obj instanceof Resource){
			if(((Resource) obj).getDescriptor() == null){
				return Activator.getImageDescriptor("icons/schema16.png").createImage();
			}
			else{
				if(((Resource) obj).isAlive()) return Activator.getImageDescriptor("icons/3d_objects_16.png").createImage();
        		else{
        			return Activator.getImageDescriptor("icons/3d_objects_off_16.png").createImage();
        		}
			}
    	}
		
		if(obj instanceof SemanticNode){
			if(((SemanticNode) obj).getDescriptor() == null){
				return Activator.getImageDescriptor("icons/class_obj.png").createImage();
			}
			else{
        		return Activator.getImageDescriptor("icons/objects16.png").createImage();
			}
    	}
		
		if(obj instanceof ObjectProperty) return Activator.getImageDescriptor("icons/det_pane_right.gif").createImage();
		if(obj instanceof DataProperty) return Activator.getImageDescriptor("icons/attribute.png").createImage();

		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
	
	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if (element instanceof ConstraintInterpreter) {
			ConstraintInterpreter constraintInterpreter = (ConstraintInterpreter) element;
			StyledString styledString = new StyledString(constraintInterpreter.getName());
			return styledString;
		}
		
		if (element instanceof Constraint) {
			Constraint constraint = (Constraint) element;
			StyledString styledString = new StyledString(((Constraint) element).getKey());
			//styledString.append("(" + constraint.getResources().size() + ") resources selected", StyledString.COUNTER_STYLER);
			styledString.append(" -> over (" + constraint.getApplyOnElements().size() + ") nodes applied", StyledString.COUNTER_STYLER);
			styledString.append(" -> (" + constraint.getValidatedElements().size() + ") elements validated", StyledString.COUNTER_STYLER);
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
			SemanticNode semanticNode = (SemanticNode) element;
			StyledString styledString = new StyledString(semanticNode.getName());
			styledString.append(" (" + semanticNode.getWeight() + ") points", StyledString.COUNTER_STYLER);
			styledString.append(" (" + semanticNode.getProperties().size() + ") properties", StyledString.QUALIFIER_STYLER);

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
}
