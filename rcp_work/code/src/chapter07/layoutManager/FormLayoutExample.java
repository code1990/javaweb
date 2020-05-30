/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class FormLayoutExample{

	public FormLayoutExample() {

		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setSize(250, 150);
		shell.setText("FormLayoutʵ��");
		FormLayout formlayout = new FormLayout();
		// formlayout.marginTop=40;
		// formlayout.marginLeft=50;

		formlayout.marginHeight = 40;
		formlayout.marginWidth = 50;
	 
		shell.setLayout(formlayout);
		Text text = new Text(shell, SWT.BORDER);
 
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new FormLayoutExample();
	}
}
