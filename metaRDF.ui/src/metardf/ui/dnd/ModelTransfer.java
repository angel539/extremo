package metardf.ui.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import metaRDF.core.model.impl.SemanticClass;

public class ModelTransfer extends ByteArrayTransfer {
	private static final String CLASS_TYPE = "SemanticClass";
	private static final int CLASS_ID = registerType(CLASS_TYPE);
	
	private static ModelTransfer _instance = new ModelTransfer();
	
	public static ModelTransfer getInstance(){
		return _instance;
	}

	public void javaToNative(Object object, TransferData transferData) {
		if (!checkIfSemanticClass(object) || !isSupportedType(transferData)){
			System.out.println("_" + checkIfSemanticClass(object) + " ^ " + isSupportedType(transferData) + "  obj: " + object + " transfer: " + transferData);
		}
		
		SemanticClass[] semanticClasses = (SemanticClass[]) object;
		
		try{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DataOutputStream writeOut = new DataOutputStream(out);
			
			for(SemanticClass semanticClass : semanticClasses){
				byte[] nameBuffer = semanticClass.getName().getBytes();
				writeOut.writeInt(nameBuffer.length);
				writeOut.write(nameBuffer);
			}
			
			byte[] buffer = out.toByteArray();
			writeOut.close();
			super.javaToNative(buffer, transferData);
		}
		catch (IOException e) { } 
	}

	public Object nativeToJava(TransferData transferData) {
		if (isSupportedType(transferData)) {
			byte[] buffer = (byte[]) super.nativeToJava(transferData);
			if (buffer == null) return null;
			
			SemanticClass[] semanticClass = new SemanticClass[0];
			try {
				ByteArrayInputStream in = new ByteArrayInputStream(buffer);
				DataInputStream readIn = new DataInputStream(in);
				
				while (readIn.available() > 20) {
					SemanticClass data = new SemanticClass();
					int size = readIn.readInt();
					byte[] name = new byte[size];
					readIn.read(name);
					
					data.setName(new String(name));
					
					SemanticClass[] newSemanticClass = new SemanticClass[semanticClass.length + 1];
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
	
	private boolean checkIfSemanticClass(Object object) {
		if((object == null) || !(object instanceof SemanticClass[]) || (((SemanticClass[]) object).length == 0)){
			return false;
		}
		
		SemanticClass[] semanticClasses = (SemanticClass[]) object;
		for(int i = 0; i < semanticClasses.length; i++){
			if((semanticClasses[i] == null) || (semanticClasses[i].getName() == null) || (semanticClasses[i].getName().length() == 0)){
				return false;
			}
		}
		return true;
	}
	
	protected boolean validate(Object object){
		return checkIfSemanticClass(object);
	}
	
	@Override
	protected int[] getTypeIds() {
		return new int[]{CLASS_ID};
	}

	@Override
	protected String[] getTypeNames() {
		return new String[]{CLASS_TYPE};
	}

}
