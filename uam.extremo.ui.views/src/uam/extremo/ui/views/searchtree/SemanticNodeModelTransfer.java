package uam.extremo.ui.views.searchtree;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import uam.extremo.ui.views.Serializer;

import semanticmanager.NamedElement;

public class SemanticNodeModelTransfer extends ByteArrayTransfer {
	private static final String TYPE_NAME = "extremo-model-transfer-format";
	private static final int TYPE_ID = registerType(TYPE_NAME);
	
	private static final SemanticNodeModelTransfer INSTANCE = new SemanticNodeModelTransfer();
	
	public static SemanticNodeModelTransfer getTransfer() {
		return INSTANCE;
	}
	
	protected SemanticNodeModelTransfer(){
	}
	
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
		byte[] data = Serializer.serialize(object);
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
		if (transferData == null) return -1;
		int[] types = getTypeIds();
		for (int i = 0; i < types.length; i++) {
			if (transferData.type == types[i]) return i;
		}
		return -1;
	}
	
    public void setSelection(ISelection s) {
    }
}
