package chapter06.swt.dialog;


import org.eclipse.swt.widgets.*;

public class DirectoryDialogExample1 {

	public DirectoryDialogExample1() {

		final Shell shell = new Shell();
		DirectoryDialog dirctorydialog = new DirectoryDialog(shell);
		dirctorydialog.setText("目录选择对话框");
		dirctorydialog.setFilterPath("C:\\");
		dirctorydialog.setMessage("选择要使用的工作空间目录:");
		String dirctory = dirctorydialog.open();
		if (dirctory != null) {
			System.out.println(dirctory);
		}
          
	}

	public static void main(String[] args) {
		new DirectoryDialogExample1();
	}
}

