/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package chapter14;

import org.eclipse.jface.viewers.*;

import org.eclipse.swt.graphics.*;

/**
 * ������ṩ�˱��ı�ǩ�����������ݼ�¼�ڱ���ÿһ�������ʾ
 */
public class EmployeeLabelProvider implements ITableLabelProvider {

	public String getColumnText(Object element, int columnIndex) {
		Employee employee = (Employee) element;
		switch (columnIndex) {
		case 0:// ��һ��

			return "" + employee.getID();

		case 1:// �ڶ���
			return employee.getName();

		case 2:// ������
			return employee.getSex();
		case 3:// ������
			return "" + employee.getAge();
		case 4:// ������

			return employee.getPosition();

		case 5:// ������
			return "" + employee.getSalary();

		}
		return null;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	// ���´���Ϊͨ�ô��룬��ʵ��

	public void addListener(ILabelProviderListener listener) {

	}

	public void dispose() {

	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {

	}
}