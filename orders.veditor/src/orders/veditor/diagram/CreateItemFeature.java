package orders.veditor.diagram;


import orders.Orders.Item;
import orders.Orders.OrdersFactory;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateItemFeature extends AbstractCreateFeature {

	public CreateItemFeature(IFeatureProvider fp) {
		super(fp, "Item", "Creates a new Item");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		// check appropriate context (canvas in this case)
		return context.getTargetContainer() instanceof Diagram;
	}
	@Override
	public Object[] create(ICreateContext context) {
		// create domain object using the factory generated using orders.genmodel
		Item newItem =
		OrdersFactory.eINSTANCE.createItem();
		// ask attribute value using a dialog window
		//String shipTo = null;
		//shipTo = (String) JOptionPane.showInputDialog(new JFrame(), "Ship to");
		//newPurchaseOrder.setShipTo(shipTo);
		
		// add object to diagram
		getDiagram().eResource().getContents().add(newItem);
		// add graphical representation of object
		addGraphicalRepresentation(context, newItem);
		// return newly created object
		return new Object[] { newItem };
	}
}