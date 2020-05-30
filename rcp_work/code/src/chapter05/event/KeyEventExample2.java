/**@author WangJinTao,MengQingChang 2006
 */
package chapter05.event;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;

public class KeyEventExample2 {

	private Text text;

	public KeyEventExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(240, 155);
		shell.setText("CancelKeyInput");
		text = new Text(shell, SWT.BORDER);
		text.setBounds(5, 5, 220, 80);
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(5, 90, 100, 25);
		button.setText("CancelKeyInput");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				cancelKeyInput();

			}

		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public void cancelKeyInput() {
		text.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				e.doit = false;
			}
		});
	}

	public static void main(String[] args) {
		new KeyEventExample2();
	}
}
