/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;

public class DirectoryDialogExample2 {
	private Text text;

	private Shell shell;

	public DirectoryDialogExample2() {
		final Display display = Display.getDefault();
		shell = new Shell(new Shell());
		shell.setSize(300, 70);
		shell.setText("Ŀ¼ѡ��Ի���ʵ��");
		// ��Shell��ʹ�����񲼾֣�����shell��������Ϊ5��
		shell.setLayout(new GridLayout(5, false));
		// ����һ����ǩ
		new Label(shell, SWT.NONE).setText("Ŀ¼��");
		text = new Text(shell, SWT.BORDER);
		// ����GridData���Ƹ��Ӳ��֣�GridData.FILL_HORIZONTALΪˮƽ����
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		// ʹ�ı���ˮƽ��ռ3��
		data.horizontalSpan = 3;
		text.setLayoutData(data);
		Button button = new Button(shell, SWT.PUSH);
		button.setText("���....");
		// buttonʹ��ѡ���¼�
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// �����Զ��巽��
				ShowDirectoryDialog();
			}
		});

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public void ShowDirectoryDialog() {
		// ����Ŀ¼ѡ��Ի���
		DirectoryDialog dlg = new DirectoryDialog(shell);
		// ���ñ�������
		dlg.setText("Ŀ¼ѡ��Ի���");
		// ��Ŀ¼ѡ��Ի�����������Ϣ
		dlg.setMessage("ѡ��Ŀ¼��");
		String dir = dlg.open();
		if (dir != null) {
			// ���ı������÷��ص�·��
			text.setText(dir);
		}
	}

	public static void main(String[] args) {
		new DirectoryDialogExample2();
	}
}
