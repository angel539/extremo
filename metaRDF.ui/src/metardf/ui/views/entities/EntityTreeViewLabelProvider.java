package metardf.ui.views.entities;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import metardf.ui.Activator;
import metardf.ui.views.entities.model.AttrFolderParent;
import metardf.ui.views.entities.model.DataPropertyObject;
import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.FolderParent;
import metardf.ui.views.entities.model.PropertyParent;
import metardf.ui.views.entities.model.SearchParent;

public class EntityTreeViewLabelProvider extends LabelProvider {
	public String getText(Object obj) {
		return obj.toString();
	}
	public Image getImage(Object obj) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if(obj instanceof SearchParent) return Activator.getImageDescriptor("icons/searchm_obj.gif").createImage();
		if(obj instanceof SearchParent) return Activator.getImageDescriptor("icons/stepbystep_co.gif").createImage();
		if(obj instanceof PropertyParent) return Activator.getImageDescriptor("icons/method.png").createImage();
		if(obj instanceof EntityParent) return Activator.getImageDescriptor("icons/class_obj.png").createImage();
		if(obj instanceof FolderParent) return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		if(obj instanceof AttrFolderParent) return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		if(obj instanceof DataPropertyObject) return Activator.getImageDescriptor("icons/attribute.png").createImage();
		
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
}
