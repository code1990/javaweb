/**@author WangJinTao,MengQingChang 2006
 */
package complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
public class TableExample2 {
	private Table table;
	public TableExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(410, 260);
		shell.setText("Table实例");
		// shell采用充满是布局
		shell.setLayout(new FillLayout());
		table = new Table(shell, SWT.FULL_SELECTION);
		// 设置表头可见
		table.setHeaderVisible(true);
		// 设置网格线可见
		table.setLinesVisible(true);
		// 定义表中的列
		TableColumn tableColumnone = new TableColumn(table, SWT.CENTER);
		// 设置列名
		tableColumnone.setText("学号");
		// 设置每一列的宽度(以像素为单位）
		tableColumnone.setWidth(100);
		TableColumn tableColumntwo = new TableColumn(table, SWT.RIGHT);
		tableColumntwo.setText("姓名");
		tableColumntwo.setWidth(100);
		TableColumn tableColumnthree = new TableColumn(table, SWT.CENTER);
		tableColumnthree.setText("性别");
		tableColumnthree.setWidth(100);
		TableColumn tableColumnfour = new TableColumn(table, SWT.LEFT);
		tableColumnfour.setText("年龄");
		tableColumnfour.setWidth(100);
		TableItem tableItem = new TableItem(table, SWT.LEFT);
		tableItem.setText(new String[] { "20020001", "李晓莉", "女", "23" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020002",
				"王晓琳", "女", "23" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020003",
				"曾志广", "男", "22" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020004",
				"陈秀玲", "女", "24" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20020005",
				"张奋斗", "男", "23" });
		// 添加右键菜单
		Menu menu = new Menu(shell, SWT.POP_UP);
		table.setMenu(menu);
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("删除行");
		// 监听Table右键事件
		item.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				//删除所选的一行
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
