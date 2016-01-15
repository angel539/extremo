package metardf.ui.dnd;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;

import metaRDF.core.model.impl.SemanticClass;

public abstract class GraphityEditorTransferDropTargetListener extends  AbstractTransferDropTargetListener implements IGraphityEditorContribution{	
	protected static EditPartViewer viewer = null;
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

	public void setViewer(EditPartViewer viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public void drop(DropTargetEvent event) {
		super.drop(event);
	}
	
	@Override
	protected void handleDrop() {
		System.out.println("Paso por handle drop" + getCurrentEvent().data.getClass());
		
		//String s = ((String)getCurrentEvent().data);
		//System.out.println("Paso"+s);
		//String separator = System.getProperty("file.separator"); 
		//s = s.substring(s.lastIndexOf(separator) + 1); 
		//factory.setName(s); 
		super.handleDrop();
	}

	@Override
	protected void updateTargetRequest() {
		if(request != null){
			request.setLocation(getDropLocation());
			//handleDrop();
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
		// TODO Auto-generated method stub
		super.dropAccept(event);
	}
	
	@Override
	public boolean isEnabled(DropTargetEvent event) {
		// TODO Auto-generated method stub
		return true;
	}
}
