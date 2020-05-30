/**
 * @author: WangJinTao,MengQingChang 2006 
 */
package swtjfaceExample;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.widgets.*;

public class DbOperate {
	// 查询员工基本信息操作
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

			ResultSet rs = sql.executeQuery("select * from 员工信息表");
			while (rs.next()) {
				id = rs.getInt("员工号");
				name = rs.getString("姓名");
				sex = rs.getString("性别");
				age = rs.getInt("年龄");
				position = rs.getString("职位");
				salary = rs.getInt("月薪");
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

	// 按员工号模糊查询员工信息操作
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

		ResultSet rs = sql.executeQuery("select * from 员工信息表 where 员工号 like'%"
				+ text1.getText().trim() + "%'");
		while (rs.next()) {
			id = rs.getInt("员工号");
			name = rs.getString("姓名");
			sex = rs.getString("性别");
			age = rs.getInt("年龄");
			position = rs.getString("职位");
			salary = rs.getInt("月薪");
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

	// 按姓名模糊查询员工信息操作
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

		ResultSet rs = sql.executeQuery("select * from 员工信息表 where 姓名 like'%"
				+ text2.getText().trim() + "%'");
		while (rs.next()) {
			id = rs.getInt("员工号");
			name = rs.getString("姓名");
			sex = rs.getString("性别");
			age = rs.getInt("年龄");
			position = rs.getString("职位");
			salary = rs.getInt("月薪");
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

	// 按性别模糊查询员工信息操作
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

		ResultSet rs = sql.executeQuery("select * from 员工信息表 where 性别='"
				+ text3.getText().trim() + "'");
		while (rs.next()) {
			id = rs.getInt("员工号");
			name = rs.getString("姓名");
			sex = rs.getString("性别");
			age = rs.getInt("年龄");
			position = rs.getString("职位");
			salary = rs.getInt("月薪");
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

	// 删除员工信息操作
	public boolean removeEmployee(Employee employee) throws SQLException {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:odbc:ygDB");

		Statement sql = con.createStatement();

		sql.executeUpdate("delete from  员工信息表 where 员工号='" + employee.getID()
				+ "'");

		return true;

	}

}
