/**@author WangJinTao,MengQingChang 2006
 */
package other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.graphics.*;

import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class StyledTextExample {
	private StyledText styledText;

	static String text = "SWT/JFace,AWT/Swing,Eclipse, Spring,Struts,Hibernate,Tomcat,Lomboz,Jsp,XML,MyEclipse,MySQL";

	public StyledTextExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(350, 230);
		shell.setText("StyledText实例");
		shell.setLayout(new FillLayout());
		styledText = new StyledText(shell, SWT.WRAP | SWT.READ_ONLY);
		styledText.setText(text);
		// 定义一个style1对象
		StyleRange style1 = new StyleRange();
		// 从第一个字符开始
		style1.start = 0;
		// 将3个字符设置下划线,即SWT/JFace下加了下划线
		style1.length = 9;
		style1.underline = true;
		// 将SWT/JFace设置为红颜色
		style1.foreground = display.getSystemColor(SWT.COLOR_RED);
		styledText.setStyleRange(style1);
		// 为AWT/Swing加“取消”划线
		StyleRange style2 = new StyleRange();
		style2.start = 10;
		style2.length = 9;
		style2.strikeout = true;
		styledText.setStyleRange(style2);
		// 为Eclipse加背景颜色，即"着重强调标记"
		StyleRange style3 = new StyleRange();
		style3.start = 20;
		style3.length = 7;
		style3.background = display.getSystemColor(SWT.COLOR_YELLOW);
		styledText.setStyleRange(style3);
		// 为文本设置颜色渐变
		styledText.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				Rectangle rect = styledText.getClientArea();
				Image image = new Image(display, 1, Math.max(1, rect.height));
				GC gc = new GC(image);
				// 从白色到蓝色渐变
				gc.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
				gc.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
				gc.fillGradientRectangle(rect.x, rect.y, 1, rect.height, true);
				// gc用完释放
				gc.dispose();
				styledText.setBackgroundImage(image);
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new StyledTextExample();
	}
}
