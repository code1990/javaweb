package org.uxteam.example.crm.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class CustonmerViewPart extends ViewPart {

	public CustonmerViewPart() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		Label label = new Label(parent,SWT.NONE);
		label.setText("����һ��ViewPart �Ĳ���");
	}

	@Override
	public void setFocus() {
		
	}

}