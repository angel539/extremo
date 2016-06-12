package metardf.ui.wizards.semanticselector;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import metardf.ui.Activator;
import metardf.ui.views.entities.model.AttributeFolderTreeParent;
import metardf.ui.views.entities.model.DataPropertyTreeObject;
import metardf.ui.views.entities.model.SemanticClassTreeParent;
import metardf.ui.views.entities.model.SemanticClassGroupTreeParent;
import metardf.ui.views.entities.model.FolderTreeParent;
import metardf.ui.views.entities.model.ObjectPropertyTreeParent;
import metardf.ui.views.entities.model.SearchTreeParent;

public class EntityGroupSelectorViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if(obj instanceof SearchTreeParent) return Activator.getImageDescriptor("icons/searchm_obj.gif").createImage();
		if(obj instanceof SearchTreeParent) return Activator.getImageDescriptor("icons/stepbystep_co.gif").createImage();
		if(obj instanceof ObjectPropertyTreeParent) return Activator.getImageDescriptor("icons/method.png").createImage();
		if(obj instanceof SemanticClassTreeParent) return Activator.getImageDescriptor("icons/class_obj.png").createImage();
		if(obj instanceof SemanticClassGroupTreeParent) return Activator.getImageDescriptor("icons/class_set.gif").createImage();
		if(obj instanceof FolderTreeParent) return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		if(obj instanceof AttributeFolderTreeParent) return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		if(obj instanceof DataPropertyTreeObject) return Activator.getImageDescriptor("icons/attribute.png").createImage();
		
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
	
	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		//System.out.println("??" + element.getClass());
		if (element instanceof FolderTreeParent) {
			FolderTreeParent repositoryNode = (FolderTreeParent) element;
			StyledString styledString = new StyledString(repositoryNode.getName());
			
			if (repositoryNode.getChildren() != null) {
				styledString.append(" (" + repositoryNode.getChildren().length + ") ", StyledString.COUNTER_STYLER);
			}
			return styledString;
		}
		
		if (element instanceof AttributeFolderTreeParent) {
			AttributeFolderTreeParent repositoryNode = (AttributeFolderTreeParent) element;
			StyledString styledString = new StyledString(repositoryNode.getName());
			
			if (repositoryNode.getChildren() != null) {
				styledString.append(" (" + repositoryNode.getChildren().length + ") ", StyledString.COUNTER_STYLER);
			}
			return styledString;
		}
		
		if (element instanceof SearchTreeParent) {
			//System.out.println("reconoce que es searchparent");
			SearchTreeParent repositoryNode = (SearchTreeParent) element;
			StyledString styledString = new StyledString(repositoryNode.getName());
			
			if (repositoryNode.getChildren() != null) {
				styledString.append(" (" + repositoryNode.getChildren().length + " results ) ", StyledString.QUALIFIER_STYLER);
			}
			return styledString;
		}
		
		if (element instanceof SemanticClassGroupTreeParent) {
			//System.out.println("reconoce que es searchparent");
			SemanticClassGroupTreeParent repositoryNode = (SemanticClassGroupTreeParent) element;
			StyledString styledString = new StyledString(repositoryNode.getName());
			
			if (repositoryNode.getChildren() != null) {
				styledString.append(" (" + repositoryNode.getChildren().length + " entities grouped) ", StyledString.QUALIFIER_STYLER);
				styledString.append(" (" + repositoryNode.getMax_weight() + " points) ", StyledString.DECORATIONS_STYLER);
			}
			return styledString;
		}
		
		if (element instanceof SemanticClassTreeParent) {
			StyledString styledString = new StyledString(((SemanticClassTreeParent) element).getName());
			styledString.append(" (" + ((SemanticClassTreeParent) element).getSemanticElement().getWeight() + " points) ", StyledString.DECORATIONS_STYLER);
			return styledString;
		}
		
		if (element instanceof DataPropertyTreeObject) {
			StyledString styledString = new StyledString(((DataPropertyTreeObject) element).getName());
			return styledString;
		}
		
		if (element instanceof ObjectPropertyTreeParent) {
			StyledString styledString = new StyledString(((ObjectPropertyTreeParent) element).getName());
			return styledString;
		}
		
		return null;
	}
}
