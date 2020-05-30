/**
 *@author: WangJinTao,MengQingChang 2006
 */
package layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class RowLayoutExample1 {

	public RowLayoutExample1() {

		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(200, 100);
		shell.setText("RowLayoutÊµÀý");
		RowLayout rowlayout = new RowLayout();
		shell.setLayout(rowlayout);
		new Button(shell, SWT.NONE).setText("Button1");

		new Button(shell, SWT.NONE).setText("Button2");

		new Button(shell, SWT.NONE).setText("Button3");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new RowLayoutExample1();
	}
}
