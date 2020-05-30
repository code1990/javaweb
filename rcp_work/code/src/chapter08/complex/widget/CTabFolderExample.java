/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;

public class CTabFolderExample {
	private List list;

	private Composite comp;

	private CTabFolder CTab;

	public CTabFolderExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(400, 300);
		shell.setText("CTabFolderʵ��");
		shell.setLayout(new GridLayout(7, false));// ��������Ϊ7��
		{
			list = new List(shell, SWT.BORDER);
			list.setItems(new String[] { "Item1", "Item2", "Item3", "Item4",
					"Item5" });
			GridData gridA = new GridData(GridData.FILL_VERTICAL);
			gridA.horizontalSpan = 4;// ˮƽǿռ4��
			gridA.widthHint = 60;// ʹ���Ϊ60������
			gridA.horizontalIndent = 5;// ����List����shell������߿�Ϊ5������
			list.setLayoutData(gridA);
		}
		{
			comp = new Composite(shell, SWT.BORDER);
			GridData gridB = new GridData(GridData.FILL_BOTH);
			// ʹcomp���˫�����
			gridB.horizontalSpan = 3;
			comp.setLayoutData(gridB);
			comp.setLayout(new GridLayout());
		}
		CTab = new CTabFolder(comp, SWT.BORDER);
		// ����CTabItem����Item1
		CTab.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
				false));
		CTab.setSimple(false);
		final CTabItem Item1 = new CTabItem(CTab, SWT.CLOSE, 0);
		Item1.setText("Item1");
		Text text1 = new Text(CTab, SWT.MULTI);
		Item1.setControl(text1);
		// ����text1������ɫ
		text1.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
		final CTabItem Item2 = new CTabItem(CTab, SWT.CLOSE, 1);
		Item2.setText("Item2");
		Text text2 = new Text(CTab, SWT.MULTI);
		// ����text2������ɫ
		text2.setBackground(display.getSystemColor(SWT.COLOR_BLUE
				| SWT.COLOR_BLACK));
		Item2.setControl(text2);
		final CTabItem Item3 = new CTabItem(CTab, SWT.CLOSE, 2);
		Item3.setText("Item3");
		Text text3 = new Text(CTab, SWT.MULTI);
		text3.setBackground(display.getSystemColor(SWT.COLOR_RED));
		Item3.setControl(text3);
		final CTabItem Item4 = new CTabItem(CTab, SWT.CLOSE, 3);
		Item4.setText("Item4");
		Text text4 = new Text(CTab, SWT.MULTI);
		text4.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
		Item4.setControl(text4);
		final CTabItem Item5 = new CTabItem(CTab, SWT.CLOSE, 4);
		Item5.setText("Item5");
		Text text5 = new Text(CTab, SWT.MULTI);
		text5.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
		Item5.setControl(text5);
		// ������С������󻯱�ǩ�ɼ�
		CTab.setMinimizeVisible(true);
		CTab.setMaximizeVisible(true);
		CTab.setMaximized(true);
		 
		// ����ѡ�����С������󻯺ͻָ����ܡ�
		CTab.addCTabFolder2Listener(new CTabFolder2Adapter() {
			// ʹѡ���С��
			public void minimize(CTabFolderEvent event) {
				CTab.setMinimized(true);
				comp.layout(true);
			}

			// ʹѡ����
			public void maximize(CTabFolderEvent event) {
				CTab.setMaximized(true);
				CTab.setLayoutData(new GridData(GridData.FILL_BOTH));
				comp.layout(true);
			}

			// ʹѡ��ָ�
			public void restore(CTabFolderEvent event) {
				CTab.setMinimized(false);
				CTab.setMaximized(false);
				CTab.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
						true, false));
				comp.layout(true);
			}
		});
		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = list.getSelectionIndex();
				if (selectionIndex == 0) {
					// ��Item1Ϊ��ǰѡ����
					CTab.setSelection(Item1);
				} else if (selectionIndex == 1) {
					// ��Item2Ϊ��ǰѡ����
					CTab.setSelection(Item2);
				} else if (selectionIndex == 2) {
					CTab.setSelection(Item3);
				} else if (selectionIndex == 3) {
					CTab.setSelection(Item4);
				} else if (selectionIndex == 4) {
					CTab.setSelection(Item5);
				}
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
		new CTabFolderExample();
	}
}
