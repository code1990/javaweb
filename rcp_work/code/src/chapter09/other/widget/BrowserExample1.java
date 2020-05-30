/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.layout.*;
public class BrowserExample1 {
	private Browser browser;
	// ���췽��
	public BrowserExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("Browserʵ��");
		shell.setLayout(new FillLayout());
		try {
			// ����browser����
			browser = new Browser(shell, SWT.NONE);
		} catch (SWTError e) {
			// �����쳣����
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR
					| SWT.OK);
			messageBox.setMessage("Browserû�б�Ԥ��");
			messageBox.setText("Exit");
			messageBox.open();
			System.exit(-1);
		}
		if (browser != null) {
			// ���õ�ǰ��URL
			browser.setUrl("http://www.google.cn");
		}
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new BrowserExample1();
	}
}
