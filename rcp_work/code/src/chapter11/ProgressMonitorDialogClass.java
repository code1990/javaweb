/**
 * @author: WangJinTao,MengQingChang2006 
 */
package chapter11;

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
		// ���𴰿�
		super(null);

	}

	public void run() {

		setBlockOnOpen(true);

		// �򿪴���
		open();

		// ���� display
		Display.getCurrent().dispose();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		// ���ô����С
		shell.setSize(300, 150);
		// ���ô������
		shell.setText("ProgressMonitorDialogʵ��");
	}

	public Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		Button button = new Button(composite, SWT.PUSH);
		button.setText("���� ProgressMonitorDialog");
		GridData grid = new GridData(200, 25);
		grid.verticalSpan = 20;
		grid.horizontalIndent = 40;
		button.setLayoutData(grid);
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {

				/*
				 * ͨ��IRunnableWithProgress�ӿ�ʵ�ִ���Ĺ��̡�
				 */

				IRunnableWithProgress runnableWithProgress = new IRunnableWithProgress() {
					// run��������IProgressMonitor�Ķ���monitor��Ϊ����
					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {

						monitor.beginTask("�������ڽ���.......", 10);
						for (int i = 0; i < 10; i++) {
							if (monitor.isCanceled()) {
								monitor.done();
								return;
							}
							// ִ�м��
							monitor.setTaskName("ѭ��" + (i + 1) + "��");
							// ����ǰ��һ��
							monitor.worked(1);
							// ÿ�μ��1��
							Thread.sleep(1000);
						}
						// ����ִ�е�����
						monitor.done();
					}
				};
				// ����һ�����ȶԻ���
				ProgressMonitorDialog dialog = new ProgressMonitorDialog(
						getShell());
				try {
					/*
					 * �����ڶ�������true����Ϊfalse��Ի���ť"Cancel"���ڲ�����״̬
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
