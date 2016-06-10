package metardf.ui.utils;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class Messages {
	public static void displayEditErrorMessage(String msg){
		MessageDialog.openError(getShell(), "Can not edit value", msg);
	}
	
	/**
	 * Static method that opens an error message dialog  whose title is cadValidationType+"Problems" and shows the specified message.
	 * @param cadValidationType - title
	 * @param msg
	 */
	public static void displayValidateErrorMessage(String cadValidationType,String msg){
		MessageDialog.openError(getShell(), cadValidationType+" Problems", msg);
	}
	
	/**
	 * Static method that opens  an warning message dialog and shows the specified message 
	 * @param cadValidationType - title
	 * @param msg
	 */
	public static void displayValidateWarningMessage(String cadValidationType,String msg){
		MessageDialog.openWarning(getShell(), cadValidationType+" Warnings", msg);
	}
	
	/**
	 * Static method that opens an information message dialog and shows a message of successful validation
	 * @param cadValidationType
	 */
	public static void displayValidateSuccessfulMessage(String cadValidationType){
		MessageDialog.openInformation(getShell(), cadValidationType+" Information", "Validation completed successfully");
		
	}
	
	/**
	 * Static method that opens an information message dialog with the specified title and shows the specifies message
	 * @param title
	 * @param msg
	 */
	public static void displayGeneralMessage(String title, String msg){
		MessageDialog.openInformation(getShell(), title, msg);
	}
	
	/**
	 * Static method that opens an error information message dialog with the specified title and shows the specifies message
	 * @param title
	 * @param msg
	 */
	public static void displayGeneralErrorMessage(String title, String msg){
		MessageDialog.openInformation(getShell(), title, msg);
	}
	
	public static Shell getShell(){
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
}
