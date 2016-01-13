package orders.veditor.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class OrdersDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public OrdersDiagramTypeProvider() {
		super(); setFeatureProvider(new OrdersFeatureProvider(this));
	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub
		super.postInit();
		
	}
	
	
}
