/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

import org.eclipse.jface.action.*;
public class StatusActionClass extends Action {
	StatusLineManager statmanger;
	// ���崥����������
	int Count = 0;
	public StatusActionClass(StatusLineManager status) {
		super("��������@Ctrl+T", AS_PUSH_BUTTON);
		statmanger = status;
		// ������ʾ��ǩ
		setToolTipText("��������");
	}
	public void run() {
		int triggercount = Count++;
		statmanger.setMessage("��ǰ��ť�������Ĵ���Ϊ:" + triggercount);
		}
}

