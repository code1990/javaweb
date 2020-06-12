/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;

public class GCExample2 {
	private Display display;

	private Composite composite;

	public GCExample2() {
		display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(260, 130);
		shell.setText("GC实例");
		shell.setLayout(new FillLayout());
		shell.open();
		composite = new Composite(shell, SWT.NONE);
		// 在paintEvent的事件中进行绘图处理
		composite.addPaintListener(new PaintListener() {
			public void paintControl(final PaintEvent event) {
				Display display = event.display;
				GC gc = new GC(composite);
				gc.drawRectangle(30, 15, 190, 60);
				gc.setBackground(display.getSystemColor(SWT.COLOR_RED));
				gc.fillRectangle(30, 15, 190, 60);
				gc.dispose();
			}
		});
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new GCExample2();
	}
}
