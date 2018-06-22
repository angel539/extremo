package uam.extremo.ui.views.extensions.dnd;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import draggablesemanticmanager.DraggableNamedElement;
import draggablesemanticmanager.DraggableSemanticNode;
import draggablesemanticmanager.DraggablesemanticmanagerFactory;
//import draggablesemanticmanager.DraggablesemanticmanagerPackage;
import semanticmanager.NamedElement;
import semanticmanager.SemanticNode;

public class DraggableNamedElementTransfer extends ByteArrayTransfer{
	private static final String TYPE_NAME = "extremo-model-transfer-format";
	private static final int TYPE_ID = registerType(TYPE_NAME);
	
	private static final DraggableNamedElementTransfer INSTANCE = new DraggableNamedElementTransfer();
	
	public static DraggableNamedElementTransfer getTransfer() {
		return INSTANCE;
	}
	
	protected DraggableNamedElementTransfer(){}
	
	@Override
	protected int[] getTypeIds() {
		return new int[]{TYPE_ID};
	}

	@Override
	protected String[] getTypeNames() {
		return new String[]{TYPE_NAME};
	}
	
	@Override
	public void javaToNative(Object object, TransferData transferData) {
		List<DraggableNamedElement> draggableNamedElements = new ArrayList<DraggableNamedElement>();

		if(object instanceof SemanticNode){
			SemanticNode semanticNode = (SemanticNode) object;
			DraggableSemanticNode draggableSemanticNode = DraggablesemanticmanagerFactory.eINSTANCE.createDraggableSemanticNode();
			draggableSemanticNode.setName(semanticNode.getName());
			draggableNamedElements.add(draggableSemanticNode);
		}
		
		DraggableNamedElement[] namedElementsArray = new DraggableNamedElement[draggableNamedElements.size()];
		namedElementsArray = draggableNamedElements.toArray(namedElementsArray);
		
		byte[] data = Serializer.serialize(namedElementsArray);
		super.javaToNative(data, transferData);
    }
	
	@Override
	public Object nativeToJava(TransferData transferData) {
		byte[] objectBytes = (byte[]) super.nativeToJava(transferData);
		Object object = Serializer.deserialize(objectBytes);
		return object;
    }
	
	private boolean checkIfNamedElement(Object object) {
		if((object == null) || !(object instanceof NamedElement[]) || (((NamedElement[]) object).length == 0)){
			return false;
		}
		
		NamedElement[] semanticElements = (NamedElement[]) object;
		
		for(int i = 0; i < semanticElements.length; i++){
			if((semanticElements[i] == null) || (semanticElements[i].getName() == null) || (semanticElements[i].getName().length() == 0)){
				return false;
			}
		}
		
		return true;
	}
	
	protected boolean validate(Object object){
		return checkIfNamedElement(object);
	}
	
	public int isDefinedSupportedType(TransferData transferData){
		if (transferData == null)
			return -1;
		int[] types = getTypeIds();
		
		for (int i = 0; i < types.length; i++) {
			if (transferData.type == types[i])
				return i;
		}
		
		return -1;
	}
	
    public void setSelection(ISelection s) {
    }
}
