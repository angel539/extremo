package uam.extremo.ui.views.draganddrop;

import org.eclipse.core.resources.IContainer;
import org.eclipse.ui.part.IDropActionDelegate;

public class NamedElementDropActionDelegate implements IDropActionDelegate {
	@Override
	public boolean run(Object source, Object target) {
		if (target instanceof IContainer) {
			/*NamedElementTransfer transfer = NamedElementTransfer.getInstance();
			NamedElement[] gadgets = transfer.ByteArray((byte[])source);
			
			IContainer parent = (IContainer)target;
			for (int i = 0; i < gadgets.length; i++) {
				writeGadgetFile(parent, gadgets[i]);
			}*/
			
			return true;
		}
		
		return false;
	}

}
