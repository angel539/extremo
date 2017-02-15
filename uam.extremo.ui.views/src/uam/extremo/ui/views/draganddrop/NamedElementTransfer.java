package uam.extremo.ui.views.draganddrop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

import semanticmanager.NamedElement;
import uam.extremo.extensions.AssistantFactory;

public class NamedElementTransfer extends ByteArrayTransfer{
	private static final NamedElementTransfer INSTANCE = new NamedElementTransfer();
	
	public static NamedElementTransfer getInstance() {
		return INSTANCE;
	}
	
	private NamedElementTransfer() {
		super();
	}
	
	private static final String TYPE_NAME =
		      "namedelement-transfer-format:" + System.currentTimeMillis() + ":" + INSTANCE.hashCode();
	
	private static final int TYPEID =
			registerType(TYPE_NAME);
	
	@Override
	protected int[] getTypeIds() {
		return new int[] {TYPEID};
	}

	@Override
	protected String[] getTypeNames() {
		return new String[] {TYPE_NAME};
	}
	
	protected void javaToNative(
		      Object data,
		      TransferData transferData) {
		
		if (!(data instanceof NamedElement[])) return;
		
		NamedElement[] items = (NamedElement[]) data;
		
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DataOutputStream dataOut = new DataOutputStream(out);
			dataOut.writeInt(items.length);
			
			for (int i = 0; i < items.length; i++) {
				NamedElement item = items[i];
				dataOut.writeUTF(item.getName());
			}
			
			dataOut.close();
			out.close();
			super.javaToNative(out.toByteArray(), transferData);
		}
		catch (IOException e) {
			// Send nothing if there were problems.
		}
	}
	
	protected Object nativeToJava(TransferData transferData) {
		byte[] bytes = (byte[]) super.nativeToJava(transferData);
		
		if (bytes == null) return null;
		
		DataInputStream in =
				new DataInputStream(new ByteArrayInputStream(bytes));
		
		try {
			AssistantFactory manager = AssistantFactory.getInstance();
			
			int count = in.readInt();
			List<NamedElement> items = new ArrayList<NamedElement>(count);
			
			for (int i = 0; i < count; i++) {
				String name = in.readUTF();
				items.add(manager.searchNamedElement(AssistantFactory.getInstance().getRepositoryManager(), name));
			}
			
			return items.toArray(new NamedElement[items.size()]);
		}
		catch (IOException e) {
			return null;
		}
	}
}
