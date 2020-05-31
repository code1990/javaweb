package chapter12;

import org.eclipse.jface.viewers.*;

import org.eclipse.swt.graphics.*;

/**
 * 这个类提供了表格的标签，决定了数据记录在表格的每一列如何显示
 */
public class PeopleLabelProvider implements ITableLabelProvider {

	public String getColumnText(Object element, int columnIndex) {
		People people = (People) element;
		switch (columnIndex) {
		case 0:// 第一列
			// Long转换为String
			return people.getID()+"";
		case 1:// 第二列
			return people.getName();

		case 2:// 第三列
			return people.getMale() ? "男" : "女";
		case 3:// 第四列
			return people.getAge()+"";
		case 4:// 第五列

			return people.getPosition(); 
			// return Salary.INSTANCES[people.getSalary().intValue()];
		case 5:// 第六列
			return people.getColor().toString();

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
