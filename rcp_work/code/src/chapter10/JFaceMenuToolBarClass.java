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
		// 将ApplicationWindow类实例作为参数传过来
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
	// 创建菜单
	protected MenuManager createMenuManager() {
		MenuManager menuBar = new MenuManager("");
		MenuManager fileMenu = new MenuManager("文件(&F)");
		MenuManager selectMenu = new MenuManager("选项");
		menuBar.add(fileMenu);
		fileMenu.add(selectMenu);
		selectMenu.add(exitAction);
		return menuBar;
	}
		// 创建工具栏
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
