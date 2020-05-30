/**@author WangJinTao,MengQingChang 2006
 */
package chapter04.basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class ViewFormExample1 {
	public ViewFormExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 190);
		shell.setText("ViewFormʵ��");
		// ��Shell��ʹ�ó����ǲ���
		shell.setLayout(new FillLayout());
		// ����ViewForm
		final ViewForm viewForm = new ViewForm(shell, SWT.BORDER);
		// ��ViewForm��ʹ�ó���ʽ����
		viewForm.setLayout(new FillLayout());
		// ��viewForm�����϶���Text
		Text text = new Text(viewForm, SWT.NONE);
		// ��ViewForm�϶���Label
		Label labelLeft = new Label(viewForm, SWT.NONE);
		labelLeft.setText("Left");
		Label labelRight = new Label(viewForm, SWT.NONE);
		labelRight.setText("Right");
		// ��setContent()��������text
		viewForm.setContent(text);
		viewForm.setTopLeft(labelLeft);
		viewForm.setTopRight(labelRight);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new ViewFormExample1();
	}
}
