/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class MenuExample1 {
	public MenuExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("菜单实例");
		// 主菜单栏，SWT.BAR用于主菜单栏
		Menu menu = new Menu(shell, SWT.BAR);
		// 添加到shell容器上
		shell.setMenuBar(menu);
		/**
		 * 设置主菜单的"用户信息管理"菜单项 
		 * SWT.CASCADE 应用于以下拉方式出现的菜单。
		 */
		MenuItem item1 = new MenuItem(menu, SWT.CASCADE);
		item1.setText("用户信息管理");
		// 设置主菜单的""学生信息管理"菜单项
		MenuItem item2 = new MenuItem(menu, SWT.CASCADE);
		item2.setText("学生信息管理");
		// 设置主菜单的一级下拉菜单
		Menu newFile = new Menu(shell, SWT.DROP_DOWN);
		item1.setMenu(newFile);
		MenuItem itemA = new MenuItem(newFile, SWT.CASCADE);
		itemA.setText("用户信息");
		MenuItem itemB = new MenuItem(newFile, SWT.CASCADE);
		itemB.setText("退出");
		// 给退出菜单项添加事件处理
		itemB.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		Menu File = new Menu(shell, SWT.DROP_DOWN);
		itemA.setMenu(File);
		// 复选类型，选中后前面会带有一个小勾。
		MenuItem itema = new MenuItem(File, SWT.CHECK);
		itema.setText("用户信息注册");
		itema.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				MessageDialog
						.openInformation(shell, " 信息提示", "您选择了“用户信息注册”菜单项");
			}
		});
		// 单选类型，选中后前面会带有一个圆点。
		MenuItem itemb = new MenuItem(File, SWT.RADIO);
		itemb.setText("删除用户信息");
		// 分割类型，在下拉菜单上产生分割符。
		new MenuItem(File, SWT.SEPARATOR);
		// 普通类型，选中后直接产生动作的发生
		MenuItem itemd = new MenuItem(File, SWT.PUSH);
		itemd.setText("修改用户信息");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new MenuExample1();
	}
}
