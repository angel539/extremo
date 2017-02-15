package uam.extremo.ui.zest.views.inheritance;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.INestedContentProvider;

import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Property;
import semanticmanager.SemanticNode;

public class InheritanceGraphViewPartNodeContentProvider implements IGraphEntityContentProvider, INestedContentProvider {
	public InheritanceGraphViewPartNodeContentProvider() {
		super();
	}
	
	@Override
	public Object[] getConnectedTo(Object node) {
		ArrayList<NamedElement> connections = new ArrayList<NamedElement>();
		
		if(node instanceof SemanticNode){
			SemanticNode semanticNode = (SemanticNode) node;
			
			List<Property> properties = semanticNode.getProperties();
			if (properties != null){
				for(Property property : properties){
					if(property instanceof ObjectProperty){
						connections.add(((ObjectProperty) property).getRange());
					}
				}
			}
		}
		
		return connections.toArray();
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof EObject) {
			return ((EObject) inputElement).eContents().toArray();
		}
		
		return null;
	}
	
	@Override
	public Object [] getChildren(Object parent) {
		if (parent instanceof EObject) {
			Object[] containmentAll = ArrayUtils.addAll(((EObject)parent).eContents().toArray());
			return containmentAll;
		}
		return new Object[0];
	}
	
	@Override
	public boolean hasChildren(Object parent) {
		if (parent instanceof EObject){
			if((((EObject) parent).eContents() == null || ((EObject) parent).eContents().size() == 0)){
				return false;
			}
			else{
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void dispose() {}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		/*if(newInput instanceof NamedElement){
			MessageDialog.openConfirm(null, "Input changed", "New input set to " + ((NamedElement) newInput).getName());
		}*/
	}
}