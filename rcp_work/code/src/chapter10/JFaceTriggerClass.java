/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

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
		// ���״̬��
		addStatusLine();
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		// ���ô������
		getShell().setText("Actionʵ��");
		// ���ô����С
		parent.setSize(350, 240);
		// �ڴ��彨����ť
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
