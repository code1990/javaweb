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
		shell.setText("TabFolderʵ��");
		// shell��������ʽ����
		shell.setLayout(new GridLayout(2, false));
		final TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		GridData gridTab = new GridData(GridData.FILL_BOTH);
		gridTab.horizontalSpan = 2;// ˮƽ��ռ����
		tabFolder.setLayoutData(gridTab);
		// �����һ��ѡ���
		final TabItem item1 = new TabItem(tabFolder, SWT.NONE);
		item1.setText("Item1");
		{
			Composite comp1 = new Composite(tabFolder, SWT.BORDER);
			item1.setControl(comp1);
			comp1.setLayout(new GridLayout());
			new Slider(comp1, SWT.NONE);// ����һ��������
			new Scale(comp1, SWT.NONE);// ����һ���̶���
			new ProgressBar(comp1, SWT.INDETERMINATE);// ����һ��������
		}
		// /����ڶ���ѡ���
		final TabItem item2 = new TabItem(tabFolder, SWT.NONE);
		item2.setText("Item2");
		{
			Composite comp2 = new Composite(tabFolder, SWT.BORDER);
			item2.setControl(comp2);
			// ������屳����ɫΪ��ɫ
			comp2.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
		}
		// ���������ѡ���
		final TabItem item3 = new TabItem(tabFolder, SWT.NONE);
		item3.setText("Item3");
		{
			Composite comp3 = new Composite(tabFolder, SWT.BORDER);
			item3.setControl(comp3);

		}
		// ����������ť
		new Button(shell, SWT.NONE).setText("ȷ��");
		new Button(shell, SWT.NONE).setText("ȡ��");
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
