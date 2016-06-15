package metardf.ui.wizards.group;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;

public class MyDragListener implements DragSourceListener {

	  private final TreeViewer viewer;

	  public MyDragListener(TreeViewer viewer) {
	    this.viewer = viewer;
	  }

	  @Override
	  public void dragFinished(DragSourceEvent event) {
	  }

	  @Override
	  public void dragSetData(DragSourceEvent event) {
	    ITreeSelection selection = (ITreeSelection) viewer
	    .getSelection();
	    
	    TreePath[] treePath = selection.getPathsFor(selection.getFirstElement());
	    
	    if (treePath[0].getSegmentCount()>0){
		    event.data = ((ENamedElement)treePath[0].getSegment(0)).getName().toString();
		    if (treePath[0].getSegmentCount()>1)
		    	event.data += "/"+((ENamedElement)treePath[0].getSegment(1)).getName().toString();
	    }
	   
	  }

	  @Override
	  public void dragStart(DragSourceEvent event) {
	  }
}
