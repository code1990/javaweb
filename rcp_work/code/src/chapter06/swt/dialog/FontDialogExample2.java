package chapter06.swt.dialog;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
public class FontDialogExample2 {
	private Text text;
	public FontDialogExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(new Shell());
		shell.setSize(383, 225);
		shell.setText("FontDialog实例");
		text = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		text.setBounds(5, 5, 365, 150);
		text.setText("SWT/JFace");
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(250, 165, 120, 20);
		button.setText("字体选择对话框");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FontDialog fontdialog = new FontDialog(shell, SWT.NONE);
				fontdialog.setFontData (new FontData());
				
				FontData fontdata = fontdialog.open();
				RGB rgb = fontdialog.getRGB();
				if (fontdata != null)
				{
					text.setFont(new Font(display, fontdata));
					text.setForeground(new Color(display, rgb));
				}
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new FontDialogExample2();
	}
}
