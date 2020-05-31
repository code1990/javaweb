/**
*@author: WangJinTao,MengQingChang2006
*/
package chapter11;

import org.eclipse.jface.wizard.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
public class WizardPageTwo extends WizardPage {
	private Text textComment;
	private GridData grid;
	protected WizardPageTwo() {
		super("");
		setTitle("��������");
		setMessage("����ʵ��д������");
		setPageComplete(true);
	}
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(1, false));
		new Label(comp, SWT.NONE).setText("�������ۣ�");
		textComment = new Text(comp, SWT.BORDER );
		grid = new GridData(GridData.FILL_HORIZONTAL);
		textComment.setLayoutData(grid);
		setControl(comp);
	}
	public String getComment() {
		return textComment.getText();
	}
}
