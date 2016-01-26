package metardf.ui.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metardf.core.ecore.assistant.model.EcoreDataProperty;
import metardf.core.ecore.assistant.model.EcoreObjectProperty;
import metardf.core.ecore.assistant.model.EcoreSemanticClass;
import metardf.ui.views.entities.model.TreeObject;

public class ModelTransfer extends ByteArrayTransfer {
	private static final String SEMANTIC_CLASS_TYPE = "SemanticClass";
	private static final int SEMANTIC_CLASS_ID = registerType(SEMANTIC_CLASS_TYPE);
	
	private static ModelTransfer _instance = new ModelTransfer();
	
	public static ModelTransfer getInstance(){
		return _instance;
	}

	public void javaToNative(Object object, TransferData transferData) {
		if (!checkIfSemanticElement(((TreeObject) object).getSemanticElement()) || (isDefinedSupportedType(transferData)!=-1)){
			ISemanticElement semanticClass = ((TreeObject) object).getSemanticElement();
			
			try{
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				DataOutputStream writeOut = new DataOutputStream(out);
				
				
				if(semanticClass instanceof ISemanticClass){
					writeOut.writeInt(0); //if semanticclass
					
					byte[] nameBuffer = semanticClass.getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
				}
				
				if(semanticClass instanceof IObjectProperty){
					writeOut.writeInt(1);
					
					byte[] nameBuffer = semanticClass.getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
				}
				
				if(semanticClass instanceof IDataProperty){
					writeOut.writeInt(2);
					
					byte[] nameBuffer = semanticClass.getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
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
			
			Object[] semanticClass = new Object[0];
			try {
				ByteArrayInputStream in = new ByteArrayInputStream(buffer);
				DataInputStream readIn = new DataInputStream(in);
				
				while (readIn.available() > 20) {
					int type = readIn.readInt();
					
					int sizeName = readIn.readInt();
					byte[] name = new byte[sizeName];
					readIn.read(name);
			
					switch(type){
						case 0:
							ISemanticClass[] newSemanticClass = new ISemanticClass[semanticClass.length + 1];
							System .arraycopy(semanticClass, 0, newSemanticClass, 0, semanticClass.length);
							
							EcoreSemanticClass semanticclassdata = new EcoreSemanticClass(null, new String(name), "");
							newSemanticClass[semanticClass.length] = semanticclassdata;
							semanticClass = newSemanticClass;
							break;
						
						case 1:
							IObjectProperty[] newObjectProperty = new IObjectProperty[semanticClass.length + 1];
							System .arraycopy(semanticClass, 0, newObjectProperty, 0, semanticClass.length);
							
							EcoreObjectProperty objectpropertydata = new EcoreObjectProperty(null, null, new String(name), false, null);
							newObjectProperty[semanticClass.length] = objectpropertydata;
							semanticClass = newObjectProperty;
							break;
						
						case 2:
							IDataProperty[] newDataProperty = new IDataProperty[semanticClass.length + 1];
							System .arraycopy(semanticClass, 0, newDataProperty, 0, semanticClass.length);
							
							EcoreDataProperty datapropertydata = new EcoreDataProperty(null, new String(name), null, false, null);
							newDataProperty[semanticClass.length] = datapropertydata;
							semanticClass = newDataProperty;
							break;
							
						default:
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
