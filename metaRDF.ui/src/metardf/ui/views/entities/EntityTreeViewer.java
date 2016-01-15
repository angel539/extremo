package metardf.ui.views.entities;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
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
		//Transfer[] transferTypes = new Transfer[]{ModelTransfer.getInstance()};
		Transfer[] transferTypes = new Transfer[]{ModelTransfer.getInstance()};
		addDragSupport(operations, transferTypes, new EntityDragSourceListener(this));
		
		
		/*DragSource dragSource = new DragSource(getTree(), DND.DROP_COPY);
		dragSource.setTransfer(transferTypes);
		dragSource.addDragListener(new DragSourceListener() {
			@Override
			public void dragStart(DragSourceEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dragSetData(DragSourceEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dragFinished(DragSourceEvent event) {
				// TODO Auto-generated method stub
				
			}
		});*/
	}
}
