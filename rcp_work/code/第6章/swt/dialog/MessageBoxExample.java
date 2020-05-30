/**@author WangJinTao,MengQingChang 2006
 */
package swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class MessageBoxExample {
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(360, 250);
		shell.setText("MessageBox实例");
		shell.addShellListener(new ShellAdapter() {
			public void shellClosed(ShellEvent e) {
				MessageBox messagebox = new MessageBox(shell, SWT.ICON_QUESTION
						| SWT.YES | SWT.NO);
				messagebox.setText("MessageBox对话框");
				messagebox.setMessage("请确认是否退出?");
				int message = messagebox.open();
				e.doit = message == SWT.YES;
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
