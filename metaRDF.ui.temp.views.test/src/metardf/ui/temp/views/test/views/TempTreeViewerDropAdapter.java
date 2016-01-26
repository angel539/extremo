package metardf.ui.temp.views.test.views;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
//import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;

public class TempTreeViewerDropAdapter extends ViewerDropAdapter {
	Viewer viewer;
	
	public TempTreeViewerDropAdapter(Viewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
	public boolean performDrop(Object data) {
		System.out.println("drop: " + data.toString() + " " + data.getClass());
		if(data.getClass() == ISemanticClass.class) {
			System.out.println("es instancia de SemanticClass");
			return true;
		}
		if(data instanceof ISemanticClass[]) {
			System.out.println("es instancia de SemanticClass");
			return true;
		}
		if(data.getClass()== IObjectProperty.class) {
			System.out.println("es instancia de Objectproperty");
			return true;
		}
		if(data.getClass()== IDataProperty.class) {
			System.out.println("es instancia de Dataproperty");
			return true;
		}
		System.out.println("No es instancia de ninguno de los anteriores");
		return true;
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		return true;
	}
}
