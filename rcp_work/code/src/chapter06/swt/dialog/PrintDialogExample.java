package chapter06.swt.dialog;


import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;



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
