/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

public class ColorDialogExample1 {
	public ColorDialogExample1() {
		final Shell shell = new Shell();
		// ����ColorDialog����
		ColorDialog colordialog = new ColorDialog(shell);
		// ���öԻ������
		colordialog.setText("��ɫѡ��Ի���");
		// ���õ�ǰ��ɫֵ
		colordialog.setRGB(new RGB(0, 0, 255));

		RGB rgb = colordialog.open();
		/**
		 * open()�������û�ѡ��һ����ɫʱ������һ������RGB���͵Ķ���
		 * ���û� ѡ��ȡ������ť����open()��������null
		 */
		if (rgb != null) {
			// ��ӡ�����ǰ��ѡ����ɫֵ
			System.out.println(rgb);

		}
	}

	public static void main(String[] args) {
		new ColorDialogExample1();
	}
}
