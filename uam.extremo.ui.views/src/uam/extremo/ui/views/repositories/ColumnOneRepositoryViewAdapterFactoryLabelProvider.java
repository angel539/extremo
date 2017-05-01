package uam.extremo.ui.views.repositories;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.*;
import uam.extremo.ui.views.Activator;

public class ColumnOneRepositoryViewAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider implements IStyledLabelProvider{

	public ColumnOneRepositoryViewAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

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
				styledString.append(" describes (" + ((Resource) element).getDescribes().size() + ")", StyledString.COUNTER_STYLER);
			}
			
			return styledString;
		}
		
		if(element instanceof SemanticNode){
			if(((SemanticNode) element).getDescriptor() == null){
				SemanticNode semanticNode = (SemanticNode) element;
				StyledString styledString = new StyledString(semanticNode.getName());
				
				if(semanticNode.getDescribes().size() > 0)
					styledString.append(" describes (" + semanticNode.getDescribes().size() + ")", StyledString.COUNTER_STYLER);
				
				//if(semanticNode.getProperties().size() > 0)
				//	styledString.append(" (" + semanticNode.getProperties().size() + ") properties", StyledString.QUALIFIER_STYLER);
				
				//styledString.append(" (" + semanticNode.getWeight() + ") pts", StyledString.COUNTER_STYLER);

				return styledString;
			}
			else{
				SemanticNode semanticNode = (SemanticNode) element;
				StyledString styledString = new StyledString(semanticNode.getName());
				styledString.append(" :" + semanticNode.getDescriptor().getName(), StyledString.COUNTER_STYLER);
				return styledString;
			}
    	}
		
		if (element instanceof Constraint) {
			Constraint constraint = (Constraint) element;
			StyledString styledString = new StyledString(((Constraint) element).getName());
			styledString.append(" (" + constraint.getBody() + ")", StyledString.COUNTER_STYLER);
			return styledString;
		}
		
		if(element instanceof DataProperty){
			if(((DataProperty) element).getDescriptor() == null){
				DataProperty property = (DataProperty) element;
				StyledString styledString = new StyledString(property.getName());
				if(property.getType() != null) styledString.append(": " + property.getType().getLiteral(), StyledString.COUNTER_STYLER);
				
				return styledString;
			}
			else{
				DataProperty property = (DataProperty) element;
				StyledString styledString = new StyledString(property.getValue());
				styledString.append(" :" + property.getDescriptor().getName(), StyledString.COUNTER_STYLER);
				
				return styledString;
			}
		}
		
		if(element instanceof ObjectProperty){
			if(((ObjectProperty) element).getDescriptor() == null){
				ObjectProperty property = (ObjectProperty) element;
				StyledString styledString = new StyledString(property.getName());
				if(property.getRange() != null) styledString.append(" ->" + property.getRange().getName(), StyledString.COUNTER_STYLER);
				
				return styledString;
			}
			else{
				ObjectProperty property = (ObjectProperty) element;
				StyledString styledString = new StyledString(property.getName());
				styledString.append(" :" + property.getDescriptor().getName(), StyledString.COUNTER_STYLER);
				
				return styledString;
			}
		}
		
		return null;
	}
	
	@Override
	public Image getImage(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		
		if(element instanceof Repository) return Activator.getImageDescriptor("icons/repo.png").createImage();
    	
		if(element instanceof Resource){
			if(((Resource) element).getDescriptor() == null){
				return Activator.getImageDescriptor("icons/descriptor.png").createImage();
			}
			else{
				if(((Resource) element).isAlive()) return Activator.getImageDescriptor("icons/description_on.png").createImage();
        		else{
        			return Activator.getImageDescriptor("icons/description.png").createImage();
        		}
			}
    	}
		
		if(element instanceof SemanticNode){
			if(((SemanticNode) element).getDescriptor() == null){
				return Activator.getImageDescriptor("icons/class_obj.png").createImage();
			}
			else{
        		return Activator.getImageDescriptor("icons/object.png").createImage();
			}
    	}
		
		if(element instanceof Constraint) return Activator.getImageDescriptor("icons/constraint.png").createImage();
		
		if(element instanceof ObjectProperty) return Activator.getImageDescriptor("icons/det_pane_right.png").createImage();
		if(element instanceof DataProperty) return Activator.getImageDescriptor("icons/attribute.png").createImage();
    	
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
}
