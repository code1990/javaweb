/**@author WangJinTao,MengQingChang 2006
 */
package chapter04.basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class ListExample {
	public ListExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(260, 170);
		shell.setText("Listʵ��");
		final List list1 = new List(shell, SWT.MULTI | SWT.BORDER
				| SWT.H_SCROLL | SWT.V_SCROLL);
		list1.setBounds(30, 25, 80, 80);
		for (int i = 1; i < 12; i++) {
			list1.add("SWT/JFace��UI����ָ��" + i + "��");
		}
		final List list2 = new List(shell, SWT.NONE | SWT.BORDER | SWT.V_SCROLL);
		list2.setBounds(130, 25, 80, 60);
		list2.setItems(new String[] { "One", "Two", "Three", "Four", "Five",
				"Six", "Seven", "Eight" });
		list2.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				System.out.println(list2.getSelection()[0]);
			}

			public void mouseUp(MouseEvent e) {
				System.out.println(list2.getSelectionIndex() + 1);
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
		new ListExample();
	}
}
