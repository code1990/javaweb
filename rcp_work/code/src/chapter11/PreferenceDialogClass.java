/**
 *@author: WangJinTao,MengQingChang2006
 */
package chapter11;

import java.io.IOException;
import org.eclipse.jface.preference.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class PreferenceDialogClass extends ApplicationWindow {
	public PreferenceDialogClass() {
		super(null);
	}

	public static void main(String[] args) {
		PreferenceDialogClass preferenceDialog = new PreferenceDialogClass();
		preferenceDialog.setBlockOnOpen(true);
		preferenceDialog.open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
		getShell().setText("��ѡ��");
		getShell().setSize(200, 80);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new GridLayout());
		Button openbutton = new Button(composite, SWT.PUSH);
		openbutton.setText("����ѡ��");
		openbutton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				openPreferenceDialog();
			}
		});
		// �Դ���ѡ�ť����
		GridData grid = new GridData(GridData.FILL_HORIZONTAL);
		openbutton.setLayoutData(grid);
		return composite;
	}

	private void openPreferenceDialog() {
		// ����PreferenceManager�����
		PreferenceManager pm = new PreferenceManager();
		// ����һ��PreferenceNode����󣬼��ڵ����
		PreferenceNode nodeA = new PreferenceNode("NODEA");
		// ������ҳ������ΪnodeA��ҳ�漴����nodeA�ڵ�ʱ��ʾ����ҳ��
		nodeA.setPage(new PreferencePageOne());
		// ���ڵ�nodeA����Ϊ���ڵ�
		pm.addToRoot(nodeA);
		// ����ڵ�nodea
		PreferenceNode nodea = new PreferenceNode("NODEa");
		nodea.setPage(new PreferencePageTwo());
		// ���ڵ�nodea����Ϊ��nodeA���ӽڵ�
		pm.addTo("NODEA", nodea);
		// ����ڵ�nodeB
		PreferenceNode nodeB = new PreferenceNode("NODEB");
		nodeB.setPage(new PreferencePageThree());
		// ���ڵ� nodeB����Ϊ���ڵ�
		pm.addToRoot(nodeB);
		// ����ڵ�nodeb
		PreferenceNode nodeb = new PreferenceNode("NODEb");
		nodeb.setPage(new PreferencePageFour());
		// ���ڵ�nodeb����Ϊ���ڵ�nodeB���ӽڵ�
		pm.addTo("NODEB", nodeb);
		// ����һ��PreferenceDialog����
		PreferenceDialog dialog = new PreferenceDialog(getShell(), pm);
		// ����preferencestore����
		PreferenceStore ps = new PreferenceStore("showprefs.properties");
		try {
			ps.load();
		} catch (IOException e) {
		}
		dialog.setPreferenceStore(ps);
		// ����ѡ��Ի���
		dialog.open();
		try {
			// ���� preferences
			ps.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ����ҳ��
	class PreferencePageOne extends PreferencePage {
		private Button CheckOne;

		private Button CheckTwo;

		private Button CheckThree;

		private Button CheckFour;

		private Button CheckFive;

		private Button RadioOne;

		private Button RadioTwo;

		private static final String ONE = "one";

		private static final String TWO = "two";

		private static final String THREE = "three";

		private static final String FOUR = "four";

		private static final String FIVE = "five";

		private static final String SIX = "six";

		private static final String SEVEN = "seven";

		public PreferencePageOne() {
			setTitle("����");
			setMessage("����");
		}

		// /�ڳ���ҳ����������
		protected Control createContents(Composite parent) {
			Composite comp = new Composite(parent, SWT.NONE);
			comp.setLayout(new GridLayout(1, true));
			IPreferenceStore preferenceStore = getPreferenceStore();
			CheckOne = new Button(comp, SWT.CHECK);
			CheckOne.setText("ʼ���ں�̨����(&U)");
			CheckOne.setSelection(preferenceStore.getBoolean(ONE));

			CheckTwo = new Button(comp, SWT.CHECK);
			CheckTwo.setText("����һ��/��һ�������ڶԻ����(&N)");
			CheckTwo.setSelection(preferenceStore.getBoolean(TWO));

			CheckThree = new Button(comp, SWT.CHECK);
			CheckThree.setText("��ʾ��״̬(&W)");
			CheckThree.setSelection(preferenceStore.getBoolean(THREE));
			// ��������
			final Group group = new Group(comp, SWT.NONE);
			group.setText("�򿪷�ʽ");
			GridData grid = new GridData(GridData.FILL_HORIZONTAL);
			group.setLayoutData(grid);
			group.setLayout(new GridLayout());
			// �ڷ������������
			RadioOne = new Button(group, SWT.RADIO);
			RadioOne.setText("˫��(&O)");
			RadioOne.setSelection(preferenceStore.getBoolean(SIX));

			RadioTwo = new Button(group, SWT.RADIO);
			RadioTwo.setText("����(&S)");
			RadioTwo.setSelection(preferenceStore.getBoolean(SEVEN));

			CheckFour = new Button(group, SWT.CHECK);
			CheckFour.setText("����������ʾѡ��(&H)");
			CheckFour.setSelection(preferenceStore.getBoolean(FOUR));
			// ��CheckFour��ť����Ϊ������״̬
			CheckFour.setEnabled(false);
			// ��CheckFour��ť���в���
			GridData buttongrid = new GridData();
			buttongrid.horizontalIndent = 20;
			CheckFour.setLayoutData(buttongrid);

			CheckFive = new Button(group, SWT.CHECK);
			CheckFive.setText("ʹ�ü�ͷ��ʱ��(&K)");
			CheckFive.setSelection(preferenceStore.getBoolean(FIVE));
			// ��CheckFive��ť����Ϊ������״̬
			CheckFive.setEnabled(false);
			CheckFive.setLayoutData(buttongrid);
			// ��group�϶����ǩ
			new Label(group, SWT.NONE).setText("ע�⣺��ѡ����ܲ�����������ͼ����Ч");
			RadioTwo.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					// ��ѡ����RadioTwo��ť��CheckFour��CheckFive�����������
					// ���ڲ�����״̬
					if (RadioTwo.getSelection() == true) {
						CheckFour.setEnabled(true);
						CheckFive.setEnabled(true);
					} else {
						CheckFour.setEnabled(false);
						CheckFive.setEnabled(false);
					}
				}
			});
			return comp;
		}

		protected void performDefaults() {
			IPreferenceStore preferenceStore = getPreferenceStore();
			// ����ť״̬����
			CheckOne.setSelection(preferenceStore.getDefaultBoolean(ONE));
			CheckTwo.setSelection(preferenceStore.getDefaultBoolean(TWO));
			CheckThree.setSelection(preferenceStore.getDefaultBoolean(THREE));
			CheckFour.setSelection(preferenceStore.getDefaultBoolean(FOUR));
			CheckFive.setSelection(preferenceStore.getDefaultBoolean(FIVE));
			RadioOne.setSelection(preferenceStore.getDefaultBoolean(SIX));
			RadioTwo.setSelection(preferenceStore.getDefaultBoolean(FOUR));
		}

		protected void performApply() {
			if (getControl() == null) {
				return;
			}
		}

		public boolean performOk() {
			performApply();
			return true;
		}
	}

	// �����ҳ��
	class PreferencePageTwo extends PreferencePage {
		public PreferencePageTwo() {
			setTitle("Web�����");
			setMessage("Web�����");
		}

		protected Control createContents(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, true));
			return composite;
		}

		protected void performApply() {
			if (getControl() == null) {
				return;
			}
		}

		public boolean performOk() {
			performApply();
			return true;
		}
	}

	// Antҳ��
	class PreferencePageThree extends PreferencePage {
		public PreferencePageThree() {
			setTitle("Ant");
			setMessage("Ant");
		}

		protected Control createContents(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, true));
			return composite;
		}

		protected void performApply() {
			if (getControl() == null) {
				return;
			}
		}

		public boolean performOk() {
			performApply();
			return true;
		}
	}

	// /�༭��ҳ��
	class PreferencePageFour extends PreferencePage {
		public PreferencePageFour() {
			setTitle("�༭��");
			setMessage("�༭��");
		}

		protected Control createContents(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, true));
			return composite;
		}

		protected void performApply() {
			if (getControl() == null) {
				return;
			}
		}

		public boolean performOk() {
			performApply();
			return true;
		}
	}
}
