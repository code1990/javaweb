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
		shell.setText("Sash实例");
		shell.setSize(300, 200);
		shell.setLayout(new FormLayout());
		// 定义一个Sash对象并对其进行布局设置
		sash = new Sash(shell, SWT.VERTICAL);
		FormData data = new FormData();
		// 使Sash顶端与Shell容器顶端距离为0
		data.top = new FormAttachment(0, 0);
		// 使Sash底端与shell容器底端距离为0
		data.bottom = new FormAttachment(100, 0);
		// 使Sash左边框到Shell容器左边框距离占整个Shell容器宽度的30%
		data.left = new FormAttachment(30, 0);

		sash.setLayoutData(data);
		// 该事件作用可使分割框格被鼠标拖动来调整被其分割左右两部分区域的大小
		sash.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				((FormData) sash.getLayoutData()).left = new FormAttachment(0,
						event.x);
				sash.getParent().layout();
			}
		});
		// 建立一个列表框位于分割框格(Sash)左边
		list = new List(shell, SWT.BORDER | SWT.V_SCROLL | SWT.HORIZONTAL);
		list.setItems(new String[] { "第1章 基础概述", "第2章 安装与配置",
				"第3章 SWT/JFace开发过程", "第4章 几种常用的SWT组件", "第5章 窗口小部件事件",
				"第6章 SWT的对话框", "第7章 布局管理器", "第8章 SWT复杂组件", "第9章 其它组件类用法" });
		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = list.getSelectionIndex();
				if (selectionIndex == 0) {
					text.setText("1.1引言" + '\n' + "1.2 Eclipse架构");
				} else if (selectionIndex == 1) {
					text.setText("第二章目录略....");
				} else if (selectionIndex == 2) {
					text.setText("第三章目录略....");
				} else if (selectionIndex == 3) {
					text.setText("第四章目录略....");
				} else if (selectionIndex == 4) {
					text.setText("第五章目录略....");
				} else if (selectionIndex == 5) {
					text.setText("第六章目录略....");
				} else if (selectionIndex == 6) {
					text.setText("第七章目录略....");
				} else if (selectionIndex == 7) {
					text.setText("第八章目录略....");
				} else if (selectionIndex == 8) {
					text.setText("第九章目录略....");
				}
			}
		});
		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(sash, 0);
		list.setLayoutData(data);
		// 建立一个文本框位于分割框格的右边
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
