package uam.extremo.ui.wizards.dialogs.searchnew.treeviewer;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import uam.extremo.ui.wizards.Activator;

public class SearchTableViewer extends TableViewer{
	public SearchTableViewer(Composite parent, List<SemanticNode> semanticNodes) {
		super(parent, SWT.CHECK | SWT.MULTI | SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.BORDER);
		
		final Table table = getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//setLabelProvider(new DelegatingStyledCellLabelProvider(new SearchTreeViewerLabelProvider()));
		//setContentProvider(new SearchTreeViewerContentProvider(root));
		setContentProvider(ArrayContentProvider.getInstance());
		
		// create a column for the first name
		TableViewerColumn colName = new TableViewerColumn(this, SWT.NONE);
		colName.getColumn().setWidth(400);
		colName.getColumn().setText("");
		colName.setLabelProvider(new DelegatingStyledCellLabelProvider(new SearchFirstColumnLabelProvider()));
		
		// create a column for the first name
		TableViewerColumn colDescriptions = new TableViewerColumn(this, SWT.NONE);
		colDescriptions.getColumn().setWidth(40);
		colDescriptions.getColumn().setText("D");
		colDescriptions.setLabelProvider(new DelegatingStyledCellLabelProvider(new SearchSecondColumnLabelProvider()));
		
		TableViewerColumn colProperties = new TableViewerColumn(this, SWT.NONE);
		colProperties.getColumn().setWidth(40);
		colProperties.getColumn().setText("P");
		colProperties.setLabelProvider(new DelegatingStyledCellLabelProvider(new SearchThirdColumnLabelProvider()));
		
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
					return styledString;
				}
				else{
					SemanticNode semanticNode = (SemanticNode) element;
					StyledString styledString = new StyledString(semanticNode.getName() + ":");
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
			// TODO Auto-generated method stub
			
		}
	}
	
	class SearchSecondColumnLabelProvider extends CellLabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();

			if(element instanceof SemanticNode){
				if(((SemanticNode) element).getDescriptor() == null){
					SemanticNode semanticNode = (SemanticNode) element;
					StyledString styledString = new StyledString();
					
					if(semanticNode.getDescribes().size() > 0)
						styledString.append(Integer.toString(semanticNode.getDescribes().size()), StyledString.QUALIFIER_STYLER);
					
					return styledString;
				}
	    	}
			
			return null;
		}

		@Override
		public void update(ViewerCell cell) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Image getImage(Object element) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	class SearchThirdColumnLabelProvider extends CellLabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			if(element instanceof SemanticNode){
				if(((SemanticNode) element).getDescriptor() == null){
					SemanticNode semanticNode = (SemanticNode) element;
					StyledString styledString = new StyledString();
					
					if(semanticNode.getProperties().size() > 0)
						styledString.append(Integer.toString(semanticNode.getProperties().size()), StyledString.QUALIFIER_STYLER);
					
					return styledString;
				}
	    	}
			
			return null;
		}
		
		@Override
		public Image getImage(Object element) {
			return null;
		}

		@Override
		public void update(ViewerCell cell) {
		}
	}
}
