/**@author WangJinTao,MengQingChang 2006
 */
package complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
public class CanvasExample {
	static Image image;
	public CanvasExample() {
		final Display display = Display.getDefault();
		// /定义一个Shell对话框
		final Shell shell = new Shell(SWT.DIALOG_TRIM | SWT.ON_TOP);
		shell.setSize(300, 360);
		shell.setText("Canvas实例");
		shell.setLayout(new GridLayout(4, false));
		final Canvas canvas = new Canvas(shell, SWT.BORDER);
		GridData gridA = new GridData();
		gridA.horizontalIndent = 15;
		gridA.widthHint = 250;
		gridA.heightHint = 120;
		gridA.horizontalSpan = 4;
		gridA.verticalIndent = 15;
		canvas.setLayoutData(gridA);
		// 监听canvas重绘事件
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(final PaintEvent event) {
				if (image != null)
					// 将其图像显示在canvas上，图像显示在canvas上的坐标为(0,0)
					event.gc.drawImage(image, 0, 0);
				image = null;
			}
		});
		final List list = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		list.setItems(new String[] { "黄颜色", "蓝颜色", "红颜色", "绿颜色", "黑颜色",
                              "青颜色","秋天即景", "木卫四", "日食" });
		GridData gridB = new GridData();
		gridB.horizontalIndent = 15;
		gridB.widthHint = 100;
		gridB.horizontalSpan = 4;
		gridB.verticalIndent = 10;
		list.setLayoutData(gridB);
		Button buttonB = new Button(shell, SWT.NONE);
		buttonB.setText("浏览");
		GridData gridD = new GridData();
		gridD.horizontalIndent = 90;
		gridD.widthHint = 80;
		gridD.horizontalSpan = 3;
		gridD.verticalIndent = 10;
		buttonB.setLayoutData(gridD);
		buttonB.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = list.getSelectionIndex();
				if (selectionIndex == 0) {
					canvas.setBackground(display
							.getSystemColor(SWT.COLOR_YELLOW));
				} else if (selectionIndex == 1) {
				canvas.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
				} else if (selectionIndex == 2) {
				canvas.setBackground(display.getSystemColor(SWT.COLOR_RED));
				} else if (selectionIndex == 3) {
				canvas.setBackground(display	.getSystemColor(SWT.COLOR_GREEN));
				} else if (selectionIndex == 4) {
				canvas.setBackground(display	.getSystemColor(SWT.COLOR_BLACK));
				} else if (selectionIndex == 5) {
				canvas.setBackground(display	.getSystemColor(SWT.COLOR_CYAN));
				} else if (selectionIndex == 6) {
				image = new Image(display, "icons/scene.jpg");
				canvas.redraw();
				} else if (selectionIndex == 7) {
				image = new Image(display, "icons/eclipse.bmp");
				canvas.redraw();
				} else if (selectionIndex == 8) {
				image = new Image(display, "icons/eclipse2.bmp");
				canvas.redraw();
				}
			}
		});
		Button buttonC = new Button(shell, SWT.NONE);
		buttonC.setText("退出");
		GridData gridE = new GridData();
		gridE.horizontalIndent = 15;
		gridE.widthHint = 80;
		gridE.verticalIndent = 10;
		buttonC.setLayoutData(gridE);
		buttonC.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
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
		new CanvasExample();
	}
}
