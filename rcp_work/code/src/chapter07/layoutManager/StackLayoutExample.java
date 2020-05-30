/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;

public class StackLayoutExample {

	public StackLayoutExample() {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setSize(500, 375);
		shell.setText("StackLayoutʵ��");
		// ��shellӦ������ʽ���֣���shell��������Ϊ2��
		shell.setLayout(new GridLayout(2, false));
		// ������Stacklayout����
		final StackLayout stacklayout = new StackLayout();
		// �������������
		final Composite composite = new Composite(shell, SWT.BORDER);
		// ʹ��GriData���Ʋ��֣�ʹ���˫���������
		GridData gridData = new GridData(GridData.FILL_BOTH);
		// ʹcomposite1ˮƽ��ռ2��
		gridData.horizontalSpan = 2;
		composite.setLayoutData(gridData);
		// ��composite1��Ӧ��stacklayout
		composite.setLayout(stacklayout);

		final Text text = new Text(composite, SWT.NONE);
		text.setText("�ı� ");

		final Button button = new Button(composite, SWT.NONE);
		button.setText("��ť");

		final Button button1 = new Button(shell, SWT.NONE);
		button1.setText("������ʾ�ı�");
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// ��topControlʹ�ı���text����ʾ�ڶ�ջ�Ķ���
				stacklayout.topControl = text;
				composite.layout();
			}
		});
		final Button button2 = new Button(shell, SWT.NONE);
		button2.setText("������ʾ��ť");
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				stacklayout.topControl = button;
				composite.layout();
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
		new StackLayoutExample();
	}
}
