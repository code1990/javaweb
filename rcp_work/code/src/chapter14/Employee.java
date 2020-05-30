/**
 * @author: WangJinTao,MengQingChang 2006 
*/
package chapter14;

	public class Employee  {
		private int  id;

		private String name;

		private String sex;

		private int age;

		private String position;
        
		private int salary;
		 

		// ����id
		public int getID() {
			return id;
		}

		// ����id
		public void setID(int  id) {
			this.id = id;
		}

		// ����name
		public String getName() {
			return name;
		}

		// ����name
		public void setName(String name) {
			this.name = name;
		}

		// ����male
		public String getSex() {
			return sex;
		}

		// ���� male
		public void setSex(String sex) {
			this.sex=sex;
		}

		// ����age
		public int getAge() {
			return age;
		}

		// ����age
		public void setAge(int age) {
			this.age = age;
		}

		// ����position
		public String getPosition() {
			return position;
		}

		// ����position
		public void setPosition(String position) {
			this.position = position;
		}

		// ����color
		public int  getSalary() {
			return salary;
		}

		// ����color
		public void setSalary(int salary) {
			this.salary = salary;
		}

	}