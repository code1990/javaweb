/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

import java.net.*;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.*;
import org.eclipse.jface.window.*;
public class ExitActionClass extends Action {
	ApplicationWindow window;
	public ExitActionClass(ApplicationWindow w) {
		window = w;
		setText("退出@Ctrl+E");
		setToolTipText("退出应用程序");
		try {
			ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
					"file:icons/close.bmp"));
			setImageDescriptor(icon);
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
		}
	}
	public void run() {
		window.close();
	}
}
