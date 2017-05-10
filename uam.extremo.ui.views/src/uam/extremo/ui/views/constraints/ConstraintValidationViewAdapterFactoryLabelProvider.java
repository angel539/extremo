package uam.extremo.ui.views.constraints;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.*;
import uam.extremo.ui.views.Activator;

public class ConstraintValidationViewAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider implements IStyledLabelProvider{
	public ConstraintValidationViewAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if(obj instanceof ConstraintInterpreter) return Activator.getImageDescriptor("icons/chain.png").createImage();
		
		
		if(obj instanceof Repository) return Activator.getImageDescriptor("icons/repo.png").createImage();
    	
		if(obj instanceof Resource){
			Resource resource = (Resource) obj;
			
			if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
				return Activator.getImageDescriptor("icons/descriptor.png").createImage();
			}
			else{
				if(((Resource) obj).isAlive()) return Activator.getImageDescriptor("icons/description_on.png").createImage();
        		else{
        			return Activator.getImageDescriptor("icons/description.png").createImage();
        		}
			}
    	}
		
		if(obj instanceof Constraint) return Activator.getImageDescriptor("icons/constraint.png").createImage();
		
		if(obj instanceof SemanticNode){
			SemanticNode semanticNode = (SemanticNode) obj;
			
			if((semanticNode.getDescriptors() == null) || (semanticNode.getDescriptors().isEmpty())){
				return Activator.getImageDescriptor("icons/class_obj.png").createImage();
			}
			else{
        		return Activator.getImageDescriptor("icons/object.png").createImage();
			}
    	}
		
		if(obj instanceof Constraint) return Activator.getImageDescriptor("icons/constraint.png").createImage();
		
		if(obj instanceof ObjectProperty) return Activator.getImageDescriptor("icons/det_pane_right.png").createImage();
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
			StyledString styledString = new StyledString("[" + constraint.getType() + "] " + constraint.getName());
			styledString.append("(" + constraint.getBody() + ")", StyledString.COUNTER_STYLER);
			return styledString;
		}
		
		if (element instanceof Resource) {
			StyledString styledString = new StyledString(((Resource) element).getName());
			
			Resource resource = (Resource) element;
			if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
				styledString.append(" describes (" + ((Resource) element).getDescribes().size() + ") resources", StyledString.COUNTER_STYLER);
			}
			
			return styledString;
		}
		
		if(element instanceof SemanticNode){
			SemanticNode semanticNode = (SemanticNode) element;
			
			if((semanticNode.getDescriptors() == null) || (semanticNode.getDescriptors().isEmpty())){
				StyledString styledString = new StyledString(semanticNode.getName());
				
				if(semanticNode.getDescribes().size() > 0)
					styledString.append(" (" + semanticNode.getDescribes().size() + ") descriptions", StyledString.QUALIFIER_STYLER);
				
				if(semanticNode.getProperties().size() > 0)
					styledString.append(" (" + semanticNode.getProperties().size() + ") properties", StyledString.QUALIFIER_STYLER);
				
				styledString.append(" (" + semanticNode.getWeight() + ") pts", StyledString.COUNTER_STYLER);

				return styledString;
			}
			else{
				StyledString styledString = new StyledString(semanticNode.getName() + ":");
				return styledString;
			}
    	}
		
		if(element instanceof DataProperty){
			DataProperty dataProperty = (DataProperty) element;
			
			if((dataProperty.getDescriptors() == null) || (dataProperty.getDescriptors().isEmpty())){
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
