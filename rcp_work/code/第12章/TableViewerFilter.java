/**
 * author: WangJinTao,MengQingChang 2006
 */
package jfaceViewer;

import java.net.*;
import java.util.ArrayList;
import org.eclipse.jface.action.*;
import org.eclipse.jface.resource.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class TableViewerFilter extends ApplicationWindow {
	private ArrayList peopleList;

	private Label label;

	private TableViewer tv;

	private Table table;

	private AgeFilter ageFilter;

	public static final String ID = "学号";

	public static final String NAME = "姓名";

	public static final String MALE = "性别";

	public static final String AGE = "年龄";

	public static final String POSITION = "职位";

	public static final String COLOR = "喜欢的颜色";

	public TableViewerFilter() {
		super(null);
		addToolBar(SWT.FLAT);

	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		getShell().setText("TableViwerFilter实例");
		getShell().setSize(480, 250);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		createTableViewer(composite);
		peopleList = createPeopleList();
		tv.setContentProvider(new PeopleContentProvider());
		// 用setInput()方法往表格中读入数据
		tv.setInput(peopleList);
		// 设置标签器
		tv.setLabelProvider(new PeopleLabelProvider());
		ageFilter = new AgeFilter();

		label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		modifyTableViewerCell();
		return composite;
	}

	private void createTableViewer(Composite comp) {

		// 定义一个TableViewer对象，样式为：选择整行
		tv = new TableViewer(comp, SWT.FULL_SELECTION);

		// 设置Table
		table = tv.getTable();

		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		// 定义表中的列
		TableColumn Col1 = new TableColumn(table, SWT.LEFT);
		Col1.setText("员工号");
		// 设置列宽度
		Col1.setWidth(70);
		TableColumn Col2 = new TableColumn(table, SWT.LEFT);
		Col2.setText("姓名");
		Col2.setWidth(60);
		TableColumn Col3 = new TableColumn(table, SWT.LEFT);
		Col3.setText("性别");
		Col3.setWidth(50);
		TableColumn Col4 = new TableColumn(table, SWT.LEFT);
		Col4.setText("年龄");
		Col4.setWidth(50);
		TableColumn Col5 = new TableColumn(table, SWT.LEFT);
		Col5.setText("职位");
		Col5.setWidth(100);
		TableColumn Col6 = new TableColumn(table, SWT.LEFT);
		Col6.setText("喜欢的颜色");
		Col6.setWidth(128);

		// 显示表头
		table.setHeaderVisible(true);
		// 显示表格线
		table.setLinesVisible(true);

	}

	private ArrayList createPeopleList() {
		peopleList = new ArrayList();
		{
			People p1 = new People();
			p1.setID(20020001);
			p1.setName("王志辉");
			p1.setMale(true);
			p1.setAge(34);
			p1.setPosition("总经理");
			p1.setColor(new RGB(255, 0, 0));

			peopleList.add(p1);

		}

		{
			People p2 = new People();
			p2.setID(20020002);
			p2.setName("李晓娟");
			p2.setMale(false);
			p2.setAge(27);
			p2.setPosition("商务总监");
			p2.setColor(new RGB(255, 255, 0));

			peopleList.add(p2);
			 
		}

		{
			People p3 = new People();
			p3.setID(20020003);
			p3.setName("李志强");
			p3.setMale(true);
			p3.setAge(29);
			p3.setPosition("行政总监");
			p3.setColor(new RGB(255, 255, 255));

			peopleList.add(p3);
		 
		}
		{
			People p4 = new People();
			p4.setID(20020004);
			p4.setName("任鸿霞");
			p4.setMale(false);
			p4.setAge(31);
			p4.setPosition("财务部经理");
			p4.setColor(new RGB(0, 255, 255));

			peopleList.add(p4);
			 
		}
		return peopleList;
	}

	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		toolBarManager.add(new filterAction());

		toolBarManager.add(new Separator());
		toolBarManager.add(new recoverAction());
		toolBarManager.add(new removeAction());
		toolBarManager.add(new refreshAction());

		return toolBarManager;
	}

	class filterAction extends Action {
		public filterAction() {
			super("PUSH", Action.AS_PUSH_BUTTON);

			setToolTipText("过滤掉年龄小于30岁的员工记录");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/filter.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			label.setText("过滤掉年龄小于30岁的员工记录结果");
			tv.addFilter(ageFilter);
		}
	}

	class recoverAction extends Action {
		public recoverAction() {

			setToolTipText("恢复到过滤前的结果");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/eclipse0.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}

		}

		public void run() {
			label.setText("恢复到过滤前的结果");
			tv.removeFilter(ageFilter);

		}
	}

	class refreshAction extends Action {
		public refreshAction() {
			setToolTipText("刷新纪录");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/refresh.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}

		}

		public void run() {
			label.setText("刷新后的结果");
			tv.refresh();

		}
	}

	class removeAction extends Action {
		public removeAction() {

			setToolTipText("删除所选择的行记录");

			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/remove.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}

		}

		public void run() {
			label.setText("删除的结果");
			table.remove(table.getSelectionIndices());

		}
	}

	// 表格记录过滤器，过滤掉年龄小于30岁的员工记录
	class AgeFilter extends ViewerFilter {
		public boolean select(Viewer viewer, Object parent, Object element) {

			People p = (People) element;
			return p.getAge() >= 30;
		}
	}

	// 自定义修改表格单元方法
	public void modifyTableViewerCell() {
		// 建立每一列的表格单元编辑器
		CellEditor[] editors = new CellEditor[6];
		editors[0] = null;
		editors[1] = new TextCellEditor(table);
		editors[2] = new CheckboxCellEditor(table);
		editors[3] = null;
		editors[4] = new ComboBoxCellEditor(table, Position.position,
				SWT.READ_ONLY);

		editors[5] = new ColorCellEditor(table);
		// 设置列属性
		tv.setColumnProperties(new String[] { ID, NAME, MALE, AGE, POSITION,
				COLOR });
		// 设置表格单元的修改
		tv.setCellModifier(new TableViewerCellModifier(tv));
		// 设置单元格的编辑
		tv.setCellEditors(editors);
	}

	public static void main(String[] args) {
		new TableViewerFilter().run();
	}
}
