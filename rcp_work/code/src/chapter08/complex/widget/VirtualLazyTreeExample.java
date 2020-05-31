/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.layout.*;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class VirtualLazyTreeExample {
	public VirtualLazyTreeExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 300);
		shell.setText("虚拟懒惰树实例");
		// 采用充满式布局
		shell.setLayout(new FillLayout());
		// 创建Tree对象
		final Tree tree = new Tree(shell, SWT.VIRTUAL);
		tree.addListener(SWT.SetData, new Listener() {
			public void handleEvent(Event e) {
				TreeItem treeItem = (TreeItem) e.item;
				// 获得一个结点的父项
				TreeItem treeItemparent = treeItem.getParentItem();
				// 调用自定义方法
				String name = getName(treeItem, treeItemparent);
				treeItem.setText("结点 " + name);
				// 创建两个子结点
				treeItem.setItemCount(2);
			}

			private String getName(TreeItem treeItem, TreeItem treeItemparent) {
				// 当该结点没有父项时返回0，即此结点为根结点,根结点名字为“结点0”
				if (treeItemparent == null) {
					return "0";
				} else {
					// 若不是根结点，则返回值作为子结点的名字
					int i = treeItemparent.indexOf(treeItem);
					return getName(treeItemparent, treeItemparent
							.getParentItem())
							+ "-" + i;
				}
			}
		});

		tree.setItemCount(2);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new VirtualLazyTreeExample();
	}
}
