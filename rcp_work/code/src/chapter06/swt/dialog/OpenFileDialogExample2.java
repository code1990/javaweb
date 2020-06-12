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
		shell.setText("FileDialog实例");
		text = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		text.setBounds(5, 5, 365, 150);
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(210, 165, 160, 20);
		button.setText("打开型文件选择对话框");
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
		// 定义文件选择对话框，类型为打开型
		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		// 打开对话框,返回一个所选文件的路径
		String selectedOpenFile = dialog.open();
		if (selectedOpenFile != null) {
			/**
			 * java.io包的File类专门处理文件，并获取文件相关信息。
			 * File类的构造方法： 
			 * public File(String pathnames)
			 * 例如 ：File file=new(D:\my.java) 
			 * public File(File parent,String child)
			 * 例如： File file=new(parent,"my.java")
			 * parent指文件所在目录的文件对象
			 * public File(String parent,String child)
			 * 例如:File file=new(dir,"my.java") 
			 * dir指文件所在目录的字符串
			 */
			file = new File(selectedOpenFile);
			try {
				/**
				 * FileReader文件字符流，构造方法：
				 * public FileReader(File file)
				 * 例如：FileReader fileReader=new FileReader(file)
				 * public FileReader(String filenames)
				 * filenames为包含文件名的字符串
				 */
				FileReader fileReader = new FileReader(file);
				/**
				 * BufferedReader类用来把字符流的字符读入缓冲区
				 */
				BufferedReader reader = new BufferedReader(fileReader);
				/**
				 * 对Stringbuffer字符串缓冲实例化
				 */
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					/**
					 * 通过append()方法实现将字符串添加到字符缓冲区。 
					 * 也可以通过insert()方法将字符串插入缓冲区中
					 */
					sb.append(line);
					// 读入一行后自动换行
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
