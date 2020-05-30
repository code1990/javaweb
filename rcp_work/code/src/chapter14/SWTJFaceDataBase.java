/**
 *@ author: WangJinTao,MengQingChang 2006 
 */
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

	private Boolean a = true;

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
		// ���ô����С
		shell.setSize(700, 500);
		shell.setText("SWT/JFace�����ݿ�ʵ��");
	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		// �����Զ��巽��
		createSurface(composite);
		return composite;
	}

	private void createSurface(Composite comp) {
		Composite composite = new Composite(comp, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new FillLayout());
		// ����ָ
		SashForm sashForm = new SashForm(composite, SWT.NONE);
		// ������չ��
		ExpandBar expandbar = new ExpandBar(sashForm, SWT.V_SCROLL);
		{ // /������չ��Item1
			comp1 = new Composite(expandbar, SWT.NONE);
			comp1.setLayoutData(new GridData(GridData.FILL_BOTH));
			comp1.setLayout(new GridLayout());
			ExpandItem item1 = new ExpandItem(expandbar, SWT.NONE);
			item1.setText("��ѯԱ����Ϣ");
			item1.setHeight(40);
			item1.setControl(comp1);
			// ����link
			Link link = new Link(comp1, SWT.NONE);
			GridData grid = new GridData();
			grid.horizontalIndent = 30;
			grid.verticalIndent = 10;
			link.setLayoutData(grid);
			link.setText(" <a>Ա��������Ϣ��ѯ</a>    ");
			link.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {

					try {
						tv.setInput(DbOperate.BasicInfor());
					} catch (SQLException e) {
					}
				}
			});

		}
		{ // ������չ��Item2
			comp2 = new Composite(expandbar, SWT.NONE);
			comp2.setLayoutData(new GridData(GridData.FILL_BOTH));
			comp2.setLayout(new GridLayout(2, false));
			ExpandItem item2 = new ExpandItem(expandbar, SWT.NONE);
			item2.setText("�����ѯԱ����Ϣ");
			item2.setHeight(150);
			item2.setControl(comp2);

			final Label label1 = new Label(comp2, SWT.NONE);
			label1.setText("��Ա���Ų�ѯ��");
			GridData grid0 = new GridData();
			grid0.horizontalSpan = 2;
			label1.setLayoutData(grid0);
			text1 = new Text(comp2, SWT.BORDER);
			GridData gridId = new GridData();
			gridId.widthHint = 80;
			text1.setLayoutData(gridId);
			final Button button1 = new Button(comp2, SWT.PUSH);
			button1.setText("��ѯ");
			button1.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {

					try {
						String Atr = text1.getText();
						// ����ı����Ƿ�Ϊ��
						if (Atr == null || Atr.equals("")) {
							MessageDialog.openInformation(null, null, "��ѯʧ�ܣ�"
									+ '\n' + '\n' + "  ע�⣺�ı��������Ϊ�գ�������");
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
			label2.setText("��������ѯ��");
			label2.setLayoutData(grid0);
			text2 = new Text(comp2, SWT.BORDER);
			text2.setLayoutData(gridId);
			final Button button2 = new Button(comp2, SWT.PUSH);
			button2.setText("��ѯ");
			button2.setLayoutData(grid1);
			button2.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {

					try {
						String Btr = text2.getText();
						// ����ı����Ƿ�Ϊ��
						if (Btr == null || Btr.equals("")) {
							MessageDialog.openInformation(null, null, "��ѯʧ�ܣ�"
									+ '\n' + '\n' + "  ע�⣺�ı����Ϊ�գ�������");
						} else {
							tv.setInput(DbOperate.SearchName(text2));
						}
					} catch (SQLException ee) {
					}

				}
			});

			final Label label3 = new Label(comp2, SWT.NONE);
			label3.setText("���Ա��ѯ��");
			label3.setLayoutData(grid0);
			text3 = new Text(comp2, SWT.BORDER);
			text3.setLayoutData(gridId);
			final Button button3 = new Button(comp2, SWT.PUSH);
			button3.setText("��ѯ");
			button3.setLayoutData(grid1);
			button3.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {

					try {
						String Ctr = text3.getText();
						// ����ı����Ƿ�Ϊ��
						if (Ctr == null || Ctr.equals("")) {
							MessageDialog.openInformation(null, null, "��ѯʧ�ܣ�"
									+ '\n' + '\n' + "  ע�⣺�ı����Ϊ�գ�������");
						} else {
							tv.setInput(DbOperate.SearchSex(text3));
						}
					} catch (SQLException ee) {
					}

				}
			});
		}
		{// ������չ��Item3
			comp3 = new Composite(expandbar, SWT.NONE);
			comp3.setLayoutData(new GridData(GridData.FILL_BOTH));
			comp3.setLayout(new GridLayout(2, false));
			ExpandItem item3 = new ExpandItem(expandbar, SWT.NONE);
			item3.setText("��ѯ˵��");
			item3.setHeight(100);
			item3.setControl(comp3);

		}

		container = new Composite(sashForm, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		container.setLayout(new GridLayout());
		sashForm.setWeights(new int[] { 2, 8 });
		{
			CTab = new CTabFolder(container, SWT.BORDER);
			// ����CTabItem����Item1
			CTab.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true,
					false));
			CTab.setSimple(false);

			Item = new CTabItem(CTab, SWT.NONE, 0);
			Item.setText(" Ա����Ϣ");
			// ������С������󻯱�ǩ�ɼ�
			CTab.setSelection(Item);
			CTab.setMinimizeVisible(true);
			CTab.setMaximizeVisible(true);
			CTab.setMaximized(true);
			// ����ѡ�����С������󻯺ͻָ����ܡ�
			CTab.addCTabFolder2Listener(new CTabFolder2Adapter() {
				// ʹѡ���С��
				public void minimize(CTabFolderEvent event) {
					CTab.setMinimized(true);
					container.layout(true);
				}

				// ��ѡ����
				public void maximize(CTabFolderEvent event) {
					CTab.setMaximized(true);
					CTab.setLayoutData(new GridData(GridData.FILL_BOTH));
					container.layout(true);
				}

				// ��ѡ��ָ�
				public void restore(CTabFolderEvent event) {
					CTab.setMinimized(false);
					CTab.setMaximized(false);
					CTab.setLayoutData(new GridData(GridData.FILL,
							GridData.FILL, true, false));
					container.layout(true);
				}
			});
			// �����Զ��巽��
			createTableViewer(CTab);
			// ���������ṩ��
			tv.setContentProvider(new EmployeeContentProvider());
			// ���ñ�ǩ�ṩ��
			tv.setLabelProvider(new EmployeeLabelProvider());
			// ����������
			tv.setSorter(new Sort());
		}

	}

	private void createTableViewer(CTabFolder ctabFolder) {
		// ����һ��TableViewer������ʽΪ���������б�ѡ��
		tv = new TableViewer(ctabFolder, SWT.FULL_SELECTION);
		// ����Table
		table = tv.getTable();
		Item.setControl(table);
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		// ������е���
		TableColumn Col1 = new TableColumn(table, SWT.LEFT);
		Col1.setText("Ա����");
		Col1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -1 : 1);
				tv.refresh();
			}
		});
		// �����п��
		Col1.setWidth(70);
		TableColumn Col2 = new TableColumn(table, SWT.LEFT);
		Col2.setText("����");

		Col2.setWidth(80);
		Col2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -2 : 2);
				tv.refresh();
			}
		});
		TableColumn Col3 = new TableColumn(table, SWT.LEFT);
		Col3.setText("�Ա�");
		Col3.setWidth(50);
		Col3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -3 : 3);
				tv.refresh();
			}
		});
		TableColumn Col4 = new TableColumn(table, SWT.LEFT);
		Col4.setText("����");
		Col4.setWidth(50);
		Col4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -4 : 4);
				tv.refresh();
			}
		});
		TableColumn Col5 = new TableColumn(table, SWT.LEFT);
		Col5.setText("ְλ");
		Col5.setWidth(100);
		Col5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -5 : 5);
				tv.refresh();
			}
		});
		TableColumn Col6 = new TableColumn(table, SWT.LEFT);
		Col6.setText("��н(�����Ԫ)");
		Col6.setWidth(128);
		Col6.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				a = !a;
				((Sort) tv.getSorter()).doSort(a ? -6 : 6);
				tv.refresh();
			}
		});
		// ��ʾ��ͷ
		table.setHeaderVisible(true);
		// ��ʾ�����
		table.setLinesVisible(true);

	}

	// ���ò˵�
	protected MenuManager createMenuManager() {
		MenuManager menuBar = new MenuManager();
		MenuManager fileMenu = new MenuManager("�ļ�(&F)");
		MenuManager helpMenu = new MenuManager("����(&H)");
		fileMenu.add(exit);
		helpMenu.add(about);
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		return menuBar;
	}

	// ���ù�����
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		// ͨ��Action���������ù�������ť��Ӧ�Ĺ���
		toolBarManager.add(new findAction());
		toolBarManager.add(new Separator());
		toolBarManager.add(new removeAction());
		return toolBarManager;
	}

	class findAction extends Action {
		public findAction() {
			setToolTipText("��ѯ");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/filter.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		// ��ѯԱ��������Ϣ����
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

		// ɾ��Ա����Ϣ����
		public void run() {
			DbOperate deleteId = new DbOperate();
			IStructuredSelection selection = (IStructuredSelection) tv
					.getSelection();
			Employee employee = (Employee) selection.getFirstElement();
			if (MessageDialog.openConfirm(null, null, "���ɾ����")) {
				try {
					if (deleteId.removeEmployee(employee)) {
						List list = (List) tv.getInput();
						list.remove(employee);// ɾ�������е�����
						tv.remove(employee);// ɾ������е�����
					}
				} catch (SQLException e) {
				}

			}
		}
	}

	class exitAction extends Action {
		public exitAction() {

			super("�˳�@Ctrl+E", null);
		}

		public void run() {
			getShell().dispose();
		}
	}

	class aboutAction extends Action {
		public aboutAction() {
			super("����@Ctrl+A", null);

		}

		public void run() {
			MessageBox messageBox = new MessageBox(getShell(), SWT.ICON_WARNING
					| SWT.YES);

			messageBox.setMessage("��ӭʹ�á�Ա����Ϣ��������V2.0");
			messageBox.open();
		}
	}

	public static void main(String[] args) {
		new SWTJFaceDataBase().run();

	}
}
