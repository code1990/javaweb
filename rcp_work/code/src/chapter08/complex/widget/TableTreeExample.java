/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;

public class TableTreeExample {
	public TableTreeExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(465, 260);
		shell.setText("TableTreeʵ��");
		// �����Զ��巽��
		createContents(shell);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	private void createContents(final Shell shell) {
		// ���ó���ʽ����
		shell.setLayout(new FillLayout());
		// ����һ�����������
		final TableTree tableTree = new TableTree(shell, SWT.BORDER
				| SWT.FULL_SELECTION);

		Table table = tableTree.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		{

			String[] columns = { "����", "ְλ", "��н(�����)" };
			for (int i = 0; i < columns.length; i++) {
				TableColumn Column = new TableColumn(table, SWT.NONE);
				Column.setText(columns[i]);
				Column.setWidth(150);
			}

		}
		final TableTreeItem tabletreeItem1 = new TableTreeItem(tableTree,
				SWT.NONE);
		tabletreeItem1.setText(0, "����");
		CreateTableTreeItem(tabletreeItem1, "��־��", "���񲿾���", "20000");
		CreateTableTreeItem(tabletreeItem1, "��־��", "���۹���ʦ", "14000");
		CreateTableTreeItem(tabletreeItem1, "������", "�߼��������", "10000");
		CreateTableTreeItem(tabletreeItem1, "̷����", "�������", "8000");
		final TableTreeItem tabletreeItem2 = new TableTreeItem(tableTree,
				SWT.NONE);
		tabletreeItem2.setText(0, "������");
		CreateTableTreeItem(tabletreeItem2, "��־ǿ", "����������", "10000");
		CreateTableTreeItem(tabletreeItem2, "������", "�߼��������ʦ", "6000");
		CreateTableTreeItem(tabletreeItem2, "�����", "�������ʦ", "5000");
		CreateTableTreeItem(tabletreeItem2, "��־�� ", "����Ա", "3000");
		final TableTreeItem tabletreeItem3 = new TableTreeItem(tableTree,
				SWT.NONE);
		tabletreeItem3.setText(0, "����");
		CreateTableTreeItem(tabletreeItem3, "���÷", "���񲿾���", "6800");
		CreateTableTreeItem(tabletreeItem3, "��ѩ��", "���", "3000");
		CreateTableTreeItem(tabletreeItem3, "����÷", "����", "2000");
	}

	// �Զ��巽��
	private TableTreeItem CreateTableTreeItem(
			TableTreeItem parentTableTreeItem, String str0, String str1,
			String str2) {
		TableTreeItem item = new TableTreeItem(parentTableTreeItem, SWT.NONE);
		item.setText(0, str0);
		item.setText(1, str1);
		item.setText(2, str2);
		return item;
	}

	public static void main(String[] args) {
		new TableTreeExample();
	}
}
