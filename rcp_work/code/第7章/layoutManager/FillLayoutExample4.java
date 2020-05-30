/**
 *@author: WangJinTao,MengQingChang 2006
 */
package layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class FillLayoutExample4 {
	public FillLayoutExample4() {

		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(460, 140);
		shell.setText("FillLayout Ù–‘¿˝");
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 40;
		fillLayout.marginWidth = 50;

		fillLayout.spacing = 80;
		shell.setLayout(fillLayout);
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
		new FillLayoutExample4();
	}
}
