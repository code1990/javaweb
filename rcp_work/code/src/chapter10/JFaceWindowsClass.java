/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

import org.eclipse.jface.window.*;
import org.eclipse.swt.widgets.*;

public class JFaceWindowsClass extends ApplicationWindow {
	JFaceWindowsClass() {
		super(null); // ���𴰿�
	}

	public void run() {
		//���ܴ�open()���أ�֪�����ڹرա�
		setBlockOnOpen(true);
		//�򿪴���
		open();
		Display.getCurrent().dispose();
	}

	public Control createContents(Composite parent) {
		// ���ô����С
		parent.getShell().setSize(500, 375);
		// ���ô������
		parent.getShell().setText("JFace ApplicationWidowsʵ��");
		return parent;
	}

	public static void main(String[] args) {
		 
		 new JFaceWindowsClass().run();
		 
	}
}
