/**
*@author: WangJinTao,MengQingChang2006
*/
package jfaceDialog;


import org.eclipse.swt.widgets.Shell;

public class ShowCustomDialogClass {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		
		final Shell shell = new Shell();
		
		CustomDialogClass dialog=new CustomDialogClass(shell);
		dialog.open();

	
	}

}

