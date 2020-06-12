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
		shell.setText("GC实例");
		shell.setLayout(new FillLayout());
		// 定义一个画布对象
		Canvas canvas = new Canvas(shell, SWT.BORDER);
		shell.open();
		// 定义一个GC对象
		GC gc = new GC(canvas);
		// 设置前景颜色为蓝色
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
		// 画一条线
		gc.drawLine(180, 10, 220, 150);
		// 画个椭圆，此处Width=Hight为圆形
		gc.drawOval(95, 20, 80, 80);
		// 设置圆形背景颜色为红色
		gc.setBackground(display.getSystemColor(SWT.COLOR_RED));
		// gc.drawOval(95, 20, 80, 80);
		// 填充圆形
		gc.fillOval(92, 19, 85, 85);
		// 画一个点
		gc.drawPoint(300, 10);
		// 画一个矩形
		gc.drawRectangle(70, 60, 130, 100);
		// 画一个多边形，此处为三角形
		gc.drawPolygon(new int[] { 250, 30, 220, 100, 300, 150 });
		// 画一个多边不规则的线
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
