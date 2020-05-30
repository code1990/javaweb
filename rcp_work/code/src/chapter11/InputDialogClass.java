/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter11;

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
		// ����һ������Ի���
		InputDialog dlg = new InputDialog(shell, "InputDialogʵ��", "�����룺5-10λ",
				"This is InputDialog", new InputValidator());
		if (dlg.open() == InputDialog.OK) {
			// �û�����OK��ť������Ϣ��ʾ�Ի���
			MessageDialog.openInformation(shell, "��ʾ��Ϣ", "���������ϢΪ��"
					+ dlg.getValue() + "!");
		}
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	// ��֤������Ϣ��
	class InputValidator implements IInputValidator {
		public String isValid(String newText) {
			int length = newText.length();
			// ��������ֵ�ĳ����Ƿ���ϱ�׼
			if (length < 5)
				return "�����λ������";
			if (length > 10)
				return "�����λ������";
			else
				return null;
		}
	}

	public static void main(String[] args) {
		new InputDialogClass();
	}
}
