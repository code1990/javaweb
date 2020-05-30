/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
public class SaveFileDialogExample1 {
	public static void main(String[] args) {
		final Shell shell = new Shell();
		FileDialog SaveFileDialog = new FileDialog(shell, SWT.SAVE);
		SaveFileDialog.setText("�������ļ�ѡ��Ի���");
		SaveFileDialog.setFilterExtensions(new String[] { "*.*", "*.psd",
				"*.jpg", "*.txt", "*.doc", "*.exe" });
		SaveFileDialog.setFilterNames(new String[] { "��������(*.*)",
				"potoshop��ʽ(*.psd)", "�ı���ʽ(*.txt)" });
		SaveFileDialog.setFileName("book");
		SaveFileDialog.setFilterPath("D:\\");
		SaveFileDialog.open();
	}
}
