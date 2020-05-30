/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;

import java.io.*;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
public class SaveFileDialogExample2 {
	private Text text;
	private File file;
	private Shell shell;
	public SaveFileDialogExample2() {
		final Display display = Display.getDefault();
		shell = new Shell(new Shell());
		shell.setSize(383, 225);
		shell.setText("FileDialogʵ��");
		text = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		text.setBounds(5, 5, 365, 150);
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(210, 165, 160, 20);
		button.setText("�������ļ�ѡ��Ի���");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				saveTextFile();
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	boolean saveTextFile() {
		// �����ļ�ѡ��Ի�������Ϊ������
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setText("����");
		// ���öԻ��򱣴���޶�����
		dialog.setFilterExtensions(new String[] { "*.txt", "*.doc", "*.xls",
				"*.*" });
		// �򿪶Ի��򣬷���һ�������ļ���·��
		String saveFile = dialog.open();
		if (saveFile == null) {
			return false;
		}
		file = new File(saveFile);
		try {
			/**
			 * FileWriter��FileWriter���ƣ��������������ַ���Ϣ�� 
			 * ����FileWriter����д�ļ��ַ���
			 */
			FileWriter filewriter = new FileWriter(file);
			filewriter.write(text.getText());
			filewriter.close();
			return true;
		} catch (IOException e) {
		}
		return false;
	}
	public static void main(String[] args) {
		new SaveFileDialogExample2();
	}
}
