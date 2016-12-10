package uam.extremo.ui.zest.views.inheritance;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import semanticmanager.DataProperty;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import uam.extremo.ui.zest.views.Activator;

//, IFigureProvider
public class InheritanceGraphPartViewLabelProvider implements ILabelProvider, IColorProvider/*, IFigureProvider*/{
    public Color BLACK = new Color(Display.getDefault(), 0, 0, 0);
    public Color WHITE = new Color(Display.getDefault(), 255, 255, 255);
    public Color YELLOW = new Color(Display.getDefault(), 225, 204, 79);
    public Color BLUE = new Color(Display.getDefault(), 0, 102, 204);
    public Color GREEN = new Color(Display.getDefault(), 0, 153, 0);
    
	@Override
	public String getText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		StringBuilder builder = new StringBuilder();
		
		if (element instanceof Repository) {
		      Repository repository = (Repository) element;
		      return repository.getName();
		}
		
		if (element instanceof Resource) {
		      Resource resource = (Resource) element;
		      return resource.getName();
		}
		
		if (element instanceof SemanticNode) {
		      SemanticNode semanticNode = (SemanticNode) element;
		      return semanticNode.getName();
		}
		
		if (element instanceof DataProperty) {
			  DataProperty dataProperty = (DataProperty) element;
		      return dataProperty.getName();
		}
		
		if (element instanceof EntityConnectionData) {
			EntityConnectionData conn = (EntityConnectionData) element;
		      if (conn.source instanceof SemanticNode)
		         builder.append("inherits");
		      else
		         builder.append("");
		}
		
		return builder.toString();
	}
	
	@Override
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		
		if(obj instanceof Repository) return Activator.getImageDescriptor("icons/folder-icon_16.png").createImage();
    	
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
		
		if(obj instanceof SemanticNode) return Activator.getImageDescriptor("icons/class_obj.png").createImage();
		if(obj instanceof DataProperty) return Activator.getImageDescriptor("icons/attribute.png").createImage();

		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
	
	@Override
	public Color getForeground(Object element) {
		return ColorConstants.black;
	}

	@Override
	public Color getBackground(Object element) {
		return YELLOW;
	}


	/*@Override
	public IFigure getFigure(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if (element instanceof Repository) {
			Repository repository = (Repository) element;
			RepositoryFigure repositoryFigure = new RepositoryFigure(repository.getYearMarried());
			repositoryFigure.setSize(repositoryFigure.getPreferredSize());
			return repositoryFigure;
		}
		
		if (element instanceof Resource) {
		}
		
		if (element instanceof SemanticNode) {
		}
		
		return null;
	}*/
	/*@Override
	public IFigure getFigure(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if(element instanceof SemanticNode){
			IFigure iFigure = new SemanticNodeFigure(((SemanticNode) element));
			if(((SemanticNode) element).getProperties() == null || ((SemanticNode) element).getProperties().size() < 1){
				iFigure.setBackgroundColor(ColorConstants.gray);
			}
			iFigure.setSize(-1, -1);
		}
				
		return null;
	}*/

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}
}
