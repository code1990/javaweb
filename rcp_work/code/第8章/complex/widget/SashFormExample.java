/**@author WangJinTao,MengQingChang 2006
 */
package complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;

public class SashFormExample {
	private SashForm sashForm1;

	private SashForm sashForm2;

	private Text textA;

	private Text textB;

	public SashFormExample() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(400, 280);
		shell.setLayout(new FillLayout());
		// 定义分割窗sashForm1
		sashForm1 = new SashForm(shell, SWT.HORIZONTAL);
		final List list = new List(sashForm1, SWT.NONE | SWT.BORDER
				| SWT.H_SCROLL);
		list.setItems(new String[] { "最大化文本框A", "最大化文本框B", "恢复文本框A,B",
				"改变分割窗的分割方向" });
		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = list.getSelectionIndex();
				if (selectionIndex == 0) {
					sashForm2.setMaximizedControl(textA);
				 
				} else if (selectionIndex == 1) {
					sashForm2.setMaximizedControl(textB);
				} else if (selectionIndex == 2) {
					sashForm2.setMaximizedControl(null);
					if (sashForm2.getOrientation() == SWT.HORIZONTAL) {
						sashForm2.setOrientation(SWT.VERTICAL);
						
					}
				} else if (selectionIndex == 3) {
					if (sashForm2.getOrientation() == SWT.VERTICAL) {
						sashForm2.setOrientation(SWT.HORIZONTAL);
					} else
						sashForm2.setOrientation(SWT.VERTICAL);
				}
			}
		});
		sashForm2 = new SashForm(sashForm1, SWT.VERTICAL);
		textA = new Text(sashForm2, SWT.BORDER | SWT.CENTER);
		textA.setText("文本框A");
		textB = new Text(sashForm2, SWT.BORDER | SWT.CENTER);
		textB.setText("文本框B");
		textB.setEnabled(false);
		sashForm1.setWeights(new int[] { 1, 3 });
		

		shell.layout();
		shell.open();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new SashFormExample();
	}
}
