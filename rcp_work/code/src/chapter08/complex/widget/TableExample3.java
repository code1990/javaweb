/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;

public class TableExample3 {
	private ProgressBar progressBar;

	private int i;

	private Table table;

	private TableItem item;

	private long time;

	// 设定表的列数为5,行数为100
		static final int COLUMNS = 5, ROWS = 1000;

		// 定义二维数组
		static final String[][] DATA = new String[ROWS][COLUMNS];
		static {// 使数组有100行5列
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j < COLUMNS; j++) {
					DATA[i][j] = "Item " + i + "-" + j;
				}
			}
		}

		// 构造方法
		public TableExample3() {
			final Display display = Display.getDefault();
			final Shell shell = new Shell(SWT.MIN);
			shell.setSize(470, 280);
			shell.setText("Table实例");
			shell.setLayout(new GridLayout(3, false));
			table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
			GridData gridtable = new GridData();
			gridtable.horizontalSpan = 3;
			gridtable.horizontalIndent = 15;
			gridtable.verticalIndent = 15;
			gridtable.heightHint = 100;
			gridtable.widthHint = 400;
			table.setLayoutData(gridtable);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			for (int i = 0; i < COLUMNS; i++) {
				TableColumn column = new TableColumn(table, SWT.NONE);
				column.setText("Column" + i);
				column.setWidth(80);
			}
			progressBar = new ProgressBar(shell, SWT.SMOOTH);
			GridData gridprogressBar = new GridData();
			gridprogressBar.horizontalSpan = 3;
			gridprogressBar.horizontalIndent = 15;
			gridprogressBar.widthHint = 422;
			progressBar.setLayoutData(gridprogressBar);
			progressBar.setMaximum(ROWS - 1);
			Button addButton = new Button(shell, SWT.PUSH);
			addButton.setText("添加");
			GridData gridaddButton = new GridData();
			gridaddButton.horizontalIndent = 147;
			gridaddButton.verticalIndent = 30;
			gridaddButton.widthHint = 80;
			addButton.setLayoutData(gridaddButton);
			addButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// 创建一个线程
					Thread thread = new Thread() {
						public void run() {
							for (i = 0; i < ROWS; i++) {
								try {

									time = -System.currentTimeMillis();
								} catch (Throwable e) {
								}
								display.asyncExec(new Runnable() {// 匿名内部类
											public void run() {
												item = new TableItem(table,
														SWT.NULL);
												// /向表格中添加数据
												for (int j = 0; j < COLUMNS; j++) {
													item.setText(j, DATA[i][j]);
												}
												// 控制进度条的进度
												progressBar.setSelection(i);
											}
										});
							}
						}
					};
					thread.start();// 启动线程
				}
			});
			Button deleteButton = new Button(shell, SWT.PUSH);
			deleteButton.setText("删除");
			GridData gridedeleteButton = new GridData();
			gridedeleteButton.horizontalIndent = 20;
			gridedeleteButton.verticalIndent = 30;
			gridedeleteButton.widthHint = 80;
			deleteButton.setLayoutData(gridedeleteButton);
			deleteButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// 删除表中选中的行
					table.remove(table.getSelectionIndices());
				}
			});
			Button exitButton = new Button(shell, SWT.PUSH);
			exitButton.setText("退出");
			GridData gridexitButton = new GridData();
			gridexitButton.horizontalIndent = 20;
			gridexitButton.verticalIndent = 30;
			gridexitButton.widthHint = 80;
			exitButton.setLayoutData(gridexitButton);
			exitButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					shell.dispose();
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
			new TableExample3();// 调用构造方法
		}
}
