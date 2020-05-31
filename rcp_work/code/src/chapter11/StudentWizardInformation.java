/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter11;

import org.eclipse.jface.wizard.*;

import org.eclipse.swt.widgets.*;

public class StudentWizardInformation extends Wizard {
	private WizardPageOne pageOne;

	private WizardPageTwo pageTwo;

	private TableItem item;

	public StudentWizardInformation(TableItem item) {
		
		this.item = item;
	}

	public boolean performFinish() {
		String id = pageOne.getID();
		String name = pageOne.getName();
		String sex = pageOne.getCombo();
		String Email = pageOne.getEmail();
		String comment = pageTwo.getComment();
		// 将收集的信息显示来表格项中
		item.setText(new String[] { id, name, sex, Email, comment });
		return true;
	}

	// 设置向导页
	public void addPages() {
		// 定义第一个向导页
		pageOne = new WizardPageOne();
		// 定义第二个向导页
		pageTwo = new WizardPageTwo();
		// 添加向导页
		addPage(pageOne);
		addPage(pageTwo);
	}
}
