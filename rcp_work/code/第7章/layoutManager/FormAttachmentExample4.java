/**
*@author: WangJinTao,MengQingChang2006
*/
package layoutManager;

import org.eclipse.swt.*;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class FormAttachmentExample4 {
	public FormAttachmentExample4() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 240);
		shell.setText("FormAttachmentÊµÀý");
		shell.setLayout(new FormLayout());
		FormData formdata1 = new FormData();
		FormAttachment formattachment = new FormAttachment(20);
		formdata1.top = formattachment;
		formdata1.left = formattachment;
		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setLayoutData(formdata1);
		FormData data1 = new FormData();
		FormAttachment formattachment1 = new FormAttachment(composite);
		data1.left = formattachment1;
		data1.top = formattachment1;
		Button button = new Button(shell, SWT.NONE);
		button.setText("Button");
		button.setLayoutData(data1);
		shell.open();
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {

		new FormAttachmentExample4();
	}
}
