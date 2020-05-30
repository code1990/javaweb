/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter07.layoutManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FillLayoutExample3 {

	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 200);
		shell.setText("��ֱ��������ʵ��");
		FillLayout fillLayout = new FillLayout();
		fillLayout.type = SWT.VERTICAL;
		shell.setLayout(fillLayout);

		new Text(shell, SWT.BORDER);
		new Text(shell, SWT.BORDER);
		new Text(shell, SWT.BORDER);
		new Text(shell, SWT.BORDER);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
