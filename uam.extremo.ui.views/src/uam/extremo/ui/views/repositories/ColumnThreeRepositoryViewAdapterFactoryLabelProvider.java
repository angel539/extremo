package uam.extremo.ui.views.repositories;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;

import uam.extremo.core.*;

public class ColumnThreeRepositoryViewAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider implements IStyledLabelProvider{
	public ColumnThreeRepositoryViewAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public StyledString getStyledText(Object element) {
		if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
		
		if (element instanceof Repository) {
			Repository repositoryNode = (Repository) element;
			StyledString styledString = new StyledString(repositoryNode.getName());
			return styledString;
		}
		
		if (element instanceof Resource) {
			Resource resourceObject = (Resource) element;
			StyledString styledString = new StyledString((String)resourceObject.getUri());
			
			return styledString;
		}
		
		return new StyledString("");
	}
	
	@Override
	public Image getImage(Object object) {
		return null;
	}
}
