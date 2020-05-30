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
		setTitle("���ѧ��������Ϣ");
		setMessage("ע�⣺����ȷ��д������Ϣ��", IMessageProvider.INFORMATION);
	
	}
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayoutData(new GridData(GridData.FILL_BOTH));
		comp.setLayout(new GridLayout(2, false));
		// ���ơ�ѧ�š���ǩ
		new Label(comp, SWT.NONE).setText("ѧ�ţ�");
		// ���ơ�ѧ�š��ı���
		textID = new Text(comp, SWT.BORDER);
		grid = new GridData(GridData.FILL_HORIZONTAL);
		textID.setLayoutData(grid);
		textID.addModifyListener(this);
		// ���ơ���������ǩ
		new Label(comp, SWT.NONE).setText("������");
		// ���ơ��������ı���
		textName = new Text(comp, SWT.BORDER);
		grid = new GridData(GridData.FILL_HORIZONTAL);
		textName.setLayoutData(grid);
		textName.addModifyListener(this);
		// ���ơ��Ԅe����ǩ
		new Label(comp, SWT.NONE).setText("�Ԅe��");
		combo = new Combo(comp, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setItems(new String[] { "��", "Ů" });
		grid = new GridData(GridData.FILL_HORIZONTAL);
		combo.setLayoutData(grid);
		combo.addModifyListener(this);
		// ���ơ�Email����ǩ
		new Label(comp, SWT.None).setText("Email:");
		// ���ơ�Email���ı���
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
	// ������������Ϸ���
	public void modifyText(ModifyEvent e) {
		if (getID().length() == 0) {
			setMessage("ע�⣺ѧ�����Ϊ�գ�����", IMessageProvider.WARNING);
			return;
		}
		if (getName().length() == 0) {
			setMessage("ע�⣺�������Ϊ�գ�����", IMessageProvider.WARNING);
			return;
		}
		if (getCombo().length() == 0) {
			setMessage("ע�⣺�Ԅe���Ϊ�գ�����", IMessageProvider.WARNING);
			return;
		}
		if (getEmail().length() == 0 || getEmail().indexOf("@") < 0) {
			setMessage("ע�⣺Email��ʽ���Email��Ϊ��", IMessageProvider.ERROR);
			return;
		}
		// ����������ʾ��Ϣ
		 setMessage(null);
		// ʹ��ɰ�ť���ڼ���״̬
		setPageComplete(true);
	}
}
