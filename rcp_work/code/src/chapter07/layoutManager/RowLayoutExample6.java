/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class RowLayoutExample6 {

	public RowLayoutExample6() {

		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(400, 150);
		shell.setText("RowLayoutʵ��");
		RowLayout rowlayout = new RowLayout();
		rowlayout.marginLeft = 50;
		// rowlayout.marginRight=50;
		rowlayout.spacing = 70;
		// rowlayout.marginBottom=20;
		rowlayout.marginTop = 40;
		// rowlayout.marginWidth=50;
		// rowlayout.marginHeight=30;
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
		new RowLayoutExample6();
	}
}
