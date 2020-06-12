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
		shell.setText("TableEditor实例");
		shell.setLayout(new FillLayout());
		// 定义一个table对象
		table = new Table(shell, SWT.SINGLE | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);
		// 设置表头可见
		table.setHeaderVisible(true);
		// 设置表格可见
		table.setLinesVisible(true);
		// 定义一个列
		TableColumn tableColumnone = new TableColumn(table, SWT.LEFT);
		// 设置列名
		tableColumnone.setText("学号");
		// 设置每一列的宽度(以像素为单位）
		tableColumnone.setWidth(100);
		TableColumn tableColumntwo = new TableColumn(table, SWT.LEFT);
		tableColumntwo.setText("姓名");
		tableColumntwo.setWidth(100);
		TableColumn tableColumnthree = new TableColumn(table, SWT.LEFT);
		tableColumnthree.setText("性别");
		tableColumnthree.setWidth(100);
		TableColumn tableColumnfour = new TableColumn(table, SWT.LEFT);
		tableColumnfour.setText("年龄");
		tableColumnfour.setWidth(100);
		// 定义Item对象
		TableItem Item = new TableItem(table, SWT.LEFT);
		// 设置表格中的数据
		Item.setText(new String[] { "20020001", "李晓莉", "女", "23" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020002",
				"王晓琳", "女", "23" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020003",
				"曾志广", "男", "22" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020004",
				"陈秀玲", "女", "24" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020005",
				"张奋斗", "男", "23" });
		// 定义editor对象
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
		// 鼠标事件
		table.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent event) {
				// 清除原来的table编辑控制
				Control old = editor.getEditor();
				if (old != null)
					old.dispose();
				// 决定鼠标单击所获取的位置
				Point point = new Point(event.x, event.y);
				// 决定哪一行被选中
				final TableItem item = table.getItem(point);
				if (item != null) {
					// 决定哪一列被选中
					int column = -1;
					for (int i = 2, n = table.getColumnCount(); i < n; i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(point)) {
							// 设置被选择的列
							column = i;
							break;
						}
					}
					// 第3列被选中时
					if (column == 2) {
						// 定义下拉列表对象
						final Combo combo = new Combo(table, SWT.READ_ONLY);
						// 设置下拉列表内容
						combo.setItems(new String[] { "男", "女" });
						editor.setEditor(combo, item, column);
						final int col = column;
						combo.addSelectionListener(new SelectionAdapter() {
							public void widgetSelected(SelectionEvent event) {
								item.setText(col, combo.getText());
								combo.dispose();
							}
						});
					} else if (column > 2) {
						// 当第4列被选中时修改第4列中某行数据
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
