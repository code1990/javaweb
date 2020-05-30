/**@author WangJinTao,MengQingChang 2006
 */
package other.widget;

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
		shell.setText("Drag and Drop实例");
		// 建立源拖放内容
		sourcelabel = new Label(shell, SWT.BORDER);
		sourcelabel.setBounds(60, 50, 100, 25);
		sourcelabel.setText("这是要拖放的信息");
		/**
		 * 明确转移的类型，此处为文本转移TextTransfer。除了TextTransfer类型外还有
		 * FileTansfer、RTFTTansfer
		 */
		Transfer[] type = new Transfer[] { TextTransfer.getInstance() };
		// 建立DragSource类的对象
		DragSource dragSource = new DragSource(sourcelabel, DND.DROP_COPY
				| DND.DROP_MOVE);
		dragSource.setTransfer(type);
		// 建立目标内容
		targetlabel = new Label(shell, SWT.BORDER);
		targetlabel.setBounds(60, 130, 100, 25);
		targetlabel.setText("这是拖放目标位置");
		// 建立DropTarge类对象
		DropTarget dropTarget = new DropTarget(targetlabel, DND.DROP_COPY
				| DND.DROP_MOVE);
		// 设置转移类型
		dropTarget.setTransfer(type);
		// 对源位置的操作
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
		// 对目标位置的操作
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
