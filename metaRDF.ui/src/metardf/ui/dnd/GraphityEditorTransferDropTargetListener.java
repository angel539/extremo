package metardf.ui.dnd;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Point;

public abstract class GraphityEditorTransferDropTargetListener extends  AbstractTransferDropTargetListener implements IGraphityEditorContribution{	
	private static EditPartViewer viewer = null;
	private SemanticElementCreationFactory factory = new SemanticElementCreationFactory();
	private CreateRequest request = null;
	
	public GraphityEditorTransferDropTargetListener(GraphicalViewer viewer) {
		super(viewer, ModelTransfer.getInstance());
		setEnablementDeterminedByCommand(true);
	}
	
	public GraphityEditorTransferDropTargetListener(){
		super(viewer, ModelTransfer.getInstance());
		setEnablementDeterminedByCommand(true);
	}
	
	public EditPartViewer getViewer() {
		return viewer;
	}

	@SuppressWarnings("static-access")
	public void setViewer(EditPartViewer viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public void drop(DropTargetEvent event) {
		super.drop(event);
	}
	
	@Override
	protected void handleDrop() {
		super.handleDrop();
	}

	@Override
	protected void updateTargetRequest() {
		if(request != null){
			request.setLocation(getDropLocation());
		}
	}

	@Override
	protected Request createTargetRequest() {
		if(request == null){
			request = new CreateRequest();
			request.setFactory(factory);
			handleDragOver();
		}
		
		return request;
	}

	@Override
	protected void handleDragOver() {
		getCurrentEvent().detail = DND.DROP_COPY;
		super.handleDragOver();
	}
	
	@Override
	public void dropAccept(DropTargetEvent event) {
		super.dropAccept(event);
	}
	
	@Override
	public boolean isEnabled(DropTargetEvent event) {
		return true;
	}
	

	public Point getControlPoint(){
		DropTargetEvent event = getCurrentEvent();
		DropTarget w = (DropTarget)event.widget;
		int x = getCurrentEvent().x;
		int y = getCurrentEvent().y;
		final Point point = w.getControl().toControl(x, y);
		return point;
	}
}
