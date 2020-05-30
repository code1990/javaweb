/**@author WangJinTao,MengQingChang 2006
 */
package chapter07.layoutManager;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.*;

public class GoogleTalkExample {

	private List list;

	private Composite composite;

	private StackLayout stacklayout;

	private Composite comp1;

	private Composite comp2;

	private Composite comp3;

	private Composite comp4;

	private Composite comp5;

	public GoogleTalkExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(new Shell());
		shell.setSize(500, 460);
		shell.setText("GoogleTalk���öԻ���ʵ��");
		// ��������Ϊ7��
		shell.setLayout(new GridLayout(7, false));
		// ��Shell�϶���List������List���в���
		{
			list = new List(shell, SWT.BORDER);
			// �����б���
			list.setItems(new String[] { "����", "��Ƶ", "����", "֪ͨ", "����" });
			// ʹList��ֱ����
			GridData gridList = new GridData(GridData.FILL_VERTICAL);
			gridList.horizontalSpan = 3;// ˮƽǿռ3��
			gridList.widthHint = 100;// ʹ���Ϊ100������
			// ����List����shell������߿�Ϊ5������
			gridList.horizontalIndent = 5;
			list.setLayoutData(gridList);
		}
		// ��Shell�϶���Composite������Composite���в���
		{
			composite = new Composite(shell, SWT.BORDER);
			// ʹcomposite���˫�����
			GridData gridComposite = new GridData(GridData.FILL_BOTH);
			gridComposite.horizontalSpan = 3;// ˮƽǿռ3��
			composite.setLayoutData(gridComposite);
			// ����һ����ջ����
			stacklayout = new StackLayout();
			// ��composite�����Ӧ�ö�ջ����
			composite.setLayout(stacklayout);
			// �����Զ��巽��
			comp1Content();
			comp2Content();
			comp3Content();
			comp4Content();
			comp5Content();

		}
		// ��Shell�϶��嵥����ť����������в���
		{
			final Button helpButton = new Button(shell, SWT.NONE);
			helpButton.setText("����");
			GridData gridHelp = new GridData();
			// ʹhelp��ťˮƽ��ռ3��
			gridHelp.horizontalSpan = 3;
			// ʹ���Ϊ90������
			gridHelp.widthHint = 90;
			// ���ð�����ť����shell������߿�Ϊ5������
			gridHelp.horizontalIndent = 5;
			helpButton.setLayoutData(gridHelp);

			final Button okButton = new Button(shell, SWT.NONE);
			okButton.setText("ȷ��");
			GridData gridOk = new GridData();
			gridOk.horizontalIndent = 180;
			gridOk.horizontalSpan = 2;
			gridOk.widthHint = 90;
			okButton.setLayoutData(gridOk);

			final Button cancelButton = new Button(shell, SWT.NONE);
			cancelButton.setText("ȡ��");
			GridData gridCancel = new GridData();
			gridCancel.horizontalSpan = 2;
			gridCancel.widthHint = 90;
			cancelButton.setLayoutData(gridCancel);
		}
		// ��comp1�������Ϊ������Ϊ��ջ�������ʾ
		stacklayout.topControl = comp1;

		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = list.getSelectionIndex();
				if (selectionIndex == 0) {
					stacklayout.topControl = comp1;
				} else if (selectionIndex == 1) {
					stacklayout.topControl = comp2;
				} else if (selectionIndex == 2) {
					stacklayout.topControl = comp3;
				} else if (selectionIndex == 3)
					stacklayout.topControl = comp4;
				else if (selectionIndex == 4)
					stacklayout.topControl = comp5;
				composite.layout();
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	// �������Ĳ�������
	private void comp1Content() {
		// ��composite����϶���comp1���
		comp1 = new Composite(composite, SWT.BORDER);
		// ��comp1�ϲ���GridLayout���֣���comp1��������5��
		comp1.setLayout(new GridLayout(5, false));
		// ���峣���ǩ����������в���
		{
			final Label labRoutine = new Label(comp1, SWT.NONE);
			labRoutine.setText("����");
			// ��GridData��labRoutine���в���
			GridData gridRoutine = new GridData();
			// ˮƽ��ռ2��
			gridRoutine.horizontalSpan = 2;
			// ����comp1����10������
			gridRoutine.verticalIndent = 10;
			labRoutine.setLayoutData(gridRoutine);
		}
		// ����labSeparator�ָ�����ǩ����������в���
		{
			final Label labSeparator = new Label(comp1, SWT.SEPARATOR
					| SWT.HORIZONTAL);
			GridData gridSeparator = new GridData(GridData.FILL_HORIZONTAL);
			gridSeparator.horizontalSpan = 5;
			// ��ֱ��ռ5��
			gridSeparator.verticalSpan = 5;
			labSeparator.setLayoutData(gridSeparator);
		}
		// ����button1��button2��ѡ��ť����������в���
		{
			/**
			 * ��Ϊbutton1��button2��comp1�ϵĲ�����ͬ 
			 * ���Բ��������ͬһ���ַ�ʽ������ͬ�����Բ������в���
			 */
			GridData gridButton = new GridData(GridData.FILL_HORIZONTAL);
			// ˮƽ��ռ5��
			gridButton.horizontalSpan = 5;
			// ��ֱ��ռ5��
			gridButton.verticalSpan = 5;
			// ����comp1��߿�20������
			gridButton.horizontalIndent = 20;
			final Button button1 = new Button(comp1, SWT.CHECK);
			button1.setText("����Windows���Զ�����(&S)");
			// ��button1���в���
			button1.setLayoutData(gridButton);
			// ����button2��ѡ��ť����������в���
			final Button button2 = new Button(comp1, SWT.CHECK);
			button2.setText("���������ʼ�����ʱ��Gmail(  &U  )");
			/**
			 * ����button1��button2������ȫ��ͬ���Կ���ͨ��
			 * button2.setLayoutData(gridDataC)������button2 �Ĳ���
			 */
			button2.setLayoutData(gridButton);
		}
		// ����Group����򣬲�������в���
		{
			final Group group = new Group(comp1, SWT.NONE);
			group.setText("�����б�");
			GridData gridGroup = new GridData(GridData.FILL_HORIZONTAL);
	
			gridGroup.horizontalSpan = 3;
			gridGroup.verticalSpan = 5;
			gridGroup.horizontalIndent = 20;
			group.setLayoutData(gridGroup);
			// ����group����������,����������в���
			{
				group.setLayout(new GridLayout());
				/**
				 * �ĸ���ѡ��ť��group������ϲ�����ȫ��ͬ��
				 * �ʴ˿�������ͬһ�ֲ��ַ�ʽ������ͬ�����Բ������в���
				 */
				GridData gridDataButton = new GridData(GridData.FILL_HORIZONTAL);
				gridDataButton.verticalSpan = 6;
				gridDataButton.horizontalIndent = 6;
				final Button buttonOne = new Button(group, SWT.CHECK);
				buttonOne.setText("����������(&N)");
				buttonOne.setLayoutData(gridDataButton);
				final Button buttonTwo = new Button(group, SWT.CHECK);
				buttonTwo.setText("�������ߺ���(&H)");
				buttonTwo.setLayoutData(gridDataButton);
				final Button buttonThree = new Button(group, SWT.CHECK);
				buttonThree.setText("���غ����б������Gmail��ϵ��(&C)");
				buttonThree.setLayoutData(gridDataButton);
				final Button buttonFour = new Button(group, SWT.CHECK);
				buttonFour.setText("������ͨѶ���˼�������б�(&A))");
				buttonFour.setLayoutData(gridDataButton);
			}
		}

		{
			/**
			 * ���塰�������尴ť���͡��˻����á���ť����������в���
			 * ��������ť��comp1����ϲ��ַ�ʽ��ͬ������ͬ���Ĳ��ַ�ʽ
			 * ������ͬ�Ĳ������в���
			 */
			GridData gridDataButton = new GridData();
			gridDataButton.horizontalSpan = 5;
			gridDataButton.verticalIndent = 8;
			gridDataButton.horizontalIndent = 20;
			gridDataButton.widthHint = 120;
			final Button buttonModify = new Button(comp1, SWT.NONE);
			buttonModify.setText("��������(&F)....");
			buttonModify.setLayoutData(gridDataButton);

			final Button buttonAccount = new Button(comp1, SWT.NONE);
			buttonAccount.setText("�ʻ�����....");
			buttonAccount.setLayoutData(gridDataButton);
		}
		{ // ��comp1�϶��塰������ϼ�¼����ť����������в���
			final Button buttonDiagnose = new Button(comp1, SWT.NONE);
			buttonDiagnose.setText("������ϼ�¼(&E)");

			GridData gridDiagnose = new GridData();
			gridDiagnose.horizontalSpan = 5;
			gridDiagnose.verticalIndent = 20;
			gridDiagnose.horizontalIndent = 20;
			gridDiagnose.widthHint = 120;
			buttonDiagnose.setLayoutData(gridDiagnose);
		}
	}

