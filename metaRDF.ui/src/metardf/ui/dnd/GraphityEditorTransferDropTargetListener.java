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
		//super(viewer, ModelTransfer.getInstance());
		super(viewer, ModelTransfer.getInstance());
		setEnablementDeterminedByCommand(true);
		//handleDragOver();
	}
	
	public GraphityEditorTransferDropTargetListener(){
		//super(viewer, ModelTransfer.getInstance());
		super(viewer, TextTransfer.getInstance());
		setEnablementDeterminedByCommand(true);
		//handleDragOver();
	}
	
	public EditPartViewer getViewer() {
		return viewer;
	}

	public void setViewer(EditPartViewer viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public void drop(DropTargetEvent event) {
		System.out.println("hola soy un DROP. si se puede");
		super.drop(event);
	}
	
	@Override
	protected void handleDrop() {
		DropTargetEvent event = getCurrentEvent();
		Object myData = event.data;
		
		if(myData != null){
			System.out.println("hola!!" + getCurrentEvent().data);
			
			if(myData instanceof SemanticClass[]){
				SemanticClass aux = ((SemanticClass[])getCurrentEvent().data)[0];
				factory.setName(aux.getName());
				factory.setUri(aux.getURI());
				System.out.println("¿????");
			}
			else{
				System.out.println("dice que no es instancia");
			}
			
			System.out.println("manejando drop...");
			super.handleDrop();
		}
	}

	@Override
	protected void updateTargetRequest() {
		if(request != null){
			request.setLocation(getDropLocation());
			handleDrop();
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
