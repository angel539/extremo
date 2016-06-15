package metardf.ui.dnd;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.osgi.framework.Bundle;

import metaRDF.core.model.ISemanticElement;
import metardf.core.extensions.AssistantFactory;
import metardf.ui.Serializer;

public class ExtremoModelTransfer extends ByteArrayTransfer {
	private static final String TYPE_NAME = "extremo-model-transfer-format";
	private static final int TYPE_ID = registerType(TYPE_NAME);
	
	private static final ExtremoModelTransfer INSTANCE = new ExtremoModelTransfer();
	
	public static ExtremoModelTransfer getTransfer() {
		return INSTANCE;
	}
	
	protected ExtremoModelTransfer(){
	}
	
	@Override
	protected int[] getTypeIds() {
		return new int[]{TYPE_ID};
	}

	@Override
	protected String[] getTypeNames() {
		return new String[]{TYPE_NAME};
	}
/*
	public void javaToNative(Object semanticElements, TransferData transferData) {
		if(semanticElements != null){
			if (!checkIfSemanticElement(semanticElements) || (isDefinedSupportedType(transferData)!=-1)){
				try{
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					DataOutputStream writeOut = new DataOutputStream(out);
					
					for(ISemanticElement semanticElement : (ISemanticElement[]) semanticElements){
						byte[] classInfoBuffer = semanticElement.getClass().getName().getBytes();
						writeOut.writeInt(classInfoBuffer.length);
						writeOut.write(classInfoBuffer);
						
						if(semanticElement instanceof ISemanticClass){
							writeOut.writeInt(0);
							
							byte[] nameBuffer = ((ISemanticClass) semanticElement).getName().getBytes();
							writeOut.writeInt(nameBuffer.length);
							writeOut.write(nameBuffer);
							
							byte[] idToStringBuffer = ((String) ((ISemanticClass) semanticElement).getId()).getBytes();
							writeOut.writeInt(idToStringBuffer.length);
							writeOut.write(idToStringBuffer);
							
							byte[] descriptionBuffer = ((ISemanticClass) semanticElement).getDescription().getBytes();
							writeOut.writeInt(descriptionBuffer.length);
							writeOut.write(descriptionBuffer);
						}
						
						if(semanticElement instanceof IObjectProperty){
							writeOut.writeInt(1);
							byte[] nameBuffer = ((IObjectProperty) semanticElement).getName().getBytes();
							writeOut.writeInt(nameBuffer.length);
							writeOut.write(nameBuffer);
							
							byte[] idToStringBuffer = ((String) ((IObjectProperty) semanticElement).getId()).getBytes();
							writeOut.writeInt(idToStringBuffer.length);
							writeOut.write(idToStringBuffer);
							
							byte[] descriptionBuffer = ((IObjectProperty) semanticElement).getDescription().getBytes();
							writeOut.writeInt(descriptionBuffer.length);
							writeOut.write(descriptionBuffer);
						}
						
						if(semanticElement instanceof IDataProperty){
							writeOut.writeInt(2);
							byte[] nameBuffer = ((IDataProperty) semanticElement).getName().getBytes();
							writeOut.writeInt(nameBuffer.length);
							writeOut.write(nameBuffer);
							
							byte[] idToStringBuffer = ((String) ((IDataProperty) semanticElement).getId()).getBytes();
							writeOut.writeInt(idToStringBuffer.length);
							writeOut.write(idToStringBuffer);
							
							byte[] descriptionBuffer = ((IDataProperty) semanticElement).getDescription().getBytes();
							writeOut.writeInt(descriptionBuffer.length);
							writeOut.write(descriptionBuffer);
						}						
					}
					
					byte[] buffer = out.toByteArray();
					writeOut.close();	
					super.javaToNative(buffer, transferData);
					
				}
				catch (IOException e) { } catch (IllegalArgumentException e) {
					e.printStackTrace();
				};
			}
		}
	}

	public Object nativeToJava(TransferData transferData) {
		if (isSupportedType(transferData)) {
			byte[] buffer = (byte[]) super.nativeToJava(transferData);
			if (buffer == null) return null;
			
			List<ISemanticElement> semanticElement = new ArrayList<ISemanticElement>();
			
			try {
				ByteArrayInputStream in = new ByteArrayInputStream(buffer);
				DataInputStream readIn = new DataInputStream(in);
				
				if(readIn.available() > 0){					
					while (readIn.available() > 0) {
						int sizeClassName = readIn.readInt();
						byte[] className = new byte[sizeClassName];
						readIn.read(className);
						
						int type = readIn.readInt();
						
						int sizeName = readIn.readInt();
						byte[] name = new byte[sizeName];
						readIn.read(name);
						
						int sizeIdToString = readIn.readInt();
						byte[] idToString = new byte[sizeIdToString];
						readIn.read(idToString);
						
						int sizeDescription = readIn.readInt();
						byte[] idDescription = new byte[sizeDescription];
						readIn.read(idDescription);
						
						switch(type){
							case 0:
								Object semanticObject = loadReflectiveClassFromExternalBundle(new String(className));
								if(semanticObject instanceof ISemanticClass){
									((ISemanticClass) semanticObject).setName(new String(name));
									((ISemanticClass) semanticObject).setId(new String(idToString));
									((ISemanticClass) semanticObject).setDescription(new String(idDescription));
									
									semanticElement.add((ISemanticClass)semanticObject);
								}
								break;
							
							case 1:
								Object objectObject = loadReflectiveClassFromExternalBundle(new String(className));
								if(objectObject instanceof IObjectProperty){
									((IObjectProperty) objectObject).setName(new String(name));
									((IObjectProperty) objectObject).setId(new String(idToString));
									((IObjectProperty) objectObject).setDescription(new String(idDescription));
									
									
									semanticElement.add((IObjectProperty)objectObject);
								}
								
								break;
							
							case 2:
								Object dataObject = loadReflectiveClassFromExternalBundle(new String(className));
								if(dataObject instanceof IDataProperty){
									((IDataProperty) dataObject).setName(new String(name));
									((IDataProperty) dataObject).setId(new String(idToString));
									((IDataProperty) dataObject).setDescription(new String(idDescription));
									
									semanticElement.add((IDataProperty)dataObject);
								}
								
								break;
								
							default:
								break;
						}	
					}
				}
				readIn.close();
			}
			catch (IOException ex) {
				return null;
			}
			
			return semanticElement.toArray(new ISemanticElement[semanticElement.size()]);
		}
		
		return null;
	}
*/
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
		Map<Bundle, List<Class<? extends ISemanticElement>>> registeredTypes = AssistantFactory.getInstance().getRegisteredTypes();
		for (Map.Entry<Bundle, List<Class<? extends ISemanticElement>>> entry : registeredTypes.entrySet()){
			Bundle bundle = entry.getKey();
			List<Class<? extends ISemanticElement>> semanticElements = entry.getValue();
			for(Class<? extends ISemanticElement> semanticElement : semanticElements){
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
		}
		
		return null;
	}
	
	private boolean checkIfSemanticElement(Object object) {
		if((object == null) || !(object instanceof ISemanticElement[]) || (((ISemanticElement[]) object).length == 0)){
			return false;
		}
		
		ISemanticElement[] semanticElements = (ISemanticElement[]) object;
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
	
    public void setSelection(ISelection s) {
    }
}
