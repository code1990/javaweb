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
		shell.setText("FileDialog实例");
		text = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		text.setBounds(5, 5, 365, 150);
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(210, 165, 160, 20);
		button.setText("保存型文件选择对话框");
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
		// 定义文件选择对话框，类型为保存型
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setText("保存");
		// 设置对话框保存的限定类型
		dialog.setFilterExtensions(new String[] { "*.txt", "*.doc", "*.xls",
				"*.*" });
		// 打开对话框，返回一个保存文件的路径
		String saveFile = dialog.open();
		if (saveFile == null) {
			return false;
		}
		file = new File(saveFile);
		try {
			/**
			 * FileWriter与FileWriter类似，都是用来处理字符信息。 
			 * 不过FileWriter用来写文件字符流
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
