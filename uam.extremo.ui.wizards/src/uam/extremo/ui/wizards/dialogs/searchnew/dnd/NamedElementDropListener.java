package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import semanticmanager.NamedElement;
import semanticmanager.Resource;

public class NamedElementDropListener extends ViewerDropAdapter {
	private final DropMetaModelElementTableTreeViewer viewer;
	private List<Resource> resources = null;
	
	protected NamedElementDropListener(DropMetaModelElementTableTreeViewer viewer, List<Resource> resources) {
		super(viewer);
		this.viewer = viewer;
		this.resources = resources;
	}

	@Override
	public boolean validateDrop(Object target, int operation,
			TransferData transferType) {
		return true;
	}

	 @Override
	 public void drop(DropTargetEvent event) {
	    int location = this.determineLocation(event);
	    String target = (String) determineTarget(event);
	    String translatedLocation = "";
	    
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
	    
	    super.drop(event);
	 }
	 
	 @Override
	 public boolean performDrop(Object data) {
		 for(NamedElement resource : resources){
			 NamedElement element = search(resource, data);
			 
			 if(element != null){
				 viewer.add(element);
				 return true;
			 }
		 }
		 
		 return false;
	 }
	 
    private NamedElement search(NamedElement node, Object data){
    	NamedElement found = null;
    	
		if(node.getName().equals(data)){
           found = node;
        }
		else {
			for(EObject content : node.eContents()){
				if(content instanceof NamedElement){
					found = search((NamedElement) content, data);
					
					if(found != null) break;
				}	
			}
         }
    	
        return found;
    } 
}
