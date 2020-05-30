/**@author WangJinTao,MengQingChang 2006
 */
package chapter08.complex.widget;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;

public class ToolBarExample3 {
	private ToolBar toolBar;

	private ToolItem item;

	private ToolItem item1;

	private ToolItem item2;

	private Composite composite;

	private Combo combo;

	private Label labelA;

	private Label labela;

	private Label labelB;

	private Label labelb;

	private Text textdisplay;

	static String Text = "";

	private Point point;

	public ToolBarExample3() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 300);
		shell.setText("ToolBarʵ��");
		// Shellʹ���в��ַ�ʽ��ʹ�������ť��������
		shell.setLayout(new RowLayout(SWT.VERTICAL));
		// ����������ˮƽ������ʽ
		toolBar = new ToolBar(shell, SWT.HORIZONTAL);
		{
			/**
			 * ����createToolItem()�Զ��巽������һ���α�ʾ��ToolItem�����ڹ������� ��
			 * �ڶ�����������ťΪPUSH���ͣ�������������ʾ��ť�ϵ����ƣ� 
			 * ���ĸ�������ʾΪ��ʾ�Ա�ǩ���֣� ��������д�ɣ�
			 * ToolItem item=new ToolItem(toolBar��SWT.PUSH); 
			 * item.setText("PUSH��ť");
			 * item.setToolTipText("����������ʾ�ԶԻ���");
			 */
			item = createToolItem(toolBar, SWT.PUSH, "PUSH��ť", "����������ʾ�ԶԻ���");
			// ����PUSH��ť�������¼�������MessageBox�Ի���
			item.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					// /����MessageBox�Ի���
					MessageBox messageBox = new MessageBox(shell,
							SWT.ICON_INFORMATION | SWT.OK);
					messageBox.setMessage("����PUSH���͵İ�ť");
					messageBox.open();
				}
			});
		}
		{ // ����һ���������˵��İ�ť
			item1 = createToolItem(toolBar, SWT.DROP_DOWN, "DROP_DOWN��ť",
					"�������˵��İ�ť");
			final Menu menu = new Menu(shell, SWT.PUSH);
			// ��������˵���
			for (int i = 0; i < 5; i++) {
				MenuItem menuitem = new MenuItem(menu, SWT.CHECK);
				menuitem.setText("MenuItem " + i);
			}
			// �����ù�������ʱ���������˵�
			item1.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					// �����ѡ��ARROW���Ͱ�ť��ִ������ĳ���
					if (event.detail == SWT.ARROW) {
						// ��ȡitem��С����ť��С
						Rectangle bound = item1.getBounds();
						// �������˵�λ�ý��ж�λ
						point = toolBar.toDisplay(bound.x, bound.y
								+ bound.height);
						menu.setLocation(point);
						menu.setVisible(true);
					}
				}
			});
		}
		{
			item = createToolItem(toolBar, SWT.CHECK, "CHECK��ť", "����״̬���ı�");
			item.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					ToolItem item = (ToolItem) event.widget;
					// ��ù������ϰ�ť��״̬
					labela.setText(item.getSelection() ? "���� " : "���� ");
				}
			});
		}
		{
			item2 = new ToolItem(toolBar, SWT.SEPARATOR);
			combo = new Combo(toolBar, SWT.READ_ONLY);
			combo.setItems(new String[] { "Eclipse", "SWT", "JFace", "AWT",
					"Swing", "MyEclipse", "Lomboz" });
			combo.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					int selectionIndex = combo.getSelectionIndex();
					if (selectionIndex == 0) {
						// �ڵ������б��ѡ��ʱ�����б����ʾ���ı�����
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 1) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 2) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 3) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 4) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 5) {
						textdisplay.setText(combo.getText());
					} else if (selectionIndex == 6) {
						textdisplay.setText(combo.getText());
					}
				}
			});
			item2.setControl(combo);
			item2.setWidth(80);// ����Combo�Ŀ��
		}
		{
			item = createToolItem(toolBar, SWT.RADIO, "RADIO1��ť ", "������ʾ�ð�ť��ѡ��");
			item.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					labelb.setText("RADIO1��ť");
				}
			});
			item = createToolItem(toolBar, SWT.RADIO, "RADIO2��ť", "������ʾ�ð�ť��ѡ��");
			item.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					labelb.setText("RADIO2��ť");
				}
			});
		}
		composite = new Composite(shell, SWT.NONE);
		// ����������ʽ���֣�����2��
		composite.setLayout(new GridLayout(2, false));
		// ��ǩ�ָ���
		Label label = new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR);
		GridData grida = new GridData(GridData.FILL_HORIZONTAL);
		grida.horizontalSpan = 2;// ˮƽ��ռ2��
		label.setLayoutData(grida);
		labelA = new Label(composite, SWT.NONE);
		labelA.setText("CHECK��ť��ǰ״̬:");
		labela = new Label(composite, SWT.NONE);
		labela.setText("����");
		// ��ǩ�ָ���
		Label lab = new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR);
		GridData grid = new GridData(GridData.FILL_HORIZONTAL);
		grid.horizontalSpan = 2;
		lab.setLayoutData(grid);
		labelB = new Label(composite, SWT.RIGHT);
		labelB.setText("��ǰѡ�е�RADIO��ťΪ:");
		labelb = new Label(composite, SWT.NONE);
		labelb.setText("��ǰ��ѡ�е�RADIO��ť");
		// ����һ���ı���
		textdisplay = new Text(composite, SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 2;// ˮƽ��ռ2��
		gridData.heightHint = 20;// �߶�Ϊ20������
		textdisplay.setLayoutData(gridData);
		// ����ƶ��¼�
		toolBar.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				item = toolBar.getItem(new Point(e.x, e.y));
				String name = "";
				if (item != null) {
					// ��ȡ������������֣����������ϰ�ť������
					name = item.getText();
				}
				if (!Text.equals(name)) {
					// ���ı�����ʾ��ȡ�Ĺ������������
					textdisplay.setText(name);
					Text = name;
				}
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	private ToolItem createToolItem(ToolBar parent, int type, String text,
			String toolTipText) {
		ToolItem item = new ToolItem(parent, type);
		item.setText(text);// ����item����
		item.setToolTipText(toolTipText);// ������ʾ�Ա�ǩ����
		return item;
	}

	public static void main(String[] args) {
		new ToolBarExample3();
	}
}
