/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class SliderExample {
	private Text text;

	private Slider slider;

	private int max;

	private int i;

	public SliderExample() {
		final Display display = new Display();
		Shell shell = new Shell(new Shell());
		shell.setSize(320, 150);
		slider = new Slider(shell, SWT.SMOOTH);
		slider.setBounds(50, 10, 200, 20);
		shell.setText("Slider实例");
		// 设置最大值
		slider.setMaximum(80);
        slider.setPageIncrement(50);
        
		// 获得slider的最大值
		max = slider.getMaximum();
		// 创建一个线程
		 new Thread() {
			public void run() {
				for (i = 0; i <= max; i++) {
					try {
						Thread.sleep(150);
					} catch (Throwable e) {
					}
					display.asyncExec(new Runnable() {
						public void run() {
							slider.setSelection(i);
							int Value = slider.getMaximum()
									- slider.getSelection() - slider.getThumb();
							// 在文本上显示当前值
							text.setText("当前值为:" + Value);
							 
						}
					});
				}
			}
		}.start();// 启动线程 
		text = new Text(shell, SWT.BORDER);
		text.setBounds(100, 60, 100, 25);
		text.setEditable(false);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public static void main(String[] args) {
		new SliderExample();
	}
}
