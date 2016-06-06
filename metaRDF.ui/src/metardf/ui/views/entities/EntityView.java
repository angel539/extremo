package metardf.ui.views.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
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
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import metaRDF.core.model.IRepository;
import metaRDF.core.model.IResource;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.ProbabilisticDistribution;
import metaRDF.core.model.impl.RepositoryManager;
import metaRDF.core.model.impl.Search;
import metaRDF.core.model.impl.SemanticClass;
import metaRDF.core.model.impl.SemanticResource;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;
import metardf.ui.Activator;
import metardf.ui.dnd.GraphityEditorTransferDropTargetListener;
import metardf.ui.dnd.ModelTransfer;
import metardf.ui.dnd.ResourceViewAction;
import metardf.ui.views.entities.filters.EntityFilter;
import metardf.ui.views.entities.filters.ShowAllFilter;
import metardf.ui.views.entities.model.DataPropertyObject;
import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.EntityParentGroup;
import metardf.ui.views.entities.model.PropertyParent;
import metardf.ui.views.entities.model.SearchParent;
import metardf.ui.views.entities.model.TreeObject;
import metardf.ui.views.entities.model.TreeParent;
import metardf.ui.wizards.SearchEntityWizardDialog;
import metardf.ui.wizards.semanticselector.EntityGroupSelectorWizardDialog;

public class EntityView extends ViewPart implements ITabbedPropertySheetPageContributor{
	public static final String ID = "metardf.ui.views.EntityView";
	private List<String> entities = new ArrayList<String>();

	private static TreeViewer viewer;
	private Action searchAction;
	private Action expandAction;
	
	private Action filterEntities;
	private Action filterShowAll;
	
	private static TreeParent invisibleRoot = new TreeParent("");
	
