/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
public class TrayExample {
	public TrayExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(200, 100);
		shell.setText("Tray实例");
		Tray tray = display.getSystemTray();
		TrayItem trayItem = new TrayItem(tray, SWT.NONE);
		trayItem.setToolTipText("TaskTray");
		trayItem.setImage(new Image(display, "icons/eclipse0.gif"));
		trayItem.addListener(SWT.Show, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("show");
			}
		});
		trayItem.addListener(SWT.Hide, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("hide");
			}
		});
		trayItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("selection");
			}
		});
		trayItem.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("default selection");
			}
		});
		final Menu menu = new Menu(shell, SWT.POP_UP);
		MenuItem item1 = new MenuItem(menu, SWT.PUSH);
		item1.setText("禁用");
		MenuItem item3 = new MenuItem(menu, SWT.CASCADE);
		item3.setText("设置");
		new MenuItem(menu, SWT.SEPARATOR);
		MenuItem item4 = new MenuItem(menu, SWT.CHECK);
		item4.setText("关于....");
		MenuItem item6 = new MenuItem(menu, SWT.RADIO);
		item6.setText("属性");
		new MenuItem(menu, SWT.SEPARATOR);
		MenuItem menuExit = new MenuItem(menu, SWT.PUSH);
		menuExit.setText("退出");
		menuExit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		trayItem.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				menu.setVisible(true);
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
		new TrayExample();
	}
}
