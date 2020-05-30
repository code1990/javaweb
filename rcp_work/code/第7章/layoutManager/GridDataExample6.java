/**
*@author: WangJinTao,MengQingChang2006
*/
package layoutManager;


import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class GridDataExample6 {
	public GridDataExample6() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 150);
		shell.setText("GridDataÊµÀý");
		shell.setLayout(new GridLayout(3, false));
		Button button1 = new Button(shell, SWT.NONE);
		button1.setText("Button1");
		GridData griddata = new GridData();
		griddata.widthHint = 90;
		button1.setLayoutData(griddata);
		Button button2 = new Button(shell, SWT.NONE);
		button2.setText("Button2");
		Button button3 = new Button(shell, SWT.NONE);
		button3.setText("Button3");
		Button button4 = new Button(shell, SWT.NONE);
		button4.setText("Button4");
		Button button5 = new Button(shell, SWT.NONE);
		button5.setText("Button5");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new GridDataExample6();
	}
}
