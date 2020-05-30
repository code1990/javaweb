/**@author WangJinTao,MengQingChang 2006
 */
package swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

public class ColorDialogExample2 {
	private Text text;

	private Color color;

	public ColorDialogExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(new Shell());
		shell.setSize(383, 225);
		shell.setText("ColorDialog实例");
		text = new Text(shell, SWT.BORDER);
		text.setBounds(5, 5, 365, 150);
		text.setText("SWT/JFace");
		color = new Color(shell.getDisplay(), new RGB(0, 255, 0));
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(250, 165, 120, 20);
		button.setText("颜色选择对话框");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// 定义颜色选择对话框
				ColorDialog dlg = new ColorDialog(shell);
				// 打开对话框
				RGB rgb = dlg.open();
				if (rgb != null) {
					color = new Color(shell.getDisplay(), rgb);
					// 设置前景颜色
					text.setForeground(color);
					/**
					 * 设置背景颜色 text.setBackground(color);
					 */
				}
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
		new ColorDialogExample2();
	}
}
