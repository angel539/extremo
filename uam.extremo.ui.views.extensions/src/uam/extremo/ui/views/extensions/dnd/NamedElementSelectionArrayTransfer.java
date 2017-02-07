package uam.extremo.ui.views.extensions.dnd;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import semanticmanager.NamedElement;

public class NamedElementSelectionArrayTransfer extends ByteArrayTransfer {
	private static final String TYPE_NAME = "extremo-model-transfer-format";
	private static final int TYPE_ID = registerType(TYPE_NAME);
	
	private static final NamedElementSelectionArrayTransfer INSTANCE = new NamedElementSelectionArrayTransfer();
	
	public static NamedElementSelectionArrayTransfer getTransfer() {
		return INSTANCE;
	}
	
	protected NamedElementSelectionArrayTransfer(){
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
	
    private boolean isInvalidNativeType(Object result) {
        return !(result instanceof byte[])
                || !TYPE_NAME.equals(new String((byte[]) result));
    }
	
	private Object loadReflectiveClassFromExternalBundle(String name){		
		/*Map<Bundle, List<Class<? extends NamedElement>>> registeredTypes = AssistantFactory.getInstance().getRegisteredTypes();
	
		for (Map.Entry<Bundle, List<Class<? extends NamedElement>>> entry : registeredTypes.entrySet()){
			Bundle bundle = entry.getKey();
			List<Class<? extends NamedElement>> semanticElements = entry.getValue();
			for(Class<? extends NamedElement> semanticElement : semanticElements){
				if(semanticElement.getName().equals(name)){
					Class<?> classBundle;
					try {
						classBundle = bundle.loadClass(semanticElement.getName());
						if (classBundle!=null){
							return classBundle.newInstance();
						}
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
						return null;
					}
				}
			}
		}*/
		
		return null;
	}
	
	private boolean checkIfSemanticElement(Object object) {
		if((object == null) || 
				!(object instanceof NamedElement[]) || 
				(((NamedElement[]) object).length == 0)){
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
		return checkIfSemanticElement(object);
	}
	
	public int isDefinedSupportedType(TransferData transferData){
		if (transferData == null) return -1;
		int[] types = getTypeIds();
		for (int i = 0; i < types.length; i++) {
			if (transferData.type == types[i]) return i;
		}
		return -1;
	}
	
    /*public void setSelection(ISelection s) {
    }*/
}
