package uam.extremo.ui.zest.views.inheritance;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.GridLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import semanticmanager.SemanticNode;
import uam.extremo.ui.zest.views.*;

public class InheritanceGraphViewPart extends ViewPart implements IZoomableWorkbenchPart{
	public static final String ID = "uam.extremo.ui.zest.views.InheritanceGraphViewPart";
	
	private Action springLayoutAction;
	private Action treeLayoutAction;
	private Action radialLayoutAction;
	private Action gridLayoutAction;
	
	private GraphViewer viewer;
	private Graph graph;

	/*ISelectionListener listener = new ISelectionListener() {
		public void selectionChanged(IWorkbenchPart part, ISelection sel) {
			if((sel != null) && (sel instanceof IStructuredSelection) && (((IStructuredSelection)sel).size() > 0)){
				if(part instanceof RepositoryViewPart){
					Job job = new Job("Graph"){
						@Override
						protected IStatus run(IProgressMonitor monitor) {					
							List<SemanticNode> input = new ArrayList<SemanticNode>();
							
							try {
								IStructuredSelection selection = (IStructuredSelection) sel;
								int max_time = selection.size() * 10;
								monitor.beginTask("Draw Graph Dependencies", max_time);
								monitor.worked(10);
							
								Thread.sleep(2000);
								
								List<Resource> resources = new ArrayList<Resource>();
								
								for(int i=0; i<selection.size(); i++){
									if(selection.toArray()[i] instanceof ResourceTreeObject){
										resources.add(((ResourceTreeObject) selection.toArray()[i]).getResource());
									}
								}
								
								for(Resource resource : resources){
									for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
										if(resource.getAssistant().compareTo(((FormatAssistant)assistant).getNameExtension()) == 0){
											assistant.load((Resource) resource);
											
											List<SemanticNode> classesInResource = assistant.getAllClasses();	
											for(SemanticNode classInResource : classesInResource){
												List<SemanticNode> superclasses = new ArrayList<SemanticNode>();
												superclasses = assistant.getSuper(classInResource, true);
												classInResource.getSupers().addAll(superclasses);
											}
											
											if(classesInResource != null) resource.getNodes().addAll((classesInResource));
										}
									}
								}
								
								for(Resource resource : resources) input.addAll(resource.getNodes());
								
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							syncWithUI(input);
							
							return Status.OK_STATUS;
						}
						
					};
					
					job.setUser(true);
			  		job.schedule();
				}
			}	
	  	}
    };*/
  
 	private void syncWithUI(List<SemanticNode> input) {
 		Display.getDefault().asyncExec(new Runnable() {
 			public void run() {
 				viewer.setInput(input);
 				MessageDialog.openInformation(getSite().getShell(), "Draw Graph Inheritance Dependencies", "Dependencies calculated");
 			}
 		});
 	}
 	
    @Override
    public void dispose() {
    	// getSite().getPage().removeSelectionListener(listener);
    }
		
	@Override
	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new InheritanceGraphViewPartNodeContentProvider());
	    viewer.setLabelProvider(new InheritanceGraphPartViewLabelProvider());
	    
	    setLayoutManager(3);
	    makeActions();
	    hookContextMenu();
	    contributeToActionBars();
	    invokeFilters();
	}

	private void invokeFilters() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.FILTER_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("filter")==0){
				ViewerFilter filter;
				try{
					filter = (ViewerFilter) extension.createExecutableExtension("class");
					
					if((filter != null)){
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
	
	
	public void setLayoutManager(int layout) {
		switch (layout) {
			case 1:
				viewer.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
				viewer.applyLayout();
			break;
			
			case 2:
				viewer.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
				viewer.applyLayout();
			break;
			
			case 3:
				viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
				viewer.applyLayout();
			break;
			
			case 4:
				viewer.setLayoutAlgorithm(new GridLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
				viewer.applyLayout();
			break;
		}
	}
	
	@Override
	public void setFocus() {
	}
	
	private void contributeToActionBars() {
		ZoomContributionViewItem toolbarZoomContributionViewItem = new ZoomContributionViewItem(this);		
		IActionBars bars = getViewSite().getActionBars();
		fillContextMenu(bars.getMenuManager());
		
	    bars.getMenuManager().add(toolbarZoomContributionViewItem);
	}
	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				InheritanceGraphViewPart.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}
	
	private void fillContextMenu(IMenuManager manager) {
		manager.add(springLayoutAction);
		manager.add(treeLayoutAction);
		manager.add(radialLayoutAction);
		manager.add(gridLayoutAction);
	}
	
	private void makeActions() {		
		springLayoutAction = new Action() {
			public void run() {
				setLayoutManager(1);
			}
		};
		
		springLayoutAction.setText("Spring Layout");
		springLayoutAction.setToolTipText("");
		springLayoutAction.setImageDescriptor(Activator.getImageDescriptor("icons/leaf_dist.png"));
		
		treeLayoutAction = new Action() {
			public void run() {
				setLayoutManager(2);
			}
		};
		
		treeLayoutAction.setText("Tree Layout");
		treeLayoutAction.setToolTipText("");
		treeLayoutAction.setImageDescriptor(Activator.getImageDescriptor("icons/tree_dist.png"));
		
		
		radialLayoutAction = new Action() {
			public void run() {
				setLayoutManager(3);
			}
		};
		
		radialLayoutAction.setText("Radial Layout");
		radialLayoutAction.setToolTipText("");
		radialLayoutAction.setImageDescriptor(Activator.getImageDescriptor("icons/radio_dist.png"));
		
		
		gridLayoutAction = new Action() {
			public void run() {
				setLayoutManager(4);
			}
		};
		
		gridLayoutAction.setText("Grid Layout");
		gridLayoutAction.setToolTipText("");
		gridLayoutAction.setImageDescriptor(Activator.getImageDescriptor("icons/grid_dist.png"));
		
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		return viewer;
	}
}
