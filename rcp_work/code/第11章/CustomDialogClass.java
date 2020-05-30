/**
 *@author: WangJinTao,MengQingChang2006
 */
package jfaceDialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class CustomDialogClass extends Dialog {
	public CustomDialogClass(Shell parentShell) {
		super(parentShell);
	}

	// 在对话框中添加组件
	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new GridLayout(2, false));

		final Label usernameLabel = new Label(composite, SWT.NONE);
		usernameLabel.setText("用户名:");
		final Text usernameText = new Text(composite, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		usernameText.setLayoutData(data);

		final Label passwordLabel = new Label(composite, SWT.NONE);
		passwordLabel.setText("密  码:");
		final Text passwordText = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		data = new GridData(GridData.FILL_HORIZONTAL);
		passwordText.setLayoutData(data);
		return composite;
	}

	/**
	 * 定制窗体样式 protected int getShellStyle() { return SWT.MIN; }
	 */
	// 添加按钮
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "确定", true);
		createButton(parent, IDialogConstants.CANCEL_ID, "取消", true);
		createButton(parent, IDialogConstants.NO_ID, "清除", true);
	}
}
