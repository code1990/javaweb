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

	// �趨�������Ϊ5,����Ϊ100
	static final int COLUMNS = 5, ROWS = 1000;

	// �����ά����
	static final String[][] DATA = new String[ROWS][COLUMNS];
	static {// ʹ������100��5��
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				DATA[i][j] = "Item " + i + "-" + j;
			}
		}
	}

	// ���췽��
	public TableExample3() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(SWT.MIN);
		shell.setSize(470, 280);
		shell.setText("Tableʵ��");
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
		addButton.setText("���");
		GridData gridaddButton = new GridData();
		gridaddButton.horizontalIndent = 147;
		gridaddButton.verticalIndent = 30;
		gridaddButton.widthHint = 80;
		addButton.setLayoutData(gridaddButton);
		addButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// ����һ���߳�
				Thread thread = new Thread() {
					public void run() {
						for (i = 0; i < ROWS; i++) {
							try {

								time = -System.currentTimeMillis();
							} catch (Throwable e) {
							}
							display.asyncExec(new Runnable() {// �����ڲ���
										public void run() {
											item = new TableItem(table,
													SWT.NULL);
											// /�������������
											for (int j = 0; j < COLUMNS; j++) {
												item.setText(j, DATA[i][j]);
											}
											// ���ƽ������Ľ���
											progressBar.setSelection(i);
										}
									});
						}
					}
				};
				thread.start();// �����߳�
			}
		});
		Button deleteButton = new Button(shell, SWT.PUSH);
		deleteButton.setText("ɾ��");
		GridData gridedeleteButton = new GridData();
		gridedeleteButton.horizontalIndent = 20;
		gridedeleteButton.verticalIndent = 30;
		gridedeleteButton.widthHint = 80;
		deleteButton.setLayoutData(gridedeleteButton);
		deleteButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// ɾ������ѡ�е���
				table.remove(table.getSelectionIndices());
			}
		});
		Button exitButton = new Button(shell, SWT.PUSH);
		exitButton.setText("�˳�");
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
		new TableExample3();// ���ù��췽��
	}
}
