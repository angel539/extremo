package metardf.ui.views.entities;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import metardf.ui.dnd.ModelTransfer;

public class EntityTreeViewer extends TreeViewer {

	public EntityTreeViewer(Composite parent) {
		super(parent);
	}

	public EntityTreeViewer(Tree tree) {
		super(tree);
	}

	public EntityTreeViewer(Composite parent, int style) {
		super(parent, style);
		
		int operations = DND.DROP_COPY| DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[]{ModelTransfer.getInstance()};
		//Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
		addDragSupport(operations, transferTypes, new EntityDragListener(this));
	}
}
