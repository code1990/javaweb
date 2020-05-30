/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter11;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class CustomDialogClass extends Dialog {
	public CustomDialogClass(Shell parentShell) {
		super(parentShell);
	}

	// �ڶԻ�����������
	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new GridLayout(2, false));

		final Label usernameLabel = new Label(composite, SWT.NONE);
		usernameLabel.setText("�û���:");
		final Text usernameText = new Text(composite, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		usernameText.setLayoutData(data);

		final Label passwordLabel = new Label(composite, SWT.NONE);
		passwordLabel.setText("��  ��:");
		final Text passwordText = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		data = new GridData(GridData.FILL_HORIZONTAL);
		passwordText.setLayoutData(data);
		return composite;
	}

	/**
	 * ���ƴ�����ʽ protected int getShellStyle() { return SWT.MIN; }
	 */
	// ��Ӱ�ť
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "ȷ��", true);
		createButton(parent, IDialogConstants.CANCEL_ID, "ȡ��", true);
		createButton(parent, IDialogConstants.NO_ID, "���", true);
	}
}
