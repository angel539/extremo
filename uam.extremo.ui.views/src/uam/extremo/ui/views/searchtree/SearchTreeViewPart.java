package uam.extremo.ui.views.searchtree;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import semanticmanager.util.SemanticmanagerAdapterFactory;
import uam.extremo.extensions.AssistantFactory;

public class SearchTreeViewPart extends ViewPart implements ITabbedPropertySheetPageContributor {
	public static final String ID = "uam.extremo.ui.views.SearchTree";
	
	public static TreeViewer viewer;
	private ExtendedPropertySheetPage propertyPage;
	
	@Override
	public void createPartControl(Composite parent) {
		PatternFilter patternfilter = new PatternFilter();
		FilteredTree tree = new FilteredTree(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL, patternfilter, true);
		
		viewer = tree.getViewer();
		
		//viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		new DrillDownAdapter(viewer);
		
		viewer.setContentProvider(new SearchTreeViewContentProvider(AssistantFactory.getInstance().getRepositoryManager(), getViewSite()));
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new SearchTreeViewLabelProvider()));
		viewer.setInput(getViewSite());
		
		SearchTreeViewFilter filter = new SearchTreeViewFilter();
		ViewerFilter[] filters = {filter};
		viewer.setFilters(filters);
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "extremo.ui.viewer");
		getSite().setSelectionProvider(viewer);
		getViewSite().setSelectionProvider(viewer);
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
		
		EContentAdapter adapter = new EContentAdapter() {
            public void notifyChanged(Notification notification) {
           		 super.notifyChanged(notification);
           		 refresh();
            }
    	};
    	
    	AssistantFactory.getInstance().getRepositoryManager().eAdapters().add(adapter);
    	
    	SearchTreeViewerComparator comparator = new SearchTreeViewerComparator();
		viewer.setComparator(comparator);
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
	
	/*@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IPropertySheetPage.class)
            return new TabbedPropertySheetPage(this);
        return super.getAdapter(adapter);
	}*/
	
	/*
	@Override
	public Object getAdapter(Class adapter) {
		if(adapter.equals(IPropertySheetPage.class)){
			if(propertyPage == null){
				propertyPage = new ExtendedPropertySheetPage(new AdapterFactoryEditingDomain());
				propertyPage.setPropertySourceProvider(new AdapterFactoryContentProvider(new SemanticmanagerAdapterFactory()));
				
				return propertyPage;
			}
		}
		
		return super.getAdapter(adapter);
	}*/
	
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


	@Override
	public String getContributorId() {
		return ID;
	}
}
