/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package swtjfaceExample;

import java.util.List;

import org.eclipse.jface.viewers.*;

// 通过IStructuredContentProvider接口实现
public class EmployeeContentProvider implements IStructuredContentProvider {

	public Object[] getElements(Object inputElement) {
		return ((List) inputElement).toArray();
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}
}