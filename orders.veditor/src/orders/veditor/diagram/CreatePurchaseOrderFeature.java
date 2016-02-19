package orders.veditor.diagram;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import orders.Orders.OrdersFactory;
import orders.Orders.PurchaseOrder;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreatePurchaseOrderFeature extends AbstractCreateFeature {

	public CreatePurchaseOrderFeature(IFeatureProvider fp) {
		super(fp, "PurchaseOrder", "Creates a new PurchaseOrder");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		// check appropriate context (canvas in this case)
		return context.getTargetContainer() instanceof Diagram;
	}
	@Override
	public Object[] create(ICreateContext context) {
		// create domain object using the factory generated using orders.genmodel
		PurchaseOrder newPurchaseOrder =
		OrdersFactory.eINSTANCE.createPurchaseOrder();
		// ask attribute value using a dialog window
		String shipTo = null;
		shipTo = (String) JOptionPane.showInputDialog(new JFrame(), "Ship to");
		newPurchaseOrder.setShipTo(shipTo);
		// add object to diagram
		getDiagram().eResource().getContents().add(newPurchaseOrder);
		// add graphical representation of object
		addGraphicalRepresentation(context, newPurchaseOrder);
		// return newly created object
		return new Object[] { newPurchaseOrder };
	}
}