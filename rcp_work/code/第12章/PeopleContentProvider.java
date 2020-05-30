/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package jfaceViewer;

import java.util.List;

import org.eclipse.jface.viewers.*;

// 通过IStructuredContentProvider接口实现
public class PeopleContentProvider implements IStructuredContentProvider {
	/**
	 * 返回People对象
	 */
	public Object[] getElements(Object inputElement) {
		return ((List) inputElement).toArray();
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}
}