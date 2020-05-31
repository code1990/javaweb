package chapter12;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.*;

import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;

public class ListViewerSort extends ApplicationWindow {
	private Button buttonSort;

	private boolean a = true;

	private ListViewer lv;

	private ArrayList itemList;

	public ListViewerSort() {
		super(null);
	}

	public void run() {

		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(245, 250);
		shell.setText("ListViewerSort实例");
	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		// 调用自定义方法
		createTableViewer(composite);
		// 调用自定义方法createItemList()
		itemList = createItemList();
		// 设置标签器
		lv.setLabelProvider(new MyLabelProvider());
		// 设置内容器
		lv.setContentProvider(new MyContentProvider());
		// 设置排序器
		lv.setSorter(new Sort());
		// 用setInput()方法读入数据
		lv.setInput(itemList);

		return composite;
	}

	private void createTableViewer(Composite comp) {
		lv = new ListViewer(comp, SWT.NONE);
		Composite com = new Composite(comp, SWT.NONE);
		com.setLayout(new GridLayout());
		buttonSort = new Button(com, SWT.PUSH);
		buttonSort.setText("排序");
		GridData grid = new GridData();
		grid.horizontalIndent = 5;
		grid.widthHint = 100;
		buttonSort.setLayoutData(grid);
		buttonSort.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) lv.getSorter()).playSort(a ? -1 : 1);
				// 强制刷新，否则排序效果不可见
				lv.refresh();
			}
		});

	}

	private ArrayList createItemList() {
		itemList = new ArrayList();

		for (int i = 0; i < 10; i++) {
			itemList.add(new MyItem(i));
		}

		return itemList;

	}

	class MyItem {
		public String item;

		public MyItem(int i) {
			item = " Item " + i;

		}

		public String getName() {
			return item;
		}
	}

	// 标签器
	class MyLabelProvider extends LabelProvider {
		public String getText(Object element) {
			return ((MyItem) element).item;
		}

	}// 内容器

	class MyContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {

			return ((List) inputElement).toArray();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

	}

	// 排序器
	class Sort extends ViewerSorter {

		private int column;

		/**
		 * 接收((Sort) tv.getSorter()).playSort()语句中 playSort()方法中的参数取值
		 */
		public void playSort(int column) {
			this.column = column;

		}

		public int compare(Viewer viewer, Object e1, Object e2) {
			MyItem item1 = (MyItem) e1;
			MyItem item2 = (MyItem) e2;
			switch (column) {
			case 1: {
				String str1 = item1.getName();
				String str2 = item2.getName();
				int itemDesc = str2.compareTo(str1);

				return itemDesc;

			}
			case -1: {
				String str1 = item1.item;
				String str2 = item2.item;
				int itemAsc = str1.compareTo(str2);
				return itemAsc;
			}
			}
			return 0;
		}

	}

	public static void main(String[] args) {
		new ListViewerSort().run();
	}
}
