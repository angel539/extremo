package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;

import semanticmanager.NamedElement;
import semanticmanager.Repository;
import semanticmanager.provider.SemanticmanagerItemProviderAdapterFactory;
import uam.extremo.ui.wizards.dialogs.searchnew.TreeViewAdapterFactoryLabelProvider;

public class RepositoryTreeViewer extends TreeViewer{
	NamedElement namedElement = null;
	protected ComposedAdapterFactory adapterFactory;
	List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
	
	public RepositoryTreeViewer(Composite parent, Repository namedElement) {
		super(parent, SWT.FULL_SELECTION | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL  | SWT.BORDER);

		int operations = DND.DROP_COPY| DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
		addDragSupport(operations, transferTypes , new NamedElementDragListener(this));
		
		TreeViewFilter filter = new TreeViewFilter();
		ViewerFilter[] filters = {filter};
		setFilters(filters);
		
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new SemanticmanagerItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
				
		adapterFactory = new ComposedAdapterFactory(factories);
		
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(adapterFactory);
		setContentProvider(contentProvider);
		setLabelProvider(new DelegatingStyledCellLabelProvider(new TreeViewAdapterFactoryLabelProvider(adapterFactory)));		  
		setInput(namedElement);
		expandAll();
	}
}
