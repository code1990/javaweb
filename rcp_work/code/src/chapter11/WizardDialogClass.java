/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter11;

import org.eclipse.jface.window.*;
import org.eclipse.jface.wizard.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class WizardDialogClass extends ApplicationWindow {
	private TableItem item;

	private Table table;

	public WizardDialogClass() {
		// ���𴰿�
		
		super(null);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		// ���ô������
		getShell().setText("�򵼶Ի���ʵ��");
		// /���ô����С
		getShell().setSize(400, 200);
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayoutData(new GridData(GridData.FILL_BOTH));
		comp.setLayout(new GridLayout(2, false));
		// ������
		table = new Table(comp, SWT.MULTI | SWT.FULL_SELECTION);
		// ʹ��ͷ�ɼ�
		table.setHeaderVisible(true);
		// ʹ����߿ɼ�
		table.setLinesVisible(true);
		// �Ա����в���
		GridData grid = new GridData(GridData.FILL_BOTH);
		grid.horizontalSpan = 2;
		table.setLayoutData(grid);
		// �������в������еĿ��
		TableColumn col1 = new TableColumn(table, SWT.NONE);
		col1.setText("ѧ��");
		col1.setWidth(80);
		TableColumn col2 = new TableColumn(table, SWT.NONE);
		col2.setText("����");
		col2.setWidth(80);
		TableColumn col3 = new TableColumn(table, SWT.NONE);
		col3.setText("�Ա�");
		col3.setWidth(80);
		TableColumn col4 = new TableColumn(table, SWT.NONE);
		col4.setText("����");
		col4.setWidth(120);
		TableColumn col5 = new TableColumn(table, SWT.NONE);
		col5.setText("��������");
		col5.setWidth(120);
		Button addButton = new Button(comp, SWT.PUSH);
		addButton.setText("ע����Ϣ");
		addButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				item = new TableItem(table, SWT.NONE);
				StudentWizardInformation wizard = new StudentWizardInformation(
						item);
				WizardDialog dialog = new WizardDialog(getShell(), wizard);
				// ���öԻ�������ҳ�Ĵ�С��
				dialog.setPageSize(-1, 105);
				dialog.open();
			}
		});
		// �ԡ�ע����Ϣ����ť���в���
		GridData gridAdd = new GridData(GridData.HORIZONTAL_ALIGN_END);
		gridAdd.widthHint = 100;
		addButton.setLayoutData(gridAdd);
		Button ExitButton = new Button(comp, SWT.PUSH);
		ExitButton.setText("�˳�");
		ExitButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				getShell().dispose();
			}
		});
		// �ԡ��˳�����ť���в���
		GridData gridExit = new GridData();
		gridExit.widthHint = 100;
		ExitButton.setLayoutData(gridExit);
		return comp;
	}

	public static void main(String[] args) {
		new WizardDialogClass().run();
	}
}
