/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class GridLayoutExample3 {
	public GridLayoutExample3() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(360, 200);
		shell.setText("GridLayoutÊµÀý");
		GridLayout gridlayout = new GridLayout();
		gridlayout.numColumns = 3;
		gridlayout.horizontalSpacing = 30;
		gridlayout.verticalSpacing = 40;
		gridlayout.makeColumnsEqualWidth = true;
		gridlayout.marginHeight = 40;
		gridlayout.marginWidth = 40;
	    //gridlayout.marginBottom=100;
		shell.setLayout(gridlayout);
		new Text(shell, SWT.BORDER);
		new Text(shell, SWT.BORDER);
		new Text(shell, SWT.BORDER);
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
		new GridLayoutExample3();
	}
}
