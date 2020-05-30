/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter11;

import org.eclipse.swt.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;
import org.eclipse.jface.dialogs.*;

public class MessageDialog1Class {

	public MessageDialog1Class() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 170);
		shell.setText("SWT Application");
		Button button = new Button(shell, SWT.NONE);
		button.setText("ȷ��");
		button.setBounds(20, 30, 80, 25);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				MessageDialog messageDialog = new MessageDialog(null,
						"MessageDialog�Ի���", null,
						"Welcome to use MessageDialog!!!",
						MessageDialog.QUESTION,
						new String[] { "OK", "Cancel" }, 0);
				messageDialog.open();
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new MessageDialog1Class();
	}
}
