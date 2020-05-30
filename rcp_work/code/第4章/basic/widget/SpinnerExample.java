/**@author WangJinTao,MengQingChang 2006
 */
package basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
public class SpinnerExample {
	public SpinnerExample() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SpinnerÊµÀý ");
		shell.setSize(200, 100);
		final Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setBounds(30, 20, 60, 20);
		spinner.setDigits(3);
		spinner.setMinimum(0);
		spinner.setMaximum(1000);
		spinner.setSelection(500);
		spinner.setIncrement(1);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	public static void main(String[] args) {
		new SpinnerExample();
	}
}

