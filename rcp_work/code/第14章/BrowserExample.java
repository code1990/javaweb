/**
 *@author: WangJinTao,MengQingChang2006
 */
package swtjfaceExample;

import java.net.*;
import org.eclipse.swt.*;
import org.eclipse.jface.action.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.jface.resource.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;

public class BrowserExample extends ApplicationWindow {
	private Browser browser;

	private Text text;

	private Label labelAddress;

	private Label labelStatus;

	public BrowserExample() {
		super(null);
		addToolBar(SWT.FLAT);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		// 设置窗体大小
		shell.setSize(550, 350);
		shell.setText("Browser实例");
	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		// 调用自定义方法
		createBrowser(composite);
		return composite;
	}

	private void createBrowser(Composite comp) {
		Composite composite = new Composite(comp, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new GridLayout(3, false));
		// 设置地址标签
		labelAddress = new Label(composite, SWT.NONE);
		labelAddress.setText("地址(&D)");
		// 设置地址文本框
		text = new Text(composite, SWT.BORDER);
		GridData gridText = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(gridText);
		// 设置转到按钮
		Button buttonRun = new Button(composite, SWT.NULL);
		buttonRun.setImage(new Image(comp.getShell().getDisplay(),
				"icons/run.gif"));
		buttonRun.setToolTipText("转到");
		// 设置浏览器组件
		browser = new Browser(composite, SWT.BORDER);
		GridData gridBrowser = new GridData(GridData.FILL_BOTH);
		gridBrowser.horizontalSpan = 3;
		browser.setLayoutData(gridBrowser);
		// 设置状态标签
		labelStatus = new Label(composite, SWT.NULL);
		labelStatus.setText("准备");
		GridData gridlabelStatus = new GridData(GridData.FILL_HORIZONTAL);
		gridlabelStatus.horizontalSpan = 2;
		labelStatus.setLayoutData(gridlabelStatus);
		// 定义一个进度条
		final ProgressBar progressBar = new ProgressBar(composite, SWT.SMOOTH);
		Listener openURLListener = new Listener() {
			public void handleEvent(Event event) {
				// Browser获取文本内容，即获取用户输入的网址
				browser.setUrl(text.getText());
			}
		};
		buttonRun.addListener(SWT.Selection, openURLListener);
		text.addListener(SWT.DefaultSelection, openURLListener);
		browser.addLocationListener(new LocationListener() {
			public void changing(LocationEvent event) {
				// 显示网址的定位在文本地址文本框
				text.setText(event.location);
			}

			public void changed(LocationEvent event) {
			}
		});
		// 用进度条设置网页显示进度状态
		browser.addProgressListener(new ProgressListener() {
			public void changed(ProgressEvent event) {
				progressBar.setMaximum(event.total);
				progressBar.setSelection(event.current);
			}

			public void completed(ProgressEvent event) {
				progressBar.setSelection(0);
			}
		});
		// 标签用于显示网页显示状态
		browser.addStatusTextListener(new StatusTextListener() {
			public void changed(StatusTextEvent event) {
				labelStatus.setText(event.text);
			}
		});
	}

	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		// 通过Action动作来设置工具栏按钮相应的功能
		toolBarManager.add(new backwardAction());
		toolBarManager.add(new forwardAction());
		toolBarManager.add(new stopAction());
		toolBarManager.add(new refreshAction());
		// 为工具栏添加分隔符
		toolBarManager.add(new Separator());
		toolBarManager.add(new homeAction());
		return toolBarManager;
	}

	class backwardAction extends Action {
		public backwardAction() {
			// 设置提示性标签
			setToolTipText("后退");
			try {
				// 载入图像
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/backward.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			browser.back();
		}
	}

	class forwardAction extends Action {
		public forwardAction() {
			setToolTipText("前进");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/forward.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			browser.forward();
		}
	}

	class stopAction extends Action {
		public stopAction() {
			setToolTipText("停止");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/stop.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			browser.stop();
		}
	}

	class refreshAction extends Action {
		public refreshAction() {
			setToolTipText("刷新");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/refresh.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			browser.refresh();
		}
	}

	class homeAction extends Action {
		public homeAction() {
			setToolTipText("主页");
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(
						"file:icons/home.gif"));
				setImageDescriptor(icon);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			}
		}

		public void run() {
			browser.setUrl("http://www.eclipse.org");
		}
	}

	public static void main(String[] args) {
		new BrowserExample().run();
	}
}
