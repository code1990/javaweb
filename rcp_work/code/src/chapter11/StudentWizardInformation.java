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
		// ���ռ�����Ϣ��ʾ���������
		item.setText(new String[] { id, name, sex, Email, comment });
		return true;
	}

	// ������ҳ
	public void addPages() {
		// �����һ����ҳ
		pageOne = new WizardPageOne();
		// ����ڶ�����ҳ
		pageTwo = new WizardPageTwo();
		// �����ҳ
		addPage(pageOne);
		addPage(pageTwo);
	}
}
