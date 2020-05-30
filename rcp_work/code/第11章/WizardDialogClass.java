/**
 *@author: WangJinTao,MengQingChang2006
 */
package jfaceDialog;

import org.eclipse.jface.window.*;
import org.eclipse.jface.wizard.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class WizardDialogClass extends ApplicationWindow {
	private TableItem item;

	private Table table;

	public WizardDialogClass() {
		// 部署窗口
		
		super(null);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		// 设置窗体标题
		getShell().setText("向导对话框实例");
		// /设置窗体大小
		getShell().setSize(400, 200);
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayoutData(new GridData(GridData.FILL_BOTH));
		comp.setLayout(new GridLayout(2, false));
		// 定义表格
		table = new Table(comp, SWT.MULTI | SWT.FULL_SELECTION);
		// 使表头可见
		table.setHeaderVisible(true);
		// 使表格线可见
		table.setLinesVisible(true);
		// 对表格进行布局
		GridData grid = new GridData(GridData.FILL_BOTH);
		grid.horizontalSpan = 2;
		table.setLayoutData(grid);
		// 定义表的列并设置列的宽度
		TableColumn col1 = new TableColumn(table, SWT.NONE);
		col1.setText("学号");
		col1.setWidth(80);
		TableColumn col2 = new TableColumn(table, SWT.NONE);
		col2.setText("姓名");
		col2.setWidth(80);
		TableColumn col3 = new TableColumn(table, SWT.NONE);
		col3.setText("性别");
		col3.setWidth(80);
		TableColumn col4 = new TableColumn(table, SWT.NONE);
		col4.setText("邮箱");
		col4.setWidth(120);
		TableColumn col5 = new TableColumn(table, SWT.NONE);
		col5.setText("自我评价");
		col5.setWidth(120);
		Button addButton = new Button(comp, SWT.PUSH);
		addButton.setText("注册信息");
		addButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				item = new TableItem(table, SWT.NONE);
				StudentWizardInformation wizard = new StudentWizardInformation(
						item);
				WizardDialog dialog = new WizardDialog(getShell(), wizard);
				// 设置对话框所有页的大小，
				dialog.setPageSize(-1, 105);
				dialog.open();
			}
		});
		// 对“注册信息”按钮进行布局
		GridData gridAdd = new GridData(GridData.HORIZONTAL_ALIGN_END);
		gridAdd.widthHint = 100;
		addButton.setLayoutData(gridAdd);
		Button ExitButton = new Button(comp, SWT.PUSH);
		ExitButton.setText("退出");
		ExitButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				getShell().dispose();
			}
		});
		// 对“退出”按钮进行布局
		GridData gridExit = new GridData();
		gridExit.widthHint = 100;
		ExitButton.setLayoutData(gridExit);
		return comp;
	}

	public static void main(String[] args) {
		new WizardDialogClass().run();
	}
}
