package metardf.ui.views.searchtree;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import metaRDF.core.model.ISearch;
import metardf.ui.views.searchtree.model.SearchWordTreeParent;
import metardf.ui.views.searchtree.model.StrategyTreeParent;
import metardf.ui.views.searchtree.model.TermTreeObject;
import metardf.ui.views.searchtree.model.TreeParent;
import metardf.ui.views.searchtree.model.WeightTreeObject;

public class SearchTreeView extends ViewPart implements ITabbedPropertySheetPageContributor {
	public static final String ID = "metardf.ui.views.SearchTree";
	static TreeViewer viewer;
	private static TreeParent invisibleRoot = new TreeParent("");
	
	private static SearchTreeView INSTANCE = null;
	
	public SearchTreeView() {
	}
	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		new DrillDownAdapter(viewer);
		
		viewer.setContentProvider(new SearchTreeViewContentProvider(invisibleRoot, getViewSite()));
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new SearchTreeViewLabelProvider()));
		viewer.setInput(getViewSite());
		viewer.getTree().setHeaderVisible(true);
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "metaRDF.ui.viewer");
		getSite().setSelectionProvider(viewer);
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();		
	}
	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				SearchTreeView.this.fillContextMenu(manager);
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
		//manager.add(addRepository);
	}

	private void fillContextMenu(IMenuManager manager) {
		//manager.add(createResource);
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		//manager.add(addRepository);
		//manager.add(importRepositories);
		//manager.add(exportRepositories);
		//manager.add(addFolder);
	}
	
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				//expandAction.run();
			}
		});
	}
	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	private static void createInstance() {
	   	 if (INSTANCE == null) {
	   		 synchronized(SearchTreeView.class) {
	   			 if (INSTANCE == null) {

	   				 
	   				 INSTANCE = new SearchTreeView();
	   			 }
	   		 }
	     }
	}

	public static SearchTreeView getInstance() {
	    if (INSTANCE == null){
	    	createInstance();
	    }
	    return INSTANCE;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException(); 
	}

	public void refresh(ISearch lastSearch) {
		SearchWordTreeParent searchTreeParent = new SearchWordTreeParent(lastSearch);	
		StrategyTreeParent strategyTreeParent = new StrategyTreeParent(lastSearch.getStrategyApplied());
		
		WeightTreeObject weightTreeObject = new WeightTreeObject(lastSearch.getWeights());
		strategyTreeParent.addChild(weightTreeObject);
		searchTreeParent.addChild(strategyTreeParent);
		
		Map<String, Integer> searchList = lastSearch.getOrderSearchesListByWeight();
		
		for(Entry<String, Integer> entry : searchList.entrySet()){
			TermTreeObject termTreeObject = new TermTreeObject(entry);
			searchTreeParent.addChild(termTreeObject);
		}
		getInvisibleRoot().addChild(searchTreeParent);
		viewer.refresh();
	}
	
	public static TreeParent getInvisibleRoot() {
		return invisibleRoot;
	}
	
	public TreeParent getRoot() {
		return invisibleRoot;
	}

	@Override
	public String getContributorId() {
		// TODO Auto-generated method stub
		return null;
	}
}
