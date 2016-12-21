package uam.extremo.ui.views.searchtree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import semanticmanager.provider.SemanticmanagerItemProviderAdapterFactory;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.views.Activator;
import uam.extremo.ui.views.dnd.GraphityEditorTransferDropTargetListener;
import uam.extremo.ui.views.extensions.ExtremoViewPartAction;

public class SearchTreeViewPart extends ViewPart implements IViewerProvider, ISelectionProvider, IEditingDomainProvider, ITabbedPropertySheetPageContributor {
	public static final String ID = "uam.extremo.ui.views.SearchTree";
	
	public static TreeViewer viewer;
	
	protected ISelection editorSelection = StructuredSelection.EMPTY;
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	protected AdapterFactoryEditingDomain editingDomain;
	protected ComposedAdapterFactory adapterFactory;
	protected List<PropertySheetPage> propertySheetPages = new ArrayList<PropertySheetPage>();
	
	@Override
	public void createPartControl(Composite parent) {
		PatternFilter patternfilter = new PatternFilter();
		FilteredTree tree = new FilteredTree(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL, patternfilter, true);
		
		viewer = tree.getViewer();
		
		//viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		new DrillDownAdapter(viewer);
		
		/*ComposedAdapterFactory composedAdapterFactory = 
				   new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(composedAdapterFactory);*/
		
		viewer.setContentProvider(new SearchTreeViewContentProvider(AssistantFactory.getInstance().getRepositoryManager(), getViewSite()));
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new SearchTreeViewLabelProvider()));
				  
		//viewer.setContentProvider(contentProvider);
		//viewer.setLabelProvider(labelProvider);
		viewer.setInput(getViewSite());
		
		SearchTreeViewFilter filter = new SearchTreeViewFilter();
		ViewerFilter[] filters = {filter};
		viewer.setFilters(filters);
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "extremo.ui.viewer");
		
		//connection with properties view
		getSite().setSelectionProvider(viewer);
		getViewSite().setSelectionProvider(viewer);
		
		
		viewer.setSelection(new StructuredSelection(AssistantFactory.getInstance().getRepositoryManager()), true);
		new AdapterFactoryTreeEditor(viewer.getTree(), adapterFactory);
		
		
		invokeActions();
		invokeEditors();
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[]{SemanticNodeModelTransfer.getTransfer()};
		
		DragSource source = new DragSource(viewer.getTree(), dndOperations);
		source.setTransfer(transfers);
		SemanticNodeDragListener listener = new SemanticNodeDragListener(viewer);
		source.addDragListener(listener);
		
    	SearchTreeViewerComparator comparator = new SearchTreeViewerComparator();
		viewer.setComparator(comparator);
		
		
		initializeEditingDomain();
		
		
		EContentAdapter adapter = new EContentAdapter() {
            public void notifyChanged(Notification notification) {
           		 super.notifyChanged(notification);
           		 refresh();
            }
    	};

    	AssistantFactory.getInstance().getRepositoryManager().eAdapters().add(adapter);
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				SearchTreeViewPart.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void makeActions() {
	}
	
	private void fillLocalPullDown(IMenuManager manager) {
	}

	private void fillContextMenu(IMenuManager manager) {
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
	}
	
	private void hookDoubleClickAction() {
	}
	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException(); 
	}
	
	public void refresh() {
		Job job = new Job("Refreshing Search Tree View") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                doLongThing();
                syncWithUi();
                return Status.OK_STATUS;
            }
	    };
	    job.setUser(true);
	    job.schedule();
	}
	
	private void syncWithUi() {
        try {
        	Thread.sleep(100);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
	}

	private void doLongThing() {
		Display.getDefault().asyncExec(new Runnable() {
            public void run() {
            	   viewer.setInput(AssistantFactory.getInstance().getRepositoryManager());
            }
		});
	}
	
	static public EditingDomain getEditingDomainFor(EObject object){
		Resource resource = object.eResource();
		if (resource != null){
			IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) EcoreUtil.getExistingAdapter(resource,IEditingDomainProvider.class);
			
			if (editingDomainProvider != null){
				return editingDomainProvider.getEditingDomain();
			}
			else{
				ResourceSet resourceSet = resource.getResourceSet();
				if (resourceSet instanceof IEditingDomainProvider){
					EditingDomain editingDomain =
							((IEditingDomainProvider)resourceSet).getEditingDomain();
					return editingDomain;
				}
				else if (resourceSet != null){
					editingDomainProvider = (IEditingDomainProvider) EcoreUtil.getExistingAdapter(resourceSet, IEditingDomainProvider.class);
					if (editingDomainProvider != null){
						return editingDomainProvider.getEditingDomain();
					}
				}
			}
		}
		return null;
	}

	private void invokeEditors(){
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IEditorPart editor = window.getActivePage().getActiveEditor();
		
		if (editor instanceof IDiagramContainerUI){
			IDiagramContainerUI diagramEditor =  (IDiagramContainerUI) editor;
			GraphicalViewer graphicalViewer = diagramEditor.getGraphicalViewer();

			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.EDITOR_EXTENSIONS_ID);
			
			for(IConfigurationElement extension : extensions){
				if(extension.getName().compareTo("editordrop") == 0){
					GraphityEditorTransferDropTargetListener graphityDrop;
					try{
						graphityDrop = (GraphityEditorTransferDropTargetListener) extension.createExecutableExtension("class");
						graphicalViewer.addDropTargetListener(graphityDrop);
					}
					catch(CoreException e){
					}
				}	
			}
		 }
	}
	
	private void invokeActions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.ACTION_EXTENSIONS_ID);
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("action")==0){
				ExtremoViewPartAction action;
				try{
					action = (ExtremoViewPartAction) extension.createExecutableExtension("class");
					action.setText(extension.getAttribute("name"));
					action.setToolTipText(extension.getAttribute("description"));
					action.setEditorID(extension.getAttribute("editorId"));
					action.setViewer(viewer);
					
					String namespace = extension.getDeclaringExtension().getNamespaceIdentifier();
					
					ImageDescriptor descriptor = null;
					while((descriptor == null) && (!namespace.isEmpty())){
						descriptor = Activator.getImageDescriptor(namespace, extension.getAttribute("icon"));
						
						if(descriptor == null){
							if(namespace.contains(".")){
								namespace = namespace.substring(0, namespace.lastIndexOf("."));
							}
							else{
								namespace = "";
							}
						}
					}
					
					if(descriptor != null) action.setImageDescriptor(descriptor);
					
					if((action != null) && (extension.getAttribute("view")).equals("entities")){
						IActionBars bars = getViewSite().getActionBars();
						if(extension.getAttribute("position").equals("toolbar")){
							bars.getToolBarManager().add(action);
						}
						if(extension.getAttribute("position").equals("menumanager")){
							
							
							menuMgr.addMenuListener(new IMenuListener() {
								public void menuAboutToShow(IMenuManager manager) {
									manager.add(action);
								}
							});
							
						}
					}
				}
				catch(CoreException e){
				}
			}	
		}
		
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}
	
	@Override
	public String getContributorId() {
		return ID;
	}
	
	//ISelectionProvider
    
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	@Override
	public ISelection getSelection() {
		return editorSelection;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
	}

	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	protected void initializeEditingDomain() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SemanticmanagerItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, null);
	}
	
	public IPropertySheetPage getPropertySheetPage() {
		PropertySheetPage propertySheetPage =
			new ExtendedPropertySheetPage(editingDomain) {
				@Override
				public void setSelectionToViewer(List<?> selection) {
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
				}
			};
		propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
		propertySheetPages.add(propertySheetPage);

		return propertySheetPage;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		else {
			return super.getAdapter(key);
		}
	}

	@Override
	public Viewer getViewer() {
		return viewer;
	}
}
