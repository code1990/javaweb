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
		shell.setText("Linkʵ��");
		shell.setLayout(new GridLayout());
		Link link = new Link(shell, SWT.NONE);
		link.setText("���� <a>link</a> ʵ��, <a>SWT and JFace</a>,<a>Eclipse Platform</a> ");
		// ����link�ı�
		link.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("��ѡ����: " + event.text);
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