	// ��Ƶ���Ĳ�������
	private void comp2Content() {
		comp2 = new Composite(composite, SWT.BORDER);
		comp2.setLayout(new GridLayout());
		// ������Ƶ��ǩ����������в���
		{
			final Label labelAudio = new Label(comp2, SWT.NONE);
			labelAudio.setText("��Ƶ");
			GridData gridAudio = new GridData();
			gridAudio.verticalIndent = 10;
			labelAudio.setLayoutData(gridAudio);
		}
		// ����comp2����ϵķָ�����ǩ
		{
			final Label labelSeparator = new Label(comp2, SWT.SEPARATOR
					| SWT.HORIZONTAL);

			GridData gridSeparator = new GridData(GridData.FILL_HORIZONTAL);
			gridSeparator.verticalSpan = 5;
			labelSeparator.setLayoutData(gridSeparator);
		}
		// ��comp2�϶��� groupOne ����򣬲�������в���
		{
			Group groupOne = new Group(comp2, SWT.NONE);
			groupOne.setText("���롪��˷�����");
			GridData gridGroupOne = new GridData(GridData.FILL_HORIZONTAL);
			gridGroupOne.horizontalIndent = 20;
			gridGroupOne.verticalSpan = 20;
			groupOne.setLayoutData(gridGroupOne);
			{ // ����groupa���������Ĳ���
				groupOne.setLayout(new GridLayout());
				/**
				 * comb1��check1��ѡ��ť������ͬ�Ĳ��ַ�ʽ����ͬ������ֵ
				 */
				GridData grid = new GridData();
				grid.verticalIndent = 5;
				grid.horizontalIndent = 10;
				final Combo combo1 = new Combo(groupOne, SWT.NONE);
				// ��������������������
				combo1.setItems(new String[] { "Ĭ���豸", "Realtek AC97 Audio" });
				combo1.setLayoutData(grid);

				final Button check1 = new Button(groupOne, SWT.CHECK);
				check1.setText("�Զ�������˷�������(&A)");
				check1.setLayoutData(grid);

			}
		}
		// ��comp2�϶���groupTwo����򣬲�������в���
		{
			Group groupTwo = new Group(comp2, SWT.NONE);
			groupTwo.setText("���롪�����������");

			GridData gridGroupTwo = new GridData(GridData.FILL_HORIZONTAL);
			gridGroupTwo.horizontalIndent = 20;
			gridGroupTwo.verticalSpan = 20;
			groupTwo.setLayoutData(gridGroupTwo);

			{// ����groupTwo��������������������в���
				groupTwo.setLayout(new GridLayout());
				GridData gridData = new GridData();
				gridData.horizontalIndent = 10;
				gridData.widthHint = 138;
				gridData.verticalSpan = 5;
				final Label lab1 = new Label(groupTwo, SWT.NONE);
				lab1.setText("֪ͨ������(&N)");
				lab1.setLayoutData(gridData);
				final Combo combo2 = new Combo(groupTwo, SWT.NONE);
				combo2.setItems(new String[] { "�����豸", "Ĭ���豸",
						"Realtek AC97 Audio" });
				combo2.setLayoutData(gridData);

				final Label lab2 = new Label(groupTwo, SWT.NONE);
				lab2.setText("����(&C)");
				lab2.setLayoutData(gridData);

				final Combo combo3 = new Combo(groupTwo, SWT.NONE);
				combo3.setItems(new String[] { "Ĭ���豸", "Realtek AC97 Audio" });

				combo3.setLayoutData(gridData);

				final Button cancelButton = new Button(groupTwo, SWT.CHECK);
				cancelButton.setText("����ʱȡ������������(&S)");
				GridData gridDataCancel = new GridData();
				gridDataCancel.verticalSpan = 6;
				cancelButton.setLayoutData(gridDataCancel);

			}
		}
		// ��comp2������callButton��ť����������в���
		{
			final Button callButton = new Button(comp2, SWT.CHECK);
			callButton.setText("����ʱȡ������������˷羲��(&U)");
			GridData gridDataCall = new GridData();
			gridDataCall.horizontalIndent = 20;
			gridDataCall.verticalSpan = 6;
			callButton.setLayoutData(gridDataCall);
		}

	}

	private void comp3Content() {
		comp3 = new Composite(composite, SWT.BORDER);
		comp3.setLayout(new GridLayout());
		final Label labelRefuse = new Label(comp3, SWT.NONE);
		labelRefuse.setText("����");

	}

	private void comp4Content() {
		comp4 = new Composite(composite, SWT.BORDER);
		comp4.setLayout(new GridLayout());
		final Label labelNotice = new Label(comp4, SWT.NONE);
		labelNotice.setText("֪ͨ");
	}

	private void comp5Content() {
		comp5 = new Composite(composite, SWT.BORDER);
		comp5.setLayout(new GridLayout());
		final Label labelLink = new Label(comp5, SWT.NONE);
		labelLink.setText("����");

	}

	public static void main(String[] args) {
		new GoogleTalkExample();
	}
}
