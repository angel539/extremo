package orders.veditor.diagram;

import orders.Orders.OrderLine;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

public class AddOrderLineFeature extends AbstractAddFeature {
	public AddOrderLineFeature(IFeatureProvider fp) { super(fp); }
	
	@Override
	public boolean canAdd(IAddContext context) {
		// check the type of the domain object is correct (it is OrderLine)
		return context instanceof IAddConnectionContext &&
		context.getNewObject() instanceof OrderLine;
	}
	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		// service for creation of connections
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		// service for creation of polylines
		IGaService gaService = Graphiti.getGaService();
		// create graphical representation (polyline)
		Connection connection = null;
		connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());
		Polyline polyline = gaService.createPlainPolyline(connection);
		polyline.setForeground(manageColor(IColorConstant.BLACK));
		// link graphics to the domain object
		Object addedOrderLine = context.getNewObject();
		link(connection, addedOrderLine);
		return connection;
	}
}
