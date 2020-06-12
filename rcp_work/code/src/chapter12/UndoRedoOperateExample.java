//package chapter12;
//
//import java.net.*;
//
//import org.eclipse.jface.action.*;
//import org.eclipse.jface.resource.*;
//
//import org.eclipse.jface.text.*;
//import org.eclipse.jface.window.*;
//import org.eclipse.swt.*;
//
//import org.eclipse.swt.events.*;
//import org.eclipse.swt.layout.*;
//import org.eclipse.swt.widgets.*;
//
//public class UndoRedoOperateExample extends ApplicationWindow {
//
//	private TextViewer tv;
//
//	private IUndoManager undoManager;
//
//	private Action undoAction;
//
//	private Action redoAction;
//
//	public UndoRedoOperateExample() {
//		super(null);
//		undoAction = new UndoAction();
//		redoAction = new RedoAction();
//		addMenuBar();
//		addToolBar(SWT.FLAT);
//	}
//
//	public void run() {
//		setBlockOnOpen(true);
//		open();
//		Display.getCurrent().dispose();
//	}
//
//	protected Control createContents(Composite parent) {
//		getShell().setText("UndoRedo实例");
//
//		Composite container = new Composite(parent, SWT.NONE);
//		container.setLayout(new FillLayout());
//
//		tv = new TextViewer(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
//		Document doc = new Document();
//		tv.setDocument(doc);
//		// /可以撤销1000步的操作
//		undoManager = new DefaultUndoManager(1000);
//		// 在text上设置IUndoManager对象
//		tv.setUndoManager(undoManager);
//		undoManager.connect(tv);
//
//		tv.getTextWidget().addVerifyListener(new VerifyListener() {
//			public void verifyText(VerifyEvent e) {
//				// 使撤销操作从最后一个字符开始，一个字符一个字符的撤销
//				undoManager.endCompoundChange();
//				/**
//				 * 用undoManager.beginCompoundChange()方法 撤销操作直接撤销到文本开始处
//				 */
//
//			}
//		});
//
//		return container;
//	}
//
//	protected MenuManager createMenuManager() {
//		MenuManager menubar = new MenuManager();
//		MenuManager editMenu = new MenuManager("编辑(&E)");
//
//		editMenu.add(undoAction);
//		editMenu.add(redoAction);
//		menubar.add(editMenu);
//		return menubar;
//	}
//
//	protected ToolBarManager createToolBarManager(int style) {
//		ToolBarManager toolBarManager = new ToolBarManager(style);
//		toolBarManager.add(new UndoAction());
//		toolBarManager.add(new RedoAction());
//
//		return toolBarManager;
//	}
//
//	class UndoAction extends Action {
//		public UndoAction() {
//			super("撤销(&U)键入@Ctrl+Z", Action.AS_PUSH_BUTTON);
//			setToolTipText("取消键入");
//			try {
//				// 载入图像
//				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
//						"file:icons/undo.bmp"));
//				setImageDescriptor(icon);
//			} catch (MalformedURLException e) {
//				System.err.println(e.getMessage());
//			}
//		}
//
//		public void run() {
//
//			undoManager.undo();
//			
//			/**
//			 * tv.doOperation(ITextOperationTarget.UNDO);
//			 *执行目标操作，ITextOperation接口用来定义文本目标操作
//			 */ 
//		}
//	}
//
//	class RedoAction extends Action {
//		public RedoAction() {
//			super("&恢复(&R)键入@Ctrl+R", Action.AS_PUSH_BUTTON);
//			setToolTipText("恢复键入");
//			try {
//				// 载入图像
//				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
//						"file:icons/redo.bmp"));
//				setImageDescriptor(icon);
//			} catch (MalformedURLException e) {
//				System.err.println(e.getMessage());
//			}
//		}
//
//		public void run() {
//			// tv.doOperation(ITextOperationTarget.REDO);
//			undoManager.redo();
//		}
//	}
//
//	public static void main(String[] args) {
//		new UndoRedoOperateExample().run();
//
//	}
//
//}
