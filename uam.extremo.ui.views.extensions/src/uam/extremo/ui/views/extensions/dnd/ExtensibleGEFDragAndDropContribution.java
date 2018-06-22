package uam.extremo.ui.views.extensions.dnd;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.graphics.Point;

public abstract class ExtensibleGEFDragAndDropContribution 
							extends  AbstractTransferDropTargetListener 
									implements IExtensibleGEFDragAndDropContribution{
	private static EditPartViewer viewer = null;
	private NamedElementLabelFactory factory = new NamedElementLabelFactory();
	
	public ExtensibleGEFDragAndDropContribution(GraphicalViewer viewer) {
		super(viewer, TextTransfer.getInstance());
		setEnablementDeterminedByCommand(true);
	}
	
	public ExtensibleGEFDragAndDropContribution(){
		super(viewer, TextTransfer.getInstance());
		setEnablementDeterminedByCommand(true);
	}
	
	protected Request createTargetRequest() {
		CreateRequest request = new CreateRequest();
		request.setFactory(factory);
		return request;
	}
	
	protected void updateTargetRequest() {
		((CreateRequest)getTargetRequest()).setLocation(getDropLocation());
	}
	
	protected void handleDragOver() {
		getCurrentEvent().detail = DND.DROP_COPY;
		super.handleDragOver();
	}
	
	protected void handleDrop() {
		String s = ((String[]) getCurrentEvent().data)[0];
		factory.setText(s);
		super.handleDrop();
	}

	/*public EditPartViewer getViewer() {
		return viewer;
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
	}*/

	public Point getControlPoint(){
		DropTargetEvent event = getCurrentEvent();
		DropTarget w = (DropTarget) event.widget;
		int x = getCurrentEvent().x;
		int y = getCurrentEvent().y;
		final Point point = w.getControl().toControl(x, y);
		return point;
	}
}
