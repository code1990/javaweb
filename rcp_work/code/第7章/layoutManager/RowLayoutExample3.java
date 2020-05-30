/**
*@author: WangJinTao,MengQingChang2006
*/
package layoutManager;


import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;



public class RowLayoutExample3 {

	
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 100);
		shell.setText("RowLayoutÊµÀý");
		RowLayout rowlayout = new RowLayout();
		rowlayout.justify=true;
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
