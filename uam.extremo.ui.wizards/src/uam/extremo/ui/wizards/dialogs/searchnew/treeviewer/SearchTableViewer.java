package uam.extremo.ui.wizards.dialogs.searchnew.treeviewer;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import uam.extremo.ui.wizards.Activator;

import semanticmanager.*;

public class SearchTableViewer extends TableViewer{
	public SearchTableViewer(Composite parent, List<NamedElement> semanticNodes) {
		super(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		
		final Table table = getTable();
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		setContentProvider(ArrayContentProvider.getInstance());
		
		TableViewerColumn colName = new TableViewerColumn(this, SWT.NONE);
		colName.getColumn().setWidth(400);
		colName.getColumn().setText("");
		colName.setLabelProvider(new DelegatingStyledCellLabelProvider(new SearchFirstColumnLabelProvider()));
		
		setInput(semanticNodes);
	}

	class SearchFirstColumnLabelProvider extends CellLabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			if (element instanceof Repository) {
				Repository repositoryNode = (Repository) element;
				StyledString styledString = new StyledString(repositoryNode.getName());
				return styledString;
			}
			
			if (element instanceof Resource) {
				StyledString styledString = new StyledString(((Resource) element).getName());
				
				Resource resource = (Resource) element; 
				if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
					styledString.append(" describes (" + ((Resource) element).getDescribes().size() + ")", StyledString.COUNTER_STYLER);
				}
				
				return styledString;
			}
			
			if(element instanceof SemanticNode){
				SemanticNode semanticNode = (SemanticNode) element;
				
				if((semanticNode.getDescriptors() == null) || (semanticNode.getDescriptors().isEmpty())){
					StyledString styledString = new StyledString(semanticNode.getName());
					
					if(semanticNode.getDescribes().size() > 0)
						styledString.append(" describes (" + semanticNode.getDescribes().size() + ")", StyledString.COUNTER_STYLER);
					return styledString;
				}
				else{
					StyledString styledString = new StyledString(semanticNode.getName());
					
					for(NamedElement namedElement : semanticNode.getDescriptors())
						styledString.append(" :" + namedElement.getName(), StyledString.COUNTER_STYLER);
					return styledString;
				}
	    	}
			
			if(element instanceof DataProperty){
				DataProperty dataProperty = (DataProperty) element;
				
				if((dataProperty.getDescriptors() == null) || (dataProperty.getDescriptors().isEmpty())){
					StyledString styledString = new StyledString(dataProperty.getName());
					if(dataProperty.getType() != null) styledString.append(": " + dataProperty.getType().getLiteral(), StyledString.COUNTER_STYLER);
					return styledString;
				}
				else{
					StyledString styledString = new StyledString(dataProperty.getValue());
					
					for(NamedElement namedElement : dataProperty.getDescriptors())
						styledString.append(" :" + namedElement.getName(), StyledString.COUNTER_STYLER);
					
					return styledString;
				}
			}
			
			if(element instanceof ObjectProperty){
				ObjectProperty objectProperty = (ObjectProperty) element;
				
				if((objectProperty.getDescriptors() == null) || (objectProperty.getDescriptors().isEmpty())){
					StyledString styledString = new StyledString(objectProperty.getName());
					if(objectProperty.getRange() != null) styledString.append(" ->" + objectProperty.getRange().getName(), StyledString.COUNTER_STYLER);		
					return styledString;
				}
				else{
					StyledString styledString = new StyledString(objectProperty.getName());
					
					for(NamedElement namedElement : objectProperty.getDescriptors())
						styledString.append(" :" + namedElement.getName(), StyledString.COUNTER_STYLER);
					
					return styledString;
				}
			}
			
			return null;
		}
		
		@Override
		public Image getImage(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			
			if(element instanceof Resource){
				Resource resource = (Resource) element;
				if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
					return Activator.getImageDescriptor("icons/descriptor.png").createImage();
				}
				else{
					if(((Resource) element).isAlive()) return Activator.getImageDescriptor("icons/description_on.png").createImage();
	        		else{
	        			return Activator.getImageDescriptor("icons/description.png").createImage();
	        		}
				}
	    	}
			
			if(element instanceof SemanticNode){
				SemanticNode semanticNode = (SemanticNode) element;
				if((semanticNode.getDescriptors() == null) || (semanticNode.getDescriptors().isEmpty())){
					return Activator.getImageDescriptor("icons/class_obj.png").createImage();
				}
				else{
	        		return Activator.getImageDescriptor("icons/object.png").createImage();
				}
	    	}

			if(element instanceof ObjectProperty) return Activator.getImageDescriptor("icons/det_pane_right.gif").createImage();
			if(element instanceof DataProperty) return Activator.getImageDescriptor("icons/attribute.png").createImage();
        	
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}

		@Override
		public void update(ViewerCell cell) {
		}
	}
}
