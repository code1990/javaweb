/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package chapter14;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.widgets.*;

public class DbOperate {
	// ��ѯԱ��������Ϣ����
	public static List BasicInfor() throws SQLException {
		List list = new ArrayList();
		String name, sex, position;
		int id, age, salary;

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:odbc:ygDB");
			Statement sql = con.createStatement();

			ResultSet rs = sql.executeQuery("select * from Ա����Ϣ��");
			while (rs.next()) {
				id = rs.getInt("Ա����");
				name = rs.getString("����");
				sex = rs.getString("�Ա�");
				age = rs.getInt("����");
				position = rs.getString("ְλ");
				salary = rs.getInt("��н");
				Employee people = new Employee();
				people.setID(id);

				people.setName(name);

				people.setSex(sex);

				people.setAge(age);

				people.setPosition(position);

				people.setSalary(salary);

				list.add(people);

			}
		} catch (SQLException e) {
		}

		return list;

	}

	// ��Ա����ģ����ѯԱ����Ϣ����
	public static List SearchId(Text text1) throws SQLException {
		List list = new ArrayList();
		String name, sex, position;

		int id, age, salary;

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = DriverManager.getConnection("jdbc:odbc:ygDB");
		Statement sql = con.createStatement();

		ResultSet rs = sql.executeQuery("select * from Ա����Ϣ�� where Ա���� like'%"
				+ text1.getText().trim() + "%'");
		while (rs.next()) {
			id = rs.getInt("Ա����");
			name = rs.getString("����");
			sex = rs.getString("�Ա�");
			age = rs.getInt("����");
			position = rs.getString("ְλ");
			salary = rs.getInt("��н");
			Employee people = new Employee();
			people.setID(id);
			people.setName(name);
			people.setSex(sex);
			people.setAge(age);
			people.setPosition(position);
			people.setSalary(salary);

			list.add(people);

		}

		return list;

	}

	// ������ģ����ѯԱ����Ϣ����
	public static List SearchName(Text text2) throws SQLException {
		List list = new ArrayList();
		String name, sex, position;

		int id, age, salary;

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = DriverManager.getConnection("jdbc:odbc:ygDB");
		Statement sql = con.createStatement();

		ResultSet rs = sql.executeQuery("select * from Ա����Ϣ�� where ���� like'%"
				+ text2.getText().trim() + "%'");
		while (rs.next()) {
			id = rs.getInt("Ա����");
			name = rs.getString("����");
			sex = rs.getString("�Ա�");
			age = rs.getInt("����");
			position = rs.getString("ְλ");
			salary = rs.getInt("��н");
			Employee people = new Employee();
			people.setID(id);
			people.setName(name);
			people.setSex(sex);
			people.setAge(age);
			people.setPosition(position);
			people.setSalary(salary);

			list.add(people);

		}

		return list;

	}

	// ���Ա�ģ����ѯԱ����Ϣ����
	public static List SearchSex(Text text3) throws SQLException {
		List list = new ArrayList();
		String name, sex, position;

		int id, age, salary;

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = DriverManager.getConnection("jdbc:odbc:ygDB");
		Statement sql = con.createStatement();

		ResultSet rs = sql.executeQuery("select * from Ա����Ϣ�� where �Ա�='"
				+ text3.getText().trim() + "'");
		while (rs.next()) {
			id = rs.getInt("Ա����");
			name = rs.getString("����");
			sex = rs.getString("�Ա�");
			age = rs.getInt("����");
			position = rs.getString("ְλ");
			salary = rs.getInt("��н");
			Employee people = new Employee();
			people.setID(id);
			people.setName(name);
			people.setSex(sex);
			people.setAge(age);
			people.setPosition(position);
			people.setSalary(salary);

			list.add(people);

		}

		return list;

	}

	// ɾ��Ա����Ϣ����
	public boolean removeEmployee(Employee employee) throws SQLException {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:odbc:ygDB");

		Statement sql = con.createStatement();

		sql.executeUpdate("delete from  Ա����Ϣ�� where Ա����='" + employee.getID()
				+ "'");

		return true;

	}

}
