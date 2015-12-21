package orders.veditor.dnd;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;

public class OrderTransferDropTargetListener extends  AbstractTransferDropTargetListener{	
	public OrderTransferDropTargetListener(GraphicalViewer viewer) {
		super(viewer, TextTransfer.getInstance());
		setEnablementDeterminedByCommand(true);
	}


	@Override
	protected void handleDrop() {
		super.handleDrop();
		if (getCurrentEvent().detail == DND.DROP_MOVE) {
			getCurrentEvent().detail = DND.DROP_COPY;
		}
		getViewer().getControl().setFocus();
		System.out.print("Hola 1");
	}

	@Override
	protected void updateTargetRequest() {
		((CreateRequest) getTargetRequest()).setLocation(getDropLocation());
		System.out.print("Hola 2");
	}

	@Override
	protected Request createTargetRequest() {
		CreateRequest request = new CreateRequest();

		request.setFactory(new MyCreationFactory());
		request.setLocation(getDropLocation());
		System.out.print("Hola 3");
		return request;
	}

	@Override
	protected void handleDragOver() {

		super.handleDragOver();

		Command command = getCommand();
		if (command != null && command.canExecute())
			getCurrentEvent().detail = DND.DROP_COPY;
		System.out.print("Hola 4");
	}

	private class MyCreationFactory implements CreationFactory {
		public MyCreationFactory() {
		}

		public Object getNewObject() {
			System.out.print("Hola 5");
			return new String("Lo que sea...");
		}

		public Object getObjectType() {
			System.out.print("Hola 6");
			return String.class;
		}
	}
}
