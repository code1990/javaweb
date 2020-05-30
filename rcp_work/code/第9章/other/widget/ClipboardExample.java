/**@author WangJinTao,MengQingChang 2006
 */
package other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.dnd.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
public class ClipboardExample {
	private Text text;
	public ClipboardExample() {
		final Display display = new Display();
		final Clipboard clipboard = new Clipboard(display);
		final Shell shell = new Shell(display);
		shell.setSize(500, 375);
		shell.setText("Clipboard实例");
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
			// 设置复制功能，将数据复制到剪贴板上
			itemcopy.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// 获得被选中的文本数据
					String textData = text.getSelectionText();
					if (textData.length() == 0)
						return;
					else if (textData.length() > 0) {
						// 定义文本转移对象
						TextTransfer textTransfer = TextTransfer.getInstance();
						// 将要复制的文本数据放到剪贴板上
						clipboard.setContents(new Object[] { textData },
								new Transfer[] { textTransfer });
					}
				}
			});
			// 用分隔符将“复制”按钮与“粘贴”按钮分开
			new ToolItem(toolBar, SWT.SEPARATOR);
			ToolItem itempaste = new ToolItem(toolBar, SWT.PUSH);
			itempaste.setToolTipText("粘贴");
			itempaste.setImage(new Image(display, "icons/paste.gif"));
			// 将剪贴板上的文本数据复制到文本框中
			itempaste.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					TextTransfer transfer = TextTransfer.getInstance();
					// 取出剪贴板上的文本数据
					String data = (String) clipboard.getContents(transfer);
					if (data != null) {
						text.insert(data);
					}
				}
			});
			CoolItem coolitem1 = new CoolItem(coolBar, SWT.DROP_DOWN);
			coolitem1.setControl(toolBar);
			// 鼠标拖动时通过tooBar来调整coolItem1的位置和尺寸
			toolBar.pack();
			Point point = new Point(toolBar.getSize().x, toolBar.getSize().y);
			coolitem1.setSize(point);
			coolitem1.setMinimumSize(point);
		}
		{
			ToolBar toolBarcut = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
			ToolItem itemcut = new ToolItem(toolBarcut, SWT.PUSH);
			itemcut.setToolTipText("剪切");
			//剪切文本内容
			itemcut.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					text.cut();
				}
			});
			itemcut.setImage(new Image(display, "icons/cut.gif"));
			CoolItem coolitem2 = new CoolItem(coolBar, SWT.DROP_DOWN);
			coolitem2.setControl(toolBarcut);
			toolBarcut.pack();
			Point pointone = new Point(toolBarcut.getSize().x, toolBarcut
					.getSize().y);
			coolitem2.setSize(pointone);
			coolitem2.setMinimumSize(pointone);
		}
		text = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL
				| SWT.H_SCROLL);
		FormData textData = new FormData();
		textData.left = new FormAttachment(0);
		textData.right = new FormAttachment(100);
		textData.top = new FormAttachment(coolBar);
		textData.bottom = new FormAttachment(100);
		text.setLayoutData(textData);
		// 监听的功能是动鼠标拖动改变子工具栏位置时，
		// 重新设置shell容器上组件的位置
		coolBar.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				shell.layout();
			}
		});
		{// /设置鼠标右键弹出下拉菜单
			Menu menu = new Menu(shell, SWT.POP_UP);
			final MenuItem copyItem = new MenuItem(menu, SWT.NONE);
			copyItem.setText("复制");
			copyItem.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					String selection = text.getSelectionText();
					if (selection.length() == 0)
						return;
					else if (selection.length() > 0) {
						// 定义文本转移对象
						TextTransfer textTransfer = TextTransfer.getInstance();
						// 将要复制的文本数据放到剪贴板上
						clipboard.setContents(new Object[] { selection },
								new Transfer[] { textTransfer });
					}
				}
			});
			final MenuItem pasteItem = new MenuItem(menu, SWT.NONE);
			pasteItem.setText("粘贴");
			pasteItem.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					String string = (String) (clipboard
							.getContents(TextTransfer.getInstance()));
					if (string != null)
						text.insert(string);
				}
			});
			new MenuItem(menu, SWT.SEPARATOR);
			final MenuItem cutItem = new MenuItem(menu, SWT.NONE);
			cutItem.setText("剪切");
			cutItem.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					text.cut();
				}
			});
			menu.addMenuListener(new MenuAdapter() {
				public void menuShown(MenuEvent e) {
					String selection = text.getSelectionText();
					// 设置拷贝菜单项是否可用
					copyItem.setEnabled(selection.length() > 0);
					// 设置剪切菜单项是否可用
					cutItem.setEnabled(selection.length() > 0);
					// 设置复制菜单项是否可用
					TransferData[] available = clipboard.getAvailableTypes();
					boolean enabled = false;
					for (int i = 0; i < available.length; i++) {
						if (TextTransfer.getInstance().isSupportedType(
								available[i])) {
							enabled = true;
							break;
						}
					}
					pasteItem.setEnabled(enabled);
				}
			});
			text.setMenu(menu);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new ClipboardExample();
	}
}
