/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class GridDataExample5 {
	public GridDataExample5() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 150);
		shell.setText("GridData实例");
		shell.setLayout(new GridLayout(3, false));
		new Button(shell, SWT.NONE).setText("Button1");
		new Button(shell, SWT.NONE).setText("Button2");
		new Button(shell, SWT.NONE).setText("Button3");

		final Button button = new Button(shell, SWT.NONE);
		button.setText("Button4");

		GridData griddata = new GridData();
		// 水平抢占3列
		griddata.horizontalSpan = 3;
		button.setLayoutData(griddata);
		new Button(shell, SWT.NONE).setText("Button5");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new GridDataExample5();
	}
}
