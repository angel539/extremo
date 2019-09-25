package uam.extremo.ui.extensions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import uam.extremo.ui.extensions.dnd.ViewPartDropListener;

public abstract class ViewPartAction extends Action{
	private static String viewPartTargetId;
	
	public ViewPartAction(){}
	
	@Override
	public final void run(){
		setCurrentEditorPart();
		//I do not understand why i am using this class here
		//execute(editorPart, viewer.getSelection(), viewPartTargetId);
	}
	
	private static void setCurrentEditorPart(){		
		IWorkbench workbench = PlatformUI.getWorkbench();
		IViewPart part = workbench.getActiveWorkbenchWindow().getActivePage().findView(viewPartTargetId);
		
		if (part instanceof StructuredViewer) {
			StructuredViewer structuredViewer = (StructuredViewer) part;
			
			int operations = DND.DROP_COPY | DND.DROP_MOVE;
            Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
            
            structuredViewer.addDropSupport(operations, transferTypes, new ViewPartDropListener(structuredViewer));
		}		
	}
}
