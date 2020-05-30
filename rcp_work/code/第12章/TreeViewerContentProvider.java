/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package jfaceViewer;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class TreeViewerContentProvider extends ArrayContentProvider implements
		ITreeContentProvider {

	public Object[] getChildren(Object parentElement) {
		Entity person = (Entity) parentElement;
		return person.children;
	}

	public Object getParent(Object element) {
		Entity person = (Entity) element;
		return person.parent;
	}

	public boolean hasChildren(Object element) {
		Entity person = (Entity) element;
		return person.children.length > 0;
	}
}
