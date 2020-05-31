/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter11;

import org.eclipse.core.runtime.*;
import org.eclipse.jface.dialogs.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ErrorDialog2Class extends ApplicationWindow {
	public ErrorDialog2Class() {
		super(null);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		parent.getShell().setText("ErrorDialog µ¿˝");
		parent.getShell().setSize(300, 200);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		Button button = new Button(composite, SWT.PUSH);
		button.setText("œ‘ æ¥ÌŒÛ");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				ErrorDialog.openError(Display.getCurrent().getActiveShell(),
						"ErrorDialog", "Error Information", createStatus(),
						IStatus.ERROR | IStatus.INFO);
			}
		});
		return composite;
	}

	public IStatus createStatus() {
		final String MyPlugin = "MyPlugin";
		IStatus[] status = new IStatus[3];
		status[0] = new Status(IStatus.ERROR, MyPlugin, IStatus.INFO,
				"An error occurred!", null);
		status[1] = new Status(IStatus.INFO, MyPlugin, IStatus.OK,
				"The  error is very severity!", null);
		status[2] = new Status(IStatus.INFO, MyPlugin, IStatus.OK,
				"The System Will Exit!!!!!!", null);
		MultiStatus multiStatus = new MultiStatus(MyPlugin, IStatus.OK, status,
				"Several errors have occured", null);
		return multiStatus;
	}

	public static void main(String[] args) {
		new ErrorDialog2Class().run();
	}
}
