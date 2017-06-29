package uam.extremo.ui.zest.views.inheritance;

import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.zest.core.viewers.IFigureProvider;

import semanticmanager.NamedElement;
import semanticmanager.Repository;
import semanticmanager.SemanticNode;
import uam.extremo.ui.zest.views.draw2d.SemanticNodeFigure;

public class ResourceExplorerLabelProvider
					extends LabelProvider
					implements IColorProvider, IFontProvider, IFigureProvider {
    public Color BLACK = new Color(Display.getDefault(), 0, 0, 0);
    public Color WHITE = new Color(Display.getDefault(), 255, 255, 255);
    public Color YELLOW = new Color(Display.getDefault(), 225, 204, 79);
    public Color BLUE = new Color(Display.getDefault(), 0, 102, 204);
    public Color GREEN = new Color(Display.getDefault(), 0, 153, 0);
    
    public ResourceExplorerLabelProvider() {
	}

	@Override
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;

		/*if(obj instanceof Repository) return Activator.getImageDescriptor("icons/repo.png").createImage();
		
		if(obj instanceof Resource){
			Resource resource = (Resource) obj;
			
			if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
				if((resource.getConstraints() == null) || (resource.getConstraints().isEmpty())){
					return Activator.getImageDescriptor("icons/datamodel/resource16.png").createImage();
				}
				else{
					return Activator.getImageDescriptor("icons/datamodel/resourcewithconstraints16.png").createImage();
				}
			}
			else{
				return Activator.getImageDescriptor("icons/datamodel/description16.png").createImage();
			}
    	}
				
		if(obj instanceof SemanticNode){
			SemanticNode semanticnode = (SemanticNode) obj;
			
			if((semanticnode.getDescriptors() == null) || (semanticnode.getDescriptors().isEmpty())){
				// node
				if((semanticnode.getConstraints() == null) || (semanticnode.getConstraints().isEmpty())){
					// without constraints
					if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
						// without properties
						return Activator.getImageDescriptor("icons/datamodel/node16.png").createImage();
					}
					else{
						long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
						long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					
						if(dataProperties == 0){
							// with objectProperties only
							return Activator.getImageDescriptor("icons/datamodel/noderefs16.png").createImage();
						}
						else{
							if(objectProperties == 0){
								// with dataProperties only
								return Activator.getImageDescriptor("icons/datamodel/nodeprop16.png").createImage();
							}
							else{
								// with dataProperties and objectProperties
								return Activator.getImageDescriptor("icons/datamodel/nodeproprefs16.png").createImage();
							}
						}
					}	
				}
				else{
					// with constraints
					if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
						// without properties
						return Activator.getImageDescriptor("icons/datamodel/nodewithconstraints16.png").createImage();
					}
					else{
						long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
						long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					
						if(dataProperties == 0){
							// with objectProperties only
							return Activator.getImageDescriptor("icons/datamodel/nodewithconstraintsrefs16.png").createImage();
						}
						else{
							if(objectProperties == 0){
								// with dataProperties only
								return Activator.getImageDescriptor("icons/datamodel/nodewithconstraintsprop16.png").createImage();
							}
							else{
								// with dataProperties and objectProperties
								return Activator.getImageDescriptor("icons/datamodel/nodewithconstraintsproprefs16.png").createImage();
							}
						}
					}	
				}
			}
			else{
				if((semanticnode.getDescribes() == null) || (semanticnode.getDescribes().isEmpty())){
					// object
					if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
						// without properties
						return Activator.getImageDescriptor("icons/datamodel/object16.png").createImage();
					}
					else{
						long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
						long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					
						if(dataProperties == 0){
							// with objectProperties only
							return Activator.getImageDescriptor("icons/datamodel/objectwithrefs16.png").createImage();
						}
						else{
							if(objectProperties == 0){
								// with dataProperties only
								return Activator.getImageDescriptor("icons/datamodel/objectwithprop16.png").createImage();
							}
							else{
								// with dataProperties and objectProperties
								return Activator.getImageDescriptor("icons/datamodel/objectwithproprefs16.png").createImage();
							}
						}
					}	
				}
				else{
					// clabject
					if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
						// without properties
						return Activator.getImageDescriptor("icons/datamodel/clabject16.png").createImage();
					}
					else{
						long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
						long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					
						if(dataProperties == 0){
							// with objectProperties only
							return Activator.getImageDescriptor("icons/datamodel/clabjectwithrefs16.png").createImage();
						}
						else{
							if(objectProperties == 0){
								// with dataProperties only
								return Activator.getImageDescriptor("icons/datamodel/clabjectwithprop16.png").createImage();
							}
							else{
								// with dataProperties and objectProperties
								return Activator.getImageDescriptor("icons/datamodel/clabjectwithproprefs16.png").createImage();
							}
						}
					}
				}
			}
    	}
		
		if(obj instanceof DataProperty){
			DataProperty dataProperty = (DataProperty) obj;
			
			if((dataProperty.getConstraints() == null) || (dataProperty.getConstraints().isEmpty())){
				return Activator.getImageDescriptor("icons/datamodel/prop16.png").createImage();
			}
			else{
				return Activator.getImageDescriptor("icons/datamodel/propwithconstraints16.png").createImage();
			}
		}*/
    	
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
	
	@Override
	public String getText(Object element) {
		StringBuilder builder = new StringBuilder();
		
		if(element instanceof Repository){
			Repository repository = (Repository) element;
			builder.append(repository.getName());
		}
		
		if(element instanceof NamedElement){
			NamedElement namedElement = (NamedElement) element;
			builder.append(namedElement.getName());
		}
		
		return builder.toString();
	}
	
	@Override
	public Color getForeground(Object element) {
		return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
	}

	@Override
	public Color getBackground(Object element) {
		Color color = Display.getCurrent().getSystemColor( SWT.COLOR_GRAY);
		
		if(element instanceof SemanticNode){
			color = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN);
		}
		
		return color;
	}

	@Override
	public Font getFont(Object element) {
		String name = "Arial";
		int size = 12;
		int style = SWT.NONE;
		
		if(element instanceof SemanticNode){
			size = 15;
			style = SWT.BOLD;
			
			if(((SemanticNode) element).isAbstract()) style = SWT.ITALIC;
		}
		
		return new Font(null, new FontData(name, size, style));
	}

	@Override
	public IFigure getFigure(Object element) {
		IFigure iFigure = null;
		
		if(element instanceof SemanticNode){
			iFigure = new SemanticNodeFigure(((SemanticNode) element));
			iFigure.setSize(-1, -1);
		}
		
		return iFigure;
	}
}
