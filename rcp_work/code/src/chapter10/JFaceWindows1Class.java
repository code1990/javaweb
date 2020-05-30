/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

import org.eclipse.jface.window.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

public class JFaceWindows1Class extends ApplicationWindow {
	JFaceWindows1Class() {
		// ���𴰿�
		super(null);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	public Control createContents(Composite parent) {
		// ���ô����С
		parent.getShell().setSize(250, 290);
		// ���ô������
		parent.getShell().setText("JFace Ӧ�ô���ʵ��");
		Composite composite = new Composite(parent, SWT.NONE);
		// ��һ��ѡ�
		final TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setBounds(20, 10, 200, 200);
		final TabItem item1 = new TabItem(tabFolder, SWT.NONE);
		item1.setText("Item1");
		// ��ѡ��϶���һ�������
		final Group group = new Group(tabFolder, SWT.NONE);
		group.setText("�����");
		item1.setControl(group);

		final TabItem item2 = new TabItem(tabFolder, SWT.NONE);
		item2.setText("Item2");
		return parent;
	}

	public static void main(String[] args) {
		new JFaceWindows1Class().run();

	}
}
