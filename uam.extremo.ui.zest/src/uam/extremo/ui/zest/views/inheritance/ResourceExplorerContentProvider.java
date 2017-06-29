package uam.extremo.ui.zest.views.inheritance;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityRelationshipContentProvider;
import org.eclipse.zest.core.viewers.INestedContentProvider;

import semanticmanager.*;

public class ResourceExplorerContentProvider implements IGraphEntityRelationshipContentProvider, INestedContentProvider {
	public ResourceExplorerContentProvider() {
		super();
	}

	public Object[] getElements(Object inputElement) {		
		ArrayList<Object> results = new ArrayList<Object>();
		
		if (inputElement instanceof RepositoryManager) {
			RepositoryManager repositoryManager = (RepositoryManager) inputElement;
			repositoryManager.eAllContents().forEachRemaining(
				element -> {
					if (element instanceof SemanticNode) {
						SemanticNode semanticNode = (SemanticNode) element;
						results.add(semanticNode);
					}
				}
			);
		}
		
		return results.toArray();
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
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getRelationships(Object source, Object dest) {
		Collection<ObjectProperty> results = new ArrayList<ObjectProperty>();
		
		if (source instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) source;
			for(Property property : semanticNode.getProperties()){
				if (property instanceof ObjectProperty) {
					ObjectProperty objectProperty = (ObjectProperty) property;
					
					if(objectProperty.getRange() == dest){
						results.add(objectProperty);
					}
				}
			}	
		}

		return results.toArray();
	}
}