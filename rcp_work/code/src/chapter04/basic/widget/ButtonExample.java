package chapter04.basic.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ButtonExample {
	public ButtonExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(410, 200);
		// ���ô���ı�������
		shell.setText("Button ʵ��");
		/**
		 * ���캯��new Button��shell��SWT.NONE) ����һ��button1����
		 * shell ��������Composite������,SWT.NONE��Button��Ĭ����ʽ��
		 */
		final Button button1 = new Button(shell, SWT.NONE);
		// ����button1�������������
		button1.setText("SWT.NONE");
		// ����button1���������ͳ���
		button1.setBounds(15, 20, 60, 35);

		button1.setToolTipText("����SWT.NONE��ʽ��Ч��");
		final Button button2 = new Button(shell, SWT.CHECK);
		button2.setText("SWT.CHECK");
		button2.setBounds(110, 20, 75, 35);
		final Button button3 = new Button(shell, SWT.RADIO);
		button3.setText("SWT.RADIO");
		button3.setBounds(210, 20, 75, 35);
		final Button button4 = new Button(shell, SWT.ARROW);
		button4.setText("SWT.ARROW");
		button4.setBounds(310, 25, 45, 25);
		final Button button5 = new Button(shell, SWT.BORDER);
		button5.setText("SWT.BORDER");
		button5.setBounds(15, 75, 75, 35);
		final Button button6 = new Button(shell, SWT.TOGGLE);
		button6.setText("SWT.TOGGLE");
		button6.setBounds(110, 74, 75, 35);
		final Button button7 = new Button(shell, SWT.FLAT);
		button7.setText("SWT.FLAT");
		button7.setBounds(210, 74, 75, 35);
		final Button button8 = new Button(shell, SWT.NONE);
		button8.setText("setEnabled");
		button8.setBounds(310, 74, 75, 35);
		button8.setEnabled(false);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new ButtonExample();
	}
}
