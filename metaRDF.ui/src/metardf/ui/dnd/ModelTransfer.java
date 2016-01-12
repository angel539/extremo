package metardf.ui.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.SemanticClass;
import metardf.ui.views.entities.TreeObject;

public class ModelTransfer extends ByteArrayTransfer {
	private static final String SEMANTIC_CLASS_TYPE = "SemanticClass";
	private static final String OBJECT_PROPERTY_TYPE = "ObjectProperty";
	private static final String DATA_PROPERTY_TYPE = "DataProperty";

	private static final int SEMANTIC_CLASS_ID = registerType(SEMANTIC_CLASS_TYPE);
	private static final int OBJECT_PROPERTY_ID = registerType(OBJECT_PROPERTY_TYPE);
	private static final int DATA_PROPERTY_ID = registerType(DATA_PROPERTY_TYPE);
	
	private static ModelTransfer _instance = new ModelTransfer();
	
	public static ModelTransfer getInstance(){
		return _instance;
	}

	public void javaToNative(Object object, TransferData transferData) {
		if (!checkIfSemanticElement(((TreeObject) object).getSemanticElement()) || (isDefinedSupportedType(transferData)!=-1)){
			System.out.println("_" + checkIfSemanticElement(((TreeObject) object).getSemanticElement()) + " ^ " + isSupportedType(transferData) + "  obj: " + object + " transfer: " + transferData + " ..." + transferData.type);
		}
		
		ISemanticElement semanticClass = ((TreeObject) object).getSemanticElement();
	
		try{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DataOutputStream writeOut = new DataOutputStream(out);
			
			/*for(SemanticClass semanticClass : semanticClasses){
				byte[] nameBuffer = semanticClass.getName().getBytes();
				writeOut.writeInt(nameBuffer.length);
				writeOut.write(nameBuffer);
			}*/
			
			byte[] nameBuffer = semanticClass.getName().getBytes();
			writeOut.writeInt(nameBuffer.length);
			writeOut.write(nameBuffer);
			
			byte[] buffer = out.toByteArray();
			writeOut.close();
			super.javaToNative(buffer, transferData);
		}
		catch (IOException e) { };		
	}

	public Object nativeToJava(TransferData transferData) {
		if (isSupportedType(transferData)) {
			byte[] buffer = (byte[]) super.nativeToJava(transferData);
			if (buffer == null) return null;
			
			ISemanticElement[] semanticClass = new ISemanticElement[0];
			try {
				ByteArrayInputStream in = new ByteArrayInputStream(buffer);
				DataInputStream readIn = new DataInputStream(in);
				
				while (readIn.available() > 20) {
					SemanticClass data = new SemanticClass();
					int size = readIn.readInt();
					byte[] name = new byte[size];
					readIn.read(name);
					
					data.setName(new String(name));
					
					ISemanticElement[] newSemanticClass = new ISemanticElement[semanticClass.length + 1];
					System .arraycopy(semanticClass, 0, newSemanticClass, 0, semanticClass.length);
					newSemanticClass[semanticClass.length] = data;
					semanticClass = newSemanticClass;
				}
				
				readIn.close();
			}
			catch (IOException ex) {return null;}
			
			return semanticClass;
		}
		
		return null;
	}
	
	private boolean checkIfSemanticElement(Object object) {
		if((object == null) || !(object instanceof ISemanticElement[]) || (((ISemanticElement[]) object).length == 0)){
			return false;
		}
		
		ISemanticElement[] semanticClasses = (ISemanticElement[]) object;
		for(int i = 0; i < semanticClasses.length; i++){
			if((semanticClasses[i] == null) || (semanticClasses[i].getName() == null) || (semanticClasses[i].getName().length() == 0)){
				return false;
			}
		}
		return true;
	}
	
	protected boolean validate(Object object){
		return checkIfSemanticElement(object);
	}
	
	@Override
	protected int[] getTypeIds() {
		return new int[]{SEMANTIC_CLASS_ID, OBJECT_PROPERTY_ID, DATA_PROPERTY_ID};
	}

	@Override
	protected String[] getTypeNames() {
		return new String[]{SEMANTIC_CLASS_TYPE, OBJECT_PROPERTY_TYPE, DATA_PROPERTY_TYPE};
	}

	public int isDefinedSupportedType(TransferData transferData){
		if (transferData == null) return -1;
		int[] types = getTypeIds();
		for (int i = 0; i < types.length; i++) {
			if (transferData.type == types[i]) return i;
		}
		return -1;
	}
	
}
