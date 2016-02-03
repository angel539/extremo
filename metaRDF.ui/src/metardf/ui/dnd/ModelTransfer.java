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
import metardf.ui.views.entities.model.EntityParent;

public class ModelTransfer extends ByteArrayTransfer {
	private static final String SEMANTIC_CLASS_TYPE = "SemanticClass";
	private static final int SEMANTIC_CLASS_ID = registerType(SEMANTIC_CLASS_TYPE);
	
	private static ModelTransfer _instance = new ModelTransfer();
	
	public static ModelTransfer getInstance(){
		return _instance;
	}

	public void javaToNative(Object object, TransferData transferData) {
		if (!checkIfSemanticElement(((EntityParent) object).getSemanticElement()) || (isDefinedSupportedType(transferData)!=-1)){
			ISemanticElement semanticClass = ((EntityParent) object).getSemanticElement();
			//System.out.println("la clase del model transfer..." + ((EntityParent) object).getSemanticElement().getClass());
			
			try{
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				DataOutputStream writeOut = new DataOutputStream(out);
				
				byte[] classInfoBuffer = ((EntityParent) object).getSemanticElement().getClass().getName().getBytes();
				writeOut.writeInt(classInfoBuffer.length);
				writeOut.write(classInfoBuffer);
				
				if(semanticClass instanceof ISemanticClass){
					writeOut.writeInt(0); //if semanticclass
					
					byte[] nameBuffer = ((ISemanticClass) semanticClass).getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
					
					byte[] idToStringBuffer = ((ISemanticClass) semanticClass).getIdToString().getBytes();
					writeOut.writeInt(idToStringBuffer.length);
					writeOut.write(idToStringBuffer);
					
					byte[] descriptionBuffer = ((ISemanticClass) semanticClass).getDescription().getBytes();
					writeOut.writeInt(descriptionBuffer.length);
					writeOut.write(descriptionBuffer);
				}
				
				if(semanticClass instanceof IObjectProperty){
					writeOut.writeInt(1);
					byte[] nameBuffer = ((IObjectProperty) semanticClass).getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
					
					byte[] idToStringBuffer = ((IObjectProperty) semanticClass).getIdToString().getBytes();
					writeOut.writeInt(idToStringBuffer.length);
					writeOut.write(idToStringBuffer);
					
					byte[] descriptionBuffer = ((IObjectProperty) semanticClass).getDescription().getBytes();
					writeOut.writeInt(descriptionBuffer.length);
					writeOut.write(descriptionBuffer);
				}
				
				if(semanticClass instanceof IDataProperty){
					writeOut.writeInt(2);
					
					byte[] nameBuffer = ((IDataProperty) semanticClass).getName().getBytes();
					writeOut.writeInt(nameBuffer.length);
					writeOut.write(nameBuffer);
					
					byte[] idToStringBuffer = ((IDataProperty) semanticClass).getIdToString().getBytes();
					writeOut.writeInt(idToStringBuffer.length);
					writeOut.write(idToStringBuffer);
					
					byte[] descriptionBuffer = ((IDataProperty) semanticClass).getDescription().getBytes();
					writeOut.writeInt(descriptionBuffer.length);
					writeOut.write(descriptionBuffer);
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

	public Object nativeToJava(TransferData transferData) {
		if (isSupportedType(transferData)) {
			byte[] buffer = (byte[]) super.nativeToJava(transferData);
			if (buffer == null) return null;
			
			ISemanticElement[] semanticClass = new ISemanticElement[0];
			try {
				ByteArrayInputStream in = new ByteArrayInputStream(buffer);
				DataInputStream readIn = new DataInputStream(in);
				
				if(readIn.available() > 0){					
					int sizeClassName = readIn.readInt();
					byte[] className = new byte[sizeClassName];
					readIn.read(className);
					
					while (readIn.available() > 0) {
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
						
						/*int sizeIdString = readIn.readInt();
						byte[] idString = new byte[sizeIdString];
						readIn.read(idString);*/
						
						switch(type){
							case 0:
								ISemanticClass[] newSemanticClass = new ISemanticClass[semanticClass.length + 1];
								System .arraycopy(semanticClass, 0, newSemanticClass, 0, semanticClass.length);
								
								//Class<? extends ISemanticClass> semanticClazz = Class.forName(new String(className)).asSubclass(ISemanticClass.class);
								//ISemanticClass semanticObject = (ISemanticClass) semanticClazz.newInstance();
								Object semanticObject = loadReflectiveClassFromExternalBundle(new String(className));
								if(semanticObject instanceof ISemanticClass){
									((ISemanticClass) semanticObject).setName(new String(name));
									((ISemanticClass) semanticObject).setIdToString(new String(idToString));
									((ISemanticClass) semanticObject).setDescription(new String(idDescription));
									
									newSemanticClass[semanticClass.length] = (ISemanticClass) semanticObject;
									semanticClass = newSemanticClass;
								}
								break;
							
							case 1:
								IObjectProperty[] newObjectProperty = new IObjectProperty[semanticClass.length + 1];
								System .arraycopy(semanticClass, 0, newObjectProperty, 0, semanticClass.length);
								
								//Class<? extends IObjectProperty> objectClazz = Class.forName(new String(className)).asSubclass(IObjectProperty.class);
								//IObjectProperty objectObject = (IObjectProperty) objectClazz.newInstance();
								Object objectObject = loadReflectiveClassFromExternalBundle(new String(className));
								if(objectObject instanceof IObjectProperty){
									((IObjectProperty) objectObject).setName(new String(name));
									((IObjectProperty) objectObject).setIdToString(new String(idToString));
									((IObjectProperty) objectObject).setDescription(new String(idDescription));
									
									newObjectProperty[semanticClass.length] = (IObjectProperty) objectObject;
									semanticClass = newObjectProperty;
								}
								
								break;
							
							case 2:
								IDataProperty[] newDataProperty = new IDataProperty[semanticClass.length + 1];
								System .arraycopy(semanticClass, 0, newDataProperty, 0, semanticClass.length);
								
								//Class<? extends IDataProperty> dataClazz = Class.forName(new String(className)).asSubclass(IDataProperty.class);
								//IDataProperty dataObject = (IDataProperty) dataClazz.newInstance();
								
								Object dataObject = loadReflectiveClassFromExternalBundle(new String(className));
								if(dataObject instanceof IObjectProperty){
									((IDataProperty) dataObject).setName(new String(name));
									((IDataProperty) dataObject).setIdToString(new String(idToString));
									((IDataProperty) dataObject).setDescription(new String(idDescription));
									
									newDataProperty[semanticClass.length] = (IDataProperty) dataObject;
									semanticClass = newDataProperty;
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
			
			return semanticClass;
		}
		
		return null;
	}
	
	private Object loadReflectiveClassFromExternalBundle(String name){
		//Set<Class<? extends ISemanticElement>> classes = ReflectiveUtils.getAllSemanticClassInstances();
		//List<Object> classes = new ArrayList<Object>();
		
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
