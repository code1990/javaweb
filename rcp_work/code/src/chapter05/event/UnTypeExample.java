
package chapter05.event;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

public class UnTypeExample {
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(200, 120);
		shell.setText("SWT Application");
		Listener listener = new Listener() {
			public void handleEvent(Event e) {

				switch (e.type) {

				case SWT.MouseDown:
					MessageDialog.openInformation(shell, null, "MouseDown!!");
					break;

				case SWT.Resize:
					MessageDialog.openInformation(shell, null, "Shell Resize!!");
					break;

				}

			}

		};
		shell.addListener(SWT.MouseDown, listener);
		shell.addListener(SWT.Resize, listener);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
