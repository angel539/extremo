package orders.veditor.dnd;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import metardf.ui.dnd.GraphityEditorTransferDropTargetListener;

public class OrdersEditorTransferDropTargetListener extends GraphityEditorTransferDropTargetListener {
	GraphicalViewer graphicalViewer = null;
	
	public OrdersEditorTransferDropTargetListener() {
		super();
		setViewer(getGraphicalViewer());
		getViewer().addDropTargetListener(this);
	}

	@Override
	public void setGraphicalViewer(GraphicalViewer viewer) {
		this.graphicalViewer = viewer;
	}

	@Override
	public GraphicalViewer getGraphicalViewer() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IEditorPart editor = window.getActivePage().getActiveEditor();
		
		IDiagramContainerUI diagramEditor =  (IDiagramContainerUI) editor;
		return diagramEditor.getGraphicalViewer();
	}
	
	@Override
	public void validate() {
		
	}

	@Override
	public void addElement() {
		
	}
}
