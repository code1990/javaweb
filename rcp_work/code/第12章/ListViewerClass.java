/**
 * @author: WangJinTao,MengQingChang 2006
 */
package jfaceViewer;

import java.util.ArrayList;

import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


public class ListViewerClass extends ApplicationWindow {
	
	private ArrayList animalList;

	public ListViewerClass() {
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

		final ListViewer lv = new ListViewer(composite);

		animalList = createAnimalList();
		lv.setContentProvider(new AnimalContentProvider());
		lv.setLabelProvider(new AnimalLabelProvider());
        lv.setInput(animalList);
		return composite;
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

	public static void main(String[] args) {
		new ListViewerClass().run();
	}
}