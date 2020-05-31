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
		// 设置导航框架
		html = "</html></head>";
		// 设置框架比例左边占25%，右边占75%
		html += "<frameset cols=\"25%,*\">";
		html += "<frame  src=\"E://index.html\">";
		html += "<frame src=\"E://display.html\" name=\"showframe\">";
		html += "</frameset></html>";

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("HTML在SWT中的嵌入实例");
		shell.setSize(450, 300);
		shell.setLayout(new FillLayout());
		// 定义浏览器对象
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
