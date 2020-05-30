/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class ShellDialogExample {
	public ShellDialogExample() {
		final Display display = new Display();
		// ���������óɶԻ���
		final Shell shell = new Shell(display, SWT.DIALOG_TRIM);
		// ��Shell�����ϲ��������ǲ��֣�
		GridLayout grid = new GridLayout();
		// ���������ó�һ��
		grid.numColumns = 1;
		shell.setLayout(grid);
		shell.setText("Shell�Ի���ʵ��");
		shell.setSize(270, 190);
		Label label1 = new Label(shell, SWT.NONE);
		label1.setImage(display.getSystemImage(SWT.ICON_ERROR));
		// ������ʾ�Ա����
		Label label2 = new Label(shell, SWT.NONE);
		label2.setImage(display.getSystemImage(SWT.ICON_INFORMATION));
		Label label3 = new Label(shell, SWT.NONE);
		label3.setImage(display.getSystemImage(SWT.ICON_WARNING));
		Label label4 = new Label(shell, SWT.NONE);
		label4.setImage(display.getSystemImage(SWT.ICON_QUESTION));
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new ShellDialogExample();
	}
}
