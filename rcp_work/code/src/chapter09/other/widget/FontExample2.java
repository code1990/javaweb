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
		shell.setText("Font实例");
		shell.setLayout(new GridLayout(3, false));
		Editortext = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);
		GridData gridEditortext = new GridData();
		// 水平强占2列
		gridEditortext.horizontalSpan = 2;
		// 设置Editortext文本宽度为250个像素
		gridEditortext.widthHint = 250;
		// 设置Editortext文本高度为195个像素
		gridEditortext.heightHint = 195;
		Editortext.setLayoutData(gridEditortext);

		Composite composite = new Composite(shell, SWT.NONE);
		// 将面板设置成为双向充满
		GridData gridcomposite = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gridcomposite);
		// Composite采用网格式布局
		composite.setLayout(new GridLayout());
		// 定义标签
		Label label = new Label(composite, SWT.NONE);
		label.setText("请设置字号大小:");
		// 定义下拉框，该下拉框设置为只读类型
		combo = new Combo(composite, SWT.READ_ONLY);
		// 设置下拉项
		combo.setItems(new String[] { "7", "8", "9", "10", "12", "14", "16",
				"18", "20", "22", "24", "26", "28", "36", "48", "72" });
		GridData gridcombo = new GridData();
		gridcombo.widthHint = 60;
		combo.setLayoutData(gridcombo);

		Button button = new Button(composite, SWT.NONE);
		button.setText("确定");
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
					messageBox.setMessage("文本内容不能为空" + '\n'
							+ "请在下拉框中选择要设置的字号!!!");
					messageBox.open();
				} else {//将获取的文本内容String类型转换为Int
					final int intStr = new Integer(getText).intValue();
					Font initialFont = Editortext.getFont();
					FontData[] fontData = initialFont.getFontData();
					for (int i = 0; i < fontData.length; i++) {
						fontData[i].setHeight(intStr);
					}
					// 定义一个字体对象
					Font newFont = new Font(display, fontData);
					// 在文本上设置字体
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
