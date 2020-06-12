package chapter12;

import org.eclipse.swt.graphics.RGB;

public class People {
	private int id;

	private String name;

	private boolean male;

	private int age;

	private String position;

	private RGB color;

	// 返回id
	public int getID() {
		return id;
	}

	// 设置id
	public void setID(int id) {
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
	public boolean getMale() {
		return male;
	}

	// 设置 male
	public void setMale(boolean male) {
		this.male = male;
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
	public RGB getColor() {
		return color;
	}

	// 设置color
	public void setColor(RGB color) {
		this.color = color;
	}

}
