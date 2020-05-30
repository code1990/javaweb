/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
public class ImageExample {
	public ImageExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 180);
		shell.setText("Imageʵ��");
		Image image = new Image(display, "icons/eclipse0.gif");
		// ���ô������ͼ��
		shell.setImage(image);
		Button buttona = new Button(shell, SWT.NONE);
		buttona.setBounds(10, 20, 80, 30);
		Image i = new Image(display, "icons/remove.gif");
		buttona.setImage(i);
		Button buttonb = new Button(shell, SWT.NONE);
		buttonb.setBounds(100, 20, 80, 30);
		final Image img = new Image(display, 40, 24);
		Color color = display.getSystemColor(SWT.COLOR_BLUE);
		GC gc = new GC(img);
		gc.setBackground(color);
		gc.fillRectangle(img.getBounds());
		gc.dispose();
		color.dispose();
		buttonb.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(img, 20, 3);
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		image.dispose();
		i.dispose();
		img.dispose();
		display.dispose();
	}
	public static void main(String[] args) {
		new ImageExample();
	}
}
