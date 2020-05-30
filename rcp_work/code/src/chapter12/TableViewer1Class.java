/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package chapter12;
import org.eclipse.jface.window.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


public class TableViewer1Class extends ApplicationWindow {
	public TableViewer1Class() {
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
		shell.setSize(400, 200);
	}
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		//����һ��TableViewer����
		TableViewer tv = new TableViewer(composite, SWT.FULL_SELECTION);
		// ����Table
		 Table table = tv.getTable();
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		// ������е���
		TableColumn Col1 = new TableColumn(table, SWT.LEFT);
		Col1.setText("ѧ��");
		// �����п��
		Col1.setWidth(60);
		TableColumn Col2 = new TableColumn(table, SWT.LEFT);
		Col2.setText("����");
		Col2.setWidth(60);
		TableColumn Col3 = new TableColumn(table, SWT.LEFT);
		Col3.setText("�Ա�");
		Col3.setWidth(60);
		TableColumn Col4 = new TableColumn(table, SWT.LEFT);
		Col4.setText("����");
		Col4.setWidth(60);
		TableColumn Col5 = new TableColumn(table, SWT.LEFT);
		Col5.setText("ϲ������ɫ");
		Col5.setWidth(80);
		// ��ʾ��ͷ
		table.setHeaderVisible(true);
		// ��ʾ�����
		table.setLinesVisible(true);
		return composite;
	}
	public static void main(String[] args) {
		new TableViewer1Class().run();
	}
}
