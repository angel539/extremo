package uam.extremo.ui.views.entities;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.Search;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import uam.extremo.ui.views.Activator;

public class EntityViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if(obj instanceof Search) return Activator.getImageDescriptor("icons/search_property.png").createImage();
		if(obj instanceof SemanticGroup) return Activator.getImageDescriptor("icons/class_set.gif").createImage();
		//if(obj instanceof SemanticNode) return Activator.getImageDescriptor("icons/class_obj.png").createImage();
		
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
	
	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if (element instanceof Search) {
			Search searchWord = (Search) element;
			StyledString styledString = new StyledString(searchWord.getName());
			return styledString;
		}
		
		if (element instanceof SemanticGroup) {
			SemanticGroup semanticGroup = (SemanticGroup) element;
			StyledString styledString = new StyledString("");
			styledString.append(" (" + semanticGroup.getNodes().size() + ") ", StyledString.QUALIFIER_STYLER);

			return styledString;
		}
		
		/*if (element instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) element;
			StyledString styledString = new StyledString("");
			styledString.append(" (" + semanticNode.getProperties().size() + ") ", StyledString.QUALIFIER_STYLER);

			return styledString;
		}*/
		
		return null;
	}
}
