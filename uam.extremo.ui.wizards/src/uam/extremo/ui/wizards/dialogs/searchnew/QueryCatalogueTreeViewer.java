package uam.extremo.ui.wizards.dialogs.searchnew;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.*;
import semanticmanager.provider.SemanticmanagerItemProviderAdapterFactory;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.wizards.Activator;

public class QueryCatalogueTreeViewer extends TreeViewer{
	List<NamedElement> elements = new ArrayList<NamedElement>();
	IStructuredSelection selection = null;
	
	protected ComposedAdapterFactory adapterFactory;
	List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
	
	public QueryCatalogueTreeViewer(Composite parent) {	
		super(parent);
		
		QueryCatalogueTableTreeViewerFilter filter = new QueryCatalogueTableTreeViewerFilter();
		ViewerFilter[] filters = {filter};
		setFilters(filters);
		
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new SemanticmanagerItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		
		adapterFactory = new ComposedAdapterFactory(factories);
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(adapterFactory);
		setContentProvider(contentProvider);
		
		setInput(AssistantFactory.getInstance().getRepositoryManager());
		
		setLabelProvider(new DelegatingStyledCellLabelProvider(new QueryCatalogueTableTreeViewerAdapterFactoryLabelProvider(adapterFactory)));
		setSelection(new StructuredSelection(AssistantFactory.getInstance().getRepositoryManager()), true);
		
		new AdapterFactoryTreeEditor(getTree(), adapterFactory);
	}
	
	class ColumnOneViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			if (element instanceof SearchConfiguration) {
				SearchConfiguration searchConfiguration = (SearchConfiguration) element;
				StyledString styledString = new StyledString(searchConfiguration.getName());
				return styledString;
			}
			
			return null;
		}
		
		@Override
		public Image getImage(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			
			if(element instanceof CustomSearch) return Activator.getImageDescriptor("icons/customsearch.png").createImage();
			if(element instanceof PredicateBasedSearch) return Activator.getImageDescriptor("icons/predicatebasedsearch.png").createImage();
			if(element instanceof CompositeSearchConfiguration) return Activator.getImageDescriptor("icons/compositesearch.png").createImage();

			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
}
