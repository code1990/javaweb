/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class OpenFileDialogExample1 {
	public OpenFileDialogExample1() {
		final Shell shell = new Shell();
		FileDialog OpenFileDialog = new FileDialog(shell, SWT.OPEN);
		OpenFileDialog.setText("�����ļ�ѡ��Ի���");
		OpenFileDialog.setFilterExtensions(new String[] { "*.*", "*.psd",
				"*.jpg", "*.txt", "*.doc", "*.exe" });
		OpenFileDialog.setFilterNames(new String[] { "��������(*.*)",
				"potoshopg��ʽ(*.psd)", "�ı���ʽ(*.txt)" });
		OpenFileDialog.setFilterPath("C:\\");
		OpenFileDialog.open();
		System.out.println(OpenFileDialog.getFileName() );
	}

	public static void main(String[] args) {
		new OpenFileDialogExample1();
	}
}
