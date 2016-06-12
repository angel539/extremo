package metardf.ui.temp.views.test.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import metardf.ui.dnd.ExtremoModelTransfer;

public class TempTreeViewer extends TreeViewer {
	public TempTreeViewer(Composite parent) {
		super(parent);
	}

	public TempTreeViewer(Tree tree) {
		super(tree);
	}

	public TempTreeViewer(Composite parent, int style) {
		super(parent, style);
		
		//int operations = DND.DROP_COPY | DND.DROP_MOVE;
		//Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
		//Transfer[] transferTypes = new Transfer[]{ModelTransfer.getInstance()};
	    //addDropSupport(operations, transferTypes, new TempTreeViewerDropAdapter(this));
		// Create the drop target on the text field
		/*DropTarget dt = new DropTarget(getTree().getShell(), DND.DROP_COPY);
		dt.setTransfer(new Transfer[] {ModelTransfer.getInstance()});
		dt.addDropListener(new DropTargetAdapter() {
			public void drop(DropTargetEvent event) {
				
				System.out.println(">>>> asdfadsfadsf");
		      }
		   });*/
	}
}
