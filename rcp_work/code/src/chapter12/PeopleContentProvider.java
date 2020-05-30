/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package chapter12;

import java.util.List;

import org.eclipse.jface.viewers.*;

// ͨ��IStructuredContentProvider�ӿ�ʵ��
public class PeopleContentProvider implements IStructuredContentProvider {
	/**
	 * ����People����
	 */
	public Object[] getElements(Object inputElement) {
		return ((List) inputElement).toArray();
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}
}