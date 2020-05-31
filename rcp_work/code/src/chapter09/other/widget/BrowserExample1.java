/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.layout.*;
public class BrowserExample1 {
	private Browser browser;
	// 构造方法
		public BrowserExample1() {
			final Display display = Display.getDefault();
			final Shell shell = new Shell();
			shell.setSize(500, 375);
			shell.setText("Browser实例");
			shell.setLayout(new FillLayout());
			try {
				// 定义browser对象
				browser = new Browser(shell, SWT.NONE);
			} catch (SWTError e) {
				// 错误异常处理
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR
						| SWT.OK);
				messageBox.setMessage("Browser没有被预置");
				messageBox.setText("Exit");
				messageBox.open();
				System.exit(-1);
			}
			if (browser != null) {
				// 设置当前的URL
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
