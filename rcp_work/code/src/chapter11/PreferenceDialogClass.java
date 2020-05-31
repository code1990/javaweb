/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter11;

import java.io.IOException;
import org.eclipse.jface.preference.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class PreferenceDialogClass extends ApplicationWindow {
	public PreferenceDialogClass() {
		super(null);
	}

	public static void main(String[] args) {
		PreferenceDialogClass preferenceDialog = new PreferenceDialogClass();
		preferenceDialog.setBlockOnOpen(true);
		preferenceDialog.open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		getShell().setText("首选项");
		getShell().setSize(200, 80);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new GridLayout());
		Button openbutton = new Button(composite, SWT.PUSH);
		openbutton.setText("打开首选项");
		openbutton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				openPreferenceDialog();
			}
		});
		// 对打开首选项按钮布局
		GridData grid = new GridData(GridData.FILL_HORIZONTAL);
		openbutton.setLayoutData(grid);
		return composite;
	}

	private void openPreferenceDialog() {
		// 定义PreferenceManager类对象
		PreferenceManager pm = new PreferenceManager();
		// 定义一个PreferenceNode类对象，即节点对象
		PreferenceNode nodeA = new PreferenceNode("NODEA");
		// 将常规页面设置为nodeA的页面即单击nodeA节点时显示常规页面
		nodeA.setPage(new PreferencePageOne());
		// 将节点nodeA设置为根节点
		pm.addToRoot(nodeA);
		// 定义节点nodea
		PreferenceNode nodea = new PreferenceNode("NODEa");
		nodea.setPage(new PreferencePageTwo());
		// 将节点nodea设置为根nodeA的子节点
		pm.addTo("NODEA", nodea);
		// 定义节点nodeB
		PreferenceNode nodeB = new PreferenceNode("NODEB");
		nodeB.setPage(new PreferencePageThree());
		// 将节点 nodeB设置为根节点
		pm.addToRoot(nodeB);
		// 定义节点nodeb
		PreferenceNode nodeb = new PreferenceNode("NODEb");
		nodeb.setPage(new PreferencePageFour());
		// 将节点nodeb设置为根节点nodeB的子节点
		pm.addTo("NODEB", nodeb);
		// 定义一个PreferenceDialog对象，
		PreferenceDialog dialog = new PreferenceDialog(getShell(), pm);
		// 设置preferencestore对象
		PreferenceStore ps = new PreferenceStore("showprefs.properties");
		try {
			ps.load();
		} catch (IOException e) {
		}
		dialog.setPreferenceStore(ps);
		// 打开首选项对话框
		dialog.open();
		try {
			// 保存 preferences
			ps.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 常规页面
	class PreferencePageOne extends PreferencePage {
		private Button CheckOne;

		private Button CheckTwo;

		private Button CheckThree;

		private Button CheckFour;

		private Button CheckFive;

		private Button RadioOne;

		private Button RadioTwo;

		private static final String ONE = "one";

		private static final String TWO = "two";

		private static final String THREE = "three";

		private static final String FOUR = "four";

		private static final String FIVE = "five";

		private static final String SIX = "six";

		private static final String SEVEN = "seven";

		public PreferencePageOne() {
			setTitle("常规");
			setMessage("常规");
		}

		// /在常规页面上添加组件
		protected Control createContents(Composite parent) {
			Composite comp = new Composite(parent, SWT.NONE);
			comp.setLayout(new GridLayout(1, true));
			IPreferenceStore preferenceStore = getPreferenceStore();
			CheckOne = new Button(comp, SWT.CHECK);
			CheckOne.setText("始终在后台运行(&U)");
			CheckOne.setSelection(preferenceStore.getBoolean(ONE));

			CheckTwo = new Button(comp, SWT.CHECK);
			CheckTwo.setText("让下一个/上一个部件在对话框打开(&N)");
			CheckTwo.setSelection(preferenceStore.getBoolean(TWO));

			CheckThree = new Button(comp, SWT.CHECK);
			CheckThree.setText("显示堆状态(&W)");
			CheckThree.setSelection(preferenceStore.getBoolean(THREE));
			// 定义分组框
			final Group group = new Group(comp, SWT.NONE);
			group.setText("打开方式");
			GridData grid = new GridData(GridData.FILL_HORIZONTAL);
			group.setLayoutData(grid);
			group.setLayout(new GridLayout());
			// 在分组框上添加组件
			RadioOne = new Button(group, SWT.RADIO);
			RadioOne.setText("双击(&O)");
			RadioOne.setSelection(preferenceStore.getBoolean(SIX));

			RadioTwo = new Button(group, SWT.RADIO);
			RadioTwo.setText("单击(&S)");
			RadioTwo.setSelection(preferenceStore.getBoolean(SEVEN));

			CheckFour = new Button(group, SWT.CHECK);
			CheckFour.setText("根据悬浮提示选择(&H)");
			CheckFour.setSelection(preferenceStore.getBoolean(FOUR));
			// 将CheckFour按钮设置为不可用状态
			CheckFour.setEnabled(false);
			// 对CheckFour按钮进行布局
			GridData buttongrid = new GridData();
			buttongrid.horizontalIndent = 20;
			CheckFour.setLayoutData(buttongrid);

			CheckFive = new Button(group, SWT.CHECK);
			CheckFive.setText("使用尖头键时打开(&K)");
			CheckFive.setSelection(preferenceStore.getBoolean(FIVE));
			// 将CheckFive按钮设置为不可用状态
			CheckFive.setEnabled(false);
			CheckFive.setLayoutData(buttongrid);
			// 在group上定义标签
			new Label(group, SWT.NONE).setText("注意：此选项可能并不对所有视图都有效");
			RadioTwo.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// 当选择了RadioTwo按钮后，CheckFour和CheckFive将被激活否则
					// 处于不可用状态
					if (RadioTwo.getSelection() == true) {
						CheckFour.setEnabled(true);
						CheckFive.setEnabled(true);
					} else {
						CheckFour.setEnabled(false);
						CheckFive.setEnabled(false);
					}
				}
			});
			return comp;
		}

		protected void performDefaults() {
			IPreferenceStore preferenceStore = getPreferenceStore();
			// 将按钮状态重置
			CheckOne.setSelection(preferenceStore.getDefaultBoolean(ONE));
			CheckTwo.setSelection(preferenceStore.getDefaultBoolean(TWO));
			CheckThree.setSelection(preferenceStore.getDefaultBoolean(THREE));
			CheckFour.setSelection(preferenceStore.getDefaultBoolean(FOUR));
			CheckFive.setSelection(preferenceStore.getDefaultBoolean(FIVE));
			RadioOne.setSelection(preferenceStore.getDefaultBoolean(SIX));
			RadioTwo.setSelection(preferenceStore.getDefaultBoolean(FOUR));
		}

		protected void performApply() {
			if (getControl() == null) {
				return;
			}
		}

		public boolean performOk() {
			performApply();
			return true;
		}
	}

	// 浏览器页面
	class PreferencePageTwo extends PreferencePage {
		public PreferencePageTwo() {
			setTitle("Web浏览器");
			setMessage("Web浏览器");
		}

		protected Control createContents(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, true));
			return composite;
		}

		protected void performApply() {
			if (getControl() == null) {
				return;
			}
		}

		public boolean performOk() {
			performApply();
			return true;
		}
	}

	// Ant页面
	class PreferencePageThree extends PreferencePage {
		public PreferencePageThree() {
			setTitle("Ant");
			setMessage("Ant");
		}

		protected Control createContents(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, true));
			return composite;
		}

		protected void performApply() {
			if (getControl() == null) {
				return;
			}
		}

		public boolean performOk() {
			performApply();
			return true;
		}
	}

	// /编辑器页面
	class PreferencePageFour extends PreferencePage {
		public PreferencePageFour() {
			setTitle("编辑器");
			setMessage("编辑器");
		}

		protected Control createContents(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, true));
			return composite;
		}

		protected void performApply() {
			if (getControl() == null) {
				return;
			}
		}

		public boolean performOk() {
			performApply();
			return true;
		}
	}
}
