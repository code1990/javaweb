/**@author WangJinTao,MengQingChang 2006
 */
package event;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class KeyEventExample1 {

	public KeyEventExample1() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(200, 150);
		shell.setText("KeyEventÊµÀý");
		shell.addListener(SWT.KeyDown, new Listener() {
			public void handleEvent(Event event) {
				String string = "";
				if ((event.stateMask & SWT.ALT) != 0)
					string += "ALT+";
				if ((event.stateMask & SWT.CTRL) != 0)
					string += "CTRL+";
				if ((event.stateMask & SWT.COMMAND) != 0)
					string += "COMMENT+";
				if ((event.stateMask & SWT.SHIFT) != 0)
					string += "SHIFT+";
				switch (event.keyCode) {
				case SWT.BS:
					string += "BACKSPACK";
					break;
				case SWT.HOME:
					string += "HOME";
					break;
				case SWT.DEL:
					string += "DELETE";
					break;
				case SWT.ESC:
					string += "ESCAPE";
					break;
				case SWT.END:
					string += "END";
					break;
				case SWT.TAB:
					string += "TAB";
					break;
				default:
					string += event.character;
					break;
				}
				System.out.println(string);
			}
		});

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public static void main(String[] args) {
		new KeyEventExample1();
	}
}