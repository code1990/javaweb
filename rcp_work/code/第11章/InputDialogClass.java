/**
 *@author: WangJinTao,MengQingChang2006
 */
package jfaceDialog;

import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.widgets.*;

public class InputDialogClass {
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public InputDialogClass() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		// 定义一个输入对话框
		InputDialog dlg = new InputDialog(shell, "InputDialog实例", "请输入：5-10位",
				"This is InputDialog", new InputValidator());
		if (dlg.open() == InputDialog.OK) {
			// 用户单击OK按钮弹出信息提示对话框
			MessageDialog.openInformation(shell, "提示信息", "您输入的信息为："
					+ dlg.getValue() + "!");
		}
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	// 验证输入信息类
	class InputValidator implements IInputValidator {
		public String isValid(String newText) {
			int length = newText.length();
			// 定义输入值的长度是否符合标准
			if (length < 5)
				return "输入的位数不足";
			if (length > 10)
				return "输入的位数过长";
			else
				return null;
		}
	}

	public static void main(String[] args) {
		new InputDialogClass();
	}
}
