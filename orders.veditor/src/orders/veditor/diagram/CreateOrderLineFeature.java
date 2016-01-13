package orders.veditor.diagram;

import orders.Orders.Item;
import orders.Orders.OrderLine;
import orders.Orders.OrdersFactory;
import orders.Orders.PurchaseOrder;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class CreateOrderLineFeature extends AbstractCreateConnectionFeature {
	public CreateOrderLineFeature(IFeatureProvider fp) {
		super(fp, "OrderLine", "Creates a new OrderLine");
	}
	
	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		Anchor source = context.getSourceAnchor();
		Anchor target = context.getTargetAnchor();
		
		// check context (type of source and target domain objects)
		if (source!=null && target!=null &&
		getBusinessObjectForPictogramElement(source.getParent())
		instanceof PurchaseOrder &&
		getBusinessObjectForPictogramElement(target.getParent()) instanceof Item)
		return true;
		return source != null && target != null;
	}
	
	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		Anchor source = context.getSourceAnchor();
		
		// check whether the connection can be started at the source anchor
		return source!=null &&
		getBusinessObjectForPictogramElement(source.getParent())
		instanceof PurchaseOrder;
	}
	
	@Override
	public Connection create(ICreateConnectionContext context) {
		// create the domain object (OrderLine)
		OrderLine newOrderLine = OrdersFactory.eINSTANCE.createOrderLine();
		
		// connect the domain object to the source and target objects
		PictogramElement source = context.getSourceAnchor().getParent();
		PictogramElement target = context.getTargetAnchor().getParent();
		PurchaseOrder order =
		(PurchaseOrder)getBusinessObjectForPictogramElement(source);
		Item item = (Item)getBusinessObjectForPictogramElement(target);
		order.getLines().add(newOrderLine);
		newOrderLine.setItem(item);
		
		// add connection between objects to the context
		AddConnectionContext addContext =
		new AddConnectionContext(
		context.getSourceAnchor(),
		context.getTargetAnchor());
		addContext.setNewObject(newOrderLine);
		Connection newConnection =
		(Connection)getFeatureProvider().addIfPossible(addContext);
		
		// return newly created connection
		return newConnection;
	}
}