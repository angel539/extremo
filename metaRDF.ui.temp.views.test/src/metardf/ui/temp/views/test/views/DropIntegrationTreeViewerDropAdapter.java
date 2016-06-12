package metardf.ui.temp.views.test.views;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
//import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;

public class DropIntegrationTreeViewerDropAdapter extends ViewerDropAdapter {
	Viewer viewer;
	
	public DropIntegrationTreeViewerDropAdapter(Viewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
	public boolean performDrop(Object data) {
		if(data != null){
			if(data.getClass() == ISemanticClass.class) {
				System.out.println("es instancia de SemanticClass");
				return true;
			}
			if(data instanceof ISemanticClass[]) {
				System.out.println("es instancia de SemanticClass vectorizada");
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
			
			return false;
		}else{
			System.out.println("no es instancia de nada porque es nulo");
			return false;
		}	
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		return true;
	}
}
