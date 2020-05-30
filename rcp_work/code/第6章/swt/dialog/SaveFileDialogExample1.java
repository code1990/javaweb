/**@author WangJinTao,MengQingChang 2006
 */
package swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
public class SaveFileDialogExample1 {
	public static void main(String[] args) {
		final Shell shell = new Shell();
		FileDialog SaveFileDialog = new FileDialog(shell, SWT.SAVE);
		SaveFileDialog.setText("保存型文件选择对话框");
		SaveFileDialog.setFilterExtensions(new String[] { "*.*", "*.psd",
				"*.jpg", "*.txt", "*.doc", "*.exe" });
		SaveFileDialog.setFilterNames(new String[] { "所有类型(*.*)",
				"potoshop格式(*.psd)", "文本格式(*.txt)" });
		SaveFileDialog.setFileName("book");
		SaveFileDialog.setFilterPath("D:\\");
		SaveFileDialog.open();
	}
}
