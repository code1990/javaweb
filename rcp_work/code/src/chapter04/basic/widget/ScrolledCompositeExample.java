/**@author WangJinTao,MengQingChang 2006
 */
package chapter04.basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.*;

public class ScrolledCompositeExample {
	public ScrolledCompositeExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(360, 180);
		shell.setText("ScrolledCompositeʵ��");
		final ScrolledComposite scrolledcomposite = new ScrolledComposite(
				shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledcomposite.setBounds(30, 20, 300, 100);
		// ����ť������ӵ����������
		Button button1 = new Button(scrolledcomposite, SWT.PUSH);

		button1.setText("ScrolledCompositeʵ��");
		 
		  button1.setSize(370,100);
		  
		 scrolledcomposite.setMinWidth(10);
		/**
		 * ��Ȼ����ť����ӵ��˻�������ϣ� 
		 * ����Ҫͨ��setContent()����������ӵ���Ч��
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
