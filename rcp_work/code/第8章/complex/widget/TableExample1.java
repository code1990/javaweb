/**@author WangJinTao,MengQingChang 2006
 */
package complex.widget;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
public class TableExample1 {
	public TableExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(410, 260);
		shell.setText("Table实例");
		// shell采用充满是布局
		shell.setLayout(new FillLayout());
		Table table = new Table(shell, SWT.MULTI);
		// 设置表头可见
		table.setHeaderVisible(true);
		// 设置网格线可见
		table.setLinesVisible(true);
		// 定义表中的列
		TableColumn tableColumnone = new TableColumn(table, SWT.NONE);
		// 设置列名
		tableColumnone.setText("学号");
		// 设置每一列的宽度(以像素为单位）
		tableColumnone.setWidth(100);
		TableColumn tableColumntwo = new TableColumn(table, SWT.NONE);
		tableColumntwo.setText("姓名");
		tableColumntwo.setWidth(100);
		TableColumn tableColumnthree = new TableColumn(table, SWT.NONE);
		tableColumnthree.setText("性别");
		tableColumnthree.setWidth(100);
		TableColumn tableColumnfour = new TableColumn(table, SWT.NONE);
		tableColumnfour.setText("年龄");
		tableColumnfour.setWidth(100);
	
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new TableExample1();
	}
}
