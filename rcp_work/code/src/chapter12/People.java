/**
 * @author: WangJinTao,MengQingChang 2006
 */
package chapter12;

import org.eclipse.swt.graphics.RGB;

public class People {
	private Integer id;

	private String name;

	private boolean male;

	private Integer age;

	private String position;

	private RGB color;

	// ����id
	public Integer getID() {
		return id;
	}

	// ����id
	public void setID(Integer id) {
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
	public boolean getMale() {
		return male;
	}

	// ���� male
	public void setMale(boolean male) {
		this.male = male;
	}

	// ����age
	public Integer getAge() {
		return age;
	}

	// ����age
	public void setAge(Integer age) {
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
	public RGB getColor() {
		return color;
	}

	// ����color
	public void setColor(RGB color) {
		this.color = color;
	}

}