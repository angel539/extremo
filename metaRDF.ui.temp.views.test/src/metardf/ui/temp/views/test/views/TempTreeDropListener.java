package metardf.ui.temp.views.test.views;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;


public class TempTreeDropListener extends ViewerDropAdapter {
	Viewer viewer;
	
	public TempTreeDropListener(Viewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
	public boolean performDrop(Object data) {
		System.out.println("drop: " + data.toString() + " " + data.getClass());
		return true;
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		// TODO Auto-generated method stub
		return true;
	}
}
