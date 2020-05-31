/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class LinkExample {
	public LinkExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 150);
		shell.setText("Link实例");
		shell.setLayout(new GridLayout());
		Link link = new Link(shell, SWT.NONE);
		link.setText("这是 <a>link</a> 实例, <a>SWT and JFace</a>,<a>Eclipse Platform</a> ");
		// 监听link文本
		link.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("您选择了: " + event.text);
			}
		});
		GridData grid = new GridData();
		grid.verticalIndent = 20;
        link.setLayoutData(grid);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new LinkExample();
	}
}
