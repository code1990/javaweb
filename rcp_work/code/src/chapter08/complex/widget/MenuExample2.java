/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
public class MenuExample2 {
	public MenuExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 200);
		shell.setText("�Ҽ�����ʽ�˵�ʵ��");
		Menu menu = new Menu(shell, SWT.POP_UP);
		final MenuItem copyItem = new MenuItem(menu, SWT.RADIO);
		copyItem.setText("����");
		final MenuItem pasteItem = new MenuItem(menu, SWT.CHECK);
		pasteItem.setText("ճ��");
		new MenuItem(menu, SWT.SEPARATOR);
		final MenuItem cutItem = new MenuItem(menu, SWT.NONE);
		cutItem.setText("����");
		shell.setMenu(menu);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new MenuExample2();
	}
}
