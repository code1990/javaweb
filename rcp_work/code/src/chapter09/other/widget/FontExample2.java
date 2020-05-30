/**@author WangJinTao,MengQingChang 2006
 */
package chapter09.other.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;

public class FontExample2 {
	private Text Editortext;

	private Combo combo;

	public FontExample2() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(400, 260);
		shell.setText("Fontʵ��");
		shell.setLayout(new GridLayout(3, false));
		Editortext = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);
		GridData gridEditortext = new GridData();
		// ˮƽǿռ2��
		gridEditortext.horizontalSpan = 2;
		// ����Editortext�ı����Ϊ250������
		gridEditortext.widthHint = 250;
		// ����Editortext�ı��߶�Ϊ195������
		gridEditortext.heightHint = 195;
		Editortext.setLayoutData(gridEditortext);

		Composite composite = new Composite(shell, SWT.NONE);
		// ��������ó�Ϊ˫�����
		GridData gridcomposite = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gridcomposite);
		// Composite��������ʽ����
		composite.setLayout(new GridLayout());
		// �����ǩ
		Label label = new Label(composite, SWT.NONE);
		label.setText("�������ֺŴ�С:");
		// ���������򣬸�����������Ϊֻ������
		combo = new Combo(composite, SWT.READ_ONLY);
		// ����������
		combo.setItems(new String[] { "7", "8", "9", "10", "12", "14", "16",
				"18", "20", "22", "24", "26", "28", "36", "48", "72" });
		GridData gridcombo = new GridData();
		gridcombo.widthHint = 60;
		combo.setLayoutData(gridcombo);

		Button button = new Button(composite, SWT.NONE);
		button.setText("ȷ��");
		GridData gridbutton = new GridData();
		gridbutton.widthHint = 80;
		gridbutton.horizontalIndent = 5;
		gridbutton.verticalIndent = 60;
		button.setLayoutData(gridbutton);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String getText = combo.getText();
				if (getText == null || getText.equals("")) {
					MessageBox messageBox = new MessageBox(shell,
							SWT.ICON_INFORMATION | SWT.OK);
					messageBox.setMessage("�ı����ݲ���Ϊ��" + '\n'
							+ "������������ѡ��Ҫ���õ��ֺ�!!!");
					messageBox.open();
				} else {//����ȡ���ı�����String����ת��ΪInt
					final int intStr = new Integer(getText).intValue();
					Font initialFont = Editortext.getFont();
					FontData[] fontData = initialFont.getFontData();
					for (int i = 0; i < fontData.length; i++) {
						fontData[i].setHeight(intStr);
					}
					// ����һ���������
					Font newFont = new Font(display, fontData);
					// ���ı�����������
					Editortext.setFont(newFont);
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
		new FontExample2();
	}
}
