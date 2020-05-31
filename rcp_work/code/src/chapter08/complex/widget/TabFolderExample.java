/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class TabFolderExample {
	public TabFolderExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(new Shell());
		shell.setSize(220, 250);
		shell.setText("TabFolder实例");
		// shell采用网格式布局
		shell.setLayout(new GridLayout(2, false));
		final TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		GridData gridTab = new GridData(GridData.FILL_BOTH);
		gridTab.horizontalSpan = 2;// 水平抢占两列
		tabFolder.setLayoutData(gridTab);
		// 定义第一个选项卡项
		final TabItem item1 = new TabItem(tabFolder, SWT.NONE);
		item1.setText("Item1");
		{
			Composite comp1 = new Composite(tabFolder, SWT.BORDER);
			item1.setControl(comp1);
			comp1.setLayout(new GridLayout());
			new Slider(comp1, SWT.NONE);// 定义一个滑动条
			new Scale(comp1, SWT.NONE);// 定义一个刻度条
			new ProgressBar(comp1, SWT.INDETERMINATE);// 定义一个进度条
		}
		// /定义第二个选项卡项
		final TabItem item2 = new TabItem(tabFolder, SWT.NONE);
		item2.setText("Item2");
		{
			Composite comp2 = new Composite(tabFolder, SWT.BORDER);
			item2.setControl(comp2);
			// 设置面板背景颜色为蓝色
			comp2.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
		}
		// 定义第三个选项卡项
		final TabItem item3 = new TabItem(tabFolder, SWT.NONE);
		item3.setText("Item3");
		{
			Composite comp3 = new Composite(tabFolder, SWT.BORDER);
			item3.setControl(comp3);

		}
		// 定义两个按钮
		new Button(shell, SWT.NONE).setText("确定");
		new Button(shell, SWT.NONE).setText("取消");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new TabFolderExample();
	}
}
