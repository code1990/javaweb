/**
*@author: WangJinTao,MengQingChang2006
*/
package jfaceDialog;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;

import org.eclipse.swt.widgets.Shell;

public class ErrorDialog1Class {

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public ErrorDialog1Class() {
	
		final Shell shell = new Shell();
		Status status = new Status(IStatus.ERROR, "MyPlugin", 0,
				"An Error Operate occurred", null);

		ErrorDialog errorDialog = new ErrorDialog(shell
				, "ErrorDialogÊµÀý", "This is ErrorDialog",
				status, IStatus.ERROR | IStatus.INFO);
		errorDialog.open();

	}

	public static void main(String[] args) {
		new ErrorDialog1Class();
	}
}
