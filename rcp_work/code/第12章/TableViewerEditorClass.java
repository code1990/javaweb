/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package jfaceViewer;

import java.util.*;

import org.eclipse.jface.window.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class TableViewerEditorClass extends ApplicationWindow {
	private ArrayList peopleList;

	private TableViewer tv;

	private Table table;

	// 设置表的列名称属性
	public static final String ID = "学号";

	public static final String NAME = "姓名";

	public static final String MALE = "性别";

	public static final String AGE = "年龄";

	public static final String POSITION = "职位";

	public static final String COLOR = "喜欢的颜色";

	public TableViewerEditorClass() {
		super(null);

	}

	public void run() {
		setBlockOnOpen(true);
		open();

		Display.getCurrent().dispose();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("TableViewer实例");
		shell.setSize(480, 200);
	}

	protected Control createContents(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		// 调用自定义创建表格方法
		createTableViewer(composite);
		// 调用createPeopleList()方法
		peopleList = createPeopleList();
		// 设置内容器
		tv.setContentProvider(new PeopleContentProvider());
		// 用setInput()方法往表格中读入数据
		tv.setInput(peopleList);
		// 设置标签器
		tv.setLabelProvider(new PeopleLabelProvider());
		// 调用自定义表格单元修改方法
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

	/**
	 * ArrayList数组表功能类似Vector，用于缩放数组维护组合，
	 *  经常在表的插入、删除时使用。
	 */
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

		return peopleList;
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
		new TableViewerEditorClass().run();
	}
}
