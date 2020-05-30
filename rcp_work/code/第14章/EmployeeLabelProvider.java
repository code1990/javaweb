/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package swtjfaceExample;

import org.eclipse.jface.viewers.*;

import org.eclipse.swt.graphics.*;

/**
 * 这个类提供了表格的标签，决定了数据记录在表格的每一列如何显示
 */
public class EmployeeLabelProvider implements ITableLabelProvider {

	public String getColumnText(Object element, int columnIndex) {
		Employee employee = (Employee) element;
		switch (columnIndex) {
		case 0:// 第一列

			return "" + employee.getID();

		case 1:// 第二列
			return employee.getName();

		case 2:// 第三列
			return employee.getSex();
		case 3:// 第四列
			return "" + employee.getAge();
		case 4:// 第五列

			return employee.getPosition();

		case 5:// 第六列
			return "" + employee.getSalary();

		}
		return null;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	// 以下代码为通用代码，空实现

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