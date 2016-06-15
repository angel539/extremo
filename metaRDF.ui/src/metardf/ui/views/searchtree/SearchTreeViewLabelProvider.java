package metardf.ui.views.searchtree;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;

import java.util.Arrays;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import metardf.ui.Activator;
import metardf.ui.views.searchtree.model.SearchWordTreeParent;
import metardf.ui.views.searchtree.model.StrategyTreeParent;
import metardf.ui.views.searchtree.model.TermTreeObject;
import metardf.ui.views.searchtree.model.WeightTreeObject;

public class SearchTreeViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
	public Image getImage(Object obj) {
		if(obj instanceof IStructuredSelection) obj = ((IStructuredSelection) obj).getFirstElement();
		
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if(obj instanceof SearchWordTreeParent) return Activator.getImageDescriptor("icons/search_property.png").createImage();
		if(obj instanceof TermTreeObject) return Activator.getImageDescriptor("icons/noun.png").createImage();
		if(obj instanceof StrategyTreeParent) return Activator.getImageDescriptor("icons/for_beginner.png").createImage();
		if(obj instanceof WeightTreeObject) return Activator.getImageDescriptor("icons/scales.png").createImage();
		
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
	
	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if (element instanceof SearchWordTreeParent) {
			SearchWordTreeParent searchWord = (SearchWordTreeParent) element;
			StyledString styledString = new StyledString(searchWord.getSearch().getName());
			return styledString;
		}
		
		if (element instanceof TermTreeObject) {
			TermTreeObject term = (TermTreeObject) element;
			StyledString styledString = new StyledString(term.getEntry().getKey());
			styledString.append(" (" + term.getEntry().getValue() + ") ", StyledString.QUALIFIER_STYLER);
			return styledString;
		}
		
		if (element instanceof StrategyTreeParent) {
			StrategyTreeParent strategy = (StrategyTreeParent) element;
			StyledString styledString = new StyledString(strategy.getStrategy());
			return styledString;
		}
		
		if (element instanceof WeightTreeObject) {
			WeightTreeObject weight = (WeightTreeObject) element;
			StyledString styledString = new StyledString(Arrays.toString(weight.getWeights()));
			return styledString;
		}
		
		return null;
	}
}
