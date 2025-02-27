package uam.extremo.ui.viz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityRelationshipContentProvider;
import org.eclipse.zest.core.viewers.INestedContentProvider;

import semanticmanager.*;

public class ResourceExplorerContentProvider implements 
		IGraphEntityRelationshipContentProvider, 
		INestedContentProvider{
	
	public ResourceExplorerContentProvider() {
		super();
	}

	public Object[] getElements(Object inputElement) {
		if(inputElement == null)
				return new Object[]{};
		
		ArrayList<Object> results = new ArrayList<Object>();
		
		if (inputElement instanceof Resource) {
			Resource repositoryManager = (Resource) inputElement;
			
			EcoreUtil.getAllProperContents((EObject) repositoryManager, true).forEachRemaining(
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
	public boolean hasChildren(Object element) {
		if (element instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) element;
			
			List<DataProperty> properties = 
									semanticNode.getProperties()
										.stream().filter(e -> e instanceof DataProperty)
										.map(e -> (DataProperty) e)
										.collect(Collectors.toList());
			
			if(!properties.isEmpty()) return true;
			return false;
		}
		
		return false;
	}

	@Override
	public Object[] getChildren(Object element) {
		if (element instanceof SemanticNode) {
			SemanticNode semanticNode = (SemanticNode) element;
			
			List<DataProperty> properties = 
					semanticNode.getProperties()
						.stream().filter(e -> e instanceof DataProperty)
						.map(e -> (DataProperty) e)
						.collect(Collectors.toList());
			
			return properties.toArray(new DataProperty[properties.size()]);
		}
		return new Object[0];
	}
	
	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getRelationships(Object source, Object dest) {
		if(source == null || dest == null){
			return new Object[] {};
		}
		
		Collection<ObjectProperty> results = new ArrayList<ObjectProperty>();
		
		/*if(source instanceof SemanticNode){
			((SemanticNode) source).getProperties().stream().
							filter(e -> e instanceof ObjectProperty && ((ObjectProperty) e).getRange().equals(dest)).get();
		}*/
		
		
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