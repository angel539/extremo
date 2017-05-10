package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import semanticmanager.*;

public class DragMetaModelElementViewer extends TreeViewer{
	IStructuredSelection selection = null;
	
	public void addElements(List<NamedElement> elements) {
		Job job = new Job("Printing elements to drag") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
            	if (Display.getCurrent() != null) {
            		setInput(elements);
                	refresh();
        		}
            	else{
        			Display.getDefault().asyncExec(new Runnable() {
                        public void run() {
                        	setInput(elements);
                        	refresh();
                        }
            		});
        		}
                return Status.OK_STATUS;
            }
	    };
	    job.setUser(true);
	    job.schedule();
	}
	
	
	public DragMetaModelElementViewer(Composite parent, List<NamedElement> namedElements) {
		super(parent);

		int operations = DND.DROP_COPY| DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
		addDragSupport(operations, transferTypes , new NamedElementDragListener(this));
		
		TreeViewFilter filter = new TreeViewFilter();
		ViewerFilter[] filters = {filter};
		setFilters(filters);
		
		setContentProvider(ArrayContentProvider.getInstance());
		setLabelProvider(new DelegatingStyledCellLabelProvider(new DragMetamodelElementViewerAdapterFactoryLabelProvider(null)));
		setInput(namedElements);
	}
}
