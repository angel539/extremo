package orders.veditor.diagram;

import orders.Orders.Item;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public class AddItemFeature extends AbstractAddFeature {
	public AddItemFeature(IFeatureProvider fp) { 
		super(fp); 
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		// check for right domain object type (PurchaseOrder)
		// and container (Diagram)
		return context.getNewObject() instanceof Item &&
		context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	public PictogramElement add(IAddContext context) {
		// obtain domain object created in Create Feature
		Item newItem = (Item)context.getNewObject();
		
		// obtain diagram where we want to add the figure
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		
		// obtain service to create pictograms (shapes...)
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// service to create figures and layouts
		IGaService gaService = Graphiti.getGaService();
		
		// create graphical representation
		ContainerShape container = null;
		RoundedRectangle figure = null;
		container = peCreateService.createContainerShape(targetDiagram, true);
		figure = gaService.createRoundedRectangle(container, 5, 5);
		gaService.setLocationAndSize(figure, context.getX(), context.getY(),
		context.getWidth(), context.getHeight());
		figure.setFilled(false);
		Shape shape = peCreateService.createShape(container, false);
		Text text = gaService.createText(shape,	"Item ");
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, 0, figure.getWidth(),
		figure.getHeight());
		
		// link graphics to the domain object
		link(container, newItem);
		peCreateService.createChopboxAnchor(container);
		return container;
	}
}
