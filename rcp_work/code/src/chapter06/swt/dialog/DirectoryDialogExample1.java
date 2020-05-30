/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;


import org.eclipse.swt.widgets.*;

public class DirectoryDialogExample1 {

	public DirectoryDialogExample1() {

		final Shell shell = new Shell();
		DirectoryDialog dirctorydialog = new DirectoryDialog(shell);
		dirctorydialog.setText("Ŀ¼ѡ��Ի���");
		dirctorydialog.setFilterPath("C:\\");
		dirctorydialog.setMessage("ѡ��Ҫʹ�õĹ����ռ�Ŀ¼:");
		String dirctory = dirctorydialog.open();
		if (dirctory != null) {
			System.out.println(dirctory);
		}
          
	}

	public static void main(String[] args) {
		new DirectoryDialogExample1();
	}
}

