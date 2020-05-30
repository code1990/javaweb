/**@author WangJinTao,MengQingChang 2006
 */
package chapter04.basic.widget;
 
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.jface.dialogs.*;
public class TextExample {
	public TextExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(370, 235);
		shell.setText("Text�ۺ�ʵ��");
		final Label label1 = new Label(shell, SWT.NONE);
		label1.setBounds(25, 25, 60, 25);
		label1.setText("User Name:");
		final Text text1 = new Text(shell, SWT.BORDER);
		text1.setBounds(90, 20, 80, 20);
        // �����ͣ���ڸ��ı���ʱ��������ʾ��Ϣ
		text1.setToolTipText("�ı����Ϊ��");
		
		final Label labe2 = new Label(shell, SWT.NONE);
		labe2.setBounds(190, 25, 55, 25);
		labe2.setText("PassWord:");
		final Text text2 = new Text(shell, SWT.PASSWORD | SWT.BORDER);
		text2.setBounds(250, 20, 80, 20);
        // setTextLimit(int x)Ϊ����������������������ı���������������ַ�����
		text2.setTextLimit(8);
		
		text2.setToolTipText("�ı����Ϊ��,�����벻����8λ����");
		final Text text3 = new Text(shell, SWT.V_SCROLL | SWT.H_SCROLL
				| SWT.BORDER);
		text3.setBounds(50, 55, 250, 90);
		final Button button1 = new Button(shell, SWT.NONE);
		button1.setBounds(140, 160, 80, 20);
		button1.setText("OK");
		button1.setToolTipText("����OK��ť��������ʾ��������ı���");
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String AD = text1.getText();// ���������ı����ݡ�
				String BD = text2.getText();
                // �ж������ı��Ƿ�Ϊ��
				if (AD == null || AD.equals("") || BD == null || BD.equals(""))
				
				{
					MessageDialog.openInformation(shell, " ��Ϣ��ʾ", "ʧ����Ϣ��"
					+ '\n' + '\n' + "  ע�⣺�ı����Ϊ�գ�������������������");
				} else
					text3.append("User Name: " + '\n' + "" + AD + '\n'
							+ "PassWord:" + '\n' + "" + BD);
				/**
				 * append���������������ı�������ʾ���ݡ�
				 *  ��append()������Ϊinsert()�����ɴﵽͬ����Ч��
				 */
			}
		});
		final Button button2 = new Button(shell, SWT.NONE);
		button2.setBounds(250, 160, 80, 20);
		button2.setText("Cancel");
		button2.setToolTipText("����Cancel��ť������ı��е�����");
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				text1.setText("");// ����ı����ݷ���
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
