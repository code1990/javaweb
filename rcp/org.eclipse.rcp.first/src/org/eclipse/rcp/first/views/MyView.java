package org.eclipse.rcp.first.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class MyView extends ViewPart {

	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		Text text = new Text(parent, SWT.BORDER);
		text.setText("Imagine a fantastic user interface here");
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
