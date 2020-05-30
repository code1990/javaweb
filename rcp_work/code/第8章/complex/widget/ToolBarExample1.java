/**@author WangJinTao,MengQingChang 2006
 */
package complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
public class ToolBarExample1 {
	public ToolBarExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("ToolBar实例");
		shell.setLayout(new FillLayout());
		// 定义一个工具栏对象，工具栏上的按钮上的文字可换行
		ToolBar toolBar = new ToolBar(shell, SWT.WRAP);
		// 设置工具栏的工具项，工具栏上按钮为普通按钮
		ToolItem toolItem1 = new ToolItem(toolBar, SWT.PUSH);
		toolItem1.setText("前进");
		// 在按钮上添加图片
		toolItem1.setImage(new Image(display, "icons/forward.gif"));
		// 工具栏上按钮为复选按钮，单击后下陷，再次单击后才弹起。
		ToolItem toolItem2 = new ToolItem(toolBar, SWT.CHECK);
		toolItem2.setText("后退");
		toolItem2.setImage(new Image(display, "icons/backward.gif"));
		// 工具栏上按钮为单选按钮，单击后会立刻弹起来。
		ToolItem toolItem3 = new ToolItem(toolBar, SWT.RADIO);
		toolItem3.setText("清除");
		toolItem3.setImage(new Image(display, "icons/remove.gif"));
		toolBar.pack();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new ToolBarExample1();
	}
}
