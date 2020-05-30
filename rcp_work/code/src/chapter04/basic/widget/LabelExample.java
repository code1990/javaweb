/**@author WangJinTao,MengQingChang 2006
 */
package chapter04.basic.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class LabelExample {
	public LabelExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		/**
		 * ���ô����С,��ʽΪ��shell.setSize(int x,int y) "x"ΪX������,"y"ΪY�����ꡣ
		 */
		shell.setSize(500, 375);
		// ���ô��ڱ������֡�
		shell.setText("Labelʵ������");
		// �����ǩ����label1��
		final Label label1 = new Label(shell, SWT.NONE);
		/**
		 * ����label�����λ�úʹ�С 
		 * ���ʽΪ��setBounds��int x ��int y ��int width ��int height��
		 * "x"ΪX������,"y"ΪY�����ꡣ"wighth"����Ŀ�ȣ� "height"����ĸ߶ȡ�
		 */
		label1.setBounds(20, 15, 30, 15);
		// setText��String string)������������ı�ǩ���֡�
		label1.setText("Label");
	  
		final Label label2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label2.setBounds(0, 45, 500, 8);
		final Label label3 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label3.setBounds(65, 0, 9, 350);
		final Label label4 = new Label(shell, SWT.NONE);
		label4.setBounds(80, 70, 40, 40);
		// setBackground(Color color)�����������ñ�����ɫ
		label4.setBackground(display.getSystemColor(SWT.COLOR_BLUE));

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new LabelExample();
	}
}
