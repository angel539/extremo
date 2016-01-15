package orders.veditor.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import orders.veditor.dnd.OrdersEditorTransferDropTargetListener;

public class OrdersDiagramTypeProvider extends AbstractDiagramTypeProvider {
	public OrdersDiagramTypeProvider() {
		super();
		setFeatureProvider(new OrdersFeatureProvider(this));
		//System.out.println("el behaviour " + getDiagramBehavior().getClass() + "   __ " + getDiagramBehavior().toString());
		//getDiagramBehavior().getDiagramContainer().
	}
	
	@Override
	public void postInit() {
		/*System.out.println("el behaviour " + getDiagramBehavior().getClass() + "   __ " + getDiagramBehavior().toString());
		Object diagramBehaviour = getDiagramBehavior();
		if(diagramBehaviour instanceof DiagramBehavior){
			System.out.println(".... claro que es instancia!");
			GraphicalViewer graphicalViewer = ((DiagramBehavior) diagramBehaviour).getDiagramContainer().getGraphicalViewer();
			OrdersEditorTransferDropTargetListener dtl = new OrdersEditorTransferDropTargetListener(graphicalViewer);
			graphicalViewer.addDropTargetListener(dtl);
			System.out.println("adsf");
		}else{
			System.out.println("No es instancia");
		}*/
		
		/*IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IEditorPart editor = window.getActivePage().getActiveEditor();
		
		IDiagramContainerUI diagramEditor =  (IDiagramContainerUI) editor;
		
		diagramEditor.getGraphicalViewer().addDropTargetListener(new OrdersEditorTransferDropTargetListener(diagramEditor.getGraphicalViewer()));
		
		super.postInit();*/
		
	}
	
	/*@Override
	public void init(Diagram diagram, IDiagramBehavior diagramBehavior) {
		if(diagramBehavior instanceof DiagramBehavior){
			System.out.println(".... claro que es instancia!");
			GraphicalViewer graphicalViewer = ((DiagramBehavior) diagramBehavior).getDiagramContainer().getGraphicalViewer();
			OrdersEditorTransferDropTargetListener dtl = new OrdersEditorTransferDropTargetListener(graphicalViewer);
			graphicalViewer.addDropTargetListener(dtl);
			System.out.println("adsf");
		}else{
			System.out.println("No es instancia");
		}
		super.init(diagram, diagramBehavior);
	}*/
	/*@Override
	public void postInit() {
		//getDiagramBehavior().get
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IEditorPart editor = window.getActivePage().getActiveEditor();
		
		IDiagramContainerUI diagramEditor =  (IDiagramContainerUI) editor;
		
		diagramEditor.getGraphicalViewer().addDropTargetListener(new OrdersEditorTransferDropTargetListener(diagramEditor.getGraphicalViewer()));
		super.postInit();	
	}*/
}
