/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;



public class RowDataExample {

	public RowDataExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("RowDataʵ��");
		RowLayout rowlayout = new RowLayout();
		shell.setLayout(rowlayout);
		Button button1 = new Button(shell, SWT.NONE);
		button1.setText("Button1");
		Button button2 = new Button(shell, SWT.NONE);
		button2.setText("Button2");
		RowData rowdata1 = new RowData(60, 40);
		button2.setLayoutData(rowdata1);
		Button button3 = new Button(shell, SWT.NONE);
		button3.setText("Button3");
		button3.setLayoutData(new RowData(80, 60));

		Button button4 = new Button(shell, SWT.NONE);
		button4.setText("Button4");
		RowData rowdata4 = new RowData();
		rowdata4.height = 80;
		rowdata4.width = 100;
		button4.setLayoutData(rowdata4);

		shell.open();

		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new RowDataExample();
	}
}
