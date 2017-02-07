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

import semanticmanager.NamedElement;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import uam.extremo.ui.wizards.Activator;

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
				return styledString;
			}
			
			if(element instanceof SemanticNode){
				if(((SemanticNode) element).getDescriptor() == null){
					SemanticNode semanticNode = (SemanticNode) element;
					StyledString styledString = new StyledString(semanticNode.getName());
					
					if(semanticNode.getDescribes().size() > 0)
						styledString.append(" describes " + Integer.toString(semanticNode.getDescribes().size()), StyledString.QUALIFIER_STYLER);
					
					return styledString;
				}
				else{
					SemanticNode semanticNode = (SemanticNode) element;
					StyledString styledString = new StyledString(semanticNode.getName() + ": ");
					styledString.append(semanticNode.getDescriptor().getName(), StyledString.QUALIFIER_STYLER);

					return styledString;
				}
	    	}
			
			return null;
		}
		
		@Override
		public Image getImage(Object element) {			
			if(element instanceof SemanticNode){
				if(((SemanticNode) element).getDescriptor() == null){
					return Activator.getImageDescriptor("icons/class_obj.png").createImage();
				}
				else{
	        		return Activator.getImageDescriptor("icons/objects16.png").createImage();
				}
	    	}
			
			return null;
		}

		@Override
		public void update(ViewerCell cell) {
		}
	}
}
