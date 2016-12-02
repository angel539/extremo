package uam.extremo.ui.views.searchtree;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Search;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchOption;
import semanticmanager.SearchResult;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.TreeNode;
import uam.extremo.ui.views.Activator;

public class SearchTreeViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if(obj instanceof SearchConfiguration) return Activator.getImageDescriptor("icons/configuration16.png").createImage();
		if(obj instanceof SearchResult) return Activator.getImageDescriptor("icons/result16.png").createImage();
		if(obj instanceof SearchResultOptionValue) return Activator.getImageDescriptor("icons/value16.png").createImage();
		if(obj instanceof SearchOption) return Activator.getImageDescriptor("icons/option16.png").createImage();
		if(obj instanceof SemanticGroup) return Activator.getImageDescriptor("icons/class_set.gif").createImage();
		if(obj instanceof SemanticNode) return Activator.getImageDescriptor("icons/class_obj.png").createImage();
		if(obj instanceof ObjectProperty) return Activator.getImageDescriptor("icons/det_pane_right.gif").createImage();
		if(obj instanceof DataProperty) return Activator.getImageDescriptor("icons/attribute.png").createImage();

		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
	
	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if (element instanceof SearchConfiguration) {
			SearchConfiguration searchConfiguration = (SearchConfiguration) element;
			StyledString styledString = new StyledString(searchConfiguration.getName());
			return styledString;
		}
		
		if (element instanceof SearchResult) {
			SearchResult searchResult = (SearchResult) element;
			StyledString styledString = new StyledString("");
			styledString.append("(" + searchResult.getResources().size() + ") resources applied", StyledString.COUNTER_STYLER);
			styledString.append("(" + searchResult.getResults().size() + ") groups resolved", StyledString.COUNTER_STYLER);
			return styledString;
		}
		
		if (element instanceof SearchResultOptionValue) {
			SearchResultOptionValue searchResultOptionValue = (SearchResultOptionValue) element;
			StyledString styledString = new StyledString(searchResultOptionValue.getOption().getName() + " : " + searchResultOptionValue.getValue());
			return styledString;
		}
		
		if (element instanceof SearchOption) {
			SearchOption searchOption = (SearchOption) element;
			StyledString styledString = new StyledString(searchOption.getType().getLiteral() + " " + searchOption.getName());
			return styledString;
		}
		
		/*if (element instanceof TreeNode) {
			TreeNode treeNode = (TreeNode) element;
			if(treeNode.getKind() == 0){
				StyledString styledString = new StyledString(treeNode.getData().toString());
				styledString.append(" (" + treeNode.getChildren().size() + ") ", StyledString.QUALIFIER_STYLER);
				return styledString;
			}
			if(treeNode.getKind() == 1){
				StyledString styledString = new StyledString(treeNode.getData().toString());
				styledString.append(" (" + treeNode.getChildren().size() + ") ", StyledString.QUALIFIER_STYLER);
				return styledString;
			}
			if(treeNode.getKind() == 2){
				StyledString styledString = new StyledString(treeNode.getData().toString());
				styledString.append(" (" + treeNode.getChildren().size() + ") ", StyledString.QUALIFIER_STYLER);
				return styledString;
			}
			if(treeNode.getKind() == 3){
				StyledString styledString = new StyledString(treeNode.getData().toString());
				return styledString;
			}
		}*/
		
		/*if (element instanceof Repository) {
			Repository repositoryNode = (Repository) element;
			StyledString styledString = new StyledString(repositoryNode.getName());
			
			if (repositoryNode.getResources() != null) {
				styledString.append(" (" + repositoryNode.getResources().size() + ") ", StyledString.COUNTER_STYLER);
			}
			return styledString;
		}
		
		if (element instanceof Resource) {
			StyledString styledString = new StyledString(((Resource) element).getName());
			return styledString;
		}*/
		
		if(element instanceof SemanticGroup){
			SemanticGroup semanticGroup = (SemanticGroup) element;
			StyledString styledString = new StyledString(semanticGroup.getName());
			styledString.append(" (" + semanticGroup.getNodes().size() + ") ", StyledString.QUALIFIER_STYLER);

			return styledString;
		}
		
		if(element instanceof SemanticNode){
			SemanticNode semanticNode = (SemanticNode) element;
			StyledString styledString = new StyledString(semanticNode.getName());
			styledString.append(" (" + semanticNode.getWeight() + ") points", StyledString.COUNTER_STYLER);
			styledString.append(" (" + semanticNode.getProperties().size() + ") properties", StyledString.QUALIFIER_STYLER);

			return styledString;
		}
		
		if(element instanceof DataProperty){
			DataProperty property = (DataProperty) element;
			StyledString styledString = new StyledString(property.getName());
			if(property.getType() != null) styledString.append(" (" + property.getType().getLiteral() + ")", StyledString.QUALIFIER_STYLER);

			return styledString;
		}
		
		if(element instanceof ObjectProperty){
			ObjectProperty property = (ObjectProperty) element;
			StyledString styledString = new StyledString(property.getName());
			if(property.getRange() != null) styledString.append(" (" + property.getRange().getName() + ")", StyledString.QUALIFIER_STYLER);

			return styledString;
		}
		
		return null;
	}
}
