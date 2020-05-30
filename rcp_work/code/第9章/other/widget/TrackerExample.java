/**@author WangJinTao,MengQingChang 2006
 */
package other.widget;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
public class TrackerExample {
	private Tracker tracker;
	public TrackerExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(400, 300);
		shell.setText("TrackerÊµÀý");
	    tracker = new Tracker(shell, SWT.RESIZE);
		shell.addMouseListener(new MouseAdapter() {
			
			public void mouseDown(MouseEvent e) {
				tracker.setRectangles(new Rectangle[] { new Rectangle(e.x, e.y,
						0, 0), });
				tracker.open();
				System.out.println(tracker.getRectangles());
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
	public static void main(String[] args) {
		new TrackerExample();
	}
}
