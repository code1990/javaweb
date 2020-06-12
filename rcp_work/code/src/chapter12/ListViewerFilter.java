package chapter12;

 
import java.util.ArrayList;

import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;

import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ListViewerFilter extends ApplicationWindow {

	private ArrayList animalList;

	private Combo combo;

	private Button button;

	private OneFilter oneFilter;

	private TwoFilter twoFilter;

	private ThreeFilter threeFilter;

	private ListViewer lv;

	public ListViewerFilter() {
		super(null);
	}

	public void run() {

		setBlockOnOpen(true);

		open();

		Display.getCurrent().dispose();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(210, 250);
		shell.setText("ListViewer实例");
	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);

		composite.setLayout(new FillLayout());
		createListViewer(composite);
		// 调用自定义方法createAnimalList()
		animalList = createAnimalList();
		// 设置内容器
		lv.setContentProvider(new AnimalContentProvider());
		// 设置标签器
		lv.setLabelProvider(new AnimalLabelProvider());
		// 用setInput()方法读入数据
		lv.setInput(animalList);
		oneFilter = new OneFilter();
		twoFilter = new TwoFilter();
		threeFilter = new ThreeFilter();
		return composite;
	}

	private void createListViewer(Composite comp) {
		lv = new ListViewer(comp, SWT.NONE);

		Composite com = new Composite(comp, SWT.NONE);
		com.setLayout(new GridLayout());

		combo = new Combo(com, SWT.DROP_DOWN);
		GridData gridCombo = new GridData();
		gridCombo.horizontalIndent = 5;
		gridCombo.widthHint = 60;
		combo.setLayoutData(gridCombo);
		combo.setItems(new String[] { "大象 ", "狮子", "老虎 " });
		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				int selectionIndex = combo.getSelectionIndex();
				if (selectionIndex == 0) {
					lv.addFilter(oneFilter);

				} else if (selectionIndex == 1) {
					lv.addFilter(threeFilter);

				} else if (selectionIndex == 2) {

					lv.addFilter(twoFilter);

				}

			}
		});
		button = new Button(com, SWT.PUSH);
		button.setText("恢复过滤");
		GridData gridButton = new GridData();
		gridButton.widthHint = 85;
		gridButton.horizontalIndent = 5;
		gridButton.verticalIndent = 50;
		button.setLayoutData(gridButton);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				lv.removeFilter(oneFilter);
				lv.removeFilter(twoFilter);
				lv.removeFilter(threeFilter);
			}
		});

	}

	private ArrayList createAnimalList() {
		animalList = new ArrayList();

		{
			Animals elephant = new Animals();
			elephant.setAnimal("大象");
			animalList.add(elephant);

		}

		{
			Animals cetacean = new Animals();
			cetacean.setAnimal("鲸鱼");
			animalList.add(cetacean);

		}
		{
			Animals leopard = new Animals();
			leopard.setAnimal("猎豹");
			animalList.add(leopard);

		}
		{
			Animals tiger = new Animals();
			tiger.setAnimal("老虎");
			animalList.add(tiger);

		}
		{
			Animals shark = new Animals();
			shark.setAnimal("鲨鱼");
			animalList.add(shark);

		}
		{
			Animals turtle = new Animals();
			turtle.setAnimal("海龟");
			animalList.add(turtle);

		}
		{
			Animals lion = new Animals();
			lion.setAnimal("狮子");
			animalList.add(lion);

		}

		return animalList;
	}

	// /过滤器
	class OneFilter extends ViewerFilter {
		public boolean select(Viewer viewer, Object parent, Object element) {
			Animals p = (Animals) element;
			return p.getAnimal() != "大象";
		}
	}

	class TwoFilter extends ViewerFilter {
		public boolean select(Viewer viewer, Object parent, Object element) {
			Animals p = (Animals) element;
			return p.getAnimal() != "老虎";
		}
	}

	class ThreeFilter extends ViewerFilter {
		public boolean select(Viewer viewer, Object parent, Object element) {
			Animals p = (Animals) element;
			return p.getAnimal() != "狮子";
		}
	}

	public static void main(String[] args) {
		new ListViewerFilter().run();
	}
}
