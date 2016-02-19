package orders.veditor.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class OrdersDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public OrdersDiagramTypeProvider() {
		super();
		setFeatureProvider(new OrdersFeatureProvider(this));
	}
}
