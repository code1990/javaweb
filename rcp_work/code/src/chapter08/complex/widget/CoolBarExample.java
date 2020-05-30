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
		shell.setText("CoolBarʵ��");
		// shell��������Formlayout��ʽ����
		shell.setLayout(new FormLayout());
		// ����һ��CoolBar��shell��
		CoolBar coolBar = new CoolBar(shell, SWT.NONE);
		// ��CoolBar���ֵ������Ķ���
		FormData coolData = new FormData();
		coolData.left = new FormAttachment(0);
		coolData.right = new FormAttachment(100);
		coolData.top = new FormAttachment(0);
		coolBar.setLayoutData(coolData);
		{
			final ToolBar toolBar = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
			ToolItem itemcopy = new ToolItem(toolBar, SWT.PUSH);
			itemcopy.setToolTipText("����");// ������ʾ�Եı�ǩ����
			// �ڹ������İ�ť�����ͼƬ
			itemcopy.setImage(new Image(display, "icons/copy.gif"));
			// �÷ָ����������ơ���ť�롰ճ������ť�ֿ�
			new ToolItem(toolBar, SWT.SEPARATOR);
			ToolItem itempaste = new ToolItem(toolBar, SWT.PUSH);
			itempaste.setToolTipText("ճ��");
			itempaste.setImage(new Image(display, "icons/paste.gif"));
			CoolItem coolitem1 = new CoolItem(coolBar, SWT.DROP_DOWN);
			coolitem1.setControl(toolBar);
			// ����϶�ʱͨ��tooBar������coolItem1��λ�úͳߴ�
			toolBar.pack();
			Point point = new Point(toolBar.getSize().x, toolBar.getSize().y);
			coolitem1.setSize(point);
			coolitem1.setMinimumSize(point);
		}
		{
			ToolBar toolBarsave = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
			ToolItem itemsave = new ToolItem(toolBarsave, SWT.PUSH);
			itemsave.setToolTipText("����");
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
			itemopen.setToolTipText("��");
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
		 * �����Ĺ���������϶��ı��ӹ�����λ��ʱ�� ��������shell�����������λ��
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
