/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class CoolBarExample {
	public CoolBarExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("CoolBar实例");
		// shell容器采用Formlayout方式布局
		shell.setLayout(new FormLayout());
		// 定义一个CoolBar在shell上
		CoolBar coolBar = new CoolBar(shell, SWT.NONE);
		// 将CoolBar布局到容器的顶端
		FormData coolData = new FormData();
		coolData.left = new FormAttachment(0);
		coolData.right = new FormAttachment(100);
		coolData.top = new FormAttachment(0);
		coolBar.setLayoutData(coolData);
		{
			final ToolBar toolBar = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
			ToolItem itemcopy = new ToolItem(toolBar, SWT.PUSH);
			itemcopy.setToolTipText("复制");// 设置提示性的标签文字
			// 在工具栏的按钮上添加图片
			itemcopy.setImage(new Image(display, "icons/copy.gif"));
			// 用分隔符将“复制”按钮与“粘贴”按钮分开
			new ToolItem(toolBar, SWT.SEPARATOR);
			ToolItem itempaste = new ToolItem(toolBar, SWT.PUSH);
			itempaste.setToolTipText("粘贴");
			itempaste.setImage(new Image(display, "icons/paste.gif"));
			CoolItem coolitem1 = new CoolItem(coolBar, SWT.DROP_DOWN);
			coolitem1.setControl(toolBar);
			// 鼠标拖动时通过tooBar来调整coolItem1的位置和尺寸
			toolBar.pack();
			Point point = new Point(toolBar.getSize().x, toolBar.getSize().y);
			coolitem1.setSize(point);
			coolitem1.setMinimumSize(point);
		}
		{
			ToolBar toolBarsave = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
			ToolItem itemsave = new ToolItem(toolBarsave, SWT.PUSH);
			itemsave.setToolTipText("保存");
			itemsave.setImage(new Image(display, "icons/save.gif"));
			CoolItem coolitem2 = new CoolItem(coolBar, SWT.DROP_DOWN);
			coolitem2.setControl(toolBarsave);
			toolBarsave.pack();
			Point pointone = new Point(toolBarsave.getSize().x, toolBarsave
					.getSize().y);
			coolitem2.setSize(pointone);
			coolitem2.setMinimumSize(pointone);
		}
		{
			final ToolBar toolBaropen = new ToolBar(coolBar, SWT.FLAT
					| SWT.WRAP);
			ToolItem itemopen = new ToolItem(toolBaropen, SWT.PUSH);
			itemopen.setToolTipText("打开");
			itemopen.setImage(new Image(display, "icons/open.gif"));
			CoolItem coolitem3 = new CoolItem(coolBar, SWT.DROP_DOWN);
			coolitem3.setControl(toolBaropen);
			toolBaropen.pack();
			Point pointopen = new Point(toolBaropen.getSize().x, toolBaropen
					.getSize().y);
			coolitem3.setSize(pointopen);
			coolitem3.setMinimumSize(pointopen);
		}
		Text text = new Text(shell, SWT.BORDER);
		FormData textData = new FormData();
		textData.left = new FormAttachment(0);
		textData.right = new FormAttachment(100);
		textData.top = new FormAttachment(coolBar);
		textData.bottom = new FormAttachment(100);
		text.setLayoutData(textData);
		/**
		 * 监听的功能是鼠标拖动改变子工具栏位置时， 重新设置shell容器上组件的位置
		 */
		coolBar.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				shell.layout();
			}
		});
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new CoolBarExample();
	}
}
