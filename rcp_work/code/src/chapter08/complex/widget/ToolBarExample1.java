/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
public class ToolBarExample1 {
	public ToolBarExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("ToolBarʵ��");
		shell.setLayout(new FillLayout());
		// ����һ�����������󣬹������ϵİ�ť�ϵ����ֿɻ���
		ToolBar toolBar = new ToolBar(shell, SWT.WRAP);
		// ���ù������Ĺ�����������ϰ�ťΪ��ͨ��ť
		ToolItem toolItem1 = new ToolItem(toolBar, SWT.PUSH);
		toolItem1.setText("ǰ��");
		// �ڰ�ť�����ͼƬ
		toolItem1.setImage(new Image(display, "icons/forward.gif"));
		// �������ϰ�ťΪ��ѡ��ť�����������ݣ��ٴε�����ŵ���
		ToolItem toolItem2 = new ToolItem(toolBar, SWT.CHECK);
		toolItem2.setText("����");
		toolItem2.setImage(new Image(display, "icons/backward.gif"));
		// �������ϰ�ťΪ��ѡ��ť������������̵�������
		ToolItem toolItem3 = new ToolItem(toolBar, SWT.RADIO);
		toolItem3.setText("���");
		toolItem3.setImage(new Image(display, "icons/remove.gif"));
		toolBar.pack();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new ToolBarExample1();
	}
}
