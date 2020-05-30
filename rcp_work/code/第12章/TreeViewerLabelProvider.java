/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package jfaceViewer;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.*;

public class TreeViewerLabelProvider implements ILabelProvider {
	public Image getImage(Object element) {
		return null;
	}

	public String getText(Object element) {
		Entity person = (Entity) element;
		return person.entityName;
	}
	public void addListener(ILabelProviderListener arg0) {

	}

	public void dispose() {

	}

	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	public void removeListener(ILabelProviderListener arg0) {

	}
}
