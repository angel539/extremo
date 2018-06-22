package uam.extremo.ui.views.draganddrop;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;

import semanticmanager.NamedElement;
import uam.extremo.ui.views.extensions.dnd.DraggableNamedElementTransfer;

public class ViewPartViewerDropAdapter extends DropTargetAdapter{
		public ViewPartViewerDropAdapter(TreeViewer viewer) {
			DropTarget target = new DropTarget(viewer.getControl(), DND.DROP_MOVE | DND.DROP_COPY);
			target.setTransfer(new Transfer[] {
		            DraggableNamedElementTransfer.getTransfer()});
			target.addDropListener(this);
		}

	   public void dragEnter(DropTargetEvent event) {
	      if (event.detail == DND.DROP_MOVE
	            || event.detail == DND.DROP_DEFAULT) {
	         if ((event.operations & DND.DROP_COPY) != 0)
	            event.detail = DND.DROP_COPY;
	         else
	            event.detail = DND.DROP_NONE;
	      }
	   }

	   public void drop(DropTargetEvent event) {
	      if (DraggableNamedElementTransfer.getTransfer().isSupportedType(
	            event.currentDataType)
	            && (event.data instanceof NamedElement[])) {
	    	  event.detail = DND.DROP_COPY;
	      }
	      else
	    	  event.detail = DND.DROP_NONE;
	   }
}
