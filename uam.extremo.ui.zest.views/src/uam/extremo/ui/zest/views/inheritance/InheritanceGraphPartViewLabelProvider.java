package uam.extremo.ui.zest.views.inheritance;

import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IFigureProvider;
import semanticmanager.SemanticNode;
import uam.extremo.ui.zest.views.draw2d.SemanticClassFigure;

public class InheritanceGraphPartViewLabelProvider extends LabelProvider implements IFigureProvider{
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

	@Override
	public IFigure getFigure(Object element) {
		IFigure iFigure = null;
		
		if(element instanceof SemanticNode){
			iFigure = new SemanticClassFigure(((SemanticNode) element));
			iFigure.setSize(-1, -1);
		}
		
		return iFigure;
	}
}
