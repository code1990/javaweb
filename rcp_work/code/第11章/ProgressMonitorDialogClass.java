/**
 * @author: WangJinTao,MengQingChang2006 
 */
package jfaceDialog;

import org.eclipse.jface.window.*;

import org.eclipse.swt.widgets.*;

import java.lang.reflect.*;

import org.eclipse.jface.operation.*;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.dialogs.*;

import org.eclipse.swt.layout.*;

import org.eclipse.swt.*;

public class ProgressMonitorDialogClass extends ApplicationWindow {

	public ProgressMonitorDialogClass() {
		// 部署窗口
		super(null);

	}

	public void run() {

		setBlockOnOpen(true);

		// 打开窗体
		open();

		// 消除 display
		Display.getCurrent().dispose();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		// 设置窗体大小
		shell.setSize(300, 150);
		// 设置窗体标题
		shell.setText("ProgressMonitorDialog实例");
	}

	public Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		Button button = new Button(composite, SWT.PUSH);
		button.setText("启动 ProgressMonitorDialog");
		GridData grid = new GridData(200, 25);
		grid.verticalSpan = 20;
		grid.horizontalIndent = 40;
		button.setLayoutData(grid);
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {

				/*
				 * 通过IRunnableWithProgress接口实现处理的过程。
				 */

				IRunnableWithProgress runnableWithProgress = new IRunnableWithProgress() {
					// run方法接受IProgressMonitor的对象monitor作为参数
					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {

						monitor.beginTask("操作正在进行.......", 10);
						for (int i = 0; i < 10; i++) {
							if (monitor.isCanceled()) {
								monitor.done();
								return;
							}
							// 执行监控
							monitor.setTaskName("循环" + (i + 1) + "次");
							// 进度前进一步
							monitor.worked(1);
							// 每次间隔1秒
							Thread.sleep(1000);
						}
						// 进度执行到结束
						monitor.done();
					}
				};
				// 定义一个进度对话框
				ProgressMonitorDialog dialog = new ProgressMonitorDialog(
						getShell());
				try {
					/*
					 * 若将第二个参数true设置为false这对话框按钮"Cancel"处于不可用状态
					 */
					dialog.run(true, true, runnableWithProgress);
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		return parent;
	}

	public static void main(String[] args) {
    new ProgressMonitorDialogClass().run();
		 
	}

}
