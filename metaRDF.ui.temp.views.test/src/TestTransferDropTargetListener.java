import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.swt.dnd.Transfer;


public class TestTransferDropTargetListener extends AbstractTransferDropTargetListener {

	public TestTransferDropTargetListener(EditPartViewer viewer) {
		super(viewer);
	}

	@Override
	protected void updateTargetRequest() {
		// TODO Auto-generated method stub
		
	}

	public TestTransferDropTargetListener(EditPartViewer viewer, Transfer xfer) {
		super(viewer, xfer);
		// TODO Auto-generated constructor stub
	}
	
	
}
