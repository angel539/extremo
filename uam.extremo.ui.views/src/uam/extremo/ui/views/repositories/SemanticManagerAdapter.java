package uam.extremo.ui.views.repositories;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;

public class SemanticManagerAdapter extends AdapterImpl {
	private TreeViewer viewer = null;
	
	public SemanticManagerAdapter(TreeViewer viewer) {
		super();
		this.viewer = viewer;
	}
	
	@Override
	public void notifyChanged(Notification msg) {
		refresh(msg);
		super.notifyChanged(msg);
		
	}
	
	private void refresh(Notification notification) {
		// If this is the UI thread, then make the change.
		if (Display.getCurrent() != null) {
			updateViewer(notification);
			return;
		}
		
		// otherwise, redirect to execute on the UI thread.
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				updateViewer(notification);
			}
		});
	}

	private void updateViewer(Notification notification) {
		viewer.getTree().setRedraw(false);
		if(notification.getNotifier() instanceof EObject){
			EObject notifier = (EObject) notification.getNotifier();
			try {
				viewer.refresh(notifier);
			}
			finally {
				viewer.getTree().setRedraw(true);
			}
		}
	}
}
