/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class GridLayoutExample1 {
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 225);
		shell.setText("GridLayoutʵ��");
		GridLayout gridlayout = new GridLayout();
		shell.setLayout(gridlayout);
		new Text(shell, SWT.BORDER);
		new Text(shell, SWT.BORDER);
		new Text(shell, SWT.BORDER);
		new Text(shell, SWT.BORDER);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
