/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class TreeExample {
	public TreeExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("Treeʵ��");
		shell.setLayout(new FillLayout());
		// ����һ��������
		final Tree tree = new Tree(shell, SWT.SINGLE);
		// �������ڵ�
		final TreeItem treeItemGoogle = new TreeItem(tree, SWT.NONE);
		treeItemGoogle.setText("Google��˾");
		new TreeItem(treeItemGoogle, SWT.NULL).setText("Google Earth");
		new TreeItem(treeItemGoogle, SWT.NULL).setText("Google ToolBar");
		new TreeItem(treeItemGoogle, SWT.NULL).setText("Google Talk");
		new TreeItem(treeItemGoogle, SWT.NULL).setText("Google Desk");

		final TreeItem treeItemMicrosoft = new TreeItem(tree, SWT.NONE);
		treeItemMicrosoft.setText("Microsoft��˾");
		new TreeItem(treeItemMicrosoft, SWT.NULL).setText("Windows 98");
		new TreeItem(treeItemMicrosoft, SWT.NULL).setText("Windows NT");
		new TreeItem(treeItemMicrosoft, SWT.NULL).setText("Windows XP");
		new TreeItem(treeItemMicrosoft, SWT.NULL).setText("Windows Vista");

		final TreeItem treeItemIBM = new TreeItem(tree, SWT.NONE);
		treeItemIBM.setText("IBM��˾");
		new TreeItem(treeItemIBM, SWT.NULL).setText("Lotus Software");
		new TreeItem(treeItemIBM, SWT.NULL).setText("Tivoli Software");
		new TreeItem(treeItemIBM, SWT.NULL).setText("WebSphere Software");
		new TreeItem(treeItemIBM, SWT.NULL).setText("Rational Software");
	    
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new TreeExample();
	}
}
