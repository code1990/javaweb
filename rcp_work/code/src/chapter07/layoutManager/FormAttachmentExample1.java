/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter07.layoutManager;

import org.eclipse.swt.*;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class FormAttachmentExample1 {
	public FormAttachmentExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 240);
		shell.setText("FormAttachmentʵ��");
		shell.setLayout(new FormLayout());
		Text text = new Text(shell, SWT.BORDER);
		FormData data = new FormData();
		data.top = new FormAttachment(25, 50, 0);
		// ʹ�ı�����ϱ߿������Ķ��˸߶�ռ���������߶�֮��Ϊ50%��
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
