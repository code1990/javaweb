package org.salever.rcp.tech.chapter6.editor;

import org.eclipse.swt.layout.GridLayout;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class SampleEditor extends EditorPart {

	public static final String ID = "org.salever.rcp.tech.chapter6.editor1";
	private Text text;

	public SampleEditor() {
	}

	public void doSave(IProgressMonitor monitor) {

	}

	public void doSaveAs() {

	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// 非常重要，必须实现这个方法
		setSite(site);
		setInput(input);
		setPartName(input.getName());
	}

	public boolean isDirty() {
		return false;
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		Label lblClickAt = new Label(composite, SWT.NONE);
		lblClickAt.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblClickAt.setText("Click At");
		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		// 设置内容
		text.setText(getEditorInput().getName());

	}

	public void setFocus() {
		text.setFocus();
	}

}
