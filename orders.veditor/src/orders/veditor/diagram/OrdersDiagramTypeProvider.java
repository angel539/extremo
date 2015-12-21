package orders.veditor.diagram;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.platform.IDiagramBehavior;
import org.eclipse.graphiti.platform.IDiagramContainer;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

import orders.veditor.dnd.OrderTransferDropTargetListener;

public class OrdersDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public OrdersDiagramTypeProvider() {
		super();
		setFeatureProvider(new OrdersFeatureProvider(this));	
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.graphiti.dt.AbstractDiagramTypeProvider#getDiagramTitle()
	 */
	/*@Override
	public void init(Diagram diagram, IDiagramBehavior diagramBehavior) {
		super.init(diagram, diagramBehavior);
	}
	
	@Override
	public void postInit() {

		super.postInit();
		IDiagramContainer editor = getDiagramBehavior().getDiagramContainer();
		if(editor instanceof DiagramEditor){
			GraphicalViewer graphicalViewer = ((DiagramEditor)editor).getGraphicalViewer();
			OrderTransferDropTargetListener droptransfer = new OrderTransferDropTargetListener(graphicalViewer, ModelTransfer.getInstance());
			graphicalViewer.addDropTargetListener(droptransfer);
		}
		
	}*/
}