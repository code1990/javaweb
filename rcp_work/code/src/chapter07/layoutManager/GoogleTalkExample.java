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
		shell.setText("GoogleTalk设置对话框实例");
		// 设置容器为7列
		shell.setLayout(new GridLayout(7, false));
		// 在Shell上定义List，并对List进行布局
		{
			list = new List(shell, SWT.BORDER);
			// 设置列表项
			list.setItems(new String[] { "常规", "音频", "被拒", "通知", "链接" });
			// 使List垂直充满
			GridData gridList = new GridData(GridData.FILL_VERTICAL);
			gridList.horizontalSpan = 3;// 水平强占3列
			gridList.widthHint = 100;// 使宽度为100个像素
			// 设置List距离shell容器左边框为5个像素
			gridList.horizontalIndent = 5;
			list.setLayoutData(gridList);
		}
		// 在Shell上定义Composite，并对Composite进行布局
		{
			composite = new Composite(shell, SWT.BORDER);
			// 使composite面板双向充满
			GridData gridComposite = new GridData(GridData.FILL_BOTH);
			gridComposite.horizontalSpan = 3;// 水平强占3列
			composite.setLayoutData(gridComposite);
			// 定义一个堆栈布局
			stacklayout = new StackLayout();
			// 在composite面板上应用堆栈布局
			composite.setLayout(stacklayout);
			// 调用自定义方法
			comp1Content();
			comp2Content();
			comp3Content();
			comp4Content();
			comp5Content();

		}
		// 在Shell上定义单个按钮，并对其进行布局
		{
			final Button helpButton = new Button(shell, SWT.NONE);
			helpButton.setText("帮助");
			GridData gridHelp = new GridData();
			// 使help按钮水平抢占3列
			gridHelp.horizontalSpan = 3;
			// 使宽度为90个像素
			gridHelp.widthHint = 90;
			// 设置帮助按钮距离shell容器左边框为5个像素
			gridHelp.horizontalIndent = 5;
			helpButton.setLayoutData(gridHelp);

			final Button okButton = new Button(shell, SWT.NONE);
			okButton.setText("确定");
			GridData gridOk = new GridData();
			gridOk.horizontalIndent = 180;
			gridOk.horizontalSpan = 2;
			gridOk.widthHint = 90;
			okButton.setLayoutData(gridOk);

			final Button cancelButton = new Button(shell, SWT.NONE);
			cancelButton.setText("取消");
			GridData gridCancel = new GridData();
			gridCancel.horizontalSpan = 2;
			gridCancel.widthHint = 90;
			cancelButton.setLayoutData(gridCancel);
		}
		// 将comp1面板设置为最设置为堆栈的最顶端显示
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

	// 常规面板的布局设置
	private void comp1Content() {
		// 在composite面板上定义comp1面板
		comp1 = new Composite(composite, SWT.BORDER);
		// 在comp1上采用GridLayout布局，将comp1容器设置5列
		comp1.setLayout(new GridLayout(5, false));
		// 定义常规标签，并对其进行布局
		{
			final Label labRoutine = new Label(comp1, SWT.NONE);
			labRoutine.setText("常规");
			// 用GridData对labRoutine进行布局
			GridData gridRoutine = new GridData();
			// 水平抢占2列
			gridRoutine.horizontalSpan = 2;
			// 距离comp1顶端10个像素
			gridRoutine.verticalIndent = 10;
			labRoutine.setLayoutData(gridRoutine);
		}
		// 定义labSeparator分隔符标签，并对其进行布局
		{
			final Label labSeparator = new Label(comp1, SWT.SEPARATOR
					| SWT.HORIZONTAL);
			GridData gridSeparator = new GridData(GridData.FILL_HORIZONTAL);
			gridSeparator.horizontalSpan = 5;
			// 垂直抢占5列
			gridSeparator.verticalSpan = 5;
			labSeparator.setLayoutData(gridSeparator);
		}
		// 定义button1、button2复选框按钮，并对其进行布局
		{
			/**
			 * 因为button1、button2在comp1上的布局相同 
			 * 所以采用下面的同一布局方式设置相同的属性参数进行布局
			 */
			GridData gridButton = new GridData(GridData.FILL_HORIZONTAL);
			// 水平抢占5列
			gridButton.horizontalSpan = 5;
			// 垂直抢占5列
			gridButton.verticalSpan = 5;
			// 距离comp1左边框20个像素
			gridButton.horizontalIndent = 20;
			final Button button1 = new Button(comp1, SWT.CHECK);
			button1.setText("启动Windows会自动运行(&S)");
			// 对button1进行布局
			button1.setLayoutData(gridButton);
			// 定义button2复选框按钮，并对其进行布局
			final Button button2 = new Button(comp1, SWT.CHECK);
			button2.setText("单击电子邮件链接时打开Gmail(  &U  )");
			/**
			 * 由于button1和button2布局完全相同所以可以通过
			 * button2.setLayoutData(gridDataC)来设置button2 的布局
			 */
			button2.setLayoutData(gridButton);
		}
		// 定义Group分组框，并对其进行布局
		{
			final Group group = new Group(comp1, SWT.NONE);
			group.setText("好友列表");
			GridData gridGroup = new GridData(GridData.FILL_HORIZONTAL);
	
			gridGroup.horizontalSpan = 3;
			gridGroup.verticalSpan = 5;
			gridGroup.horizontalIndent = 20;
			group.setLayoutData(gridGroup);
			// 设置group分组框上组件,并对组件进行布局
			{
				group.setLayout(new GridLayout());
				/**
				 * 四个复选按钮在group分组框上布局完全相同，
				 * 故此可用下面同一种布局方式设置相同的属性参数进行布局
				 */
				GridData gridDataButton = new GridData(GridData.FILL_HORIZONTAL);
				gridDataButton.verticalSpan = 6;
				gridDataButton.horizontalIndent = 6;
				final Button buttonOne = new Button(group, SWT.CHECK);
				buttonOne.setText("按姓名排列(&N)");
				buttonOne.setLayoutData(gridDataButton);
				final Button buttonTwo = new Button(group, SWT.CHECK);
				buttonTwo.setText("隐藏离线好友(&H)");
				buttonTwo.setLayoutData(gridDataButton);
				final Button buttonThree = new Button(group, SWT.CHECK);
				buttonThree.setText("隐藏好友列表以外的Gmail联系人(&C)");
				buttonThree.setLayoutData(gridDataButton);
				final Button buttonFour = new Button(group, SWT.CHECK);
				buttonFour.setText("将经常通讯的人加入好友列表(&A))");
				buttonFour.setLayoutData(gridDataButton);
			}
		}

		{
			/**
			 * 定义“更改字体按钮”和“账户设置”按钮，并对其进行布局
			 * 这两个按钮在comp1面板上布局方式相同可以用同样的布局方式
			 * 设置相同的参数进行布局
			 */
			GridData gridDataButton = new GridData();
			gridDataButton.horizontalSpan = 5;
			gridDataButton.verticalIndent = 8;
			gridDataButton.horizontalIndent = 20;
			gridDataButton.widthHint = 120;
			final Button buttonModify = new Button(comp1, SWT.NONE);
			buttonModify.setText("更改字体(&F)....");
			buttonModify.setLayoutData(gridDataButton);

			final Button buttonAccount = new Button(comp1, SWT.NONE);
			buttonAccount.setText("帐户设置....");
			buttonAccount.setLayoutData(gridDataButton);
		}
		{ // 在comp1上定义“启用诊断记录”按钮，并对其进行布局
			final Button buttonDiagnose = new Button(comp1, SWT.NONE);
			buttonDiagnose.setText("启用诊断记录(&E)");

			GridData gridDiagnose = new GridData();
			gridDiagnose.horizontalSpan = 5;
			gridDiagnose.verticalIndent = 20;
			gridDiagnose.horizontalIndent = 20;
			gridDiagnose.widthHint = 120;
			buttonDiagnose.setLayoutData(gridDiagnose);
		}
	}

	// 音频面板的布局设置
	private void comp2Content() {
		comp2 = new Composite(composite, SWT.BORDER);
		comp2.setLayout(new GridLayout());
		// 定义音频标签，并对其进行布局
		{
			final Label labelAudio = new Label(comp2, SWT.NONE);
			labelAudio.setText("音频");
			GridData gridAudio = new GridData();
			gridAudio.verticalIndent = 10;
			labelAudio.setLayoutData(gridAudio);
		}
		// 设置comp2面板上的分隔符标签
		{
			final Label labelSeparator = new Label(comp2, SWT.SEPARATOR
					| SWT.HORIZONTAL);

			GridData gridSeparator = new GridData(GridData.FILL_HORIZONTAL);
			gridSeparator.verticalSpan = 5;
			labelSeparator.setLayoutData(gridSeparator);
		}
		// 在comp2上定义 groupOne 分组框，并对其进行布局
		{
			Group groupOne = new Group(comp2, SWT.NONE);
			groupOne.setText("输入—麦克风或耳麦");
			GridData gridGroupOne = new GridData(GridData.FILL_HORIZONTAL);
			gridGroupOne.horizontalIndent = 20;
			gridGroupOne.verticalSpan = 20;
			groupOne.setLayoutData(gridGroupOne);
			{ // 设置groupa面板上组件的布局
				groupOne.setLayout(new GridLayout());
				/**
				 * comb1和check1复选框按钮可用相同的布局方式和相同的属性值
				 */
				GridData grid = new GridData();
				grid.verticalIndent = 5;
				grid.horizontalIndent = 10;
				final Combo combo1 = new Combo(groupOne, SWT.NONE);
				// 在下拉框中设置下拉项
				combo1.setItems(new String[] { "默认设备", "Realtek AC97 Audio" });
				combo1.setLayoutData(grid);

				final Button check1 = new Button(groupOne, SWT.CHECK);
				check1.setText("自动调整麦克风灵敏度(&A)");
				check1.setLayoutData(grid);

			}
		}
		// 在comp2上定义groupTwo分组框，并对其进行布局
		{
			Group groupTwo = new Group(comp2, SWT.NONE);
			groupTwo.setText("输入—扬声器或耳麦");

			GridData gridGroupTwo = new GridData(GridData.FILL_HORIZONTAL);
			gridGroupTwo.horizontalIndent = 20;
			gridGroupTwo.verticalSpan = 20;
			groupTwo.setLayoutData(gridGroupTwo);

			{// 设置groupTwo面板上组件，并对组件进行布局
				groupTwo.setLayout(new GridLayout());
				GridData gridData = new GridData();
				gridData.horizontalIndent = 10;
				gridData.widthHint = 138;
				gridData.verticalSpan = 5;
				final Label lab1 = new Label(groupTwo, SWT.NONE);
				lab1.setText("通知—铃声(&N)");
				lab1.setLayoutData(gridData);
				final Combo combo2 = new Combo(groupTwo, SWT.NONE);
				combo2.setItems(new String[] { "所有设备", "默认设备",
						"Realtek AC97 Audio" });
				combo2.setLayoutData(gridData);

				final Label lab2 = new Label(groupTwo, SWT.NONE);
				lab2.setText("呼叫(&C)");
				lab2.setLayoutData(gridData);

				final Combo combo3 = new Combo(groupTwo, SWT.NONE);
				combo3.setItems(new String[] { "默认设备", "Realtek AC97 Audio" });

				combo3.setLayoutData(gridData);

				final Button cancelButton = new Button(groupTwo, SWT.CHECK);
				cancelButton.setText("响铃时取消扬声器静音(&S)");
				GridData gridDataCancel = new GridData();
				gridDataCancel.verticalSpan = 6;
				cancelButton.setLayoutData(gridDataCancel);

			}
		}
		// 在comp2上设置callButton按钮，并对其进行布局
		{
			final Button callButton = new Button(comp2, SWT.CHECK);
			callButton.setText("呼叫时取消扬声器和麦克风静音(&U)");
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
		labelRefuse.setText("被拒");

	}

	private void comp4Content() {
		comp4 = new Composite(composite, SWT.BORDER);
		comp4.setLayout(new GridLayout());
		final Label labelNotice = new Label(comp4, SWT.NONE);
		labelNotice.setText("通知");
	}

	private void comp5Content() {
		comp5 = new Composite(composite, SWT.BORDER);
		comp5.setLayout(new GridLayout());
		final Label labelLink = new Label(comp5, SWT.NONE);
		labelLink.setText("链接");

	}

	public static void main(String[] args) {
		new GoogleTalkExample();
	}
}
