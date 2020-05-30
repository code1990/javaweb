/**
 *@author: WangJinTao,MengQingChang2006
 */
package jfaceDialog;

import org.eclipse.jface.window.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ShowMyTitleAreaDialogClass extends ApplicationWindow {
	public ShowMyTitleAreaDialogClass() {
		super(null);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		parent.getShell().setSize(300, 100);
		parent.getShell().setText("TitleAreaDialog实例");
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		Button button = new Button(composite, SWT.PUSH);
		button.setText("显示TitleAreaDialog");
		GridData grid = new GridData(200, 25);
		grid.horizontalIndent = 40;
		grid.verticalIndent = 15;
		button.setLayoutData(grid);
		final Shell shell = parent.getShell();
		// 单击显示TitleAreaDialog
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				// 建立并显示对话框
				MyTitleAreaDialogClass dlg = new MyTitleAreaDialogClass(shell);
				dlg.open();
			}
		});
		return composite;
	}

	public static void main(String[] args) {
		new ShowMyTitleAreaDialogClass().run();
	}
}
