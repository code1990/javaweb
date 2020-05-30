/**
*@author: WangJinTao,MengQingChang2006
*/
package layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;;

public class FillLayoutExample2 {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 200);
		shell.setText("水平充满布局实例");
		 // FillLayout fillLayout = new FillLayout();
	      // fillLayout.type = SWT.VERTICAL;

	       shell.setLayout(new FillLayout(SWT.HORIZONTAL));
	       new Text(shell,SWT.BORDER);
	       new Text(shell,SWT.BORDER);
	       new Text(shell,SWT.BORDER);
	       new Text(shell,SWT.BORDER);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
