/**@author WangJinTao,MengQingChang 2006
 */
package jfaceWindows;

import org.eclipse.jface.window.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

public class JFaceWindows1Class extends ApplicationWindow {
	JFaceWindows1Class() {
		// 部署窗口
		super(null);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	public Control createContents(Composite parent) {
		// 设置窗体大小
		parent.getShell().setSize(250, 290);
		// 设置窗体标题
		parent.getShell().setText("JFace 应用窗口实例");
		Composite composite = new Composite(parent, SWT.NONE);
		// 第一个选项卡
		final TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setBounds(20, 10, 200, 200);
		final TabItem item1 = new TabItem(tabFolder, SWT.NONE);
		item1.setText("Item1");
		// 在选项卡上定义一个分组框
		final Group group = new Group(tabFolder, SWT.NONE);
		group.setText("分组框");
		item1.setControl(group);

		final TabItem item2 = new TabItem(tabFolder, SWT.NONE);
		item2.setText("Item2");
		return parent;
	}

	public static void main(String[] args) {
		new JFaceWindows1Class().run();

	}
}
