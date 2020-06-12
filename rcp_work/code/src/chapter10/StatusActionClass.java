/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

import org.eclipse.jface.action.*;
public class StatusActionClass extends Action {
	StatusLineManager statmanger;
	// 定义触发次数变量
		int Count = 0;
		public StatusActionClass(StatusLineManager status) {
			super("单击触发@Ctrl+T", AS_PUSH_BUTTON);
			statmanger = status;
			// 设置提示标签
			setToolTipText("单击触发");
		}
		public void run() {
			int triggercount = Count++;
			statmanger.setMessage("当前按钮被触发的次数为:" + triggercount);
			}
}

