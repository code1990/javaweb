
package chapter05.event;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class MouseEventExample {
	public MouseEventExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("MouseEventÊµÀý");
		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				String string = "";
				switch (e.type) {
				case SWT.MouseDown:
					string += "DOWN";
					break;
				case SWT.MouseUp:
					string += "UP";
					break;
				case SWT.MouseMove:
					string += "MOVE";
					break;
				case SWT.MouseDoubleClick:
					string += "DOUBLE";
					break;
				case SWT.MouseEnter:
					string += "ENTER";
					break;
				case SWT.MouseExit:
					string += "EXIT";
					break;
				case SWT.MouseHover:
					string += "HOVER";
					break;
				}

				if ((e.stateMask & SWT.BUTTON1) != 0)
					string += " BUTTON1";
				if ((e.stateMask & SWT.BUTTON2) != 0)
					string += " BUTTON2";
				if ((e.stateMask & SWT.BUTTON3) != 0)
					string += " BUTTON3";
				if ((e.stateMask & SWT.ALT) != 0)
					string += " ALT";
				if ((e.stateMask & SWT.SHIFT) != 0)
					string += " SHIFT";
				string += ", x=" + e.x + ", y=" + e.y;
				System.out.println(string);
			}
		};
		shell.addListener(SWT.MouseDown, listener);
		shell.addListener(SWT.MouseUp, listener);
		shell.addListener(SWT.MouseDoubleClick, listener);
		shell.addListener(SWT.MouseMove, listener);
		shell.addListener(SWT.MouseEnter, listener);
		shell.addListener(SWT.MouseExit, listener);
		shell.addListener(SWT.MouseHover, listener);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new MouseEventExample();
	}
}
