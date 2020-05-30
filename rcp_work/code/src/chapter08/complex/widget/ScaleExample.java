/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;

public class ScaleExample {
	private Label label;

	private Scale scale;

	private Text text;

	public ScaleExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(new Shell());
		shell.setText("Scaleʵ��");
		shell.setSize(180, 260);
		shell.setLayout(new GridLayout(3, true));
		{
			label = new Label(shell, SWT.NONE);
			label.setText("����:");
			GridData gridlabel = new GridData();
			gridlabel.horizontalSpan = 3;
			gridlabel.horizontalIndent = 30;
			label.setLayoutData(gridlabel);
		}
		{
			scale = new Scale(shell, SWT.VERTICAL);
			GridData gridscale = new GridData();
			gridscale.horizontalSpan = 3;
			gridscale.horizontalIndent = 60;
			scale.setLayoutData(gridscale);
			scale.setMinimum(0);
			scale.setMaximum(100);
			scale.setIncrement(1);
			scale.setSelection(20);
			scale.setPageIncrement(5);
			scale.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					int Value = scale.getMaximum() - scale.getSelection();
					text.setText("����ֵ:" + Value);
				}
			});
		}
		{
			text = new Text(shell, SWT.BORDER | SWT.SINGLE);
			GridData gridtext = new GridData();
			gridtext.horizontalSpan = 3;
			gridtext.horizontalIndent = 45;
			text.setLayoutData(gridtext);
			text.setEditable(false);
		}
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new ScaleExample();
	}
}
