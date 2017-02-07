package uam.extremo.ui.views.extensions.dnd.actions;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

public class ViewPartDropListener extends ViewerDropAdapter{
	private StructuredViewer viewer;
	
	public ViewPartDropListener(StructuredViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
    public void drop(DropTargetEvent event) {
            int location = this.determineLocation(event);
            String target = (String) determineTarget(event);
            String translatedLocation ="";
            switch (location){
            case 1 :
                    translatedLocation = "Dropped before the target ";
                    break;
            case 2 :
                    translatedLocation = "Dropped after the target ";
                    break;
            case 3 :
                    translatedLocation = "Dropped on the target ";
                    break;
            case 4 :
                    translatedLocation = "Dropped into nothing ";
                    break;
            }
            System.out.println(translatedLocation);
            System.out.println("The drop was done on the element: " + target );
            super.drop(event);
    }
	
	// This method performs the actual drop
    // We simply add the String we receive to the model and trigger a refresh of the
    // viewer by calling its setInput method.
    
    @Override
    public boolean performDrop(Object data) {
            //ContentProviderTree.INSTANCE.getModel().add(data.toString());
            //viewer.setInput(ContentProviderTree.INSTANCE.getModel());
    	System.out.println(data);
        return false;
    }
    

    @Override
    public boolean validateDrop(Object target, int operation, TransferData transferType) {
            return true;

    }
}
