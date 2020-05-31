package chapter14;

import java.sql.*;
import java.net.*;
import org.eclipse.swt.*;
import org.eclipse.jface.action.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.jface.resource.*;
import java.util.List;
import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;

public class SWTJFaceDataBase extends ApplicationWindow {
	private Action exit;

	private Action about;

	private CTabFolder CTab;

	private CTabItem Item;

	private Composite comp1;

	private Composite comp2;

	private Composite comp3;

	private Composite container;

	private TableViewer tv;

	private Table table;

	private boolean a = true;

	private Text text1;

	private Text text2;

	private Text text3;

	public SWTJFaceDataBase() {
		super(null);
		exit = new exitAction();
		about = new aboutAction();
		addMenuBar();
		addToolBar(SWT.FLAT);

	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		// 设置窗体大小
		shell.setSize(700, 500);
		shell.setText("SWT/JFace与数据库实例");
	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		// 调用自定义方法
		createSurface(composite);
		return composite;
	}

	private void createSurface(Composite comp) {
		Composite composite = new Composite(comp, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new FillLayout());
		// 定义分割窗
		SashForm sashForm = new SashForm(composite, SWT.NONE);
		// 定义扩展栏
		ExpandBar expandbar = new ExpandBar(sashForm, SWT.V_SCROLL);
		{ // /设置扩展项Item1
			comp1 = new Composite(expandbar, SWT.NONE);
			comp1.setLayoutData(new GridData(GridData.FILL_BOTH));
			comp1.setLayout(new GridLayout());
			ExpandItem item1 = new ExpandItem(expandbar, SWT.NONE);
			item1.setText("查询员工信息");
			item1.setHeight(40);
			item1.setControl(comp1);
			// 定义link
			Link link = new Link(comp1, SWT.NONE);
			GridData grid = new GridData();
			grid.horizontalIndent = 30;
			grid.verticalIndent = 10;
			link.setLayoutData(grid);
			link.setText(" <a>员工基本信息查询</a>    ");
			link.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {

					try {
						tv.setInput(DbOperate.BasicInfor());
					} catch (SQLException e) {
					}
				}
			});

		}
		{ // 设置扩展项Item2
			comp2 = new Composite(expandbar, SWT.NONE);
			comp2.setLayoutData(new GridData(GridData.FILL_BOTH));
			comp2.setLayout(new GridLayout(2, false));
			ExpandItem item2 = new ExpandItem(expandbar, SWT.NONE);
			item2.setText("分类查询员工信息");
			item2.setHeight(150);
			item2.setControl(comp2);

			final Label label1 = new Label(comp2, SWT.NONE);
			label1.setText("按员工号查询：");
			GridData grid0 = new GridData();
			grid0.horizontalSpan = 2;
			label1.setLayoutData(grid0);
			text1 = new Text(comp2, SWT.BORDER);
			GridData gridId = new GridData();
			gridId.widthHint = 80;
			text1.setLayoutData(gridId);
			final Button button1 = new Button(comp2, SWT.PUSH);
			button1.setText("查询");
			button1.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {

					try {
						String Atr = text1.getText();
						// 检查文本项是否为空
						if (Atr == null || Atr.equals("")) {
							MessageDialog.openInformation(null, null, "查询失败！"
									+ '\n' + '\n' + "  注意：文本项均不能为空！！！！");
						} else {
							tv.setInput(DbOperate.SearchId(text1));
						}
					} catch (SQLException ee) {
					}

				}
			});

			GridData grid1 = new GridData();
			grid1.horizontalIndent =5;
			grid1.widthHint = 60;
			button1.setLayoutData(grid1);

			final Label label2 = new Label(comp2, SWT.NONE);
			label2.setText("按姓名查询：");
			label2.setLayoutData(grid0);
			text2 = new Text(comp2, SWT.BORDER);
			text2.setLayoutData(gridId);
			final Button button2 = new Button(comp2, SWT.PUSH);
			button2.setText("查询");
			button2.setLayoutData(grid1);
			button2.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {

					try {
						String Btr = text2.getText();
						// 检查文本项是否为空
						if (Btr == null || Btr.equals("")) {
							MessageDialog.openInformation(null, null, "查询失败！"
									+ '\n' + '\n' + "  注意：文本项不能为空！！！！");
						} else {
							tv.setInput(DbOperate.SearchName(text2));
						}
					} catch (SQLException ee) {
					}

				}
			});

			final Label label3 = new Label(comp2, SWT.NONE);
			label3.setText("按性别查询：");
			label3.setLayoutData(grid0);
			text3 = new Text(comp2, SWT.BORDER);
			text3.setLayoutData(gridId);
			final Button button3 = new Button(comp2, SWT.PUSH);
			button3.setText("查询");
			button3.setLayoutData(grid1);
			button3.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {

					try {
						String Ctr = text3.getText();
						// 检查文本项是否为空
						if (Ctr == null || Ctr.equals("")) {
							MessageDialog.openInformation(null, null, "查询失败！"
									+ '\n' + '\n' + "  注意：文本项不能为空！！！！");
						} else {
							tv.setInput(DbOperate.SearchSex(text3));
						}
					} catch (SQLException ee) {
					}

				}
			});
		}
		{// 设置扩展项Item3
			comp3 = new Composite(expandbar, SWT.NONE);
			comp3.setLayoutData(new GridData(GridData.FILL_BOTH));
			comp3.setLayout(new GridLayout(2, false));
			ExpandItem item3 = new ExpandItem(expandbar, SWT.NONE);
			item3.setText("查询说明");
			item3.setHeight(100);
			item3.setControl(comp3);

		}

		container = new Composite(sashForm, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		container.setLayout(new GridLayout());
		sashForm.setWeights(new int[] { 2, 8 });
		{
			CTab = new CTabFolder(container, SWT.BORDER);
			// 定义CTabItem对象Item1
			CTab.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
					false));
			CTab.setSimple(false);

			Item = new CTabItem(CTab, SWT.NONE, 0);
			Item.setText(" 员工信息");
			// 设置最小化，最大化标签可见
			CTab.setSelection(Item);
			CTab.setMinimizeVisible(true);
			CTab.setMaximizeVisible(true);
			CTab.setMaximized(true);
			// 设置选项卡的最小化，最大化和恢复功能。
			CTab.addCTabFolder2Listener(new CTabFolder2Adapter() {
				// 使选项卡最小化
				public void minimize(CTabFolderEvent event) {
					CTab.setMinimized(true);
					container.layout(true);
				}

				// 是选项卡最大化
				public void maximize(CTabFolderEvent event) {
					CTab.setMaximized(true);
					CTab.setLayoutData(new GridData(GridData.FILL_BOTH));
					container.layout(true);
				}

				// 是选项卡恢复
				public void restore(CTabFolderEvent event) {
					CTab.setMinimized(false);
					CTab.setMaximized(false);
					CTab.setLayoutData(new GridData(GridData.FILL,
							GridData.FILL, true, false));
					container.layout(true);
				}
			});
			// 调用自定义方法
			createTableViewer(CTab);
			// 设置内容提供器
			tv.setContentProvider(new EmployeeContentProvider());
			// 设置标签提供器
			tv.setLabelProvider(new EmployeeLabelProvider());
			// 设置排序器
			tv.setSorter(new Sort());
		}

	}

	private void createTableViewer(CTabFolder ctabFolder) {
		// 定义一个TableViewer对象，样式为：可以整行被选择
		tv = new TableViewer(ctabFolder, SWT.FULL_SELECTION);
		// 设置Table
		table = tv.getTable();
		Item.setControl(table);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		// 定义表中的列
		TableColumn Col1 = new TableColumn(table, SWT.LEFT);
		Col1.setText("员工号");
		Col1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -1 : 1);
				tv.refresh();
			}
		});
		// 设置列宽度
		Col1.setWidth(70);
		TableColumn Col2 = new TableColumn(table, SWT.LEFT);
		Col2.setText("姓名");

		Col2.setWidth(80);
		Col2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -2 : 2);
				tv.refresh();
			}
		});
		TableColumn Col3 = new TableColumn(table, SWT.LEFT);
		Col3.setText("性别");
		Col3.setWidth(50);
		Col3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -3 : 3);
				tv.refresh();
			}
		});
		TableColumn Col4 = new TableColumn(table, SWT.LEFT);
		Col4.setText("年龄");
		Col4.setWidth(50);
		Col4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -4 : 4);
				tv.refresh();
			}
		});
		TableColumn Col5 = new TableColumn(table, SWT.LEFT);
		Col5.setText("职位");
		Col5.setWidth(100);
		Col5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -5 : 5);
				tv.refresh();
			}
		});
		TableColumn Col6 = new TableColumn(table, SWT.LEFT);
		Col6.setText("月薪(人民币元)");
		Col6.setWidth(128);
		Col6.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -6 : 6);
				tv.refresh();
			}
		});
		// 显示表头
		table.setHeaderVisible(true);
		// 显示表格线
		table.setLinesVisible(true);

	}

	// 设置菜单
	protected MenuManager createMenuManager() {
		MenuManager menuBar = new MenuManager();
		MenuManager fileMenu = new MenuManager("文件(&F)");
		MenuManager helpMenu = new MenuManager("帮助(&H)");
		fileMenu.add(exit);
		helpMenu.add(about);
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		return menuBar;
	}

	// 设置工具栏
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		// 通过Action动作来设置工具栏按钮相应的功能
		toolBarManager.add(new findAction());
		toolBarManager.add(new Separator());
		toolBarManager.add(new removeAction());
		return toolBarManager;
	}

	class findAction extends Action {
		public findAction() {
			setToolTipText("查询");
			try {
				// 载入图像
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/filter.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		// 查询员工基本信息操作
		public void run() {

			try {
				tv.setInput(DbOperate.BasicInfor());
			} catch (SQLException e) {
			}
		}
	}

	class removeAction extends Action {
		public removeAction() {

			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/remove.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		// 删除员工信息操作
		public void run() {
			DbOperate deleteId = new DbOperate();
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			Employee employee = (Employee) selection.getFirstElement();
			if (MessageDialog.openConfirm(null, null, "真的删除吗？")) {
				try {
					if (deleteId.removeEmployee(employee)) {
						List list = (List) tv.getInput();
						list.remove(employee);// 删除容器中的数据
						tv.remove(employee);// 删除表格中的数据
					}
				} catch (SQLException e) {
				}

			}
		}
	}

	class exitAction extends Action {
		public exitAction() {

			super("退出@Ctrl+E", null);
		}

		public void run() {
			getShell().dispose();
		}
	}

	class aboutAction extends Action {
		public aboutAction() {
			super("关于@Ctrl+A", null);

		}

		public void run() {
			MessageBox messageBox = new MessageBox(getShell(), SWT.ICON_WARNING
					| SWT.YES);

			messageBox.setMessage("欢迎使用“员工信息管理器”V2.0");
			messageBox.open();
		}
	}

	public static void main(String[] args) {
		new SWTJFaceDataBase().run();

	}
}
