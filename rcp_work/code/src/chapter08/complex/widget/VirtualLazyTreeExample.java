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
		shell.setText("����������ʵ��");
		// ���ó���ʽ����
		shell.setLayout(new FillLayout());
		// ����Tree����
		final Tree tree = new Tree(shell, SWT.VIRTUAL);
		tree.addListener(SWT.SetData, new Listener() {
			public void handleEvent(Event e) {
				TreeItem treeItem = (TreeItem) e.item;
				// ���һ�����ĸ���
				TreeItem treeItemparent = treeItem.getParentItem();
				// �����Զ��巽��
				String name = getName(treeItem, treeItemparent);
				treeItem.setText("��� " + name);
				// ���������ӽ��
				treeItem.setItemCount(2);
			}

			private String getName(TreeItem treeItem, TreeItem treeItemparent) {
				// ���ý��û�и���ʱ����0�����˽��Ϊ�����,���������Ϊ�����0��
				if (treeItemparent == null) {
					return "0";
				} else {
					// �����Ǹ���㣬�򷵻�ֵ��Ϊ�ӽ�������
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
