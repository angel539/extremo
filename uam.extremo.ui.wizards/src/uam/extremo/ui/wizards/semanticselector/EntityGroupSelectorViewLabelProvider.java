package uam.extremo.ui.wizards.semanticselector;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Search;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import uam.extremo.ui.wizards.Activator;

public class EntityGroupSelectorViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if(obj instanceof Search) return Activator.getImageDescriptor("icons/searchm_obj.gif").createImage();
		if(obj instanceof ObjectProperty) return Activator.getImageDescriptor("icons/method.png").createImage();
		if(obj instanceof SemanticNode) return Activator.getImageDescriptor("icons/class_obj.png").createImage();
		if(obj instanceof SemanticGroup) return Activator.getImageDescriptor("icons/class_set.gif").createImage();
		//if(obj instanceof Folder) return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		//if(obj instanceof AttributeFolderTreeParent) return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		if(obj instanceof DataProperty) return Activator.getImageDescriptor("icons/attribute.png").createImage();
		
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
	
	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		/*if (element instanceof FolderTreeParent) {
			FolderTreeParent repositoryNode = (FolderTreeParent) element;
			StyledString styledString = new StyledString(repositoryNode.getName());
			
			if (repositoryNode.getChildren() != null) {
				styledString.append(" (" + repositoryNode.getChildren().length + ") ", StyledString.COUNTER_STYLER);
			}
			return styledString;
		}*/
		
		/*if (element instanceof AttributeFolderTreeParent) {
			AttributeFolderTreeParent repositoryNode = (AttributeFolderTreeParent) element;
			StyledString styledString = new StyledString(repositoryNode.getName());
			
			if (repositoryNode.getChildren() != null) {
				styledString.append(" (" + repositoryNode.getChildren().length + ") ", StyledString.COUNTER_STYLER);
			}
			return styledString;
		}*/
		
		if (element instanceof Search) {
			Search repositoryNode = (Search) element;
			StyledString styledString = new StyledString(repositoryNode.getName());
			
			/*if (repositoryNode.getChildren() != null) {
				styledString.append(" (" + repositoryNode.getChildren().length + " results ) ", StyledString.QUALIFIER_STYLER);
			}*/
			return styledString;
		}
		
		if (element instanceof SemanticGroup) {
			SemanticGroup repositoryNode = (SemanticGroup) element;
			StyledString styledString = new StyledString(repositoryNode.toString());
			
			/*if (repositoryNode.getChildren() != null) {
				styledString.append(" (" + repositoryNode.getChildren().length + " entities grouped) ", StyledString.QUALIFIER_STYLER);
				styledString.append(" (" + repositoryNode.getMax_weight() + " points) ", StyledString.DECORATIONS_STYLER);
			}*/
			return styledString;
		}
		
		if (element instanceof SemanticNode) {
			StyledString styledString = new StyledString(((SemanticNode) element).getName());
			styledString.append(" (" + ((SemanticNode) element).getWeight() + " points) ", StyledString.DECORATIONS_STYLER);
			return styledString;
		}
		
		if (element instanceof DataProperty) {
			StyledString styledString = new StyledString(((DataProperty) element).getName());
			return styledString;
		}
		
		if (element instanceof ObjectProperty) {
			StyledString styledString = new StyledString(((ObjectProperty) element).getName());
			return styledString;
		}
		
		return null;
	}
}
