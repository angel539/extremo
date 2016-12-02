package uam.extremo.ui.zest.views.draw2d;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Color;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import semanticmanager.DataProperty;
import semanticmanager.Property;
import semanticmanager.SemanticNode;
import uam.extremo.ui.zest.views.Activator;

public class SemanticClassFigure extends Figure {
	  public static Color classColor = new Color(null,255,255,255);
	  private CompartmentFigure attributeFigure = new CompartmentFigure();
	  
	  public SemanticClassFigure(SemanticNode semanticClass){
		  Font classFont = new Font(null, "Arial", 12, SWT.BOLD);
		  Label classLabel = new Label(semanticClass.getName(), Activator.getImageDescriptor("icons/class_obj.gif").createImage());
		  classLabel.setFont(classFont);
		  
		  ToolbarLayout layout = new ToolbarLayout();
		  setLayoutManager(layout);
		  setBorder(new LineBorder(ColorConstants.black,1));
		  setBackgroundColor(classColor);
		  setOpaque(true);
		  
		  if(semanticClass.getProperties() != null){
			  for(Property dataProperty : semanticClass.getProperties()){
				  if(dataProperty instanceof DataProperty){
					  Label attribute = new Label(dataProperty.getName() + " : " + ((DataProperty) dataProperty).getType(), Activator.getImageDescriptor("icons/field_private_obj.gif").createImage());
					  attributeFigure.add(attribute);
				  }  
			  }
		  }
		  
		  add(classLabel);
		  add(attributeFigure);
	  }
	  
	  public SemanticClassFigure(Label name) {
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
