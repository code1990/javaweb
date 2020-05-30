/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;


import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.printing.*;



public class PrintDialogExample {

	public PrintDialogExample () {

		final Display display = new Display();
		final Shell shell = new Shell(display);
		PrintDialog printdialog = new PrintDialog(shell);
		printdialog.setStartPage(1);
		printdialog.setEndPage(15);

		PrinterData printerdata = printdialog.open();
		if (printerdata != null) { 
			System.out.println(printerdata.startPage);
		}
	}
       
	public static void main(String[] args) {
		new PrintDialogExample ();
	}
}
