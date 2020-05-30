/**@author WangJinTao,MengQingChang 2006
 */
package chapter06.swt.dialog;

import java.io.*;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
public class OpenFileDialogExample2 {
	private Text text;
	private File file;
    private Shell shell;
	public OpenFileDialogExample2() {
		final Display display = Display.getDefault();
		shell = new Shell(new Shell());
		shell.setSize(383, 225);
		shell.setText("FileDialogʵ��");
		text = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		text.setBounds(5, 5, 365, 150);
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(210, 165, 160, 20);
		button.setText("�����ļ�ѡ��Ի���");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				OpenTextFile();
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	boolean OpenTextFile() {
		// �����ļ�ѡ��Ի�������Ϊ����
		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		// �򿪶Ի���,����һ����ѡ�ļ���·��
		String selectedOpenFile = dialog.open();
		if (selectedOpenFile != null) {
			/**
			 * java.io����File��ר�Ŵ����ļ�������ȡ�ļ������Ϣ��
			 * File��Ĺ��췽���� 
			 * public File(String pathnames)
			 * ���� ��File file=new(D:\my.java) 
			 * public File(File parent,String child)
			 * ���磺 File file=new(parent,"my.java")
			 * parentָ�ļ�����Ŀ¼���ļ�����
			 * public File(String parent,String child)
			 * ����:File file=new(dir,"my.java") 
			 * dirָ�ļ�����Ŀ¼���ַ���
			 */
			file = new File(selectedOpenFile);
			try {
				/**
				 * FileReader�ļ��ַ��������췽����
				 * public FileReader(File file)
				 * ���磺FileReader fileReader=new FileReader(file)
				 * public FileReader(String filenames)
				 * filenamesΪ�����ļ������ַ���
				 */
				FileReader fileReader = new FileReader(file);
				/**
				 * BufferedReader���������ַ������ַ����뻺����
				 */
				BufferedReader reader = new BufferedReader(fileReader);
				/**
				 * ��Stringbuffer�ַ�������ʵ����
				 */
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					/**
					 * ͨ��append()����ʵ�ֽ��ַ�����ӵ��ַ��������� 
					 * Ҳ����ͨ��insert()�������ַ������뻺������
					 */
					sb.append(line);
					// ����һ�к��Զ�����
					sb.append("\r\n");
				}
				text.setText(sb.toString());
				fileReader.close();
				return true;
			} catch (IOException e) {
			}
		}
		return false;
	}
	public static void main(String[] args) {
		new OpenFileDialogExample2();
	}
}
