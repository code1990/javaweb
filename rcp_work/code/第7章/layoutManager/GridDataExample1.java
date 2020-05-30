/**
*@author: WangJinTao,MengQingChang2006
*/
package layoutManager;


import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class GridDataExample1{
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 150);
		shell.setText("GridData实例");
		//将容器分为2列
		shell.setLayout(new GridLayout(2, false));
		final Button button1 = new Button(shell, SWT.NONE);
		button1.setText("Button1");
		final Button button2 = new Button(shell, SWT.NONE);
		button2.setText("Button2");
		final Button button3 = new Button(shell, SWT.NONE);
		button3.setText("Button3");
		
		final Button button4 = new Button(shell, SWT.NONE);
		button4.setText("B4");
		//sytle为GridData.Fill_BOTH,双向充满
		GridData gridData = new GridData(GridData.FILL_BOTH);
		button4.setLayoutData(gridData);
		
		
		
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
