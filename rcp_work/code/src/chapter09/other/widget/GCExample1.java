/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
public class GCExample1 {
	public GCExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(350, 230);
		shell.setText("GCʵ��");
		shell.setLayout(new FillLayout());
		// ����һ����������
		Canvas canvas = new Canvas(shell, SWT.BORDER);
		shell.open();
		// ����һ��GC����
		GC gc = new GC(canvas);
		// ����ǰ����ɫΪ��ɫ
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
		// ��һ����
		gc.drawLine(180, 10, 220, 150);
		// ������Բ���˴�Width=HightΪԲ��
		gc.drawOval(95, 20, 80, 80);
		// ����Բ�α�����ɫΪ��ɫ
		gc.setBackground(display.getSystemColor(SWT.COLOR_RED));
		// gc.drawOval(95, 20, 80, 80);
		// ���Բ��
		gc.fillOval(92, 19, 85, 85);
		// ��һ����
		gc.drawPoint(300, 10);
		// ��һ������
		gc.drawRectangle(70, 60, 130, 100);
		// ��һ������Σ��˴�Ϊ������
		gc.drawPolygon(new int[] { 250, 30, 220, 100, 300, 150 });
		// ��һ����߲��������
		gc.drawPolyline(new int[] { 10, 80, 70, 10, 90, 80, 60, 125, 160,150 });
		gc.dispose();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new GCExample1();
	}
}
