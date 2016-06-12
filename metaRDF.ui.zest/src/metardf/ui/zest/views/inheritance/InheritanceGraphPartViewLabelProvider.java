package metardf.ui.zest.views.inheritance;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipse.zest.core.widgets.ZestStyles;

import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;

public class InheritanceGraphPartViewLabelProvider extends LabelProvider implements IConnectionStyleProvider, IEntityStyleProvider{
    public Color BLACK = new Color(Display.getDefault(), 0, 0, 0);
    public Color WHITE = new Color(Display.getDefault(), 255, 255, 255);
    public Color YELLOW = new Color(Display.getDefault(), 225, 204, 79);
    public Color BLUE = new Color(Display.getDefault(), 0, 102, 204);
    public Color GREEN = new Color(Display.getDefault(), 0, 153, 0);
    
	@Override
	public String getText(Object element) {
		if (element instanceof ISemanticClass) {
		      ISemanticClass myNode = (ISemanticClass) element;
		      return myNode.getName();
		}
		
		if (element instanceof EntityConnectionData) {
			EntityConnectionData test = (EntityConnectionData) element;
			return "";
		}
		
		throw new RuntimeException("Wrong type: "
		        + element.getClass().toString());	   
	}

	@Override
	public Color getNodeHighlightColor(Object entity) {
		return WHITE;
	}

	@Override
	public Color getBorderColor(Object entity) {
		return BLACK;
	}

	@Override
	public Color getBorderHighlightColor(Object entity) {
		return BLUE;
	}

	@Override
	public int getBorderWidth(Object entity) {
		if(entity instanceof ISemanticClass)
			return 1;
		return 0;
	}

	@Override
	public Color getBackgroundColour(Object entity) {
		return WHITE;
	}

	@Override
	public Color getForegroundColour(Object entity) {
		return BLACK;
	}

	@Override
	public boolean fisheyeNode(Object entity) {
		return false;
	}

	@Override
	public int getConnectionStyle(Object rel) {
		if(rel instanceof EntityConnectionData){
			if(((EntityConnectionData) rel).dest instanceof ISemanticClass){
				ISemanticClass semanticClassDestination = (ISemanticClass) ((EntityConnectionData) rel).dest;
				ISemanticClass semanticClassSource = (ISemanticClass) ((EntityConnectionData) rel).source;
				
				for(ISemanticClass superclass : semanticClassSource.getSuperclasses()){
					if(superclass.getName().equals(semanticClassDestination.getName())){
						return ZestStyles.CONNECTIONS_DIRECTED;
					}
				}
				
				for(IObjectProperty reference : semanticClassSource.getReferences()){
					if(reference.getRange().getName().equals(semanticClassDestination.getName())){
						return ZestStyles.CONNECTIONS_DOT;
					}
				}
			}
		}
		return ZestStyles.CONNECTIONS_DIRECTED;
	}

	@Override
	public Color getColor(Object rel) {
		if(rel instanceof EntityConnectionData){
			if(((EntityConnectionData) rel).dest instanceof ISemanticClass){
				ISemanticClass semanticClassDestination = (ISemanticClass) ((EntityConnectionData) rel).dest;
				ISemanticClass semanticClassSource = (ISemanticClass) ((EntityConnectionData) rel).source;
				
				for(ISemanticClass superclass : semanticClassSource.getSuperclasses()){
					if(superclass.getName().equals(semanticClassDestination.getName())){
						return GREEN;
					}
				}
				
				for(IObjectProperty reference : semanticClassSource.getReferences()){
					if(reference.getRange().getName().equals(semanticClassDestination.getName())){
						return BLACK;
					}
				}
			}
		}
		
		return BLACK;
	}

	@Override
	public Color getHighlightColor(Object rel) {
        return ColorConstants.green;
	}

	@Override
	public int getLineWidth(Object rel) {
		return 1;
	}

	@Override
	public IFigure getTooltip(Object entity) {
		if(entity instanceof ISemanticClass){
			return new Label(((ISemanticClass) entity).getDescription());
		}
		
		if(entity instanceof EntityConnectionData){
			ISemanticClass source = (ISemanticClass) ((EntityConnectionData) entity).source;
			ISemanticClass target = (ISemanticClass) ((EntityConnectionData) entity).dest;
			return new Label(source.getName() + " -> " + target.getName());
		}
		
		return new Label("");
	}	
}
