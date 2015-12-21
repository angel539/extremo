package metardf.ui.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import metardf.ui.views.entities.TreeObject;

public class ModelTransfer extends ByteArrayTransfer {
	private static final String CLASS_TYPE = "EntityParent";
	private static final int CLASS_ID = registerType(CLASS_TYPE);
	
	private static ModelTransfer _instance = new ModelTransfer();
	
	public static ModelTransfer getInstance(){
		return _instance;
	}

	public void javaToNative(Object object, TransferData transferData) {
		if (!checkIfSemanticClass(object) || !isSupportedType(transferData)){
			System.out.println("_" + checkIfSemanticClass(object) + " ^ " + isSupportedType(transferData) + "  obj: " + object + " transfer: " + transferData);
		}
		
		List<TreeObject> myTypes = new ArrayList<TreeObject>();
		if(object instanceof TreeObject){
			TreeObject newobject = new TreeObject(((EntityParent) object).getName());
			myTypes.add(newobject);
			//myTypes = (TreeObject[]) newobject;
		}
		
		/*
		 * List<SemanticElement> myTypes = new ArrayList<SemanticElement>();
		if(object instanceof EntityParent){
			TreeObject newobject = new TreeObject(((EntityParent) object).getName());
			myTypes.add(newobject);
			//myTypes = (TreeObject[]) newobject;
		}
		 */
		
		
		try{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DataOutputStream writeOut = new DataOutputStream(out);
			
			for(TreeObject myType : myTypes){
				byte[] buffer = myType.getName().getBytes();
				writeOut.writeInt(buffer.length);
				writeOut.write(buffer);
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
			
			TreeObject[] myData = new TreeObject[0];
			try {
				ByteArrayInputStream in = new ByteArrayInputStream(buffer);
				DataInputStream readIn = new DataInputStream(in);
				
				while (readIn.available() > 20) {
					
					int size = readIn.readInt();
					byte[] name = new byte[size];
					readIn.read(name);
					
					TreeObject datum = new TreeObject(new String(name));
					TreeObject[] newMyData = new TreeObject[myData.length + 1];
					System .arraycopy(myData, 0, newMyData, 0, myData.length);
					newMyData[myData.length] = datum;
					myData = newMyData;
				}
				
				readIn.close();
			}
			catch (IOException ex) {return null;}
			
			return myData;
		}
		
		return null;
	}
	
	private boolean checkIfSemanticClass(Object object) {
		if((object == null) || !(object instanceof TreeObject[]) || (((TreeObject[]) object).length == 0)){
			System.out.println("No pasa el check");
			return false;
		}
		
		TreeObject[] semanticClasses = (TreeObject[]) object;
		for(int i = 0; i < semanticClasses.length; i++){
			if((semanticClasses[i] == null) || (semanticClasses[i].getName() == null) || (semanticClasses[i].getName().length() == 0)){
				System.out.println("No pasa el check 2");
				return false;
			}
		}
		return true;
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
