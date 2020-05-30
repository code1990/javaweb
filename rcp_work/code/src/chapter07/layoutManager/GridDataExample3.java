/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class GridDataExample3{
	public GridDataExample3() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(360, 200);
		shell.setText("GridDataʵ��");
		GridLayout gridlayout = new GridLayout(2,false);
        shell.setLayout(gridlayout);
		new Button(shell, SWT.PUSH).setText("Button1");
		new Button(shell, SWT.PUSH).setText("Button2");
		new Button(shell, SWT.PUSH).setText("Button3");
		Button button=new Button(shell, SWT.PUSH);
		button.setText("B4");
		GridData grid=new GridData(GridData.END,GridData.CENTER,true ,false);
		//GridData grid=new GridData(GridData.END,GridData.CENTER,false ,false);
		button.setLayoutData(grid);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new GridDataExample3();
	}
}
