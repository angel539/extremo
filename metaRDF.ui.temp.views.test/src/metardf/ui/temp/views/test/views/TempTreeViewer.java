package metardf.ui.temp.views.test.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
//import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import metardf.ui.dnd.ModelTransfer;

public class TempTreeViewer extends TreeViewer {
	public TempTreeViewer(Composite parent) {
		super(parent);
	}

	public TempTreeViewer(Tree tree) {
		super(tree);
	}

	public TempTreeViewer(Composite parent, int style) {
		super(parent, style);
		
		int operations = DND.DROP_COPY | DND.DROP_MOVE;
		//Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
		Transfer[] transferTypes = new Transfer[]{ModelTransfer.getInstance()};
	    addDropSupport(operations, transferTypes, new TempTreeViewerDropAdapter(this));
	}
}
