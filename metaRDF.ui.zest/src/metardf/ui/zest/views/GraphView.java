package metardf.ui.zest.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
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

import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.IResource;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.impl.SemanticResource;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;
import metardf.ui.views.repositories.RepositoryView;
import metardf.ui.views.repositories.model.ResourceObject;
import metardf.ui.zest.Activator;

public class GraphView extends ViewPart implements IZoomableWorkbenchPart{
	public static final String ID = "metardf.ui.zest.view.ZestView";
	
	private Action springLayoutAction;
	private Action treeLayoutAction;
	private Action radialLayoutAction;
	private Action gridLayoutAction;
	
	private GraphViewer viewer;
	private Graph graph;

	//private int compositeStyle = ZestStyles.CONNECTIONS_DIRECTED;
	//private int inheritanceStyle = ZestStyles.CONNECTIONS_DOT;

	public GraphView() {
	}

	ISelectionListener listener = new ISelectionListener() {
		public void selectionChanged(IWorkbenchPart part, ISelection sel) {
			if((sel != null) && (sel instanceof IStructuredSelection) && (((IStructuredSelection)sel).size() > 0)){
				if(part instanceof RepositoryView){
					Job job = new Job("Graph"){
						@Override
						protected IStatus run(IProgressMonitor monitor) {					
							List<ISemanticClass> input = new ArrayList<ISemanticClass>();
							
							try {
								IStructuredSelection selection = (IStructuredSelection) sel;
								int max_time = selection.size() * 10;
								monitor.beginTask("Draw Graph Dependencies", max_time);
								monitor.worked(10);
							
								Thread.sleep(2000);
								
								//algoritmo de recuperacion de todos los elementos
								
								List<IResource> resources = new ArrayList<IResource>();
								
								for(int i=0; i<selection.size(); i++){
									if(selection.toArray()[i] instanceof ResourceObject){
										resources.add(((ResourceObject) selection.toArray()[i]).getResource());
									}
								}
								
								for(IResource resource : resources){
									for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
										if(resource.getAssistant().compareTo(((FormatAssistant)assistant).getNameExtension()) == 0){
											assistant.load((SemanticResource) resource);
											
											List<ISemanticClass> classesInResource = assistant.getAllClasses();
											for(ISemanticClass classInResource : classesInResource){
												List<IObjectProperty> references = new ArrayList<IObjectProperty>();
												references = assistant.getObjectProperties(classInResource.getId(), true, true);
												classInResource.addReferences(references);
											}
											
											if(classesInResource != null) resource.addClasses((classesInResource));
										}
									}
								}
								
								for(IResource resource : resources) input.addAll(resource.getClasses());
								
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
    };
  
 	private void syncWithUI(List<ISemanticClass> input) {
 		Display.getDefault().asyncExec(new Runnable() {
 			public void run() {
 				viewer.setInput(input.toArray(new ISemanticClass[input.size()]));
 				MessageDialog.openInformation(getSite().getShell(), "Draw Graph Dependencies", "Dependencies calculated");
 			}
 		});
 	}
 	
    @Override
    public void dispose() {
    	 getSite().getPage().removeSelectionListener(listener);
    }
		
	@Override
	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new GraphViewNodeContentProvider());
	    viewer.setLabelProvider(new GraphViewLabelProvider());
	    
	    getSite().getPage().addSelectionListener(listener);
	    setLayoutManager(3);
	    
	    makeActions();
	    hookContextMenu();
	    contributeToActionBars();
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
				GraphView.this.fillContextMenu(manager);
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
	
	/*private GraphNode drawGraphNode(String name){
		return new GraphNode(getGraph(), SWT.NONE, name);
	}*/
	
	/*private GraphConnection drawGraphCompositionConnection(GraphNode init, GraphNode finall){
		return new GraphConnection(getGraph(), compositeStyle,
		        init, finall);
		
		
		graphConnection.changeLineColor(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
	    // Also set a text
	    graphConnection.setText("This is a text");
	    graphConnection.setHighlightColor(parent.getDisplay().getSystemColor(SWT.COLOR_RED));
	    graphConnection.setLineWidth(3);
		 
	}*/
	
	/*private GraphConnection drawGraphInheritanceConnection(GraphNode init, GraphNode finall){
		return new GraphConnection(getGraph(), inheritanceStyle,
		        init, finall);
		
		graphConnection.changeLineColor(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
	    // Also set a text
	    graphConnection.setText("This is a text");
	    graphConnection.setHighlightColor(parent.getDisplay().getSystemColor(SWT.COLOR_RED));
	    graphConnection.setLineWidth(3);
		 
	}*/
	
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
