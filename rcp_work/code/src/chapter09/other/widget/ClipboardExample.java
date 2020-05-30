/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

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
		shell.setText("Clipboardʵ��");
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
			// ���ø��ƹ��ܣ������ݸ��Ƶ���������
			itemcopy.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// ��ñ�ѡ�е��ı�����
					String textData = text.getSelectionText();
					if (textData.length() == 0)
						return;
					else if (textData.length() > 0) {
						// �����ı�ת�ƶ���
						TextTransfer textTransfer = TextTransfer.getInstance();
						// ��Ҫ���Ƶ��ı����ݷŵ���������
						clipboard.setContents(new Object[] { textData },
								new Transfer[] { textTransfer });
					}
				}
			});
			// �÷ָ����������ơ���ť�롰ճ������ť�ֿ�
			new ToolItem(toolBar, SWT.SEPARATOR);
			ToolItem itempaste = new ToolItem(toolBar, SWT.PUSH);
			itempaste.setToolTipText("ճ��");
			itempaste.setImage(new Image(display, "icons/paste.gif"));
			// ���������ϵ��ı����ݸ��Ƶ��ı�����
			itempaste.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					TextTransfer transfer = TextTransfer.getInstance();
					// ȡ���������ϵ��ı�����
					String data = (String) clipboard.getContents(transfer);
					if (data != null) {
						text.insert(data);
					}
				}
			});
			CoolItem coolitem1 = new CoolItem(coolBar, SWT.DROP_DOWN);
			coolitem1.setControl(toolBar);
			// ����϶�ʱͨ��tooBar������coolItem1��λ�úͳߴ�
			toolBar.pack();
			Point point = new Point(toolBar.getSize().x, toolBar.getSize().y);
			coolitem1.setSize(point);
			coolitem1.setMinimumSize(point);
		}
		{
			ToolBar toolBarcut = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
			ToolItem itemcut = new ToolItem(toolBarcut, SWT.PUSH);
			itemcut.setToolTipText("����");
			//�����ı�����
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
		// �����Ĺ����Ƕ�����϶��ı��ӹ�����λ��ʱ��
		// ��������shell�����������λ��
		coolBar.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				shell.layout();
			}
		});
		{// /��������Ҽ����������˵�
			Menu menu = new Menu(shell, SWT.POP_UP);
			final MenuItem copyItem = new MenuItem(menu, SWT.NONE);
			copyItem.setText("����");
			copyItem.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					String selection = text.getSelectionText();
					if (selection.length() == 0)
						return;
					else if (selection.length() > 0) {
						// �����ı�ת�ƶ���
						TextTransfer textTransfer = TextTransfer.getInstance();
						// ��Ҫ���Ƶ��ı����ݷŵ���������
						clipboard.setContents(new Object[] { selection },
								new Transfer[] { textTransfer });
					}
				}
			});
			final MenuItem pasteItem = new MenuItem(menu, SWT.NONE);
			pasteItem.setText("ճ��");
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
			cutItem.setText("����");
			cutItem.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					text.cut();
				}
			});
			menu.addMenuListener(new MenuAdapter() {
				public void menuShown(MenuEvent e) {
					String selection = text.getSelectionText();
					// ���ÿ����˵����Ƿ����
					copyItem.setEnabled(selection.length() > 0);
					// ���ü��в˵����Ƿ����
					cutItem.setEnabled(selection.length() > 0);
					// ���ø��Ʋ˵����Ƿ����
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
