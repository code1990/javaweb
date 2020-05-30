/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter14;

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
		// ���ô����С
		shell.setSize(550, 350);
		shell.setText("Browserʵ��");
	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		// �����Զ��巽��
		createBrowser(composite);
		return composite;
	}

	private void createBrowser(Composite comp) {
		Composite composite = new Composite(comp, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new GridLayout(3, false));
		// ���õ�ַ��ǩ
		labelAddress = new Label(composite, SWT.NONE);
		labelAddress.setText("��ַ(&D)");
		// ���õ�ַ�ı���
		text = new Text(composite, SWT.BORDER);
		GridData gridText = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(gridText);
		// ����ת����ť
		Button buttonRun = new Button(composite, SWT.NULL);
		buttonRun.setImage(new Image(comp.getShell().getDisplay(),
				"icons/run.gif"));
		buttonRun.setToolTipText("ת��");
		// ������������
		browser = new Browser(composite, SWT.BORDER);
		GridData gridBrowser = new GridData(GridData.FILL_BOTH);
		gridBrowser.horizontalSpan = 3;
		browser.setLayoutData(gridBrowser);
		// ����״̬��ǩ
		labelStatus = new Label(composite, SWT.NULL);
		labelStatus.setText("׼��");
		GridData gridlabelStatus = new GridData(GridData.FILL_HORIZONTAL);
		gridlabelStatus.horizontalSpan = 2;
		labelStatus.setLayoutData(gridlabelStatus);
		// ����һ��������
		final ProgressBar progressBar = new ProgressBar(composite, SWT.SMOOTH);
		Listener openURLListener = new Listener() {
			public void handleEvent(Event event) {
				// Browser��ȡ�ı����ݣ�����ȡ�û��������ַ
				browser.setUrl(text.getText());
			}
		};
		buttonRun.addListener(SWT.Selection, openURLListener);
		text.addListener(SWT.DefaultSelection, openURLListener);
		browser.addLocationListener(new LocationListener() {
			public void changing(LocationEvent event) {
				// ��ʾ��ַ�Ķ�λ���ı���ַ�ı���
				text.setText(event.location);
			}

			public void changed(LocationEvent event) {
			}
		});
		// �ý�����������ҳ��ʾ����״̬
		browser.addProgressListener(new ProgressListener() {
			public void changed(ProgressEvent event) {
				progressBar.setMaximum(event.total);
				progressBar.setSelection(event.current);
			}

			public void completed(ProgressEvent event) {
				progressBar.setSelection(0);
			}
		});
		// ��ǩ������ʾ��ҳ��ʾ״̬
		browser.addStatusTextListener(new StatusTextListener() {
			public void changed(StatusTextEvent event) {
				labelStatus.setText(event.text);
			}
		});
	}

	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		// ͨ��Action���������ù�������ť��Ӧ�Ĺ���
		toolBarManager.add(new backwardAction());
		toolBarManager.add(new forwardAction());
		toolBarManager.add(new stopAction());
		toolBarManager.add(new refreshAction());
		// Ϊ��������ӷָ���
		toolBarManager.add(new Separator());
		toolBarManager.add(new homeAction());
		return toolBarManager;
	}

	class backwardAction extends Action {
		public backwardAction() {
			// ������ʾ�Ա�ǩ
			setToolTipText("����");
			try {
				// ����ͼ��
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
			setToolTipText("ǰ��");
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
			setToolTipText("ֹͣ");
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
			setToolTipText("ˢ��");
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
			setToolTipText("��ҳ");
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
