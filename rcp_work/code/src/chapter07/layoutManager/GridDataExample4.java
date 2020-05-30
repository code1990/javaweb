/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class GridDataExample4{
	public GridDataExample4() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(360, 200);
		shell.setText("GridDataʵ��");
		GridLayout gridlayout = new GridLayout(3,false);
        shell.setLayout(gridlayout);
		new Button(shell, SWT.PUSH).setText("Button1");
		new Button(shell, SWT.PUSH).setText("Button2");
		new Button(shell, SWT.PUSH).setText("Button3");
		Button button=new Button(shell, SWT.PUSH);
		button.setText("B4");
		GridData grid=new GridData(GridData.BEGINNING,GridData.CENTER,false ,false,2,1);
        button.setLayoutData(grid);
		new Button(shell, SWT.PUSH).setText("Button4");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new GridDataExample4();
	}
}
