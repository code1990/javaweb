/**@author WangJinTao,MengQingChang 2006
 */
package chapter05.event;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.jface.dialogs.*;

public class ListenerExample {

	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(200, 120);
		shell.setText("������ʵ��");
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(35, 25, 120, 25);
		button.setText("ȷ��");
		button.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(shell, null, "HelloWorld!!");
			}

			public void widgetDefaultSelected(SelectionEvent e) {
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
