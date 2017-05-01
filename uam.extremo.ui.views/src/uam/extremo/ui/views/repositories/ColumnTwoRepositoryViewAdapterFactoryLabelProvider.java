package uam.extremo.ui.views.repositories;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import semanticmanager.Resource;

public class ColumnTwoRepositoryViewAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider implements IStyledLabelProvider{
	public ColumnTwoRepositoryViewAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if (element instanceof Resource) {
			Resource resourceObject = (Resource) element;
			if(resourceObject.getAssistant() != null) return new StyledString(resourceObject.getAssistant());
			else new StyledString("");
		}
		
		return new StyledString("");
	}
	
	@Override
	public Image getImage(Object object) {
		return null;
	}
}
