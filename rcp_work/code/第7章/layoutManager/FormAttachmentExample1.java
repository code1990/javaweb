/**
 *@author: WangJinTao,MengQingChang2006
 */
package layoutManager;

import org.eclipse.swt.*;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class FormAttachmentExample1 {
	public FormAttachmentExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 240);
		shell.setText("FormAttachment实例");
		shell.setLayout(new FormLayout());
		Text text = new Text(shell, SWT.BORDER);
		FormData data = new FormData();
		data.top = new FormAttachment(25, 50, 0);
		// 使文本框的上边框到容器的顶端高度占整个容器高度之比为50%，
		text.setLayoutData(data);
		shell.open();
		shell.layout();

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {

		new FormAttachmentExample1();
	}
}
