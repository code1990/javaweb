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
		//设置窗体大小
		shell.setSize(280, 300);
		shell.setText("TreeViewer实例");
	}

	protected Control createContents(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());

		final TreeViewer treeViewer = new TreeViewer(composite, SWT.NONE);
		//设置值标签器
		treeViewer.setLabelProvider(new TreeViewerLabelProvider());
		//设置内容其
		treeViewer.setContentProvider(new TreeViewerContentProvider());
		//用setInput()方法读入数据 
		treeViewer.setInput(Entity.node());
		return composite;
	}
}
