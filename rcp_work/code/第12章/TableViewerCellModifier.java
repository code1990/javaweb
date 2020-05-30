/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package jfaceViewer;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class TableViewerCellModifier implements ICellModifier {
	private Viewer viewer;

	public TableViewerCellModifier(Viewer viewer) {
		this.viewer = viewer;
	}

	// 返回是否可以被修改，true为可修改
	public boolean canModify(Object element, String property) {

		return true;
	}

	// 返回列的值 ：参数element表格记录对象，property表格列属性
	public Object getValue(Object element, String property) {
		People p = (People) element;
		if (TableViewerEditorClass.ID.equals(property))
			return null;
		else if (TableViewerEditorClass.NAME.equals(property))
			return p.getName();
		else if (TableViewerEditorClass.MALE.equals(property))
			return p.getMale();
		else if (TableViewerEditorClass.AGE.equals(property))
			return null;
		else if (TableViewerEditorClass.POSITION.equals(property))
			return new Integer(0);
		else if (TableViewerEditorClass.COLOR.equals(property))
			return p.getColor();
		else
			return null;
	}

	/**
	 *  修改表格单元中的值： 参数element表格记录对象，
	 *  property表格列属性，value修改的新值
	 */
	public void modify(Object element, String property, Object value) {

		TableItem tableItem = (TableItem) element;
		People p = (People) tableItem.getData();

		if (TableViewerEditorClass.NAME.equals(property))
			p.setName((String) value);
		else if (TableViewerEditorClass.MALE.equals(property))
			p.setMale(((Boolean) value).booleanValue());

		else if (TableViewerEditorClass.POSITION.equals(property))

			p.setPosition(Position.position[(Integer) value]);

		else if (TableViewerEditorClass.COLOR.equals(property))
			p.setColor((RGB) value);

		// 修改更新
		viewer.refresh();
	}
}