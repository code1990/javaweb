/**@author WangJinTao,MengQingChang 2006
 */
package swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
public class FontDialogExample1 {
	public FontDialogExample1() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		FontDialog fontdialog = new FontDialog(shell, SWT.NONE);
		fontdialog.setFontData (new FontData("ËÎÌו", 14, SWT.BOLD | SWT.ITALIC));
		fontdialog.setRGB(new RGB(255, 0, 0));
		FontData fontdata = fontdialog.open();
		if (fontdata != null) {
			System.out.println(fontdata.getName());
			System.out.println(fontdata.getStyle());
			System.out.println(fontdata.getHeight());
			System.out.println(fontdata.getClass());
		}
		 
	}
	public static void main(String[] args) {
		new FontDialogExample1();
	}
}
