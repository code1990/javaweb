/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.dnd.*;

public class DragDropExample {
	private Label sourcelabel;

	private Label targetlabel;

	public DragDropExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(new Shell());
		shell.setSize(230, 280);
		shell.setText("Drag and Dropʵ��");
		// ����Դ�Ϸ�����
		sourcelabel = new Label(shell, SWT.BORDER);
		sourcelabel.setBounds(60, 50, 100, 25);
		sourcelabel.setText("����Ҫ�Ϸŵ���Ϣ");
		/**
		 * ��ȷת�Ƶ����ͣ��˴�Ϊ�ı�ת��TextTransfer������TextTransfer�����⻹��
		 * FileTansfer��RTFTTansfer
		 */
		Transfer[] type = new Transfer[] { TextTransfer.getInstance() };
		// ����DragSource��Ķ���
		DragSource dragSource = new DragSource(sourcelabel, DND.DROP_COPY
				| DND.DROP_MOVE);
		dragSource.setTransfer(type);
		// ����Ŀ������
		targetlabel = new Label(shell, SWT.BORDER);
		targetlabel.setBounds(60, 130, 100, 25);
		targetlabel.setText("�����Ϸ�Ŀ��λ��");
		// ����DropTarge�����
		DropTarget dropTarget = new DropTarget(targetlabel, DND.DROP_COPY
				| DND.DROP_MOVE);
		// ����ת������
		dropTarget.setTransfer(type);
		// ��Դλ�õĲ���
		dragSource.addDragListener(new DragSourceAdapter() {
			public void dragStart(DragSourceEvent event) {
				if (sourcelabel.getText().length() == 0) {
					event.doit = false;
				}
			}

			public void dragSetData(DragSourceEvent event) {
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = sourcelabel.getText();
				}
			}

			public void dragFinished(DragSourceEvent event) {
				if (event.detail == DND.DROP_MOVE)
					sourcelabel.setText("");
			}
		});
		// ��Ŀ��λ�õĲ���
		dropTarget.addDropListener(new DropTargetAdapter() {
			public void drop(DropTargetEvent event) {
				if (event.data == null) {
					event.detail = DND.DROP_NONE;
					return;
				}
				targetlabel.setText((String) event.data);
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new DragDropExample();
	}
}
