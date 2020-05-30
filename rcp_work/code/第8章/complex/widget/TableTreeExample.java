/**@author WangJinTao,MengQingChang 2006
 */
package complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;

public class TableTreeExample {
	public TableTreeExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(465, 260);
		shell.setText("TableTree实例");
		// 调用自定义方法
		createContents(shell);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	private void createContents(final Shell shell) {
		// 采用充满式布局
		shell.setLayout(new FillLayout());
		// 定义一个表格树对象
		final TableTree tableTree = new TableTree(shell, SWT.BORDER
				| SWT.FULL_SELECTION);

		Table table = tableTree.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		{

			String[] columns = { "部门", "职位", "月薪(人民币)" };
			for (int i = 0; i < columns.length; i++) {
				TableColumn Column = new TableColumn(table, SWT.NONE);
				Column.setText(columns[i]);
				Column.setWidth(150);
			}

		}
		final TableTreeItem tabletreeItem1 = new TableTreeItem(tableTree,
				SWT.NONE);
		tabletreeItem1.setText(0, "商务部");
		CreateTableTreeItem(tabletreeItem1, "曾志广", "商务部经理", "20000");
		CreateTableTreeItem(tabletreeItem1, "李志娟", "销售工程师", "14000");
		CreateTableTreeItem(tabletreeItem1, "王晓玲", "高级商务代表", "10000");
		CreateTableTreeItem(tabletreeItem1, "谭金生", "商务代表", "8000");
		final TableTreeItem tabletreeItem2 = new TableTreeItem(tableTree,
				SWT.NONE);
		tabletreeItem2.setText(0, "技术部");
		CreateTableTreeItem(tabletreeItem2, "张志强", "技术部经理", "10000");
		CreateTableTreeItem(tabletreeItem2, "王铭杰", "高级软件工程师", "6000");
		CreateTableTreeItem(tabletreeItem2, "隋凤玲", "软件工程师", "5000");
		CreateTableTreeItem(tabletreeItem2, "乔志彪 ", "程序员", "3000");
		final TableTreeItem tabletreeItem3 = new TableTreeItem(tableTree,
				SWT.NONE);
		tabletreeItem3.setText(0, "财务部");
		CreateTableTreeItem(tabletreeItem3, "李鸿梅", "财务部经理", "6800");
		CreateTableTreeItem(tabletreeItem3, "方雪娟", "会计", "3000");
		CreateTableTreeItem(tabletreeItem3, "赵淑梅", "出纳", "2000");
	}

	// 自定义方法
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
