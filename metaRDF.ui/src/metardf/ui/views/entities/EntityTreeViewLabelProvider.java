package metardf.ui.views.entities;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import metardf.ui.Activator;
import metardf.ui.views.entities.EntityView.EntityParent;
import metardf.ui.views.entities.EntityView.FolderParent;
import metardf.ui.views.entities.EntityView.PropertyParent;

public class EntityTreeViewLabelProvider extends LabelProvider {
	public String getText(Object obj) {
		return obj.toString();
	}
	public Image getImage(Object obj) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if(obj instanceof PropertyParent) return Activator.getImageDescriptor("icons/method.png").createImage();
		if(obj instanceof EntityParent) return Activator.getImageDescriptor("icons/class_obj.png").createImage();
		if(obj instanceof FolderParent) return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		if(obj instanceof TreeObject) return Activator.getImageDescriptor("icons/attribute.png").createImage();
		
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
}
