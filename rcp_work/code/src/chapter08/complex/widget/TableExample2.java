/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
public class TableExample2 {
	private Table table;
	public TableExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(410, 260);
		shell.setText("Tableʵ��");
		// shell���ó����ǲ���
		shell.setLayout(new FillLayout());
		table = new Table(shell, SWT.FULL_SELECTION);
		// ���ñ�ͷ�ɼ�
		table.setHeaderVisible(true);
		// ���������߿ɼ�
		table.setLinesVisible(true);
		// ������е���
		TableColumn tableColumnone = new TableColumn(table, SWT.CENTER);
		// ��������
		tableColumnone.setText("ѧ��");
		// ����ÿһ�еĿ��(������Ϊ��λ��
		tableColumnone.setWidth(100);
		TableColumn tableColumntwo = new TableColumn(table, SWT.RIGHT);
		tableColumntwo.setText("����");
		tableColumntwo.setWidth(100);
		TableColumn tableColumnthree = new TableColumn(table, SWT.CENTER);
		tableColumnthree.setText("�Ա�");
		tableColumnthree.setWidth(100);
		TableColumn tableColumnfour = new TableColumn(table, SWT.LEFT);
		tableColumnfour.setText("����");
		tableColumnfour.setWidth(100);
		TableItem tableItem = new TableItem(table, SWT.LEFT);
		tableItem.setText(new String[] { "20020001", "������", "Ů", "23" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020002",
				"������", "Ů", "23" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020003",
				"��־��", "��", "22" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020004",
				"������", "Ů", "24" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020005",
				"�ŷܶ�", "��", "23" });
		// ����Ҽ��˵�
		Menu menu = new Menu(shell, SWT.POP_UP);
		table.setMenu(menu);
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("ɾ����");
		// ����Table�Ҽ��¼�
		item.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				//ɾ����ѡ��һ��
				table.remove(table.getSelectionIndices());
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new TableExample2();
	}
}
