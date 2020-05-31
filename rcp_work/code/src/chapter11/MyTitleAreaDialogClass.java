/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter11;

import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
/**
 * 建立MyTitleAreaDialogClass类使它继承 TitleAreaDialog 类，为创建标题区域对话框的 通用格式
 */
public class MyTitleAreaDialogClass extends TitleAreaDialog {
	public MyTitleAreaDialogClass(Shell shell) {
		super(shell);
	}
	/**
	 * 建立对话框上的内容
	 * 
	 */
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// 设置标题
		setTitle("标题");
		// 设置对话框样式效果
		setMessage("这是TitleAreaDialog", IMessageProvider.INFORMATION);
		// setErrorMessage("请检查输出是否出错？");
		// setMessage("这是TitleAreaDialog", IMessageProvider.ERROR);
		// setMessage("这是TitleAreaDialog", IMessageProvider.WARNING);
		// setMessage("这是TitleAreaDialog", IMessageProvider.NONE);
		return contents;
	}
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		// 建立选项卡
		TabFolder tableFolder = new TabFolder(composite, SWT.NONE);
		tableFolder.setLayoutData(new GridData(GridData.FILL_BOTH));
		TabItem tabItem1 = new TabItem(tableFolder, SWT.NONE);
		tabItem1.setText("Item1");
		TabItem tabItem2 = new TabItem(tableFolder, SWT.NONE);
		tabItem2.setText("Item2");
		// 建立表格
		Table table = new Table(tableFolder, SWT.FULL_SELECTION | SWT.BORDER);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		// 显示表头和表格线
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tabItem1.setControl(table);
		// 建立列宽度为80个像素
		TableColumn one = new TableColumn(table, SWT.LEFT);
		one.setText("员工号");
		one.setWidth(80);
		TableColumn two = new TableColumn(table, SWT.LEFT);
		two.setText("姓名");
		two.setWidth(80);
		TableColumn three = new TableColumn(table, SWT.LEFT);
		three.setText("职位");
		three.setWidth(80);
		// 添加数据
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(0, "20020001");
		item.setText(1, "曾志光");
		item.setText(2, "商务部经理");
		
item = new TableItem(table, SWT.NONE);
		item.setText(0, "20020002");
		item.setText(1, "张志强");
		item.setText(2, "技术部经理");

		item = new TableItem(table, SWT.NONE);
		item.setText(0, "20020003");
		item.setText(1, "李鸿梅");
		item.setText(2, "财务部经理");

		return composite;
	}
	 /**
	  * 用SWT.RESIZE、SWT.MAX、SWT.MIN分别设置窗口为可以变大小、窗口可最 大化、最小化
	  */
	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE | SWT.MAX | SWT.MIN;
	}
	/**
	 * 建立按钮——确认、取消按钮
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, true);
	 }
}
