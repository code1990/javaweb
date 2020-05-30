/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter12;

import java.net.*;

import org.eclipse.jface.action.*;
import org.eclipse.jface.resource.*;

import org.eclipse.jface.text.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;

import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class UndoRedoOperateExample extends ApplicationWindow {

	private TextViewer tv;

	private IUndoManager undoManager;

	private Action undoAction;

	private Action redoAction;

	public UndoRedoOperateExample() {
		super(null);
		undoAction = new UndoAction();
		redoAction = new RedoAction();
		addMenuBar();
		addToolBar(SWT.FLAT);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		getShell().setText("UndoRedoʵ��");

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());

		tv = new TextViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		Document doc = new Document();
		tv.setDocument(doc);
		// /���Գ���1000���Ĳ���
		undoManager = new DefaultUndoManager(1000);
		// ��text������IUndoManager����
		tv.setUndoManager(undoManager);
		undoManager.connect(tv);

		tv.getTextWidget().addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				// ʹ�������������һ���ַ���ʼ��һ���ַ�һ���ַ��ĳ���
				undoManager.endCompoundChange();
				/**
				 * ��undoManager.beginCompoundChange()���� ��������ֱ�ӳ������ı���ʼ��
				 */

			}
		});

		return container;
	}

	protected MenuManager createMenuManager() {
		MenuManager menubar = new MenuManager();
		MenuManager editMenu = new MenuManager("�༭(&E)");

		editMenu.add(undoAction);
		editMenu.add(redoAction);
		menubar.add(editMenu);
		return menubar;
	}

	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		toolBarManager.add(new UndoAction());
		toolBarManager.add(new RedoAction());

		return toolBarManager;
	}

	class UndoAction extends Action {
		public UndoAction() {
			super("����(&U)����@Ctrl+Z", Action.AS_PUSH_BUTTON);
			setToolTipText("ȡ������");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/undo.bmp"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {

			undoManager.undo();
			
			/**
			 * tv.doOperation(ITextOperationTarget.UNDO);
			 *ִ��Ŀ�������ITextOperation�ӿ����������ı�Ŀ�����
			 */ 
		}
	}

	class RedoAction extends Action {
		public RedoAction() {
			super("&�ָ�(&R)����@Ctrl+R", Action.AS_PUSH_BUTTON);
			setToolTipText("�ָ�����");
			try {
				// ����ͼ��
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/redo.bmp"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			// tv.doOperation(ITextOperationTarget.REDO);
			undoManager.redo();
		}
	}

	public static void main(String[] args) {
		new UndoRedoOperateExample().run();

	}

}