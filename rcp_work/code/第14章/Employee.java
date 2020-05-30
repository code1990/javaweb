/**
 * @author: WangJinTao,MengQingChang 2006 
*/
package swtjfaceExample;

	public class Employee  {
		private int  id;

		private String name;

		private String sex;

		private int age;

		private String position;
        
		private int salary;
		 

		// 返回id
		public int getID() {
			return id;
		}

		// 设置id
		public void setID(int  id) {
			this.id = id;
		}

		// 返回name
		public String getName() {
			return name;
		}

		// 设置name
		public void setName(String name) {
			this.name = name;
		}

		// 返回male
		public String getSex() {
			return sex;
		}

		// 设置 male
		public void setSex(String sex) {
			this.sex=sex;
		}

		// 设置age
		public int getAge() {
			return age;
		}

		// 返回age
		public void setAge(int age) {
			this.age = age;
		}

		// 返回position
		public String getPosition() {
			return position;
		}

		// 设置position
		public void setPosition(String position) {
			this.position = position;
		}

		// 返回color
		public int  getSalary() {
			return salary;
		}

		// 设置color
		public void setSalary(int salary) {
			this.salary = salary;
		}

	}