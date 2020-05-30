/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
public class BrowserExample2 {
	String html;
	public BrowserExample2() {
		// ���õ������
		html = "</html></head>";
		// ���ÿ�ܱ������ռ25%���ұ�ռ75%
		html += "<frameset cols=\"25%,*\">";
		html += "<frame  src=\"E://index.html\">";
		html += "<frame src=\"E://display.html\" name=\"showframe\">";
		html += "</frameset></html>";

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("HTML��SWT�е�Ƕ��ʵ��");
		shell.setSize(450, 300);
		shell.setLayout(new FillLayout());
		// �������������
		Browser browser = new Browser(shell, SWT.NONE);
		browser.setText(html);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	public static void main(String[] args) {
		new BrowserExample2();
	}
}
