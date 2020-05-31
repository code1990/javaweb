/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class FormDataExample {

	public FormDataExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 200);
		shell.setText("FormDataÊµÀý");
		FormLayout formlayout = new FormLayout();
		shell.setLayout(formlayout);
		final Text text = new Text(shell, SWT.BORDER);
		FormData formdata = new FormData(100, 60);
		text.setLayoutData(formdata);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new FormDataExample();
	}
}
