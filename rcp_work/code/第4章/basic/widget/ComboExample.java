/**@author WangJinTao,MengQingChang 2006
 */
package basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class ComboExample {
	public ComboExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 190);
		shell.setText("Combo实例");
		final Combo combo1 = new Combo(shell, SWT.SIMPLE);
		combo1.setBounds(25, 25, 90, 90);
		// 用数组为Combo设置下拉框中的下拉项
		combo1.setItems(new String[] { "Eclipse", "SWT", "JFace", "AWT",
				"Swing", "MyEclipse", "Lomboz" });
		
		final Combo combo2 = new Combo(shell, SWT.DROP_DOWN);
		combo2.setBounds(150, 25, 90, 20);
		// 用循环语句设置下拉框中的下拉项
		for (int i = 0; i < 8; i++) {
			combo2.add("Page " + i);
		}
		final Button button1 = new Button(shell, SWT.NONE);
		button1.setBounds(145, 115, 45, 25);
		button1.setText("OK");
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				 combo2.add(combo2.getText());// 向combo2中添加下拉项
				 
			}
		});
		final Button button2 = new Button(shell, SWT.NONE);
		button2.setBounds(200, 115, 45, 25);
		button2.setText("Cancel");
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				combo2.removeAll();// 将下拉框选项设置为空
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
		new ComboExample();
	}
}
