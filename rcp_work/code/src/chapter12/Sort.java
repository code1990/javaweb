/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package chapter12;

import org.eclipse.jface.viewers.*;

// ��������Sort�̳�ViewerSorter��
public class Sort extends ViewerSorter {

	private int column;

	/**
	 * ����TableViewerSort����((Sort) tv.getSorter()).doSort()�����
	 * doSort()�����еĲ���ȡֵ����ֵ��Ϊ�к� ��
	 */
	public void doSort(int column) {
		this.column = column;
	}

	public int compare(Viewer viewer, Object e1, Object e2) {

		People p1 = (People) e1;
		People p2 = (People) e2;
		// �����е�ȡֵ�����ж�Ӧ�еĽ����������б��¼
		switch (column) {
		case 1: {
			Integer str1 = p1.getID();
			Integer str2 = p2.getID();
			int IDDesc = str2.compareTo(str1);
			return IDDesc;
		}

		case -1: {
			Integer str1 = p1.getID();
			Integer str2 = p2.getID();
			int IDAsc = str1.compareTo(str2);

			return IDAsc;
		}

		case 2: {
			String str1 = p1.getName();
			String str2 = p2.getName();
			int NameDesc = str2.compareTo(str1);
			return NameDesc;
		}

		case -2: {
			String str1 = p1.getName();
			String str2 = p2.getName();
			int NameAsc = str1.compareTo(str2);

			return NameAsc;
		}

		case 3: {
			Boolean str1 = p1.getMale();
			Boolean str2 = p2.getMale();
			int MaleDesc = str2.compareTo(str1);
			return MaleDesc;
		}

		case -3: {
			Boolean str1 = p1.getMale();
			Boolean str2 = p2.getMale();
			int MaleAsc = str1.compareTo(str2);

			return MaleAsc;
		}
		case 4: {
			Integer str1 = p1.getAge();
			Integer str2 = p2.getAge();
			int AgeDesc = str2.compareTo(str1);
			return AgeDesc;
		}

		case -4: {
			Integer str1 = p1.getAge();
			Integer str2 = p2.getAge();
			int AgeAsc = str1.compareTo(str2);

			return AgeAsc;
		}

		case 5: {
			String str1 = p1.getPosition();
			String str2 = p2.getPosition();
			int PositionDesc = str2.compareTo(str1);
			return PositionDesc;
		}

		case -5: {
			String str1 = p1.getPosition();
			String str2 = p2.getPosition();
			int PositionAsc = str1.compareTo(str2);

			return PositionAsc;
		}

		}

		return 0;

	}

}