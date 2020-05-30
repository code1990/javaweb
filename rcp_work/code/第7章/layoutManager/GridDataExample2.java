/**
*@author: WangJinTao,MengQingChang2006
*/
package layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class GridDataExample2{
	public GridDataExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(360, 200);
		shell.setText("GridDataÊµÀý");
		GridLayout gridlayout = new GridLayout(2,false);
        shell.setLayout(gridlayout);
		new Button(shell, SWT.PUSH).setText("Button1");
		new Button(shell, SWT.PUSH).setText("Button2");
		new Button(shell, SWT.PUSH).setText("Button3");
		Button button=new Button(shell, SWT.PUSH);
		button.setText("B4");
		GridData grid=new GridData(80,100);
	
		button.setLayoutData(grid);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new GridDataExample2();
	}
}
