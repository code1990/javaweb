/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter11;

import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
/**
 * ����MyTitleAreaDialogClass��ʹ���̳� TitleAreaDialog �࣬Ϊ������������Ի���� ͨ�ø�ʽ
 */
public class MyTitleAreaDialogClass extends TitleAreaDialog {
	public MyTitleAreaDialogClass(Shell shell) {
		super(shell);
	}
	/**
	 * �����Ի����ϵ�����
	 * 
	 */
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// ���ñ���
		setTitle("����");
		// ���öԻ�����ʽЧ��
		setMessage("����TitleAreaDialog", IMessageProvider.INFORMATION);
		// setErrorMessage("��������Ƿ����");
		// setMessage("����TitleAreaDialog", IMessageProvider.ERROR);
		// setMessage("����TitleAreaDialog", IMessageProvider.WARNING);
		// setMessage("����TitleAreaDialog", IMessageProvider.NONE);
		return contents;
	}
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		// ����ѡ�
		TabFolder tableFolder = new TabFolder(composite, SWT.NONE);
		tableFolder.setLayoutData(new GridData(GridData.FILL_BOTH));
		TabItem tabItem1 = new TabItem(tableFolder, SWT.NONE);
		tabItem1.setText("Item1");
		TabItem tabItem2 = new TabItem(tableFolder, SWT.NONE);
		tabItem2.setText("Item2");
		// �������
		Table table = new Table(tableFolder, SWT.FULL_SELECTION | SWT.BORDER);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		// ��ʾ��ͷ�ͱ����
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tabItem1.setControl(table);
		// �����п��Ϊ80������
		TableColumn one = new TableColumn(table, SWT.LEFT);
		one.setText("Ա����");
		one.setWidth(80);
		TableColumn two = new TableColumn(table, SWT.LEFT);
		two.setText("����");
		two.setWidth(80);
		TableColumn three = new TableColumn(table, SWT.LEFT);
		three.setText("ְλ");
		three.setWidth(80);
		// �������
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(0, "20020001");
		item.setText(1, "��־��");
		item.setText(2, "���񲿾���");
		
item = new TableItem(table, SWT.NONE);
		item.setText(0, "20020002");
		item.setText(1, "��־ǿ");
		item.setText(2, "����������");

		item = new TableItem(table, SWT.NONE);
		item.setText(0, "20020003");
		item.setText(1, "���÷");
		item.setText(2, "���񲿾���");

		return composite;
	}
	 /**
	  * ��SWT.RESIZE��SWT.MAX��SWT.MIN�ֱ����ô���Ϊ���Ա��С�����ڿ��� �󻯡���С��
	  */
	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE | SWT.MAX | SWT.MIN;
	}
	/**
	 * ������ť����ȷ�ϡ�ȡ����ť
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, true);
	 }
}
