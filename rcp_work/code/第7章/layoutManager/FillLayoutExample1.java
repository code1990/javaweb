/**
*@author: WangJinTao,MengQingChang2006
*/
package layoutManager;

 

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class FillLayoutExample1 {

	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("FillLayoutÊµÀý");
		shell.setLayout(new FillLayout()); 
		final Text text = new Text(shell, SWT.BORDER);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}

