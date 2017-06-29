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
	  public static Color classColor = new Color(null, 255, 255, 255);
	  private CompartmentFigure attributeFigure = new CompartmentFigure();
	  
	  public SemanticNodeFigure(SemanticNode semanticnode){
		  Font classFont = new Font(null, "Arial", 12, SWT.BOLD);
		  
		  Label classLabel = null;
		  
		  if((semanticnode.getDescriptors() == null) || (semanticnode.getDescriptors().isEmpty())){
			  // node
			  if((semanticnode.getConstraints() == null) || (semanticnode.getConstraints().isEmpty())){
				  // without constraints
				  if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
					  // without properties
					  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/node16.png").createImage());
				  }
				  else{
					  long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
					  long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					  
					  if(dataProperties == 0){
						  // with objectProperties only
						  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/noderefs16.png").createImage());
					  }
					  else{
						  if(objectProperties == 0){
							  // with dataProperties only
							  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/nodeprop16.png").createImage());
						  }
						  else{
							  // with dataProperties and objectProperties
							  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/nodeproprefs16.png").createImage());
						  }
					  }
				  }
			  }
			  else{
				  // with constraints
				  if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
					  // without properties
					  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/nodewithconstraints16.png").createImage());
				  }
				  else{
					  long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
					  long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					  
					  if(dataProperties == 0){
								// with objectProperties only
						  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/nodewithconstraintsrefs16.png").createImage());
					  }
					  else{
						  if(objectProperties == 0){
							  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/nodewithconstraintsprop16.png").createImage());
						  }
						  else{
							  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/nodewithconstraintsproprefs16.png").createImage());
						  }
					  }
				  }
			  }
		  }
		  else{
			  if((semanticnode.getDescribes() == null) || (semanticnode.getDescribes().isEmpty())){
						// object
				  if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
					  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/object16.png").createImage());
				  }
				  else{
					  long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
					  long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					  
					  if(dataProperties == 0){
						  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/objectwithrefs16.png").createImage());
					  }
					  else{
						  if(objectProperties == 0){
							  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/objectwithprop16.png").createImage());
						  }
						  else{
							  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/objectwithproprefs16.png").createImage());
						  }
					  }
				  }
			}
			else{
				if((semanticnode.getProperties() == null) || (semanticnode.getProperties().isEmpty())){
					  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/clabject16.png").createImage());
				}
				else{
					long dataProperties = semanticnode.getProperties().stream().filter(element -> element instanceof DataProperty).count();
					long objectProperties = semanticnode.getProperties().stream().filter(element -> element instanceof ObjectProperty).count();
					
					if(dataProperties == 0){
						  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/clabjectwithrefs16.png").createImage());
					}
					else{
						if(objectProperties == 0){
							  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/clabjectwithprop16.png").createImage());
						}
						else{
							  classLabel = new Label(semanticnode.getName(), Activator.getImageDescriptor("icons/datamodel/clabjectwithproprefs16.png").createImage());
						}
					}
				}
			}
		}

		  classLabel.setFont(classFont);
		  
		  ToolbarLayout layout = new ToolbarLayout();
		  setLayoutManager(layout);
		  setBorder(new LineBorder(ColorConstants.black, 1));
		  setBackgroundColor(classColor);
		  setOpaque(true);
		  
		  if(semanticnode.getProperties() != null){
			  for(Property dataProperty : semanticnode.getProperties()){
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
		  setBorder(new LineBorder(ColorConstants.black, 1));
		  setBackgroundColor(classColor);
		  setOpaque(true);
		  
		  add(name);
		  add(attributeFigure);
	  }
	  
	  public CompartmentFigure getAttributesCompartment() {
		  return attributeFigure;
	  }
}
