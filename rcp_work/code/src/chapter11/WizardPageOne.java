/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter11;

import org.eclipse.jface.wizard.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
public class WizardPageOne extends WizardPage implements ModifyListener {
	private Text textID;
	private Text textName;
	private Combo combo;
	private Text textEmail;
	private GridData grid;
	protected WizardPageOne() {
		super("");
		setTitle("添加学生基本信息");
		setMessage("注意：请正确填写如下信息！", IMessageProvider.INFORMATION);
	
	}
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayoutData(new GridData(GridData.FILL_BOTH));
		comp.setLayout(new GridLayout(2, false));
		// 定制“学号”标签
		new Label(comp, SWT.NONE).setText("学号：");
		// 定制“学号”文本框
		textID = new Text(comp, SWT.BORDER);
		grid = new GridData(GridData.FILL_HORIZONTAL);
		textID.setLayoutData(grid);
		textID.addModifyListener(this);
		// 定制“姓名”标签
		new Label(comp, SWT.NONE).setText("姓名：");
		// 定制“姓名”文本框
		textName = new Text(comp, SWT.BORDER);
		grid = new GridData(GridData.FILL_HORIZONTAL);
		textName.setLayoutData(grid);
		textName.addModifyListener(this);
		// 定制“性別”标签
		new Label(comp, SWT.NONE).setText("性別：");
		combo = new Combo(comp, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setItems(new String[] { "男", "女" });
		grid = new GridData(GridData.FILL_HORIZONTAL);
		combo.setLayoutData(grid);
		combo.addModifyListener(this);
		// 定制“Email”标签
		new Label(comp, SWT.None).setText("Email:");
		// 定制“Email”文本框
		textEmail = new Text(comp, SWT.BORDER);
		grid = new GridData(GridData.FILL_HORIZONTAL);
		textEmail.setLayoutData(grid);
		textEmail.addModifyListener(this);
		setControl(comp);
	}
	public String getID() {
		return textID.getText();
	}
	public String getName() {
		return textName.getText();
	}
	public String getCombo() {
		int index = combo.getSelectionIndex();
		if (index == -1) {
			return "";
		}
		return combo.getItem(index);
	}
	public String getEmail() {
		return textEmail.getText();
	}
	// 监听数据输入合法性
	public void modifyText(ModifyEvent e) {
		if (getID().length() == 0) {
			setMessage("注意：学号项不能为空！！！", IMessageProvider.WARNING);
			return;
		}
		if (getName().length() == 0) {
			setMessage("注意：姓名项不能为空！！！", IMessageProvider.WARNING);
			return;
		}
		if (getCombo().length() == 0) {
			setMessage("注意：性別项不能为空！！！", IMessageProvider.WARNING);
			return;
		}
		if (getEmail().length() == 0 || getEmail().indexOf("@") < 0) {
			setMessage("注意：Email格式错或Email项为空", IMessageProvider.ERROR);
			return;
		}
		// 消除错误提示信息
		 setMessage(null);
		// 使完成按钮处于激活状态
		setPageComplete(true);
	}
}
