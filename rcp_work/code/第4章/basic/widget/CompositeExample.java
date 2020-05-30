/**@author WangJinTao,MengQingChang 2006
 */
package basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
public class CompositeExample {
	public CompositeExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(260, 310);
		shell.setText("Compositeʵ��");
		shell.setToolTipText("Shell����");
		final Composite composite = new Composite(shell, SWT.BORDER);
		composite.setBounds(20, 25, 210, 220);
		composite.setToolTipText("Composite����");
		final Group group = new Group(composite, SWT.NONE);
		group.setBounds(20, 20, 160, 160);
		group.setText("�����룺");
		group.setToolTipText("Group����");
		final Label label1 = new Label(group, SWT.NONE);
		label1.setBounds(10, 30, 45, 20);
		label1.setText("�û�����");
		final Text text1 = new Text(group, SWT.BORDER);
		text1.setBounds(65, 25, 80, 25);
		final Label label2 = new Label(group, SWT.NONE);
		label2.setBounds(10, 70, 45, 20);
		label2.setText("��  �룺");
		final Text text2 = new Text(group, SWT.BORDER | SWT.PASSWORD);
		text2.setBounds(65, 65, 80, 25);
		final Button button1 = new Button(group, SWT.NONE);
		button1.setBounds(40, 120, 50, 25);
		button1.setText("ȷ��");
		final Button button2 = new Button(group, SWT.NONE);
		button2.setBounds(95, 120, 50, 25);
		button2.setText("ȡ��");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new CompositeExample();
	}
}
