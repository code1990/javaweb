/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter14;

import java.io.*;
import java.net.*;
import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.jface.action.*;
import org.eclipse.jface.resource.*;
import org.eclipse.jface.window.*;

public class TextEditorExample extends ApplicationWindow {
	private StyledText text;

	private Action newCreate;

	private Action openFile;

	private Action saveFile;

	private Action saveAsFile;

	private Action exit;

	private Action copyFile;

	private Action pasteFile;

	private Action cutFile;

	private Action setFont;

	private Action setColor;

	private Action selectAll;

	private Action formate;

	private Action about;

	private Font font;

	private File file;

	private Color color;

	private StyleRange style, range;

	boolean changes;;

	TextEditorExample() {
		// ���𴰿�
		super(null);
		newCreate = new NewCreateAction();
		openFile = new OpenFileAction();
		saveFile = new SaveFileAction();
		saveAsFile = new SaveAsFileAction();
		exit = new ExitAction();
		copyFile = new CopyFileAction();
		pasteFile = new PasteFileAction();
		cutFile = new CutFileAction();
		setFont = new SetFontAction();
		setColor = new SetColorAction();
		selectAll = new SelectAllAction();
		formate = new FormateAction();
		about = new AboutAction();

		addMenuBar();
		addToolBar(SWT.FLAT);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	public Control createContents(Composite parent) {
		// ���ô����С
		parent.getShell().setSize(520, 370);
		// ���ô������
		parent.getShell().setText("TextEditorʵ��");
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, true));
		text = new StyledText(composite, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		text.setLayoutData(new GridData(GridData.FILL_BOTH));
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				changes = true;
			}
		});
		return composite;
	}

	protected MenuManager createMenuManager() {
		MenuManager menuBar = new MenuManager();
		MenuManager fileMenu = new MenuManager("�ļ�(&F)");
		MenuManager editorMenu = new MenuManager("�༭(&E)");
		MenuManager helpMenu = new MenuManager("����(&H)");
		// ���ļ��˵�����������˵�
		fileMenu.add(newCreate);
		fileMenu.add(openFile);
		fileMenu.add(new Separator());
		fileMenu.add(saveFile);
		fileMenu.add(saveAsFile);
		fileMenu.add(new Separator());
		fileMenu.add(exit);
		// �ڱ༭�˵�����������˵�
		editorMenu.add(copyFile);
		editorMenu.add(pasteFile);
		editorMenu.add(cutFile);
		editorMenu.add(new Separator());
		editorMenu.add(setFont);
		editorMenu.add(setColor);
		editorMenu.add(new Separator());
		editorMenu.add(selectAll);
		editorMenu.add(formate);
		helpMenu.add(about);
		// ��menuBar������ļ��˵����༭�˵��Ͱ����˵�
		menuBar.add(fileMenu);
		menuBar.add(editorMenu);
		menuBar.add(helpMenu);
		return menuBar;
	}

	// �ڹ���������ӹ�������ť
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		toolBarManager.add(new NewCreateAction());
		toolBarManager.add(new OpenFileAction());
		toolBarManager.add(new SaveFileAction());
		toolBarManager.add(new Separator());
		toolBarManager.add(new CopyFileAction());
		toolBarManager.add(new PasteFileAction());
		toolBarManager.add(new CutFileAction());
		toolBarManager.add(new Separator());
		toolBarManager.add(new BlodAction());
		toolBarManager.add(new ItalicAction());
		toolBarManager.add(new UnderlineAction());
		return toolBarManager;
	}

	class NewCreateAction extends Action {
		public NewCreateAction() {
			super("NewCreateAction@Ctrl+N", Action.AS_PUSH_BUTTON);
			setText("�½�");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/new.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			// ���½��ı�֮ǰ���жϵ�ǰ�ı��Ƿ���Ҫ����
			if (judgeTextSave()) {
				text.setText("");
			}
		}
	}

	class OpenFileAction extends Action {
		public OpenFileAction() {
			super("OpenFileAction@Ctrl+O", Action.AS_PUSH_BUTTON);
			setText("��");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/open.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			// �ڴ��µ��ļ�֮ǰ���ж��Ƿ񱣴浱ǰ�ļ�
			if (judgeTextSave())
				OpenTextFile();
		}
	}

	class SaveFileAction extends Action {
		public SaveFileAction() {
			super("SaveFileAction@Ctrl+S", Action.AS_PUSH_BUTTON);
			setText("����");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/save.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			saveTextFile();
		}
	}

	class SaveAsFileAction extends Action {
		public SaveAsFileAction() {
			super("���Ϊ@Ctrl+A", Action.AS_PUSH_BUTTON);
		}

		public void run() {
			saveFileAs();
		}
	}

	class ExitAction extends Action {
		public ExitAction() {
			super("�˳�@Ctrl+E", Action.AS_PUSH_BUTTON);
		}

		public void run() {
			getShell().dispose();
		}
	}

	class CopyFileAction extends Action {
		public CopyFileAction() {
			super("CopyFileAction@Ctrl+C", Action.AS_PUSH_BUTTON);
			setText("����");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/copy.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			text.copy();
		}
	}

	class PasteFileAction extends Action {
		public PasteFileAction() {
			super("PasteFileAction@Ctrl+V", Action.AS_PUSH_BUTTON);
			setText("ճ��");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/paste.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			text.paste();
		}
	}

	class CutFileAction extends Action {
		public CutFileAction() {
			super("CutFileAction @Ctrl+X", Action.AS_PUSH_BUTTON);
			setText("����");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/cut.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			 text.cut();
		 
		}
	}

	class SetFontAction extends Action {
		public SetFontAction() {
			super("��������@Alt+F", Action.AS_PUSH_BUTTON);
		}

		public void run() {
			FontDialog fontDialog = new FontDialog(getShell());
			fontDialog.setFontList((text.getFont()).getFontData());
			FontData fontData = fontDialog.open();

			if (fontData != null) {
				if (font != null) {
					font.dispose();
				}
				font = new Font(getShell().getDisplay(), fontData);
				text.setFont(font);

			}
		}
	}

	class SetColorAction extends Action {
		public SetColorAction() {
			super("������ɫ@Alt+C", Action.AS_PUSH_BUTTON);
		}

		public void run() {
			// ������ɫѡ��Ի���
			ColorDialog dlg = new ColorDialog(getShell());
			// �򿪶Ի���
			RGB rgb = dlg.open();
			if (rgb != null) {
				// ����color����
				color = new Color(getShell().getDisplay(), rgb);
				// ����point���󣬻�ȡѡ��Χ��
				Point point = text.getSelectionRange();
				for (int i = point.x; i < point.x + point.y; i++) {
					// ���ѡ�е�������ʽ�ͷ�Χ
					range = text.getStyleRangeAtOffset(i);
					// �������������������ʽ(��Ӵ֡�б�塢���»���)
					if (range != null) {
				 		/**
						 * ����һ����ԭ��StyleRange��ֵ��ͬ��StyleRange
						 */
						 style = (StyleRange) range.clone();
						 style.start = i;
						 style.length = 1;
						// ����ǰ����ɫ
						 style.foreground = color;
					} else {
						
						style = new StyleRange(i, 1, color, null, SWT.NORMAL);
					}
					text.setStyleRange(style);
				}

			}
		}
	}

	class SelectAllAction extends Action {
		public SelectAllAction() {
			super("ȫѡ@Alt+A", Action.AS_PUSH_BUTTON);
		}

		public void run() {
			text.selectAll();
			
		}
	}

	class FormateAction extends Action {
		public FormateAction() {
			super("��ʽ��@Ctrl+W", Action.AS_CHECK_BOX);
		}

		public void run() {
			text.setWordWrap(isChecked());
		}
	}

	class AboutAction extends Action {
		public AboutAction() {
			super("����@Ctrl+H", Action.AS_PUSH_BUTTON);
		}

		public void run() {
			MessageBox messageBox = new MessageBox(getShell(),
					SWT.ICON_INFORMATION | SWT.OK);
			messageBox.setMessage("�ı��༭��2.0�汾��");
			messageBox.open();
		}
	}

	class BlodAction extends Action {
		public BlodAction() {
			setText("�Ӵ�");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/blod.bmp"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			Point point= text.getSelectionRange();
			for (int i = point.x; i < point.x + point.y; i++) {
				StyleRange range = text.getStyleRangeAtOffset(i);
				if (range != null) {
					style = (StyleRange) range.clone();
					style.start = i;
					style.length = 1;
				} else {
					style = new StyleRange(i, 1, null, null, SWT.NORMAL);
				}
				
				//�Ӵ�����
				style.fontStyle ^= SWT.BOLD;

				text.setStyleRange(style);

			}
		}

	}

	class ItalicAction extends Action {
		public ItalicAction() {
			setText("б��");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/italic.bmp"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			
			Point point = text.getSelectionRange();

			for (int i = point.x; i < point.x + point.y; i++) {
			   range = text.getStyleRangeAtOffset(i);
				if (range != null) {
				style = (StyleRange) range.clone();
					style.start = i;
					style.length = 1;
				} else {
					style = new StyleRange(i, 1, null, null, SWT.NORMAL);
				}
				//����Ϊб��
				style.fontStyle ^= SWT.ITALIC;

				text.setStyleRange(style);

			}
		}

	}

	class UnderlineAction extends Action {
		public UnderlineAction() {
			setText("�»���");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/underline.bmp"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			Point point = text.getSelectionRange();
			for (int i = point.x; i < point.x + point.y; i++) {
				 range = text.getStyleRangeAtOffset(i);
				if (range != null) {
					style = (StyleRange) range.clone();
					style.start = i;
					style.length = 1;
				} else {
					style = new StyleRange(i, 1, null, null, SWT.NORMAL);
				}
                //�����»���
				style.underline = !style.underline;

				text.setStyleRange(style);

			}
		}

	}

	boolean judgeTextSave() {
		if (!changes)
			return true;
		MessageBox messageBox = new MessageBox(getShell(), SWT.ICON_WARNING
				| SWT.YES | SWT.NO | SWT.CANCEL);
		messageBox.setMessage("�Ƿ񱣴���ļ��ĸ��ģ�");
		messageBox.setText("�ı��༭��V2.0");
		int message = messageBox.open();
		if (message == SWT.YES) {
			return saveTextFile();
		} else if (message == SWT.NO) {
			return true;
		} else {
			return false;
		}
	}

	boolean OpenTextFile() {
		// ����Ի�������Ϊ����
		FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
		// ���öԻ���򿪵��޶�����
		dialog.setFilterExtensions(new String[] { "*.txt", "*.*" });
		// �򿪶Ի��򣬲����ش��ļ���·��
		String openFile = dialog.open();
		if (openFile == null) {
			return false;
		}
		/**
		 * java.io����File��ר�Ŵ����ļ�������ȡ�ļ������Ϣ��
		 * File��Ĺ��췽���� public File(String pathnames)
		 * ���� ��File file=new(D:\my.java)
		 * public File(File parent,String child)
		 * ���磺 File file=new(parent,"my.java")
		 * parentָ�ļ�����Ŀ¼���ļ����� 
		 * public File(String parent,String child) 
		 * ����:File file=new(dir,"my.java")
		 * dirָ�ļ�����Ŀ¼���ַ���
		 */
		file = new File(openFile);
		try {
			/**
			 * FileReader�ļ��ַ��� 
			 * ���췽���� public FileReader(File file)
			 * ���磺FileReader fileReade=new FileReader(file) 
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
				sb.append("\r\n");
			}
			text.setText(sb.toString());
			return true;
		} catch (IOException e) {
		}
		return false;
	}

	boolean saveTextFile() {
		if (file == null) {
			// �����ļ�ѡ��Ի�������Ϊ������
			FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
			dialog.setText("����");
			// ���öԻ��򱣴���޶�����
			dialog.setFilterExtensions(new String[] { "*.txt", "*.doc",
					"*.xls", "*.*" });
			// �򿪶Ի��򣬲����ر����ļ���·��
			String saveFile = dialog.open();
			if (saveFile == null) {
				return false;
			}
			file = new File(saveFile);
		}
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(text.getText());
			writer.close();
			changes = false;
			return true;
		} catch (IOException e) {
		}
		return false;
	}

	boolean saveFileAs() {
		SafeSaveDialog dlg = new SafeSaveDialog(getShell());
		String temp = dlg.open();
		if (temp == null) {
			return false;
		}
		file = new File(temp);
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(text.getText());
			writer.close();
		} catch (IOException e) {
		}
		return false;
	}

	class SafeSaveDialog {
		private FileDialog dlg;

		public SafeSaveDialog(Shell shell) {
			dlg = new FileDialog(shell, SWT.SAVE);
			dlg.setFilterExtensions(new String[] { "*.txt", "*.doc", "*.xls",
					"*.*" });
		}

		public String open() {
			String fileName = null;
			boolean done = false;
			while (!done) {
				// �����Ϊ�Ի��򣬲����ر���·��
				fileName = dlg.open();
				if (fileName == null) {
					done = true;
				} else {
					// �жϱ�����ļ��Ƿ��Ѿ�����
					File file = new File(fileName);
					if (file.exists()) {
						// ���ļ����ڣ��򵯳���ʾ�ԵĶԻ���
						MessageBox mb = new MessageBox(dlg.getParent(),
								SWT.ICON_WARNING | SWT.YES | SWT.NO);
						// ��ʾ�Ե���Ϣ
						mb.setMessage(fileName + "�Ѿ����ڣ��Ƿ񽫸��ļ��滻?");
						/**
						 * ������yes����ť�⽫�����ϵ��ļ��滻 
						 * ����������д�ļ���
						 */
						done = mb.open() == SWT.YES;
					} else {
						done = true;
					}
				}
			}
			return fileName;
		}
	}

	public static void main(String[] args) {
		new TextEditorExample().run();
	}
}
