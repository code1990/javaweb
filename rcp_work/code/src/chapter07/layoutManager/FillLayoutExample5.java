/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class FillLayoutExample5 {
	public  FillLayoutExample5 () {

		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(460, 140);
		shell.setText("FillLayout������");
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 20;
		fillLayout.marginWidth = 30;

		fillLayout.spacing = 40;
		shell.setLayout(fillLayout);
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

	public static void main(String[] args) {
		new  FillLayoutExample5 ();
	}
}
