/**
 *@ author: WangJinTao,MengQingChang 2006 
 */
package chapter12;

import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import org.eclipse.jface.viewers.*;

import org.eclipse.jface.window.*;
import org.eclipse.swt.*;

public class TreeViewerClass extends ApplicationWindow {

	public TreeViewerClass() {
		super(null);

	}

	public static void main(String[] args) {
		ApplicationWindow w = new TreeViewerClass();
		w.setBlockOnOpen(true);
		w.open();
		Display.getCurrent().dispose();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		//���ô����С
		shell.setSize(280, 300);
		shell.setText("TreeViewerʵ��");
	}

	protected Control createContents(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());

		final TreeViewer treeViewer = new TreeViewer(composite, SWT.NONE);
		//����ֵ��ǩ��
		treeViewer.setLabelProvider(new TreeViewerLabelProvider());
		//����������
		treeViewer.setContentProvider(new TreeViewerContentProvider());
		//��setInput()������������ 
		treeViewer.setInput(Entity.node());
		return composite;
	}
}
