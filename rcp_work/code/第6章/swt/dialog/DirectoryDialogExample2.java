/**@author WangJinTao,MengQingChang 2006
 */
package swt.dialog;

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
		shell.setText("目录选择对话框实例");
		// 在Shell上使用网格布局，并将shell容器设置为5列
		shell.setLayout(new GridLayout(5, false));
		// 定义一个标签
		new Label(shell, SWT.NONE).setText("目录：");
		text = new Text(shell, SWT.BORDER);
		// 采用GridData控制复杂布局，GridData.FILL_HORIZONTAL为水平充满
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		// 使文本框水平抢占3列
		data.horizontalSpan = 3;
		text.setLayoutData(data);
		Button button = new Button(shell, SWT.PUSH);
		button.setText("浏览....");
		// button使用选择事件
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// 调用自定义方法
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
		// 定义目录选择对话框
		DirectoryDialog dlg = new DirectoryDialog(shell);
		// 设置标题文字
		dlg.setText("目录选择对话框");
		// 在目录选择对话框上设置信息
		dlg.setMessage("选择目录：");
		String dir = dlg.open();
		if (dir != null) {
			// 在文本上设置返回的路径
			text.setText(dir);
		}
	}

	public static void main(String[] args) {
		new DirectoryDialogExample2();
	}
}
