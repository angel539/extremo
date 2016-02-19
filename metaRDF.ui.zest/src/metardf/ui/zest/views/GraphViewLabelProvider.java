package metardf.ui.zest.views;

import org.eclipse.jface.viewers.LabelProvider;

import metaRDF.core.model.ISemanticClass;

public class GraphViewLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof ISemanticClass) {
			return ((ISemanticClass) element).getName();
		}
		
		/*if (element instanceof MyConnection) {
			MyConnection myConnection = (MyConnection) element;
			return myConnection.getLabel();
		}
		
		if (element instanceof EntityConnectionData) {
			EntityConnectionData test = (EntityConnectionData) element;
			return "";
		}*/
		
		return null;
	}
}
