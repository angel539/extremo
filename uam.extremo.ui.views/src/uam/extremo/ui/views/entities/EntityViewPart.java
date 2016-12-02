package uam.extremo.ui.views.entities;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.views.Activator;
import uam.extremo.ui.views.dnd.GraphityEditorTransferDropTargetListener;
import uam.extremo.ui.views.extensions.ExtremoViewPartAction;

public class EntityViewPart extends ViewPart implements ITabbedPropertySheetPageContributor{
	public static final String ID = "uam.extremo.ui.views.EntityView";
	private static TreeViewer viewer;

	public void createPartControl(Composite parent) {
		/*
		PatternFilter patternfilter = new PatternFilter();
		FilteredTree tree = new FilteredTree(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL, patternfilter, true);*/
		
		//viewer = tree.getViewer();
		
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		//new DrillDownAdapter(viewer);
		
		viewer.setContentProvider(new EntityViewContentProvider(AssistantFactory.getInstance().getRepositoryManager(), getViewSite()));
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new EntityViewLabelProvider()));
		viewer.setInput(getViewSite());
		viewer.getTree().setHeaderVisible(true);
		
		EntityTreeViewFilter filter = new EntityTreeViewFilter();
		ViewerFilter[] filters = {filter};
		viewer.setFilters(filters);
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "extremo.ui.viewer");
		getSite().setSelectionProvider(viewer);
		
		invokeActions();
		invokeFilters();
		invokeEditors();
		makeActions();
		hookDoubleClickAction();
		contributeToActionBars();

		/*int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[]{ExtremoModelTransfer.getTransfer()};
		
		DragSource source = new DragSource(viewer.getTree(), dndOperations);
		source.setTransfer(transfers);
		EntityDragListener listener = new EntityDragListener(viewer);
		source.addDragListener(listener);*/
		
		EContentAdapter adapter = new EContentAdapter() {
            public void notifyChanged(Notification notification) {
           		 super.notifyChanged(notification);
           		 refresh();
            }
    	};
    	
    	AssistantFactory.getInstance().getRepositoryManager().eAdapters().add(adapter);
	}
	
	public void refresh() {
		Job job = new Job("Refreshing Entity Tree View") {
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


	private void invokeFilters() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.FILTER_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("filter")==0){
				ViewerFilter filter;
				try{
					filter = (ViewerFilter) extension.createExecutableExtension("class");
					
					if((filter != null) && (extension.getAttribute("view")).equals("entities")){
						Action extensionFilterAction = new Action() {
							public void run() {
								ViewerFilter[] filters = {filter};
								viewer.setFilters(filters);
								viewer.refresh();
							}
						};
						
						extensionFilterAction.setText(extension.getAttribute("name"));
						extensionFilterAction.setToolTipText(extension.getAttribute("description"));
						
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
						
						if(descriptor != null) extensionFilterAction.setImageDescriptor(descriptor);
						
						IActionBars bars = getViewSite().getActionBars();
						bars.getMenuManager().add(extensionFilterAction);
					}
				}
				catch(CoreException e){
				}
			}	
		}
	}
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		//manager.add(searchAction);
	}
	
	private void hookDoubleClickAction() {
		/*viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				expandAction.run();
			}
		});*/
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

	private void makeActions() {
		/*
		expandAction = new Action(){
			public void run(){
				executeExpandAction();
			}
		};
		expandAction.setText("Expand");
		expandAction.setToolTipText("");
		expandAction.setImageDescriptor(Activator.getImageDescriptor("icons/details_view.gif"));
		*/
	}
	
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	/*private void executeExpandAction() {
		ISelection selection = viewer.getSelection();
		Object obj = ((IStructuredSelection)selection).getFirstElement();
		
		if(obj instanceof SemanticNode){
				RepositoryManager repositoryManager = AssistantFactory.getInstance().getRepositoryManager();
				List<IFormatAssistant> assistances = AssistantFactory.getInstance().getAssistances();
				
				for(Repository repository : repositoryManager.getRepositories()){    
					for(Resource resource : repository.getResources()){
						if(resource instanceof Resource){			
							for(IFormatAssistant assistant : assistances){
								if((resource.isAlive()) && (resource.getAssistant() != null)){
									if(((FormatAssistant)assistant).getNameExtension().compareTo(resource.getAssistant())==0){
										if((resource instanceof Resource) && (assistant.load((Resource) resource))){	
											AssistantFactory.completeSemanticClassProperties(assistant, (SemanticNode)((SemanticClassTreeParent) obj).getSemanticElement());
										}
									}
								}
							}
						}	
					}		
				}
		}
	}*/

	/*private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Entities",
			message);
	}*/
	
	/*private boolean isOnTheTree(SemanticClassTreeParent obj){
		boolean onTheTree = false;
		Object element = obj;
		
		while((((TreeParent) element).getParent() != getRoot()) && (!onTheTree)){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof SemanticClassTreeParent) && (child!=obj)){
				}
			}
			element = ((TreeParent) element).getParent();
		}
		
		if(((TreeParent)element).getParent() == getRoot()){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof SemanticClassTreeParent) && (child!=obj)){
					if(((String) ((SemanticClassTreeParent) child).getSemanticElement().getId()).compareTo((String) ((SemanticClassTreeParent) obj).getSemanticElement().getId())==0){
						onTheTree = true;
					}
				}		
			}
		}
		
		return onTheTree;
	}*/
	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IPropertySheetPage.class)
            return new TabbedPropertySheetPage(this);
        return super.getAdapter(adapter);
	}
	

	@Override
	public String getContributorId() {
		return ID;
	}
}
