/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

import org.eclipse.jface.action.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class JFaceMenuManager extends ApplicationWindow {
	private Action pushAction;

	private Action checkBoxAction;

	private Action radioAction;

	private Label label;

	public JFaceMenuManager() {
		super(null);
		pushAction = new PushAction();
		checkBoxAction = new CheckBoxAction();
		radioAction = new RadioAction();
		addMenuBar();
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		getShell().setSize(400, 250);
		getShell().setText("MenuManager实例");
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, true));
		Text text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_BOTH));
		label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		label.setText("信息提示");
		return composite;
	}

	protected MenuManager createMenuManager() {
		MenuManager menuBar = new MenuManager();
		MenuManager fileMenu = new MenuManager("文件(&F)");
		MenuManager newMenu = new MenuManager("&New");
		fileMenu.add(newMenu);
		// 添加pushAction动作
		newMenu.add(pushAction);
		// 分割线
		fileMenu.add(new Separator());
		// 添加checkBoxAcion动作
		fileMenu.add(checkBoxAction);
		// 添加radioAction动作
		fileMenu.add(radioAction);
		menuBar.add(fileMenu);
		return menuBar;
	}

	class PushAction extends Action {
		public PushAction() {
			super("PUSH@Ctrl+P", Action.AS_PUSH_BUTTON);
			setText("Push");
		}

		public void run() {
			label.setText("Push效果");
		}
	}

	class CheckBoxAction extends Action {
		public CheckBoxAction() {
			super("CHECKBOX_ACTION@Ctrl+C", Action.AS_CHECK_BOX);
			setText("Check");
		}

		public void run() {
			label.setText("复选按钮效果");
		}
	}

	class RadioAction extends Action {
		public RadioAction() {
			super("RADIO@Ctrl+R", Action.AS_RADIO_BUTTON);
			setText("Radio");
		}

		public void run() {
			label.setText("单选按钮效果");
		}
	}

	public static void main(String[] args) {
		new JFaceMenuManager().run();
	}
}
