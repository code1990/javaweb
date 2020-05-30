/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
public class ColorExample{
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(350, 200);
		shell.setText("Colorʵ��");
		shell.setLayout(new FillLayout());
		Canvas canvas = new Canvas(shell, SWT.BORDER);
		shell.open();
		GC gc = new GC(canvas);
		Color red = display.getSystemColor(SWT.COLOR_RED);
		gc.setBackground(red);
		gc.fillOval(210, 20, 60, 60);
		Color bule = new Color(display,0,0,255);
		gc.setBackground(bule);
		gc.fillPolygon(new int[] { 10, 150, 190, 10, 290, 150 });
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
