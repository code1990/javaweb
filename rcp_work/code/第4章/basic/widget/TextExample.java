/**@author WangJinTao,MengQingChang 2006
 */
package basic.widget;
 
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.jface.dialogs.*;
public class TextExample {
	public TextExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(370, 235);
		shell.setText("Text综合实例");
		final Label label1 = new Label(shell, SWT.NONE);
		label1.setBounds(25, 25, 60, 25);
		label1.setText("User Name:");
		final Text text1 = new Text(shell, SWT.BORDER);
		text1.setBounds(90, 20, 80, 20);
        // 当鼠标停留在该文本框时将出现提示信息
		text1.setToolTipText("文本项不能为空");
		
		final Label labe2 = new Label(shell, SWT.NONE);
		labe2.setBounds(190, 25, 55, 25);
		labe2.setText("PassWord:");
		final Text text2 = new Text(shell, SWT.PASSWORD | SWT.BORDER);
		text2.setBounds(250, 20, 80, 20);
        // setTextLimit(int x)为常用组件方法，用来设置文本框中最多可输入的字符数。
		text2.setTextLimit(8);
		
		text2.setToolTipText("文本项不能为空,且输入不超过8位密码");
		final Text text3 = new Text(shell, SWT.V_SCROLL | SWT.H_SCROLL
				| SWT.BORDER);
		text3.setBounds(50, 55, 250, 90);
		final Button button1 = new Button(shell, SWT.NONE);
		button1.setBounds(140, 160, 80, 20);
		button1.setText("OK");
		button1.setToolTipText("单击OK按钮姓名将显示在下面的文本中");
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String AD = text1.getText();// 获得输入的文本内容。
				String BD = text2.getText();
                // 判断输入文本是否为空
				if (AD == null || AD.equals("") || BD == null || BD.equals(""))
				
				{
					MessageDialog.openInformation(shell, " 信息提示", "失败信息！"
					+ '\n' + '\n' + "  注意：文本项不能为空！！！！。。。。。。");
				} else
					text3.append("User Name: " + '\n' + "" + AD + '\n'
							+ "PassWord:" + '\n' + "" + BD);
				/**
				 * append（）方法用来在文本框中显示内容。
				 *  将append()方法改为insert()方法可达到同样的效果
				 */
			}
		});
		final Button button2 = new Button(shell, SWT.NONE);
		button2.setBounds(250, 160, 80, 20);
		button2.setText("Cancel");
		button2.setToolTipText("单击Cancel按钮将清除文本中的内容");
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				text1.setText("");// 清除文本内容方法
				text2.setText("");
				text3.setText("");
				
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
		new TextExample();
	}
}
