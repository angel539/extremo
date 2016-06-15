package metardf.ui.wizards.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class DragAndDropUtils {
	public static TreeViewer createTableViewerDrop(Composite parent, EPackage ecoreDiagram, TreeViewer viewerEcore, String patternName){
		
		Composite drop = new Composite(parent, SWT.NONE);
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 1;
	    gridLayout.marginHeight = gridLayout.marginWidth = 2;
	    gridLayout.horizontalSpacing = gridLayout.verticalSpacing = 0;
	    drop.setLayout(gridLayout);

	    Label treeScopeLabel = new Label(drop, SWT.BORDER);
	    treeScopeLabel.setText("PATTERN");
	    treeScopeLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
	        | GridData.VERTICAL_ALIGN_FILL));
	    treeScopeLabel.setAlignment(SWT.CENTER);

	    TreeViewer viewer = new TreeViewer(drop, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
	        | SWT.SINGLE | SWT.FULL_SELECTION);
	    final Tree addressTree = viewer.getTree();
	    addressTree.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
	        | GridData.FILL_VERTICAL));
		
		createTreeViewerColumn(viewer,220, 0, null);
		createTreeViewerColumn(viewer,30,1, null);
		createTreeViewerColumn(viewer,160,2, new ElementDiagramSupport(viewer));	
		createTreeViewerColumn(viewer,60,3, null);
		createTreeViewerColumn(viewer,100,4, null);
		
		viewer.getTree().setHeaderVisible(true);
		
	    /*class TreeContentProviderDrop implements ITreeContentProvider{
	    	private List<MMInterfaceRelDiagram> list = null;

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
			
			@Override
			public void dispose() {
			}
			
			@Override
			public boolean hasChildren(Object element) {
				MMInterfaceRelDiagram relElement = (MMInterfaceRelDiagram) element;
				return (relElement.getMmInterface() instanceof ClassInterface);
			}
			
			@Override
			public Object getParent(Object element) {
				return ((MMInterfaceRelDiagram)element).getParent();
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
			    list = (List<MMInterfaceRelDiagram>) inputElement;
			    List<MMInterfaceRelDiagram> classInterfaces = new ArrayList<>();
			    for (MMInterfaceRelDiagram element: list){
			    	if (element.getMmInterface() instanceof ClassInterface)classInterfaces.add(element);
			    }
			    return classInterfaces.toArray();
			}
			
			@Override
			public Object[] getChildren(Object parentElement) {
				List<MMInterfaceRelDiagram> children = ((MMInterfaceRelDiagram)parentElement).getChildren();			
					return children.toArray();
			}
			
			private boolean isAbstract (MMInterfaceRelDiagram mmird){
				return PatternUtils.isAbstract(mmird, list);
			}
	    }
	    class LabelProviderDrop implements ITableLabelProvider,  ITableFontProvider, ITableColorProvider{
	    	
	    	public TreeContentProviderDrop cpd = null;
	    	public LabelProviderDrop(TreeContentProviderDrop cpd) {
				super();
				this.cpd = cpd;
			}

			@Override
	    	public Image getColumnImage(Object element, int columnIndex){
	    		ImageDescriptor desc = null;
				MMInterfaceRelDiagram mmo = (MMInterfaceRelDiagram) element;
	    		if (columnIndex == 0){
					if (mmo.getMmInterface() instanceof ClassInterface){
						desc = ImagesUtils.getImageDescriptor("icons/eClass.gif");
					} else if (mmo.getMmInterface()  instanceof ReferenceInterface){
						desc = ImagesUtils.getImageDescriptor("icons/eReference.gif");
					} else if (mmo.getMmInterface() instanceof FeatureType){
						desc = ImagesUtils.getImageDescriptor("icons/eAttribute.gif");
					} else if (mmo.getMmInterface() instanceof FeatureInstance){
						desc = ImagesUtils.getImageDescriptor("icons/alert.gif");
					}
					if (desc != null)return desc.createImage();
					
				} else if (columnIndex == 4){	
					if ((mmo.getMmInterface() instanceof ClassInterface)&& (!mmo.getAdditionalInformation().isEmpty()))  {
						EClass eclass = PatternUtils.getEClass((ClassInterface)mmo.getMmInterface());
						if (eclass.getEAllSuperTypes().size() != 0)
							desc = ImagesUtils.getImageDescriptor("icons/parent.gif");
						else desc = ImagesUtils.getImageDescriptor("icons/children.gif");
					}
					if (desc != null)return desc.createImage();
				}
				return null;
		      }
	    			 
			@Override  
			public String getColumnText(Object element, int columnIndex){
		    	MMInterfaceRelDiagram relElement = (MMInterfaceRelDiagram) element;
		    	switch (columnIndex){  
			    	case 0: 
			    	 	return relElement.getTextMMInterfaceRelDiagramOnlyName(true);	
			    	case 1:
			    		String cad = "";
			    		if (relElement.getMmInterface() instanceof ClassInterface){
			        	   cad = "."+String.valueOf(relElement.getOrder());
			        	   if (cad.compareTo(".0")==0) return "";
			    		} else if (relElement.getMmInterface() instanceof ReferenceInterface){ 
			        		cad = "."+String.valueOf(relElement.getOrderPointer());
			        		if (cad.compareTo(".0")==0) return "";
			        	}			    		
			        	return cad;
		           case 2:
		        	   return relElement.getElementDiagram();
		           case 3:
			    		if (relElement.getMmInterface() instanceof ClassInterface){
			    			if (relElement.getOrder()==0) return relElement.getCardText();
			    		} else if (relElement.getMmInterface() instanceof ReferenceInterface){ 
			    			if (relElement.getOrderPointer()==0) return relElement.getCardText();
			        	} else if (relElement.getMmInterface() instanceof FeatureInterface){ 
			    			if (relElement.getOrderPointer()==0) return relElement.getCardText();
			        	}return null;
		          case 4:
		        	 return relElement.getAdditionalInformation();
		        }
		       return null;
		    }
			@Override
			public void addListener(ILabelProviderListener listener){
			}
			 
			@Override
			public void dispose(){
			}
			 
			@Override
			public boolean isLabelProperty(Object element, String property){
			return false;
			}
			@Override
			public void removeListener(ILabelProviderListener listener){
			}

			@Override
			public Font getFont(Object element, int columnIndex) {
				FontRegistry registry = new FontRegistry();
				if (element instanceof MMInterfaceRelDiagram){
					if (cpd.isAbstract((MMInterfaceRelDiagram)element)) 
						return registry.getItalic(Display.getCurrent().getSystemFont()
								.getFontData()[0].getName());
				}
				return null;
			}

			@Override
			public Color getForeground(Object element, int columnIndex) {
				if (element instanceof MMInterfaceRelDiagram){
					if (cpd.isAbstract((MMInterfaceRelDiagram)element))return Display.getCurrent().getSystemColor(SWT.COLOR_RED);	
				}
				return null;
			}
					
			@Override
			public Color getBackground(Object element, int columnIndex) {
				return null;
			}
		}
	    
	    TreeContentProviderDrop tcpd =  new TreeContentProviderDrop();
	    viewer.setContentProvider(tcpd);	
	    viewer.setLabelProvider(new LabelProviderDrop(tcpd));
	    
	    final Menu menu = new Menu(addressTree);
	  	addressTree.setMenu(menu);
	    menu.addMenuListener(new PatternMenuAdapter(menu, viewer, ecoreDiagram, viewerEcore, patternName));*/
	    return viewer;
	}
	
	/**
	 * Static method that creates a editable treeViewerColumn 
	 * @param viewer
	 * @param width
	 * @param colNumber
	 * @param ed
	 * @return TreeViewerColumn
	 */
	private static TreeViewerColumn createTreeViewerColumn(TreeViewer viewer, int width,  final int colNumber, EditingSupport ed) {
	    
		final TreeColumn column = new TreeColumn(viewer.getTree(), SWT.NONE);	
		column.setWidth(width);
	    column.setResizable(true);
	    column.setMoveable(true);
	    
	    switch (colNumber){
		    case 0: {
		    	column.setText("Pattern Element");
		    	break;
		    }
		    case 1: {
		    	column.setText("");
		    	break;
		    }
		    case 2: {
		    	column.setText("Diagram Element");
		    	break;
		    }
		    case 3:{
		    	column.setText("Card.");
		    	break;
		    }
		    case 4: {
		    	column.setText("Inheritance");
		    	break;
		    }
	    }
	    
	   
	    TreeViewerColumn tvc = new TreeViewerColumn(viewer, column);
	    if (ed!=null){	
	    	tvc.setEditingSupport(ed);	
	    }
	    return tvc;
	  }
	
	/**
	 * Static method that creates a treeViewer that sends (drag) metamodel elements.
	 * @param parent
	 * @return TreeViewer
	 */
	public static TreeViewer createTreeViewerDrag(Composite parent){
		
		Composite drag = new Composite(parent, SWT.NONE);
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 1;
	    gridLayout.marginHeight = gridLayout.marginWidth = 2;
	    gridLayout.horizontalSpacing = gridLayout.verticalSpacing = 0;
	    drag.setLayout(gridLayout);

	    Label treeScopeLabel = new Label(drag, SWT.BORDER);
	    treeScopeLabel.setText("DIAGRAM");
	    treeScopeLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
	        | GridData.VERTICAL_ALIGN_FILL));
	    treeScopeLabel.setAlignment(SWT.CENTER);

	    TreeViewer viewer = new TreeViewer(drag, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
	        | SWT.MULTI);
	    viewer.getTree().setLayoutData(new GridData(GridData.FILL_HORIZONTAL
	        | GridData.FILL_VERTICAL));
		
		int operations = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
		viewer.addDragSupport(operations, transferTypes, new MyDragListener(viewer));
		
 		viewer.setContentProvider(new ITreeContentProvider() {
			
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
			
			@Override
			public void dispose() {
			}
			
			@Override
			public boolean hasChildren(Object element) {
				return (element instanceof EClass);
			}
			
			@Override
			public Object getParent(Object element) {
				return null;
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
			    @SuppressWarnings("unchecked")
				List<ENamedElement> list = (List<ENamedElement>) inputElement;
			    return list.toArray();
			}
			
			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof EClass){
					List<Object> listAttributes = new ArrayList<>(Arrays.asList(((EClass)parentElement).getEAllAttributes().toArray()));
					List<Object> listReferences = new ArrayList<>(Arrays.asList(((EClass)parentElement).getEAllReferences().toArray()));
					listAttributes.addAll(listReferences);
					return listAttributes.toArray();
				}
				return null;
			}

		});
	    
 		viewer.setLabelProvider(new LabelProvider(){
			@Override
			public String getText(Object element) {
				String s = ((ENamedElement) element).getName(); 
			    return s;
			}
			

			/*@Override
			public Image getImage(Object element) {
				ImageDescriptor desc = null;
				
				if (element instanceof EClass){
					desc = ImagesUtils.getImageDescriptor("icons/eClass.gif");
				} else if (element instanceof EReference){
					desc = ImagesUtils.getImageDescriptor("icons/eReference.gif");
				} else if (element instanceof EAttribute){
					desc = ImagesUtils.getImageDescriptor("icons/eAttribute.gif");
				}
				if (desc != null)return desc.createImage();
				return null;
			}*/
	
 		});
 		
 		return viewer;
	}

	/**
	 * Static method that selects the given elements on the treeViewer
	 * Important!!the elements are parentClass children
	 * @param dragViewer - TreeViewer
	 * @param parentClass -  Eclass
	 * @param elements - eNamedElements to select
	 */
	public static void selectDragElements (TreeViewer dragViewer, EClass parentClass, List<ENamedElement> elements ){
		dragViewer.getTree().deselectAll();
		if (!noDragElementsToSelect(elements)){
			TreeItem[] items = dragViewer.getTree().getItems();
			Object[] sonsToSelect = new Object[]{};
			for (TreeItem item : items){
				if (parentClass.equals(((ENamedElement)item.getData()))){
					dragViewer.expandToLevel(parentClass, TreeViewer.ALL_LEVELS);
					for (TreeItem son : item.getItems()){
						if (elements.contains((ENamedElement)son.getData())){
							//sonsToSelect = Utils.addObjectArray(sonsToSelect, son);
						}
					}
				}
			}
			for (Object item: sonsToSelect)
			dragViewer.getTree().select((TreeItem)item);
		}//else Messages.displayGeneralMessage("Pattern Assistant", "No elements to select");
	}
	
	/**
	 * Static method that selects the given elements on the treeViewer, it doesn't matter the parent.
	 * @param dragViewer - TreeViewer destiny 
	 * @param elements - eNamedElements to select on the treeViewer
	 */
	public static void selectDragElements (TreeViewer dragViewer, List<ENamedElement> elements ){
		dragViewer.getTree().deselectAll();
		if (!noDragElementsToSelect(elements)){
			dragViewer.setSelection(new StructuredSelection(elements), false);
		}//else Messages.displayGeneralMessage("Pattern Assistant", "No elements to select");
	}
	
	/**
	 * Static method that returns  true if the list of elements to select doesn't have elements.
	 * @param elements eNamedElements to select
	 * @return boolean with the result.
	 */
	public static boolean noDragElementsToSelect(List<ENamedElement> elements){
		if (elements != null)
			return elements.size() == 0;
		else return true;
	}
	
}