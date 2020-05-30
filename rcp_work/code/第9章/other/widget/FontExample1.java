/**@author WangJinTao,MengQingChang 2006
 */
package other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
public class FontExample1 {
	public FontExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(400, 180);
		shell.setText("Font实例");
		shell.setLayout(new FillLayout());
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				// 定义GC对象
				GC gc = new GC(shell);
				// 设置字体的前景颜色为“红色”
				gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
				// 定义一个字体对象
				Font font = new Font(display, "Arial", 12, SWT.BOLD);
				gc.setFont(font);
				gc.drawString("为中华民族的伟大复兴贡献力量", 80, 40);
				Font newfont = new Font(display, new FontData("null", 12,
						 SWT.ITALIC));
				gc.setFont(newfont);
				gc.drawString("为中华民族的伟大复兴贡献力量", 80, 80);
				font.dispose();
				newfont.dispose();
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new FontExample1();
	}
}
