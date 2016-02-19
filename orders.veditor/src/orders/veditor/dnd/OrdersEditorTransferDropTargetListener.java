package orders.veditor.dnd;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metardf.ui.dnd.GraphityEditorTransferDropTargetListener;

public class OrdersEditorTransferDropTargetListener extends GraphityEditorTransferDropTargetListener {
	GraphicalViewer graphicalViewer = null;
	
	public OrdersEditorTransferDropTargetListener() {
		super();
		setViewer(getGraphicalViewer());
		getViewer().addDropTargetListener(this);
	}
	
	public OrdersEditorTransferDropTargetListener(GraphicalViewer graphicalViewer) {
		super(graphicalViewer);
		setViewer(getGraphicalViewer());
		getViewer().addDropTargetListener(this);
	}
	
	
	@Override
	public void drop(DropTargetEvent event) {
		super.drop(event);
	}
	
	@Override
	public void dropAccept(DropTargetEvent event) {
		super.dropAccept(event);
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
	
	@Override
	protected void handleDrop() {	
		if(getCurrentEvent().data instanceof ISemanticElement){
			if(getCurrentEvent().data instanceof ISemanticClass){
				System.out.println(">1 " + getCurrentEvent().data.toString());
			}
			if(getCurrentEvent().data instanceof IObjectProperty){
				System.out.println(">2 " + getCurrentEvent().data.toString());
			}
			if(getCurrentEvent().data instanceof IDataProperty){
				System.out.println(">3 " + getCurrentEvent().data.toString());
			}
		}
		
		if(getCurrentEvent().data instanceof ISemanticElement[]){
			ISemanticElement[] semanticElements = (ISemanticElement[]) getCurrentEvent().data;
			for(ISemanticElement semanticElement : semanticElements){
				if(semanticElement instanceof ISemanticClass){
					System.out.println(">a " + getCurrentEvent().data.toString());
				}
				if(semanticElement instanceof IObjectProperty){
					System.out.println(">b " + getCurrentEvent().data.toString());
				}
				if(semanticElement instanceof IDataProperty){
					System.out.println(">c " + getCurrentEvent().data.toString());
				}
				
				System.out.println("la clase es..." + getCurrentEvent().data.toString());
			}
		}
		super.handleDrop();
	}
}
