/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class SashExample {
	private Sash sash;

	private Text text;

	private List list;

	public SashExample() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Sashʵ��");
		shell.setSize(300, 200);
		shell.setLayout(new FormLayout());
		// ����һ��Sash���󲢶�����в�������
		sash = new Sash(shell, SWT.VERTICAL);
		FormData data = new FormData();
		// ʹSash������Shell�������˾���Ϊ0
		data.top = new FormAttachment(0, 0);
		// ʹSash�׶���shell�����׶˾���Ϊ0
		data.bottom = new FormAttachment(100, 0);
		// ʹSash��߿�Shell������߿����ռ����Shell������ȵ�30%
		data.left = new FormAttachment(30, 0);

		sash.setLayoutData(data);
		// ���¼����ÿ�ʹ�ָ�������϶�����������ָ���������������Ĵ�С
		sash.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				((FormData) sash.getLayoutData()).left = new FormAttachment(0,
						event.x);
				sash.getParent().layout();
			}
		});
		// ����һ���б��λ�ڷָ���(Sash)���
		list = new List(shell, SWT.BORDER | SWT.V_SCROLL | SWT.HORIZONTAL);
		list.setItems(new String[] { "��1�� ��������", "��2�� ��װ������",
				"��3�� SWT/JFace��������", "��4�� ���ֳ��õ�SWT���", "��5�� ����С�����¼�",
				"��6�� SWT�ĶԻ���", "��7�� ���ֹ�����", "��8�� SWT�������", "��9�� ����������÷�" });
		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = list.getSelectionIndex();
				if (selectionIndex == 0) {
					text.setText("1.1����" + '\n' + "1.2 Eclipse�ܹ�");
				} else if (selectionIndex == 1) {
					text.setText("�ڶ���Ŀ¼��....");
				} else if (selectionIndex == 2) {
					text.setText("������Ŀ¼��....");
				} else if (selectionIndex == 3) {
					text.setText("������Ŀ¼��....");
				} else if (selectionIndex == 4) {
					text.setText("������Ŀ¼��....");
				} else if (selectionIndex == 5) {
					text.setText("������Ŀ¼��....");
				} else if (selectionIndex == 6) {
					text.setText("������Ŀ¼��....");
				} else if (selectionIndex == 7) {
					text.setText("�ڰ���Ŀ¼��....");
				} else if (selectionIndex == 8) {
					text.setText("�ھ���Ŀ¼��....");
				}
			}
		});
		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(sash, 0);
		list.setLayoutData(data);
		// ����һ���ı���λ�ڷָ�����ұ�
		text = new Text(shell, SWT.BORDER | SWT.HORIZONTAL | SWT.V_SCROLL);
		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		data.left = new FormAttachment(sash, 0);
		data.right = new FormAttachment(100, 0);
		text.setLayoutData(data);
		shell.layout();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	public static void main(String[] args) {
		new SashExample();
	}
}
