package uam.extremo.ui.extensions.integration;

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

import uam.extremo.ui.extensions.dnd.NamedElementLabelFactory;

public abstract class ExtensibleGEFDragAndDropContribution 
							extends  AbstractTransferDropTargetListener{
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

	public Point getControlPoint(){
		DropTargetEvent event = getCurrentEvent();
		DropTarget w = (DropTarget) event.widget;
		int x = getCurrentEvent().x;
		int y = getCurrentEvent().y;
		final Point point = w.getControl().toControl(x, y);
		return point;
	}
	
	public abstract GraphicalViewer getGraphicalViewer();
}
