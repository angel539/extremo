package metardf.ui.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.osgi.framework.Bundle;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metardf.core.extensions.AssistantFactory;
import metardf.ui.views.entities.model.TreeObject;

public class ModelTransfer extends ByteArrayTransfer {
	private static final String SEMANTIC_CLASS_TYPE = "SemanticClass";
	private static final int SEMANTIC_CLASS_ID = registerType(SEMANTIC_CLASS_TYPE);
	
	private static ModelTransfer _instance = new ModelTransfer();
	
	public static ModelTransfer getInstance(){
		return _instance;
	}

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
							writeOut.writeInt(0); //if semanticclass
							
							byte[] nameBuffer = ((ISemanticClass) semanticElement).getName().getBytes();
							writeOut.writeInt(nameBuffer.length);
							writeOut.write(nameBuffer);
							
							byte[] idToStringBuffer = ((ISemanticClass) semanticElement).getIdToString().getBytes();
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
							
							byte[] idToStringBuffer = ((IObjectProperty) semanticElement).getIdToString().getBytes();
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
							
							byte[] idToStringBuffer = ((IDataProperty) semanticElement).getIdToString().getBytes();
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
			
			ISemanticElement[] semanticElement = new ISemanticElement[0];
			
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
								ISemanticClass[] newSemanticClass = new ISemanticClass[semanticElement.length + 1];
								System .arraycopy(semanticElement, 0, newSemanticClass, 0, semanticElement.length);
								
								Object semanticObject = loadReflectiveClassFromExternalBundle(new String(className));
								if(semanticObject instanceof ISemanticClass){
									((ISemanticClass) semanticObject).setName(new String(name));
									((ISemanticClass) semanticObject).setIdToString(new String(idToString));
									((ISemanticClass) semanticObject).setDescription(new String(idDescription));
									
									newSemanticClass[semanticElement.length] = (ISemanticClass) semanticObject;
									semanticElement = newSemanticClass;
								}
								break;
							
							case 1:
								IObjectProperty[] newObjectProperty = new IObjectProperty[semanticElement.length + 1];
								System .arraycopy(semanticElement, 0, newObjectProperty, 0, semanticElement.length);
								
								Object objectObject = loadReflectiveClassFromExternalBundle(new String(className));
								if(objectObject instanceof IObjectProperty){
									((IObjectProperty) objectObject).setName(new String(name));
									((IObjectProperty) objectObject).setIdToString(new String(idToString));
									((IObjectProperty) objectObject).setDescription(new String(idDescription));
									
									newObjectProperty[semanticElement.length] = (IObjectProperty) objectObject;
									semanticElement = newObjectProperty;
								}
								
								break;
							
							case 2:
								IDataProperty[] newDataProperty = new IDataProperty[semanticElement.length + 1];
								System .arraycopy(semanticElement, 0, newDataProperty, 0, semanticElement.length);
								
								Object dataObject = loadReflectiveClassFromExternalBundle(new String(className));
								if(dataObject instanceof IDataProperty){
									((IDataProperty) dataObject).setName(new String(name));
									((IDataProperty) dataObject).setIdToString(new String(idToString));
									((IDataProperty) dataObject).setDescription(new String(idDescription));
									
									newDataProperty[semanticElement.length] = (IDataProperty) dataObject;
									semanticElement = newDataProperty;
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
			
			return semanticElement;
		}
		
		return null;
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
							//classes.add();
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
