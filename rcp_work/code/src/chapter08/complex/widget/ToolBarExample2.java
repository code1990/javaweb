/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.custom.*;

public class ToolBarExample2 {
	public ToolBarExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("ToolBar实例");
		shell.setLayout(new FillLayout());

		// 定义ViewForm对象
		ViewForm vf = new ViewForm(shell, SWT.FLAT);
		vf.setLayout(new FillLayout());
		ToolBar toolBar1 = new ToolBar(vf, SWT.WRAP);
		ToolBar toolBar2 = new ToolBar(vf, SWT.WRAP);
		Text text = new Text(vf, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		vf.setContent(text);
		vf.setTopLeft(toolBar1);
		vf.setTopCenter(toolBar2);
		vf.setTopCenterSeparate(true);

		ToolItem toolItem1 = new ToolItem(toolBar1, SWT.PUSH);

		// 在按钮上添加图片
		toolItem1.setImage(new Image(display, "icons/forward.gif"));

		ToolItem toolItem2 = new ToolItem(toolBar1, SWT.CHECK);

		toolItem2.setImage(new Image(display, "icons/backward.gif"));

		ToolItem toolItem3 = new ToolItem(toolBar1, SWT.RADIO);

		toolItem3.setImage(new Image(display, "icons/remove.gif"));

		ToolItem toolItem4 = new ToolItem(toolBar2, SWT.RADIO);

		toolItem4.setImage(new Image(display, "icons/cut.gif"));

		toolBar1.pack();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new ToolBarExample2();
	}
}
