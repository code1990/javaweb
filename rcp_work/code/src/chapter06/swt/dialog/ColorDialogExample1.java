package chapter06.swt.dialog;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

public class ColorDialogExample1 {
	public ColorDialogExample1() {
		final Shell shell = new Shell();
		// 定于ColorDialog对象
		ColorDialog colordialog = new ColorDialog(shell);
		// 设置对话框标题
		colordialog.setText("颜色选择对话框");
		// 设置当前颜色值
		colordialog.setRGB(new RGB(0, 0, 255));

		RGB rgb = colordialog.open();
		/**
		 * open()方法当用户选择一中颜色时将返回一个代表RGB类型的对象，
		 * 如用户 选择“取消”按钮，则open()方法返回null
		 */
		if (rgb != null) {
			// 打印输出当前所选的颜色值
			System.out.println(rgb);

		}
	}

	public static void main(String[] args) {
		new ColorDialogExample1();
	}
}
