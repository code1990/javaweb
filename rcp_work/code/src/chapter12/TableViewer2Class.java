/**
 * @author: WangJinTao,MengQingChang 2006
 */
package chapter12;

import java.util.*;

import org.eclipse.jface.window.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class TableViewer2Class extends ApplicationWindow {
	ArrayList peopleList;

	private TableViewer tv;

	public TableViewer2Class() {
		super(null);

	}

	public void run() {
		setBlockOnOpen(true);
		open();

		Display.getCurrent().dispose();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("TableViewerʵ��");
		shell.setSize(460, 200);
	}

	protected Control createContents(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		// �����Զ��崴����񷽷�
		createTableViewer(composite);
		// ����createPeopleList()����
		peopleList = createPeopleList();
		// ����������
		tv.setContentProvider(new PeopleContentProvider());
		// ��setInput()����������ж�������
		tv.setInput(peopleList);
		// ���ñ�ǩ��
		tv.setLabelProvider(new PeopleLabelProvider());
		return composite;
	}

	private void createTableViewer(Composite comp) {

		// ����һ��TableViewer������ʽΪ��ѡ������
		tv = new TableViewer(comp, SWT.FULL_SELECTION);

		// ����Table
		Table table = tv.getTable();

		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		// ������е���
		TableColumn Col1 = new TableColumn(table, SWT.LEFT);
		Col1.setText("Ա����");
		// �����п��
		Col1.setWidth(80);
		TableColumn Col2 = new TableColumn(table, SWT.LEFT);
		Col2.setText("����");
		Col2.setWidth(80);
		TableColumn Col3 = new TableColumn(table, SWT.LEFT);
		Col3.setText("�Ա�");
		Col3.setWidth(80);
		TableColumn Col4 = new TableColumn(table, SWT.LEFT);
		Col4.setText("����");
		Col4.setWidth(80);
		TableColumn Col5 = new TableColumn(table, SWT.LEFT);
		Col5.setText("ְλ");
		Col5.setWidth(70);
		TableColumn Col6 = new TableColumn(table, SWT.LEFT);
		Col6.setText("ϲ������ɫ");
		Col6.setWidth(128);

		// ��ʾ��ͷ
		table.setHeaderVisible(true);
		// ��ʾ�����
		table.setLinesVisible(true);

	}

	/**
	 * ArrayList�����������Vector��������������ά����ϣ�
	 * �����ڱ�Ĳ��롢ɾ��ʱʹ�á�
	 */
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
		return peopleList;
	}

	public static void main(String[] args) {
		new TableViewer2Class().run();
	}
}
