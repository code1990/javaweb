/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

import org.eclipse.jface.window.*;
import org.eclipse.swt.widgets.*;

public class JFaceWindowsClass extends ApplicationWindow {
	JFaceWindowsClass() {
		super(null); // 部署窗口
	}

	public void run() {
		//不能从open()返回，知道窗口关闭。
		setBlockOnOpen(true);
		//打开窗口
		open();
		Display.getCurrent().dispose();
	}

	public Control createContents(Composite parent) {
		// 设置窗体大小
		parent.getShell().setSize(500, 375);
		// 设置窗体标题
		parent.getShell().setText("JFace ApplicationWidows实例");
		return parent;
	}

	public static void main(String[] args) {
		 
		 new JFaceWindowsClass().run();
		 
	}
}
