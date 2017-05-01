package uam.extremo.ui.zest.views.draw2d;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Color;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import uam.extremo.ui.zest.views.Activator;
import semanticmanager.*;

public class SemanticNodeFigure extends Figure {
	  public static Color classColor = new Color(null,255,255,255);
	  private CompartmentFigure attributeFigure = new CompartmentFigure();
	  
	  public SemanticNodeFigure(SemanticNode semanticNode){
		  Font classFont = new Font(null, "Arial", 12, SWT.BOLD);
		  Label classLabel = new Label(semanticNode.getName(), Activator.getImageDescriptor("icons/class_obj.gif").createImage());
		  classLabel.setFont(classFont);
		  
		  ToolbarLayout layout = new ToolbarLayout();
		  setLayoutManager(layout);
		  setBorder(new LineBorder(ColorConstants.black,1));
		  setBackgroundColor(classColor);
		  setOpaque(true);
		  
		  if(semanticNode.getProperties() != null){
			  for(Property dataProperty : semanticNode.getProperties()){
				  if(dataProperty instanceof DataProperty){
					  Label attribute = new Label(dataProperty.getName() + " : " + ((DataProperty) dataProperty).getType(), Activator.getImageDescriptor("icons/field_private_obj.gif").createImage());
					  attributeFigure.add(attribute);
				  }  
			  }
		  }
		  
		  add(classLabel);
		  add(attributeFigure);
	  }
	  
	  public SemanticNodeFigure(Label name) {
		  ToolbarLayout layout = new ToolbarLayout();
		  setLayoutManager(layout);
		  setBorder(new LineBorder(ColorConstants.black,1));
		  setBackgroundColor(classColor);
		  setOpaque(true);
		  
		  add(name);
		  add(attributeFigure);
	  }
	  
	  public CompartmentFigure getAttributesCompartment() {
		  return attributeFigure;
	  }
}
