package uam.extremo.ui.zest.views.relations;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IFigureProvider;
import org.eclipse.zest.core.widgets.ZestStyles;

import semanticmanager.SemanticNode;
import uam.extremo.ui.zest.views.draw2d.SemanticClassFigure;

//, IConnectionStyleProvider
public class RelationshipGraphViewPartLabelProvider extends LabelProvider implements IFigureProvider, IConnectionStyleProvider{
    public Color BLACK = new Color(Display.getDefault(), 0, 0, 0);
    public Color WHITE = new Color(Display.getDefault(), 255, 255, 255);
    public Color YELLOW = new Color(Display.getDefault(), 225, 204, 79);
    public Color BLUE = new Color(Display.getDefault(), 0, 102, 204);
    public Color GREEN = new Color(Display.getDefault(), 0, 153, 0);
    
	@Override
	public String getText(Object element) {
		if (element instanceof SemanticNode) {
		      SemanticNode myNode = (SemanticNode) element;
		      return myNode.getName();
		}
		
		if (element instanceof EntityConnectionData) {
			EntityConnectionData test = (EntityConnectionData) element;
			return "";
		}
		
		throw new RuntimeException("Wrong type: "
		        + element.getClass().toString());	   
	}

	/*@Override
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
	}*/

	/*
	@Override
	public int getConnectionStyle(Object rel) {
		if(rel instanceof EntityConnectionData){
			if(((EntityConnectionData) rel).dest instanceof ISemanticClass){
				ISemanticClass semanticClassDestination = (ISemanticClass) ((EntityConnectionData) rel).dest;
				ISemanticClass semanticClassSource = (ISemanticClass) ((EntityConnectionData) rel).source;
				
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
	}*/
	
	@Override
	public IFigure getFigure(Object element) {
		IFigure iFigure = null;
		
		if(element instanceof SemanticNode){
				iFigure = new SemanticClassFigure(((SemanticNode) element));
				if(((SemanticNode) element).getProperties() == null || ((SemanticNode) element).getProperties().size() < 1){
					iFigure.setBackgroundColor(ColorConstants.gray);
				}
				iFigure.setSize(-1, -1);
				
				//((ISemanticClass) element).setFigure(iFigure);
		}
				
		return iFigure;
	}

	@Override
	public int getConnectionStyle(Object rel) {
		if(rel instanceof EntityConnectionData) return ZestStyles.CONNECTIONS_DIRECTED;
		return 0;
	}

	@Override
	public Color getColor(Object rel) {
		if(rel instanceof EntityConnectionData) return ColorConstants.black;
		return null;
	}

	@Override
	public Color getHighlightColor(Object rel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLineWidth(Object rel) {
		if(rel instanceof EntityConnectionData) return 1;
		return 0;
	}

	@Override
	public IFigure getTooltip(Object entity) {
		/*IFigure iFigure  = null;
		
		if(entity instanceof EntityConnectionData){
			ISemanticClass source = (ISemanticClass) ((EntityConnectionData) entity).source;
			ISemanticClass target = (ISemanticClass) ((EntityConnectionData) entity).dest;
			iFigure = new SemanticClassFigure(source);
			if(((ISemanticClass) element).getReferences() == null || ((ISemanticClass) element).getReferences().size() < 1){
				iFigure.setBackgroundColor(ColorConstants.gray);
			}
			iFigure.setSize(-1, -1);
		}*/
		/*if(entity instanceof EntityConnectionData){
			PolylineConnection connection = new PolylineConnection();
			//ChopboxAnchor sourceAnchor = new ChopboxAnchor(((ISemanticClass) ((EntityConnectionData) entity).source).getFigure());
			//ChopboxAnchor targetAnchor = new ChopboxAnchor(((ISemanticClass) ((EntityConnectionData) entity).dest).getFigure());
			
			PolygonDecoration decoration = new PolygonDecoration();
			PointList decorationPointList = new PointList();
			decorationPointList.addPoint(0, 0);
			decorationPointList.addPoint(-2, 2);
			decorationPointList.addPoint(-4, 0);
			decorationPointList.addPoint(-2, -2);
			
			decoration.setTemplate(decorationPointList);
			
			connection.setSourceAnchor(sourceAnchor);
			connection.setTargetAnchor(targetAnchor);
			connection.setSourceDecoration(decoration);
		}
		
		System.out.println("entity en tooltip es instancia de: " + entity.getClass());*/
		//return iFigure;
		return null;
	}	
}
