package metardf.ui.views.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

import metardf.ui.Activator;
import metardf.ui.dnd.GraphityEditorTransferDropTargetListener;
import metardf.ui.dnd.ModelTransfer;
import metardf.ui.dnd.ResourceViewAction;
import metardf.ui.views.entities.filters.EntityFilter;
import metardf.ui.views.entities.filters.EntityWithAttrsFilter;
import metardf.ui.views.entities.filters.ShowAllFilter;
import metardf.ui.views.entities.model.TreeParent;
import metardf.ui.wizards.WordnetLocationWizardDialog;

public class EntityView extends ViewPart {
	public static final String ID = "metardf.ui.views.EntityView";
	private List<String> entities = new ArrayList<String>();

	private TreeViewer viewer;
	private Action wordnetLocation;
	private Action filterEntities;
	private Action filterShowAll;
	private Action filterEntitiesWithAttrs;
	
	private TreeParent invisibleRoot = new TreeParent("");
	
	public TreeParent getRoot() {
		return invisibleRoot;
	}

	public void setRoot(TreeParent root) {
		this.invisibleRoot = root;
	}

	class NameSorter extends ViewerSorter {
	}

	public EntityView() {
	}

	public void createPartControl(Composite parent) {
		
		entities.addAll(Arrays.asList());
		
		PatternFilter filter = new PatternFilter();
		FilteredTree tree = new FilteredTree(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL, filter, true);
		
		//viewer = new EntityTreeViewer(tree);
		viewer = tree.getViewer();
		//viewer = new EntityTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new EntityTreeViewContentProvider(invisibleRoot, getViewSite()));
		viewer.setLabelProvider(new EntityTreeViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "metaRDF.ui.viewer");
		getSite().setSelectionProvider(viewer);
		
		DragSource ds = new DragSource(viewer.getTree(), DND.DROP_COPY);
		ds.setTransfer(new Transfer[] {ModelTransfer.getInstance()});
		ds.addDragListener(new DragSourceAdapter() {
		     public void dragSetData(DragSourceEvent event) {
		    	 IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		    	 if(selection.getFirstElement() instanceof IAdaptable){
		 	    	IAdaptable data = (IAdaptable) selection.getFirstElement();	
		 		    if (ModelTransfer.getInstance().isSupportedType(event.dataType)) {
		 		    	event.data = data;
		 		    }
		 	    }
		    	//event.data = getSelection();
		     }
		  });
		
		defaultFilteringActions();
		invokeActions();
		invokeEditors();
		makeActions();
		contributeToActionBars();	
	}

	private void defaultFilteringActions() {
		filterShowAll = new Action() {
			public void run() {
				ViewerFilter[] filters = {new ShowAllFilter()};
				viewer.setFilters(filters);
				viewer.refresh();
			}
		};
		
		filterShowAll.setText("Show all");
		filterShowAll.setToolTipText("");
		filterShowAll.setImageDescriptor(Activator.getImageDescriptor("icons/alpha_mode.gif"));
		
		filterEntities = new Action() {
			public void run() {
				ViewerFilter[] filters = {new EntityFilter()};
				viewer.setFilters(filters);
				viewer.refresh();
			}
		};
		
		filterEntities.setText("Show main entities only");
		filterEntities.setToolTipText("");
		filterEntities.setImageDescriptor(Activator.getImageDescriptor("icons/filter_top_level.gif"));
		
		filterEntitiesWithAttrs = new Action() {
			public void run() {
				ViewerFilter[] filters = {new EntityWithAttrsFilter()};
				viewer.setFilters(filters);
				viewer.refresh();
			}
		};
		
		filterEntitiesWithAttrs.setText("Show entities with attrs");
		filterEntitiesWithAttrs.setToolTipText("");
		filterEntitiesWithAttrs.setImageDescriptor(Activator.getImageDescriptor("icons/filter_properties.gif"));
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(wordnetLocation);
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(filterShowAll);
		manager.add(filterEntities);
		manager.add(filterEntitiesWithAttrs);
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
					//System.out.println("hemos llegado a la extension..." + extension.getAttribute("class"));
					GraphityEditorTransferDropTargetListener graphityDrop;
					try{
						graphityDrop = (GraphityEditorTransferDropTargetListener) extension.createExecutableExtension("class");
						graphicalViewer.addDropTargetListener(graphityDrop);
					}
					catch(CoreException e){
						//System.out.println("Creating action in editor exception");
					}
				}	
			}
		 }
	}
	
	private void invokeActions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("action")==0){
				ResourceViewAction action;
				try{
					action = (ResourceViewAction) extension.createExecutableExtension("class");
					action.setText(extension.getAttribute("name"));
					action.setToolTipText(extension.getAttribute("description"));
					action.setView(this);
					
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
							MenuManager menuMgr = new MenuManager("#PopupMenu");
							menuMgr.setRemoveAllWhenShown(true);
							menuMgr.addMenuListener(new IMenuListener() {
								public void menuAboutToShow(IMenuManager manager) {
									manager.add(action);
								}
							});
							Menu menu = menuMgr.createContextMenu(viewer.getControl());
							viewer.getControl().setMenu(menu);
							getSite().registerContextMenu(menuMgr, viewer);
						}	
					}
				}
				catch(CoreException e){
				}
			}	
		}
	}

	private void makeActions() {		
		wordnetLocation = new Action() {
			public void run() {
				WizardDialog wizardDialog = new WizardDialog(null, new WordnetLocationWizardDialog());
				wizardDialog.open();
			}
		};
		
		wordnetLocation.setText("Wordnet Location");
		wordnetLocation.setToolTipText("");
		wordnetLocation.setImageDescriptor(Activator.getImageDescriptor("icons/wn.png"));
	}
	
	/*private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Entities",
			message);
	}*/
	


	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public TreeViewer getViewer() {
		return viewer;
	}

	public void setViewer(EntityTreeViewer viewer) {
		this.viewer = viewer;
	}

	public TreeParent getInvisibleRoot() {
		return invisibleRoot;
	}
}
