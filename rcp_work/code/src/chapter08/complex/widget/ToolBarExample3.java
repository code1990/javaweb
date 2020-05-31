/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;

public class ToolBarExample3 {
	private ToolBar toolBar;

	private ToolItem item;

	private ToolItem item1;

	private ToolItem item2;

	private Composite composite;

	private Combo combo;

	private Label labelA;

	private Label labela;

	private Label labelB;

	private Label labelb;

	private Text textdisplay;

	static String Text = "";

	private Point point;

	public ToolBarExample3() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 300);
		shell.setText("ToolBar实例");
		// Shell使用行布局方式，使工具栏项按钮依次排列
		shell.setLayout(new RowLayout(SWT.VERTICAL));
		// 工具栏采用水平放置样式
		toolBar = new ToolBar(shell, SWT.HORIZONTAL);
		{
			/**
			 * 调用createToolItem()自定义方法，第一个参表示将ToolItem构造在工具栏上 ，
			 * 第二个参数：按钮为PUSH类型，第三个参数表示按钮上的名称， 
			 * 第四个参数表示为提示性标签文字， 该语句可以写成：
			 * ToolItem item=new ToolItem(toolBar，SWT.PUSH); 
			 * item.setText("PUSH按钮");
			 * item.setToolTipText("单击弹出提示性对话框");
			 */
			item = createToolItem(toolBar, SWT.PUSH, "PUSH按钮", "单击弹出提示性对话框");
			// 单击PUSH按钮触发该事件，弹出MessageBox对话框
			item.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					// /定义MessageBox对话框
					MessageBox messageBox = new MessageBox(shell,
							SWT.ICON_INFORMATION | SWT.OK);
					messageBox.setMessage("这是PUSH类型的按钮");
					messageBox.open();
				}
			});
		}
		{ // 定义一个带下拉菜单的按钮
			item1 = createToolItem(toolBar, SWT.DROP_DOWN, "DROP_DOWN按钮",
					"带下拉菜单的按钮");
			final Menu menu = new Menu(shell, SWT.PUSH);
			// 定义五个菜单项
			for (int i = 0; i < 5; i++) {
				MenuItem menuitem = new MenuItem(menu, SWT.CHECK);
				menuitem.setText("MenuItem " + i);
			}
			// 单击该工具栏项时弹出下拉菜单
			item1.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					// 当鼠标选中ARROW类型按钮则执行下面的程序
					if (event.detail == SWT.ARROW) {
						// 获取item大小即按钮大小
						Rectangle bound = item1.getBounds();
						// 对下拉菜单位置进行定位
						point = toolBar.toDisplay(bound.x, bound.y
								+ bound.height);
						menu.setLocation(point);
						menu.setVisible(true);
					}
				}
			});
		}
		{
			item = createToolItem(toolBar, SWT.CHECK, "CHECK按钮", "单击状态将改变");
			item.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					ToolItem item = (ToolItem) event.widget;
					// 获得工具栏上按钮的状态
					labela.setText(item.getSelection() ? "按下 " : "弹起 ");
				}
			});
		}
		{
			item2 = new ToolItem(toolBar, SWT.SEPARATOR);
			combo = new Combo(toolBar, SWT.READ_ONLY);
			combo.setItems(new String[] { "Eclipse", "SWT", "JFace", "AWT",
					"Swing", "MyEclipse", "Lomboz" });
			combo.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					int selectionIndex = combo.getSelectionIndex();
					if (selectionIndex == 0) {
						// 在当下拉列表项被选中时，该列表项将显示在文本框中
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 1) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 2) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 3) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 4) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 5) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 6) {
						textdisplay.setText(combo.getText());
					}
				}
			});
			item2.setControl(combo);
			item2.setWidth(80);// 设置Combo的宽度
		}
		{
			item = createToolItem(toolBar, SWT.RADIO, "RADIO1按钮 ", "单击显示该按钮被选中");
			item.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					labelb.setText("RADIO1按钮");
				}
			});
			item = createToolItem(toolBar, SWT.RADIO, "RADIO2按钮", "单击显示该按钮被选中");
			item.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					labelb.setText("RADIO2按钮");
				}
			});
		}
		composite = new Composite(shell, SWT.NONE);
		// 面板采用网格式布局，定义2列
		composite.setLayout(new GridLayout(2, false));
		// 标签分隔符
		Label label = new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR);
		GridData grida = new GridData(GridData.FILL_HORIZONTAL);
		grida.horizontalSpan = 2;// 水平抢占2列
		label.setLayoutData(grida);
		labelA = new Label(composite, SWT.NONE);
		labelA.setText("CHECK按钮当前状态:");
		labela = new Label(composite, SWT.NONE);
		labela.setText("弹起");
		// 标签分隔符
		Label lab = new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR);
		GridData grid = new GridData(GridData.FILL_HORIZONTAL);
		grid.horizontalSpan = 2;
		lab.setLayoutData(grid);
		labelB = new Label(composite, SWT.RIGHT);
		labelB.setText("当前选中的RADIO按钮为:");
		labelb = new Label(composite, SWT.NONE);
		labelb.setText("当前无选中的RADIO按钮");
		// 定义一个文本框
		textdisplay = new Text(composite, SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 2;// 水平抢占2列
		gridData.heightHint = 20;// 高度为20个像素
		textdisplay.setLayoutData(gridData);
		// 鼠标移动事件
		toolBar.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				item = toolBar.getItem(new Point(e.x, e.y));
				String name = "";
				if (item != null) {
					// 获取工具栏项的名字，即工具栏上按钮的名称
					name = item.getText();
				}
				if (!Text.equals(name)) {
					// 在文本上显示获取的工具栏项的名称
					textdisplay.setText(name);
					Text = name;
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

	private ToolItem createToolItem(ToolBar parent, int type, String text,
			String toolTipText) {
		ToolItem item = new ToolItem(parent, type);
		item.setText(text);// 设置item名称
		item.setToolTipText(toolTipText);// 设置提示性标签文字
		return item;
	}

	public static void main(String[] args) {
		new ToolBarExample3();
	}
}
