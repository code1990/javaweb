/**@author WangJinTao,MengQingChang 2006
 */
package jfaceWindows;

import org.eclipse.swt.widgets.*;
import org.eclipse.jface.window.*;
import org.eclipse.jface.action.*;

public class JFaceTriggerClass extends ApplicationWindow {
	StatusLineManager statusLineManager = new StatusLineManager();

	StatusActionClass statusAction = new StatusActionClass(statusLineManager);

	ActionContributionItem actionContributonItem = new ActionContributionItem(
			statusAction);

	public JFaceTriggerClass() {
		super(null);
		// 添加状态线
		addStatusLine();
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		// 设置窗体标题
		getShell().setText("Action实例");
		// 设置窗体大小
		parent.setSize(350, 240);
		// 在窗体建立按钮
		actionContributonItem.fill(parent);
		return parent;
	}

	protected StatusLineManager createStatusLineManager() {
		return statusLineManager;
	}

	public static void main(String[] args) {
		new JFaceTriggerClass().run();

	}
}
