/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package chapter12;

import org.eclipse.jface.viewers.*;

import org.eclipse.swt.graphics.*;

/**
 * ������ṩ�˱��ı�ǩ�����������ݼ�¼�ڱ���ÿһ�������ʾ
 */
public class PeopleLabelProvider implements ITableLabelProvider {

	public String getColumnText(Object element, int columnIndex) {
		People people = (People) element;
		switch (columnIndex) {
		case 0:// ��һ��
			// Longת��ΪString
			return people.getID().toString();
		case 1:// �ڶ���
			return people.getName();

		case 2:// ������
			return people.getMale() ? "��" : "Ů";
		case 3:// ������
			return people.getAge().toString();
		case 4:// ������

			return people.getPosition(); 
			// return Salary.INSTANCES[people.getSalary().intValue()];
		case 5:// ������
			return people.getColor().toString();

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