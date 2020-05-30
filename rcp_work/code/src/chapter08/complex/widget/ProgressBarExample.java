/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class ProgressBarExample {
	private ProgressBar progressBar;

	private int max;

	private int i;

	private int Value;

	private int value;

	public ProgressBarExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(SWT.ON_TOP);
		shell.setSize(340, 300);
		// ���ô���λ��
		shell.setLocation(350, 180);
		shell.setLayout(new FormLayout());
		shell.setBackground(display.getSystemColor(SWT.COLOR_BLUE
				| SWT.COLOR_BLACK)); // ���ñ�����ɫ
		// ���������
		progressBar = new ProgressBar(shell, SWT.SMOOTH);
		FormData data = new FormData(337, 20);
		data.bottom = new FormAttachment(50, 50, 0);
		progressBar.setLayoutData(data);
		max = progressBar.getMaximum();
		// ����һ���߳�
		new Thread() {
			public void run() {
				for (i = 0; i <= max; i++) {
					try {
						Thread.sleep(80);
					} catch (Throwable e) {
					}
					display.asyncExec(new Runnable() {
						public void run() {
							progressBar.setSelection(i);
							Value = progressBar.getMaximum();
							value = progressBar.getSelection();
							if (Value == value) {
								shell.dispose();// �ͷ�shell����
								final Display dis = Display.getDefault();
								Shell sh = new Shell(dis);
								sh.setText("ProgressBarʵ��");
								sh.setSize(500, 400);
								sh.open();
								while (!sh.isDisposed()) {
									if (!dis.readAndDispatch())
										dis.sleep();
								}
							}
						}
					});
				}
			}
		}.start();// �����߳�
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new ProgressBarExample();
	}
}
