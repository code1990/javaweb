/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class MenuExample1 {
	public MenuExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("�˵�ʵ��");
		// ���˵�����SWT.BAR�������˵���
		Menu menu = new Menu(shell, SWT.BAR);
		// ��ӵ�shell������
		shell.setMenuBar(menu);
		/**
		 * �������˵���"�û���Ϣ����"�˵��� 
		 * SWT.CASCADE Ӧ������������ʽ���ֵĲ˵���
		 */
		MenuItem item1 = new MenuItem(menu, SWT.CASCADE);
		item1.setText("�û���Ϣ����");
		// �������˵���""ѧ����Ϣ����"�˵���
		MenuItem item2 = new MenuItem(menu, SWT.CASCADE);
		item2.setText("ѧ����Ϣ����");
		// �������˵���һ�������˵�
		Menu newFile = new Menu(shell, SWT.DROP_DOWN);
		item1.setMenu(newFile);
		MenuItem itemA = new MenuItem(newFile, SWT.CASCADE);
		itemA.setText("�û���Ϣ");
		MenuItem itemB = new MenuItem(newFile, SWT.CASCADE);
		itemB.setText("�˳�");
		// ���˳��˵�������¼�����
		itemB.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		Menu File = new Menu(shell, SWT.DROP_DOWN);
		itemA.setMenu(File);
		// ��ѡ���ͣ�ѡ�к�ǰ������һ��С����
		MenuItem itema = new MenuItem(File, SWT.CHECK);
		itema.setText("�û���Ϣע��");
		itema.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				MessageDialog
						.openInformation(shell, " ��Ϣ��ʾ", "��ѡ���ˡ��û���Ϣע�ᡱ�˵���");
			}
		});
		// ��ѡ���ͣ�ѡ�к�ǰ������һ��Բ�㡣
		MenuItem itemb = new MenuItem(File, SWT.RADIO);
		itemb.setText("ɾ���û���Ϣ");
		// �ָ����ͣ��������˵��ϲ����ָ����
		new MenuItem(File, SWT.SEPARATOR);
		// ��ͨ���ͣ�ѡ�к�ֱ�Ӳ��������ķ���
		MenuItem itemd = new MenuItem(File, SWT.PUSH);
		itemd.setText("�޸��û���Ϣ");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new MenuExample1();
	}
}
