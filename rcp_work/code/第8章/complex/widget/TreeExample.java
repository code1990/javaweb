/**@author WangJinTao,MengQingChang 2006
 */
package complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class TreeExample {
	public TreeExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("Tree实例");
		shell.setLayout(new FillLayout());
		// 定义一个树对象
		final Tree tree = new Tree(shell, SWT.SINGLE);
		// 创建树节点
		final TreeItem treeItemGoogle = new TreeItem(tree, SWT.NONE);
		treeItemGoogle.setText("Google公司");
		new TreeItem(treeItemGoogle, SWT.NULL).setText("Google Earth");
		new TreeItem(treeItemGoogle, SWT.NULL).setText("Google ToolBar");
		new TreeItem(treeItemGoogle, SWT.NULL).setText("Google Talk");
		new TreeItem(treeItemGoogle, SWT.NULL).setText("Google Desk");

		final TreeItem treeItemMicrosoft = new TreeItem(tree, SWT.NONE);
		treeItemMicrosoft.setText("Microsoft公司");
		new TreeItem(treeItemMicrosoft, SWT.NULL).setText("Windows 98");
		new TreeItem(treeItemMicrosoft, SWT.NULL).setText("Windows NT");
		new TreeItem(treeItemMicrosoft, SWT.NULL).setText("Windows XP");
		new TreeItem(treeItemMicrosoft, SWT.NULL).setText("Windows Vista");

		final TreeItem treeItemIBM = new TreeItem(tree, SWT.NONE);
		treeItemIBM.setText("IBM公司");
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
