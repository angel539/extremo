package metardf.ui.temp.views.test.views;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import metaRDF.core.model.ISemanticElement;
import metardf.ui.dnd.ExtremoModelTransfer;


public class DropIntegrationTestView extends ViewPart {
	public static final String ID = "metardf.ui.temp.views.test.views.DropIntegrationTestView";
	
	private TempTreeViewer viewer;
	
	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;
		
		public TreeObject(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		public String toString() {
			return getName();
		}
		public <T> T getAdapter(Class<T> key) {
			return null;
		}
	}
	
	class TreeParent extends TreeObject {
		private ArrayList<TreeObject> children;
		public TreeParent(String name) {
			super(name);
			children = new ArrayList<TreeObject>();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public TreeObject [] getChildren() {
			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
	}

	class ViewContentProvider implements IStructuredContentProvider, 
										   ITreeContentProvider {
		private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot==null) initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}
		private void initialize() {
			TreeObject to1 = new TreeObject("Leaf 1");
			TreeObject to2 = new TreeObject("Leaf 2");
			TreeObject to3 = new TreeObject("Leaf 3");
			TreeParent p1 = new TreeParent("Parent 1");
			p1.addChild(to1);
			p1.addChild(to2);
			p1.addChild(to3);
			
			TreeObject to4 = new TreeObject("Leaf 4");
			TreeParent p2 = new TreeParent("Parent 2");
			p2.addChild(to4);
			
			TreeParent root = new TreeParent("Root");
			root.addChild(p1);
			root.addChild(p2);
			
			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(root);
		}
	}
	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}
		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
			   imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	class NameSorter extends ViewerSorter {
	}

	public DropIntegrationTestView() {
	}

	public void createPartControl(Composite parent) {
		viewer = new TempTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "metaRDF.ui.temp.views.test.viewer");
		getSite().setSelectionProvider(viewer);	
		
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE  | DND.DROP_DEFAULT;
		DropTarget target = new DropTarget(viewer.getTree(), dndOperations);
		
		Transfer[] transfers = new Transfer[]{ExtremoModelTransfer.getTransfer()};
		target.setTransfer(transfers);
		
		target.addDropListener(new DropTargetListener() {
			@Override
			public void dropAccept(DropTargetEvent event) {}
			
			@Override
			public void drop(DropTargetEvent event) {
				//System.out.println("los datos del drop:: " + event.data);
				if(event.data instanceof Object[]){
					for(Object o : (Object[])event.data){
						if(o instanceof ISemanticElement) System.out.println("es semantic element "+ o.toString());
						//if(o instanceof TreeObject) System.out.println("es tree object " + o.toString());
						System.out.println("la clase es ... " + o.getClass() +  " " + o.toString());
					}
				}else{
					System.out.println("no es instancia de esto...");
				}
			}
			
			@Override
			public void dragOver(DropTargetEvent event) {}
			
			@Override
			public void dragOperationChanged(DropTargetEvent event) {}
			
			@Override
			public void dragLeave(DropTargetEvent event) {}
			
			@Override
			public void dragEnter(DropTargetEvent event) {}
		});
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
