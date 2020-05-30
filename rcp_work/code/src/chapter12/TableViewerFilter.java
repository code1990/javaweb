/**
 * author: WangJinTao,MengQingChang 2006
 */
package chapter12;

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

	public static final String ID = "ѧ��";

	public static final String NAME = "����";

	public static final String MALE = "�Ա�";

	public static final String AGE = "����";

	public static final String POSITION = "ְλ";

	public static final String COLOR = "ϲ������ɫ";

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
		getShell().setText("TableViwerFilterʵ��");
		getShell().setSize(480, 250);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		createTableViewer(composite);
		peopleList = createPeopleList();
		tv.setContentProvider(new PeopleContentProvider());
		// ��setInput()����������ж�������
		tv.setInput(peopleList);
		// ���ñ�ǩ��
		tv.setLabelProvider(new PeopleLabelProvider());
		ageFilter = new AgeFilter();

		label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		modifyTableViewerCell();
		return composite;
	}

	private void createTableViewer(Composite comp) {

		// ����һ��TableViewer������ʽΪ��ѡ������
		tv = new TableViewer(comp, SWT.FULL_SELECTION);

		// ����Table
		table = tv.getTable();

		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		// ������е���
		TableColumn Col1 = new TableColumn(table, SWT.LEFT);
		Col1.setText("Ա����");
		// �����п��
		Col1.setWidth(70);
		TableColumn Col2 = new TableColumn(table, SWT.LEFT);
		Col2.setText("����");
		Col2.setWidth(60);
		TableColumn Col3 = new TableColumn(table, SWT.LEFT);
		Col3.setText("�Ա�");
		Col3.setWidth(50);
		TableColumn Col4 = new TableColumn(table, SWT.LEFT);
		Col4.setText("����");
		Col4.setWidth(50);
		TableColumn Col5 = new TableColumn(table, SWT.LEFT);
		Col5.setText("ְλ");
		Col5.setWidth(100);
		TableColumn Col6 = new TableColumn(table, SWT.LEFT);
		Col6.setText("ϲ������ɫ");
		Col6.setWidth(128);

		// ��ʾ��ͷ
		table.setHeaderVisible(true);
		// ��ʾ�����
		table.setLinesVisible(true);

	}

	private ArrayList createPeopleList() {
		peopleList = new ArrayList();
		{
			People p1 = new People();
			p1.setID(20020001);
			p1.setName("��־��");
			p1.setMale(true);
			p1.setAge(34);
			p1.setPosition("�ܾ���");
			p1.setColor(new RGB(255, 0, 0));

			peopleList.add(p1);

		}

		{
			People p2 = new People();
			p2.setID(20020002);
			p2.setName("������");
			p2.setMale(false);
			p2.setAge(27);
			p2.setPosition("�����ܼ�");
			p2.setColor(new RGB(255, 255, 0));

			peopleList.add(p2);
			 
		}

		{
			People p3 = new People();
			p3.setID(20020003);
			p3.setName("��־ǿ");
			p3.setMale(true);
			p3.setAge(29);
			p3.setPosition("�����ܼ�");
			p3.setColor(new RGB(255, 255, 255));

			peopleList.add(p3);
		 
		}
		{
			People p4 = new People();
			p4.setID(20020004);
			p4.setName("�κ�ϼ");
			p4.setMale(false);
			p4.setAge(31);
			p4.setPosition("���񲿾���");
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

			setToolTipText("���˵�����С��30���Ա����¼");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/filter.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			label.setText("���˵�����С��30���Ա����¼���");
			tv.addFilter(ageFilter);
		}
	}

	class recoverAction extends Action {
		public recoverAction() {

			setToolTipText("�ָ�������ǰ�Ľ��");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/eclipse0.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}

		}

		public void run() {
			label.setText("�ָ�������ǰ�Ľ��");
			tv.removeFilter(ageFilter);

		}
	}

	class refreshAction extends Action {
		public refreshAction() {
			setToolTipText("ˢ�¼�¼");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/refresh.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}

		}

		public void run() {
			label.setText("ˢ�º�Ľ��");
			tv.refresh();

		}
	}

	class removeAction extends Action {
		public removeAction() {

			setToolTipText("ɾ����ѡ����м�¼");

			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/remove.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}

		}

		public void run() {
			label.setText("ɾ���Ľ��");
			table.remove(table.getSelectionIndices());

		}
	}

	// ����¼�����������˵�����С��30���Ա����¼
	class AgeFilter extends ViewerFilter {
		public boolean select(Viewer viewer, Object parent, Object element) {

			People p = (People) element;
			return p.getAge() >= 30;
		}
	}

	// �Զ����޸ı��Ԫ����
	public void modifyTableViewerCell() {
		// ����ÿһ�еı��Ԫ�༭��
		CellEditor[] editors = new CellEditor[6];
		editors[0] = null;
		editors[1] = new TextCellEditor(table);
		editors[2] = new CheckboxCellEditor(table);
		editors[3] = null;
		editors[4] = new ComboBoxCellEditor(table, Position.position,
				SWT.READ_ONLY);

		editors[5] = new ColorCellEditor(table);
		// ����������
		tv.setColumnProperties(new String[] { ID, NAME, MALE, AGE, POSITION,
				COLOR });
		// ���ñ��Ԫ���޸�
		tv.setCellModifier(new TableViewerCellModifier(tv));
		// ���õ�Ԫ��ı༭
		tv.setCellEditors(editors);
	}

	public static void main(String[] args) {
		new TableViewerFilter().run();
	}
}
