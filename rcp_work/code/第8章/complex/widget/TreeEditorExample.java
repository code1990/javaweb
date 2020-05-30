/**@author WangJinTao,MengQingChang 2006
 */
package complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
public class TreeEditorExample{
	private Text text;
	private TreeItem item;
	public TreeEditorExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(180, 200);
		shell.setText("TreeEditor实例");
		shell.setLayout(new FillLayout());
		final Tree tree = new Tree(shell, SWT.BORDER);
		TreeItem item1 = new TreeItem(tree, SWT.NULL);
		item1.setText("城市");
		TreeItem item2 = new TreeItem(item1, SWT.NULL);
		item2.setText("北京");
		TreeItem item3 = new TreeItem(item1, SWT.NULL);
		item3.setText("上海");
		final TreeEditor treeEditor = new TreeEditor(tree);
		treeEditor.grabHorizontal = true;
		tree.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// 清除原来编辑的节点数据
				Control oldEditor = treeEditor.getEditor();
				if (oldEditor != null)
					oldEditor.dispose();
				item = (TreeItem) e.item;
				if (item == null) {
					return;
				}
				text = new Text(tree, SWT.BORDER);
				text.setText(item.getText());
				text.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						item = treeEditor.getItem();
						item.setText(text.getText());
					}
				});
				text.selectAll();
				//text.setFocus();
				treeEditor.setEditor(text, item);
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
		new TreeEditorExample();
	}
}