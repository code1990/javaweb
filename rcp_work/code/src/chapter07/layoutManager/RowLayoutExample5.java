/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;



public class RowLayoutExample5 {

	
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(150, 100);
		shell.setText("RowLayoutʵ��");
		RowLayout rowlayout = new RowLayout();
		rowlayout.wrap=false;
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

}
