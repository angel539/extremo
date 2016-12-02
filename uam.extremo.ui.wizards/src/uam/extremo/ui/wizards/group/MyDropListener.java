package uam.extremo.ui.wizards.group;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

public class MyDropListener extends ViewerDropAdapter {	
	private final Viewer viewer;
	//private final EPackage modelPack;
	//private List<MMInterfaceRelDiagram> content;
	//private Button replace;

	protected MyDropListener(Viewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	
	/*public MyDropListener(Viewer viewer, EPackage pack, List<MMInterfaceRelDiagram> content, Button replace) {
	    super(viewer);
	    this.viewer = viewer;
	    this.modelPack = pack;
	    this.content = content;
	    this.replace = replace;
	 }
	  
	public void setContent(List<MMInterfaceRelDiagram> content){
		  this.content = content;
	}*/
	
	@Override
	public void drop(DropTargetEvent event) {
		/*MMInterfaceRelDiagram target = (MMInterfaceRelDiagram) determineTarget(event);
		if(!Utils.isWindows())
			if (!validateDrop(target, event.operations, event.currentDataType)) {
			return;
		}
	  
		if (target.getMmInterface() instanceof ClassInterface){
			if ((target.getElementDiagram().isEmpty()) || (replace.getSelection())){
				for (MMInterfaceRelDiagram mmird : PatternUtils.getChildren(content, target)){
					if (!(mmird.getMmInterface() instanceof FeatureInstance)) mmird.setElementDiagram("");
				}
		 
				for (MMInterfaceRelDiagram mmird : PatternUtils.getMMInterfaceRelDiagramRefsEClass(content, target)){
					mmird.setElementDiagram("");
				}
			} else { //duplicamos.
				if ((target.getMaxValue()> PatternUtils.getNumMMInterfaceRelDiagram(content,target)) || (target.getMaxValue()==-1))	{
					int order = PatternUtils.getNumMaxOrderMMInterfaceRelDiagram(content, target)+1;
					target = PatternUtils.duplicateStructureClass(content, target, order, target.getOrderPointer());
				}	
				else {
					Messages.displayEditErrorMessage("Cardinality error");
					return;
				}
			}
		}	
		target.setElementDiagram(event.data.toString());*/
	    super.drop(event);
	}
	
	
	@Override
	public boolean performDrop(Object data) {
		  viewer.refresh();
		  return false;
	}
	
	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		  /*Object data =  TextTransfer.getInstance().nativeToJava(transferType);
		  if(data == null) {
			    return true;
		  }
			  
		  EObject object = ModelsUtils.getEObject(modelPack,data.toString());
		 
		  if (target instanceof MMInterfaceRelDiagram){
			if (!PatternUtils.isAbstract((MMInterfaceRelDiagram)target, content)) { 
			  
				MMInterfaceRelDiagram parent = ((MMInterfaceRelDiagram)target).getParent();
				String[] datas = data.toString().split("/");
			  
				EClass eClassParent = (EClass)ModelsUtils.getEObject(modelPack, datas[0]);
				EList<EClass> eClassesParent =eClassParent.getEAllSuperTypes();
				EClass eClassParentRel = null;
				  
				if (parent != null)
				  eClassParentRel = (EClass)ModelsUtils.getEObject(modelPack,parent.getElementDiagram());
				 
				if (((((MMInterfaceRelDiagram)target).getMmInterface() instanceof ClassInterface)&&(object instanceof EClass))
					    	|| ( ((((MMInterfaceRelDiagram)target).getMmInterface() instanceof FeatureType) &&(object instanceof EAttribute)) && (!parent.getElementDiagram().isEmpty())
					    			&&((datas[0].compareTo(parent.getElementDiagram())==0)||(eClassesParent.contains(eClassParentRel)))) 
					    	|| ( ((((MMInterfaceRelDiagram)target).getMmInterface() instanceof ReferenceInterface) &&(object instanceof EReference)) && (!parent.getElementDiagram().isEmpty()) && (!parent.getElementDiagram().isEmpty())
					    			&&((datas[0].compareTo(parent.getElementDiagram())==0) || (eClassesParent.contains(eClassParentRel))))){		  	
					if ((((MMInterfaceRelDiagram)target).getMmInterface() instanceof ReferenceInterface) &&(object instanceof EReference)){
						return (PatternUtils.isETypeTarget((MMInterfaceRelDiagram)target, (EClass)((EReference)object).getEType(), content, modelPack, ((MMInterfaceRelDiagram)target).getOrderPointer())
								  &&(PatternUtils.areCompatibleReferences((ReferenceInterface)((MMInterfaceRelDiagram)target).getMmInterface(), (EReference)object)   
									&& (PatternUtils.areCompatibleEOppositeReferences(content, (MMInterfaceRelDiagram)target, (EReference)object)) ));
					}
					if (((MMInterfaceRelDiagram)target).getMmInterface() instanceof FeatureType){
						if ((PatternUtils.getEType((FeatureType)((MMInterfaceRelDiagram)target).getMmInterface()) == DataType.EJAVAOBJECT.getEDataType())
							|| PatternUtils.getEType((FeatureType)((MMInterfaceRelDiagram)target).getMmInterface()) == ((EAttribute)object).getEAttributeType())
							return (PatternUtils.areCompatibleFeatureTypes((FeatureType)((MMInterfaceRelDiagram)target).getMmInterface(), (EAttribute)object));
					} if (((MMInterfaceRelDiagram)target).getMmInterface() instanceof ClassInterface)	
						  return (PatternUtils.areCompatibleClasses(content, (MMInterfaceRelDiagram)target, (EClass) object));		  
					else return true;
				} else return false; 
			}
		  }*/
		  return false;
	  }
}
