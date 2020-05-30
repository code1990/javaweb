/**@author WangJinTao,MengQingChang 2006
 */
package chapter10;

import org.eclipse.jface.action.*;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
public class JFaceMenuToolBarClass extends ApplicationWindow {
	private ExitActionClass exitAction;
	public JFaceMenuToolBarClass() {
		super(null);
		// ��ApplicationWindow��ʵ����Ϊ����������
		exitAction = new ExitActionClass(this);
		this.addMenuBar();
		this.addStatusLine();
		this.addToolBar(SWT.FLAT | SWT.WRAP);
	}
	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}
	protected Control createContents(Composite parent) {
		getShell().setText("JFace Menu and TooBar");
		getShell().setSize(370, 250);
		new Text(getShell(), SWT.BORDER);
		setStatus("This is StatusLine");
		return parent;
	}
	// �����˵�
	protected MenuManager createMenuManager() {
		MenuManager menuBar = new MenuManager("");
		MenuManager fileMenu = new MenuManager("�ļ�(&F)");
		MenuManager selectMenu = new MenuManager("ѡ��");
		menuBar.add(fileMenu);
		fileMenu.add(selectMenu);
		selectMenu.add(exitAction);
		return menuBar;
	}
		// ����������
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		toolBarManager.add(exitAction);
		return toolBarManager;
	}
	public static void main(String[] args) {
		JFaceMenuToolBarClass menutoolbar = new JFaceMenuToolBarClass();
		menutoolbar.run();
	}
}
