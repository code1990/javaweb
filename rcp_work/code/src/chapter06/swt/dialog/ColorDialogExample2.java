/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;

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
		shell.setText("ColorDialogʵ��");
		text = new Text(shell, SWT.BORDER);
		text.setBounds(5, 5, 365, 150);
		text.setText("SWT/JFace");
		color = new Color(shell.getDisplay(), new RGB(0, 255, 0));
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(250, 165, 120, 20);
		button.setText("��ɫѡ��Ի���");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// ������ɫѡ��Ի���
				ColorDialog dlg = new ColorDialog(shell);
				// �򿪶Ի���
				RGB rgb = dlg.open();
				if (rgb != null) {
					color = new Color(shell.getDisplay(), rgb);
					// ����ǰ����ɫ
					text.setForeground(color);
					/**
					 * ���ñ�����ɫ text.setBackground(color);
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
