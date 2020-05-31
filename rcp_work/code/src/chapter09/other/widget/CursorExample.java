/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

public class CursorExample {

	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("鼠标游标实例");
		Cursor cursor = new Cursor(display, SWT.CURSOR_HAND);
		shell.setCursor(cursor);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
