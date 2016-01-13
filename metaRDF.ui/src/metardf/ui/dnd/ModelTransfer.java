package metardf.ui.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.DataProperty;
import metaRDF.core.model.impl.ObjectProperty;
import metaRDF.core.model.impl.SemanticClass;
import metardf.ui.views.entities.TreeObject;

public class ModelTransfer extends ByteArrayTransfer {
	private static final String SEMANTIC_CLASS_TYPE = "SemanticClass";
	
	private static final int SEMANTIC_CLASS_ID = registerType(SEMANTIC_CLASS_TYPE);
	
	private static ModelTransfer _instance = new ModelTransfer();
	
	public static ModelTransfer getInstance(){
		return _instance;
	}

	public void javaToNative(Object object, TransferData transferData) {
		if (!checkIfSemanticElement(((TreeObject) object).getSemanticElement()) || (isDefinedSupportedType(transferData)!=-1)){
			System.out.println("_" + checkIfSemanticElement(((TreeObject) object).getSemanticElement()) + " ^ " + isSupportedType(transferData) + "  obj: " + object + " transfer: " + transferData + " ..." + transferData.type);
		
			ISemanticElement semanticClass = ((TreeObject) object).getSemanticElement();
		
			try{
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				DataOutputStream writeOut = new DataOutputStream(out);
				
				/*for(SemanticClass semanticClass : semanticClasses){
					byte[] nameBuffer = semanticClass.getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
				}*/
				
				if(semanticClass instanceof SemanticClass){
					writeOut.writeInt(0); //if semanticclass
					
					byte[] nameBuffer = semanticClass.getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
					
					byte[] uriBuffer = semanticClass.getURI().getBytes();
					writeOut.writeInt(uriBuffer.length);
					writeOut.write(uriBuffer);
				}
				
				if(semanticClass instanceof ObjectProperty){
					writeOut.writeInt(1);
					
					byte[] nameBuffer = semanticClass.getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
					
					byte[] uriBuffer = semanticClass.getURI().getBytes();
					writeOut.writeInt(uriBuffer.length);
					writeOut.write(uriBuffer);
				}
				
				if(semanticClass instanceof DataProperty){
					writeOut.writeInt(2);
					
					byte[] nameBuffer = semanticClass.getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
					
					byte[] uriBuffer = semanticClass.getURI().getBytes();
					writeOut.writeInt(uriBuffer.length);
					writeOut.write(uriBuffer);
				}
				
				
				byte[] buffer = out.toByteArray();
				writeOut.close();
				super.javaToNative(buffer, transferData);
			}
			catch (IOException e) { };
		}
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
					int type = readIn.readInt();
					
					int sizeName = readIn.readInt();
					byte[] name = new byte[sizeName];
					readIn.read(name);
					//data.setName(new String(name));
					
					int sizeUri = readIn.readInt();
					byte[] uri = new byte[sizeUri];
					readIn.read(uri);
					//data.setUri(new String(uri));
					
					ISemanticElement[] newSemanticClass = new ISemanticElement[semanticClass.length + 1];
					System .arraycopy(semanticClass, 0, newSemanticClass, 0, semanticClass.length);
					
					switch(type){
						case 0:
							System.out.println("voy a definir una semanticclass");
							SemanticClass semanticclassdata = new SemanticClass(new String(name), new String(uri), null, null);
							newSemanticClass[semanticClass.length] = semanticclassdata;
							semanticClass = newSemanticClass;
							break;
						
						case 1:
							System.out.println("voy a definir una objectproperty");
							ObjectProperty objectpropertydata = new ObjectProperty(new String(name), new String(uri), null, false, null);
							newSemanticClass[semanticClass.length] = objectpropertydata;
							semanticClass = newSemanticClass;
							break;
						
						case 2:
							System.out.println("voy a definir una dataproperty");
							DataProperty datapropertydata = new DataProperty(new String(name), new String(uri), null, false, null);
							newSemanticClass[semanticClass.length] = datapropertydata;
							semanticClass = newSemanticClass;
							break;
						default:
							System.out.println("voy a definir un objeto X");
							break;
					}	
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
		return new int[]{SEMANTIC_CLASS_ID};
	}

	@Override
	protected String[] getTypeNames() {
		return new String[]{SEMANTIC_CLASS_TYPE};
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
