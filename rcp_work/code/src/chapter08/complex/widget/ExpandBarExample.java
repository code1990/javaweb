/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
public class ExpandBarExample {
	
	public ExpandBarExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 270);
		shell.setText("ExpandBarʵ��");
		shell.setLayout(new FillLayout());
		// ������չ������
		ExpandBar expandbar = new ExpandBar(shell, SWT.V_SCROLL);
		// �����һ����չ����
		{
			Composite comp1 = new Composite(expandbar, SWT.NONE);
			comp1.setLayout(new GridLayout());
			new Slider(comp1, SWT.SMOOTH);
			new Scale(comp1, SWT.HORIZONTAL);
			new ProgressBar(comp1, SWT.INDETERMINATE);
			// ������չ��Ķ���
			ExpandItem item1 = new ExpandItem(expandbar, SWT.NONE);
			item1.setText("ExpandItem  Item1");
			item1.setHeight(100);// ����Item�ĸ߶�
			item1.setControl(comp1);// setControl��������comp1������
		}
		// ����ڶ�����չ����
		{
			Composite comp2 = new Composite(expandbar, SWT.NONE);
			comp2.setLayout(new GridLayout());
			// ������ʾ�Ա����
			final Label label1 = new Label(comp2, SWT.NONE);
			label1.setImage(display.getSystemImage(SWT.ICON_ERROR));
			final Label label2 = new Label(comp2, SWT.NONE);
			label2.setImage(display.getSystemImage(SWT.ICON_INFORMATION));
			final Label label3 = new Label(comp2, SWT.NONE);
			label3.setImage(display.getSystemImage(SWT.ICON_WARNING));
			final Label label4 = new Label(comp2, SWT.NONE);
			label4.setImage(display.getSystemImage(SWT.ICON_QUESTION));
			ExpandItem  item2 = new ExpandItem(expandbar, SWT.NONE);
			item2.setText("ExpandItem  Item2");
			item2.setHeight(160);
			item2.setControl(comp2);
		}
		// �����������չ����
		{
			Composite comp3 = new Composite(expandbar, SWT.NONE);
			comp3.setLayout(new GridLayout());
			new Button(comp3, SWT.CHECK).setText("CHECK");
			new Button(comp3, SWT.RADIO).setText("RADIO");
			ExpandItem item3 = new ExpandItem(expandbar, SWT.NONE);
			item3.setText("ExpandItem  Item3");
			item3.setHeight(80);
			item3.setControl(comp3);
			 
		     
		}
    
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new ExpandBarExample();
	}
}
