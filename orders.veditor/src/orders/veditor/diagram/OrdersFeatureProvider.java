package orders.veditor.diagram;

import orders.Orders.Item;
import orders.Orders.OrderLine;
import orders.Orders.PurchaseOrder;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

public class OrdersFeatureProvider extends DefaultFeatureProvider {
	public OrdersFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}
	
	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] { new CreatePurchaseOrderFeature(this), new CreateItemFeature(this) };
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new CreateOrderLineFeature(this) };
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) { 
		if (context.getNewObject() instanceof PurchaseOrder) {
			return new AddPurchaseOrderFeature(this);
		} else if (context.getNewObject() instanceof Item) {
			return new AddItemFeature(this);
		} else if (context.getNewObject() instanceof OrderLine) {
			return new AddOrderLineFeature(this);
		}
		return super.getAddFeature(context);
	}
}
