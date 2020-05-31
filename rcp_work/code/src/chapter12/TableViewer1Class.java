package chapter12;
import org.eclipse.jface.window.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


public class TableViewer1Class extends ApplicationWindow {
	public TableViewer1Class() {
		super(null);
	}
	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("TableViewer实例");
		shell.setSize(400, 200);
	}
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		//定义一个TableViewer对象
		TableViewer tv = new TableViewer(composite, SWT.FULL_SELECTION);
		// 设置Table
		 Table table = tv.getTable();
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		// 定义表中的列
		TableColumn Col1 = new TableColumn(table, SWT.LEFT);
		Col1.setText("学号");
		// 设置列宽度
		Col1.setWidth(60);
		TableColumn Col2 = new TableColumn(table, SWT.LEFT);
		Col2.setText("姓名");
		Col2.setWidth(60);
		TableColumn Col3 = new TableColumn(table, SWT.LEFT);
		Col3.setText("性别");
		Col3.setWidth(60);
		TableColumn Col4 = new TableColumn(table, SWT.LEFT);
		Col4.setText("年龄");
		Col4.setWidth(60);
		TableColumn Col5 = new TableColumn(table, SWT.LEFT);
		Col5.setText("喜欢的颜色");
		Col5.setWidth(80);
		// 显示表头
		table.setHeaderVisible(true);
		// 显示表格线
		table.setLinesVisible(true);
		return composite;
	}
	public static void main(String[] args) {
		new TableViewer1Class().run();
	}
}
