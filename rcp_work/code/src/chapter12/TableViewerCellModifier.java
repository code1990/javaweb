/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package chapter12;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class TableViewerCellModifier implements ICellModifier {
	private Viewer viewer;

	public TableViewerCellModifier(Viewer viewer) {
		this.viewer = viewer;
	}

	// �����Ƿ���Ա��޸ģ�trueΪ���޸�
	public boolean canModify(Object element, String property) {

		return true;
	}

	// �����е�ֵ ������element����¼����property���������
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
	 *  �޸ı��Ԫ�е�ֵ�� ����element����¼����
	 *  property��������ԣ�value�޸ĵ���ֵ
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

		// �޸ĸ���
		viewer.refresh();
	}
}