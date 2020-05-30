/**
 *@author: WangJinTao,MengQingChang 2006 
 */
package jfaceViewer;

import java.util.*;

import org.eclipse.jface.viewers.*;

public class AnimalContentProvider implements IStructuredContentProvider {

	public Object[] getElements(Object element) {

		return ((List) element).toArray();
	}

	public void dispose() {

	}

	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

	}
}