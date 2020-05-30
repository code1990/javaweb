/**
 *@ author: WangJinTao,MengQingChang 2006 
 */
package chapter12;

import org.eclipse.jface.viewers.*;

import org.eclipse.swt.graphics.Image;

public class AnimalLabelProvider implements ILabelProvider {

	public String getText(Object arg0) {
		return ((Animals) arg0).getAnimal();
	}

	public Image getImage(Object arg0) {
		return null;
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
