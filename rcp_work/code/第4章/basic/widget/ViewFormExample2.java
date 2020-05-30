/**@author WangJinTao,MengQingChang 2006
 */
package basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class ViewFormExample2 {
	public ViewFormExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 190);
		shell.setText("ViewForm实例");
		// 在Shell上使用充满是布局
		shell.setLayout(new FillLayout());
		// 定义ViewForm
		final ViewForm viewForm = new ViewForm(shell, SWT.BORDER);
		// 在ViewForm上使用充满式布局
		viewForm.setLayout(new FillLayout());
		// 在viewForm容器上定义Text
		Text text = new Text(viewForm, SWT.NONE);
		// 在ViewForm上定义Label
		Label labelLeft = new Label(viewForm, SWT.NONE);
		labelLeft.setText("Left");
		Label labelRight = new Label(viewForm, SWT.NONE);
		labelRight.setText("Right");
		Label labelCenter = new Label(viewForm, SWT.NONE);
		labelCenter.setText("Center");
		// 用setContent()方法控制text
		viewForm.setContent(text);
		//控制标签在ViewForm上显示
		viewForm.setTopLeft(labelLeft);
		viewForm.setTopRight(labelRight);
		viewForm.setTopCenter(labelCenter);
		viewForm.setTopCenterSeparate(true);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new ViewFormExample2();
	}
}