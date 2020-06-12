
package chapter04.basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class GroupExample {
	public GroupExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(240, 300);
		shell.setText("Groupʵ��");
		shell.setToolTipText("Shell����");
		final Group group1 = new Group(shell, SWT.NONE);
		group1.setBounds(40, 25, 160, 60);
		group1.setText("��ѡ��");
		group1.setToolTipText("Group����");
		Button button1 = new Button(group1, SWT.RADIO);
		button1.setBounds(20, 10, 100, 25);
		button1.setText("Groupʵ��");
		Button button2 = new Button(group1, SWT.RADIO);
		button2.setBounds(20, 35, 100, 25);
		button2.setText("Buttonʵ��");
		final Group group2 = new Group(shell, SWT.NONE);
		group2.setBounds(40, 110, 160, 90);
		group2.setToolTipText("Group����");
		Button button3 = new Button(group2, SWT.CHECK);
		button3.setBounds(20, 10, 100, 25);
		button3.setText("Labelʵ��");
		Button button4 = new Button(group2, SWT.CHECK);
		button4.setBounds(20, 35, 100, 25);
		button4.setText("Comboʵ��");
		Button button5 = new Button(group2, SWT.CHECK);
		button5.setBounds(20, 60, 100, 25);
		button5.setText("Listʵ��");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new GroupExample();
	}
}