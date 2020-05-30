/**@author WangJinTao,MengQingChang 2006
 */
package swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class OpenFileDialogExample1 {
	public OpenFileDialogExample1() {
		final Shell shell = new Shell();
		FileDialog OpenFileDialog = new FileDialog(shell, SWT.OPEN);
		OpenFileDialog.setText("打开型文件选择对话框");
		OpenFileDialog.setFilterExtensions(new String[] { "*.*", "*.psd",
				"*.jpg", "*.txt", "*.doc", "*.exe" });
		OpenFileDialog.setFilterNames(new String[] { "所有类型(*.*)",
				"potoshopg格式(*.psd)", "文本格式(*.txt)" });
		OpenFileDialog.setFilterPath("C:\\");
		OpenFileDialog.open();
		System.out.println(OpenFileDialog.getFileName() );
	}

	public static void main(String[] args) {
		new OpenFileDialogExample1();
	}
}
