/**@author WangJinTao,MengQingChang 2006
 */
package basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.*;

public class ScrolledCompositeExample {
	public ScrolledCompositeExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(360, 180);
		shell.setText("ScrolledComposite实例");
		final ScrolledComposite scrolledcomposite = new ScrolledComposite(
				shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledcomposite.setBounds(30, 20, 300, 100);
		// 将按钮对象添加到滑动面板上
		Button button1 = new Button(scrolledcomposite, SWT.PUSH);

		button1.setText("ScrolledComposite实例");
		 
		  button1.setSize(370,100);
		  
		 scrolledcomposite.setMinWidth(10);
		/**
		 * 虽然将按钮对象加到了滑动面板上， 
		 * 但还要通过setContent()方法设置添加的有效性
		 */
		scrolledcomposite.setContent(button1);
         
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new ScrolledCompositeExample();
	}
}
