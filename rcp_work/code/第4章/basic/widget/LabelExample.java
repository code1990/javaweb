/**@author WangJinTao,MengQingChang 2006
 */
package basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class LabelExample {
	public LabelExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		/**
		 * 设置窗体大小,格式为：shell.setSize(int x,int y) "x"为X轴坐标,"y"为Y轴坐标。
		 */
		shell.setSize(500, 375);
		// 设置窗口标题文字。
		shell.setText("Label实例界面");
		// 定义标签对象label1。
		final Label label1 = new Label(shell, SWT.NONE);
		/**
		 * 设置label组件的位置和大小 
		 * 其格式为：setBounds（int x ，int y ，int width ，int height）
		 * "x"为X轴坐标,"y"为Y轴坐标。"wighth"组件的宽度， "height"组件的高度。
		 */
		label1.setBounds(20, 15, 30, 15);
		// setText（String string)用来设置组件的标签文字。
		label1.setText("Label");
	  
		final Label label2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label2.setBounds(0, 45, 500, 8);
		final Label label3 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label3.setBounds(65, 0, 9, 350);
		final Label label4 = new Label(shell, SWT.NONE);
		label4.setBounds(80, 70, 40, 40);
		// setBackground(Color color)方法用来设置背景颜色
		label4.setBackground(display.getSystemColor(SWT.COLOR_BLUE));

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new LabelExample();
	}
}
