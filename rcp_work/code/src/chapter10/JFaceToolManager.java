/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

import org.eclipse.jface.action.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
public class JFaceToolManager extends ApplicationWindow {
	private Label label;
	public JFaceToolManager() {
		super(null);
		addToolBar(SWT.FLAT);
	}
	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}
	protected Control createContents(Composite parent) {
		getShell().setText("ToolManagerʵ��");
		getShell().setSize(400, 250);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		Text text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_BOTH));
		label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return composite;
	}
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		toolBarManager.add(new CheckBoxAction());
		toolBarManager.add(new RadioAction());
		toolBarManager.add(new Separator());
		toolBarManager.add(new PushAction());
		toolBarManager.add(new DropDownAction());
		return toolBarManager;
	}
	class CheckBoxAction extends Action {
		public CheckBoxAction() {
			super("CHECKBOX_ACTION", Action.AS_CHECK_BOX);
			setText("CheckBox");
		}
		public void run() {
			label.setText("������Checkbox��ť .");
		}
	}
	class RadioAction extends Action {
		public RadioAction() {
			super("RADIO", Action.AS_RADIO_BUTTON);
			setText("Radio");
		}
		public void run() {
			label.setText("������Radio��ť.");
		}
	}
	class PushAction extends Action {
		public PushAction() {
			super("PUSH", Action.AS_PUSH_BUTTON);
			setText("Push");
		}
		public void run() {
			label.setText("������Push��ť.");
		}
	}
	class DropDownAction extends Action {
		public DropDownAction() {
			super("DropDown", Action.AS_DROP_DOWN_MENU);
             //���ù�������ť�����˵�
			setMenuCreator(new IMenuCreator() {
				public Menu getMenu(Control parent) {
					Menu menu = new Menu(parent);
					MenuItem item1 = new MenuItem(menu, SWT.NONE);
					item1.setText("Item1");
					MenuItem item2 = new MenuItem(menu, SWT.NONE);
					item2.setText("Item2");
					MenuItem item3 = new MenuItem(menu, SWT.NONE);
					item3.setText("Item3");
					return menu;
				}
				public Menu getMenu(Menu parent) {
					return null;
				}
				public void dispose() {
				}
			});
		}
		public void run() {
			label.setText("������DropDown��ť");
		}
	}
	public static void main(String[] args) {
		new JFaceToolManager().run();
	}
}
