/**@author WangJinTao,MengQingChang 2006
 */
package chapter05.event;

import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.*;

import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class AdapterExample {

	public static void main(String[] args) {

		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(200, 120);
		shell.setText("������������");
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(30, 25, 120, 25);
		button.setText("ȷ��");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(shell, null, "HelloWorld!!");
			}

		});

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
