package metardf.ui.views.searchtree;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import metardf.ui.Activator;
import metardf.ui.views.repositories.model.RepositoryTreeParent;
import metardf.ui.views.repositories.model.ResourceTreeObject;
import metardf.ui.views.repositories.model.TreeObject;
import metardf.ui.views.repositories.model.TreeParent;
import metardf.ui.views.searchtree.model.SearchTreeParent;
import metardf.ui.views.searchtree.model.TermTreeParent;

public class SearchTreeView extends ViewPart {
	public static final String ID = "metardf.ui.views.SearchTree";
	
	private static TreeViewer viewer;
	private TreeParent invisibleRoot;
	
	public SearchTreeView() {
	}
	
	class ColumnOneViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if (element instanceof SearchTreeParent) {
				SearchTreeParent searchingNode = (SearchTreeParent) element;
				StyledString styledString = new StyledString(searchingNode.getName());
				
				if (searchingNode.getChildren() != null) {
					styledString.append(" (" + searchingNode.getChildren().length + ") ", StyledString.COUNTER_STYLER);
				}
				return styledString;
			}
			
			if (element instanceof ResourceTreeObject) {
				StyledString styledString = new StyledString(((ResourceTreeObject) element).getName());
				return styledString;
			}
			
			return null;
		}
		
		@Override
		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			
			if(obj instanceof SearchTreeParent) return Activator.getImageDescriptor("icons/close_pane.png").createImage();
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	
	class ColumnTwoViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			return new StyledString("");
		}
	}
	
	class ViewContentProvider implements IStructuredContentProvider,  ITreeContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			if (child instanceof ResourceTreeObject) {
				return ((ResourceTreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			if (parent instanceof RepositoryTreeParent) {
				return ((RepositoryTreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			if (parent instanceof RepositoryTreeParent)
				return ((RepositoryTreeParent)parent).hasChildren();
			return false;
		}
		
		private void initialize() {
			invisibleRoot = new TreeParent("");
		}
	}
	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		
		ViewContentProvider provider = new ViewContentProvider();
		new DrillDownAdapter(viewer);
		viewer.setContentProvider(provider);
		viewer.setInput(getViewSite());
		
		/**/
		viewer.getTree().setHeaderVisible(true);
		
		TreeViewerColumn nameColumn = new TreeViewerColumn(viewer, SWT.NONE);
		nameColumn.getColumn().setText("Name");
		nameColumn.getColumn().setWidth(300);
		nameColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnOneViewLabelProvider()));
		
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
}
