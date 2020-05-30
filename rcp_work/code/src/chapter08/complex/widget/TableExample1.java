/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
public class TableExample1 {
	public TableExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(410, 260);
		shell.setText("Tableʵ��");
		// shell���ó����ǲ���
		shell.setLayout(new FillLayout());
		Table table = new Table(shell, SWT.MULTI);
		// ���ñ�ͷ�ɼ�
		table.setHeaderVisible(true);
		// ���������߿ɼ�
		table.setLinesVisible(true);
		// ������е���
		TableColumn tableColumnone = new TableColumn(table, SWT.NONE);
		// ��������
		tableColumnone.setText("ѧ��");
		// ����ÿһ�еĿ��(������Ϊ��λ��
		tableColumnone.setWidth(100);
		TableColumn tableColumntwo = new TableColumn(table, SWT.NONE);
		tableColumntwo.setText("����");
		tableColumntwo.setWidth(100);
		TableColumn tableColumnthree = new TableColumn(table, SWT.NONE);
		tableColumnthree.setText("�Ա�");
		tableColumnthree.setWidth(100);
		TableColumn tableColumnfour = new TableColumn(table, SWT.NONE);
		tableColumnfour.setText("����");
		tableColumnfour.setWidth(100);
	
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new TableExample1();
	}
}