	public TreeParent getRoot() {
		return invisibleRoot;
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
		
		viewer = tree.getViewer();
		viewer.setContentProvider(new EntityTreeViewContentProvider(invisibleRoot, getViewSite()));
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new EntityTreeViewLabelProvider()));
	
		viewer.setInput(getViewSite());
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "metaRDF.ui.viewer");
		
		getSite().setSelectionProvider(viewer);
		
		DragSource ds = new DragSource(viewer.getTree(), DND.DROP_COPY);
		ds.setTransfer(new Transfer[] {ModelTransfer.getInstance()});
		ds.addDragListener(new DragSourceAdapter() {
				class DragSemanticClass extends SemanticClass{
					String idToString;
					
					@Override
					public String getId() {
						return this.idToString;
					}				
				}
			
		     public void dragSetData(DragSourceEvent event) {
		    	 IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		    	 ISemanticElement[] data = new ISemanticElement[selection.size()];
		    	 
		    	 for(int i=0; i<selection.size(); i++){
		    		 if(selection.toArray()[i] instanceof EntityParent){
		    			 data[i] = ((EntityParent) selection.toArray()[i]).getSemanticElement();
		    		 }
		    		 
		    		 if(selection.toArray()[i] instanceof DataPropertyObject){
		    			 data[i] = ((DataPropertyObject) selection.toArray()[i]).getSemanticElement();
		    		 }
		    		 
		    		 if(selection.toArray()[i] instanceof PropertyParent){
		    			 data[i] = ((PropertyParent) selection.toArray()[i]).getSemanticElement();
		    		 }
		    		 
		    		 if(selection.toArray()[i] instanceof EntityParentGroup){
		    			 DragSemanticClass dragSemanticClass = new DragSemanticClass();
		    			 dragSemanticClass.setName(((EntityParentGroup) selection.toArray()[i]).getName());
		    			 
		    			 WizardDialog wizardDialog = new WizardDialog(null, new EntityGroupSelectorWizardDialog((EntityParentGroup) selection.toArray()[i], dragSemanticClass));
				    	 if (wizardDialog.open() == Window.OK) {
				    	 }
		    		 }
		    	 }
		    	 
		    	 event.data = data;
		     }
		  });
		
		defaultFilteringActions();
		invokeActions();
		invokeFilters();
		invokeEditors();
		makeActions();
		hookDoubleClickAction();
		contributeToActionBars();
		
		EntityViewViewerComparator comparator = new EntityViewViewerComparator();
		viewer.setComparator(comparator);
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
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(searchAction);
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(filterShowAll);
		manager.add(filterEntities);
	}
	
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				expandAction.run();
			}
		});
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
		searchAction = new Action(){
			public void run(){
				executeSearchAction();
			}
		};
		searchAction.setText("Search");
		searchAction.setToolTipText("Open the search action wizard");
		searchAction.setImageDescriptor(Activator.getImageDescriptor("icons/search.png"));
		
		expandAction = new Action(){
			public void run(){
				executeExpandAction();
			}
		};
		expandAction.setText("Expand");
		expandAction.setToolTipText("");
		expandAction.setImageDescriptor(Activator.getImageDescriptor("icons/details_view.gif"));
	}
	
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public static TreeViewer getViewer() {
		return viewer;
	}

	public static TreeParent getInvisibleRoot() {
		return invisibleRoot;
	}
	
	private void executeSearchAction() {
		RepositoryManager repositoryManager = RepositoryManager.getInstance();
		
		if((repositoryManager!=null) && (repositoryManager.getRepositories()!=null) && (repositoryManager.getRepositories().size() > 0)){
			Search searchOptions = new Search();
			
			searchOptions.setRelevanceR1(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R1"));
			searchOptions.setRelevanceR2(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R2"));
			searchOptions.setRelevanceR3(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R3"));
			searchOptions.setRelevanceR4(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R4"));
			searchOptions.setRelevanceR5(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R5"));
			searchOptions.setMaxWeight(Activator.getDefault().getPreferenceStore().getInt("MAX_WEIGHT"));
			
			WizardDialog wizardDialog = new WizardDialog(null, new SearchEntityWizardDialog(searchOptions));
			if (wizardDialog.open() == Window.OK) {
				if(searchOptions != null) searchAndRefreshView(searchOptions);
			}
		}  
	}
	
	private static boolean searchAndRefreshView(Search searchOptions){
		SearchParent searchParent = createSearchParent(searchOptions.getSearchField(), searchOptions);
		
		List<ISemanticClass> searchResults = searchInAssistances(searchOptions);
		Map<String, List<ISemanticClass>> semanticElementsGrouped = groupSemanticClasses(searchResults);
		
		for(Entry<String, List<ISemanticClass>> entrySemanticElementsGrouped : semanticElementsGrouped.entrySet()){
			/*List<IDataProperty> attrs = new ArrayList<IDataProperty>();
			
			for(ISemanticClass semanticClass : entrySemanticElementsGrouped.getValue()){
				attrs.addAll(semanticClass.getProperties());
			}*/
			
			//Map<String, List<IDataProperty>> dataPropertiesGrouped = attrs.stream().collect(Collectors.groupingBy(w -> w.getName()));
			if(entrySemanticElementsGrouped.getValue().size()>1){
				EntityParentGroup parent = new EntityParentGroup(entrySemanticElementsGrouped.getKey(), entrySemanticElementsGrouped.getValue());
				
				for(ISemanticClass semanticClass : entrySemanticElementsGrouped.getValue()){
					EntityParent semanticClassParent = new EntityParent((ISemanticClass) semanticClass);
					EntityTreeViewDrawingProvider.drawEntityParentContent(semanticClassParent);
					parent.addChild(semanticClassParent);
				}
				
				searchParent.addChild(parent);
			}
			if(entrySemanticElementsGrouped.getValue().size()==1){
				EntityParent parent = new EntityParent((ISemanticClass) entrySemanticElementsGrouped.getValue().get(0));
				EntityTreeViewDrawingProvider.drawEntityParentContent(parent);
				searchParent.addChild(parent);
			}
		}
		
		getInvisibleRoot().addChild(searchParent);
		getViewer().refresh();
		
		return true;
	}
	
	public static boolean searchAndRefreshView(String candidate){
		Search search = new Search();
		search.setSearchField(candidate);
		return searchAndRefreshView(search);
	}
	
	private static List<ISemanticClass> searchInAssistances(Search search) {
		RepositoryManager repositoryManager = RepositoryManager.getInstance();
		AssistantFactory.getInstance().getAssistances();
		return AssistantFactory.getInstance().search(repositoryManager, search);
	}
	
	private static Map<String, List<ISemanticClass>> groupSemanticClasses(List<ISemanticClass> semanticElements){ 
		return semanticElements.stream().collect(Collectors.groupingBy(w -> w.getName()));
	}

	private static SearchParent createSearchParent(String search, Search searchParameters) {
		SearchParent searchParent = new SearchParent(search, searchParameters);
		return searchParent;
	}
	
	private void executeExpandAction() {
		ISelection selection = getViewer().getSelection();
		Object obj = ((IStructuredSelection)selection).getFirstElement();
		
		if(obj instanceof EntityParent){
			if(!isOnTheTree((EntityParent) obj)){
				RepositoryManager repositoryManager = RepositoryManager.getInstance();
				List<IFormatAssistant> assistances = AssistantFactory.getInstance().getAssistances();
				
				for(IRepository repository : repositoryManager.getRepositories()){    
					for(IResource resource : repository.getResources()){
						if(resource instanceof SemanticResource){			
							for(IFormatAssistant assistant : assistances){
								if((resource.isAlive()) && (resource.getAssistant() != null)){
									if(((FormatAssistant)assistant).getNameExtension().compareTo(resource.getAssistant())==0){
										if((resource instanceof SemanticResource) && (assistant.load((SemanticResource) resource))){	
											AssistantFactory.completeSemanticClassProperties(assistant, (ISemanticClass)((EntityParent) obj).getSemanticElement());
										}
									}
								}
							}
						}	
					}		
				}
				
				EntityTreeViewDrawingProvider.drawEntityParentContent((EntityParent) obj);
				getViewer().refresh();
			}
			else{
				showMessage("Entity " + ((EntityParent)obj).getName() + " is already expanded on the list");
			}
		}
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(
			getViewer().getControl().getShell(),
			"Entities",
			message);
	}
	
	private boolean isOnTheTree(EntityParent obj){
		boolean onTheTree = false;
		Object element = obj;
		
		while((((TreeParent) element).getParent() != getRoot()) && (!onTheTree)){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof EntityParent) && (child!=obj)){
				}
			}
			element = ((TreeParent) element).getParent();
		}
		
		if(((TreeParent)element).getParent() == getRoot()){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof EntityParent) && (child!=obj)){
					if(((String) ((EntityParent) child).getSemanticElement().getId()).compareTo((String) ((EntityParent) obj).getSemanticElement().getId())==0){
						onTheTree = true;
					}
				}		
			}
		}
		
		return onTheTree;
	}

	@Override
	public String getContributorId() {
		return getSite().getId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IPropertySheetPage.class)
            return new TabbedPropertySheetPage(this);
        return super.getAdapter(adapter);
	}
}
