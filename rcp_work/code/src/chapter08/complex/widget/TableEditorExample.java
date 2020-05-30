/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class TableEditorExample {
	private TableEditor editor;

	private Table table;

	public TableEditorExample() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TableEditorʵ��");
		shell.setLayout(new FillLayout());
		// ����һ��table����
		table = new Table(shell, SWT.SINGLE | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);
		// ���ñ�ͷ�ɼ�
		table.setHeaderVisible(true);
		// ���ñ��ɼ�
		table.setLinesVisible(true);
		// ����һ����
		TableColumn tableColumnone = new TableColumn(table, SWT.LEFT);
		// ��������
		tableColumnone.setText("ѧ��");
		// ����ÿһ�еĿ��(������Ϊ��λ��
		tableColumnone.setWidth(100);
		TableColumn tableColumntwo = new TableColumn(table, SWT.LEFT);
		tableColumntwo.setText("����");
		tableColumntwo.setWidth(100);
		TableColumn tableColumnthree = new TableColumn(table, SWT.LEFT);
		tableColumnthree.setText("�Ա�");
		tableColumnthree.setWidth(100);
		TableColumn tableColumnfour = new TableColumn(table, SWT.LEFT);
		tableColumnfour.setText("����");
		tableColumnfour.setWidth(100);
		// ����Item����
		TableItem Item = new TableItem(table, SWT.LEFT);
		// ���ñ���е�����
		Item.setText(new String[] { "20020001", "������", "Ů", "23" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020002",
				"������", "Ů", "23" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020003",
				"��־��", "��", "22" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020004",
				"������", "Ů", "24" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020005",
				"�ŷܶ�", "��", "23" });
		// ����editor����
		editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		createEditorContents();
	
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void createEditorContents() {
		// ����¼�
		table.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent event) {
				// ���ԭ����table�༭����
				Control old = editor.getEditor();
				if (old != null)
					old.dispose();
				// ������굥������ȡ��λ��
				Point point = new Point(event.x, event.y);
				// ������һ�б�ѡ��
				final TableItem item = table.getItem(point);
				if (item != null) {
					// ������һ�б�ѡ��
					int column = -1;
					for (int i = 2, n = table.getColumnCount(); i < n; i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(point)) {
							// ���ñ�ѡ�����
							column = i;
							break;
						}
					}
					// ��3�б�ѡ��ʱ
					if (column == 2) {
						// ���������б����
						final Combo combo = new Combo(table, SWT.READ_ONLY);
						// ���������б�����
						combo.setItems(new String[] { "��", "Ů" });
						editor.setEditor(combo, item, column);
						final int col = column;
						combo.addSelectionListener(new SelectionAdapter() {
							public void widgetSelected(SelectionEvent event) {
								item.setText(col, combo.getText());
								combo.dispose();
							}
						});
					} else if (column > 2) {
						// ����4�б�ѡ��ʱ�޸ĵ�4����ĳ������
						final Text text = new Text(table, SWT.NONE);
						text.setText(item.getText(column));
						text.selectAll();
						text.setFocus();
						editor.setEditor(text, item, column);
						final int col = column;
						text.addModifyListener(new ModifyListener() {
							public void modifyText(ModifyEvent event) {
								item.setText(col, text.getText());
							}
						});
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new TableEditorExample();
	}
}
