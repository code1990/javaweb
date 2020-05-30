/*author: WangJinTao,MengQingChang 2006-10-12
 */
package chapter12;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.jface.text.*;
import org.eclipse.jface.text.source.*;
import org.eclipse.jface.window.*;

public class TextSourceViewerClass extends ApplicationWindow {

	public TextSourceViewerClass() {
		super(null);
	}

	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		getShell().setText("TextViewerʵ��");
		getShell().setSize(400, 200);
		Display display = getShell().getDisplay();
		Composite compoiste = new Composite(parent, SWT.NONE);
		compoiste.setLayout(new FillLayout());
		SashForm sashForm = new SashForm(compoiste, SWT.HORIZONTAL);
		Document doc = new Document();
		// ���ô�ֱ�кű�ע
		CompositeRuler ruler = new CompositeRuler();

		LineNumberRulerColumn lineCol = new LineNumberRulerColumn();
		lineCol.setBackground(display.getSystemColor(SWT.COLOR_GREEN));

		ruler.addDecorator(0, lineCol);

		SourceViewer sourceViewer = new SourceViewer(sashForm, ruler,
				SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);

		sourceViewer.setDocument(doc);
		TextViewer text = new TextViewer(sashForm, SWT.MULTI | SWT.BORDER
				| SWT.V_SCROLL);
		text.setDocument(doc);
		final StyledText styledText = text.getTextWidget();

		// �����Զ�����
		styledText.setWordWrap(true);

		// ���ñ�����ɫΪ��ɫ
		text.getTextWidget().setBackground(
				display.getSystemColor(SWT.COLOR_BLACK));
		// ����ǰ����ɫΪ��ɫ
		text.getTextWidget().setForeground(
				display.getSystemColor(SWT.COLOR_WHITE));
		// TextViewer��SourceViewer��ռ���ڵı���Ϊ1:1
		sashForm.setWeights(new int[] { 1, 1 });

		return compoiste;
	}

	public static void main(String[] args) {
		new TextSourceViewerClass().run();

	}
}