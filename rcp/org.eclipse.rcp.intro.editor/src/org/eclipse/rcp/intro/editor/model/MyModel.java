package org.eclipse.rcp.intro.editor.model;

import java.util.ArrayList;
import java.util.List;

public class MyModel {
	private List<Person> persons = new ArrayList<Person>();

	public List<Person> getPersons() {
		return persons;
	}

	public MyModel() {
		Person person = new Person("Lars", "Vogel");
		person.setAddress(new Address());
		person.getAddress().setCountry("Germany");
		persons.add(person);
		person = new Person("Jim", "Knopf");
		person.setAddress(new Address());
		person.getAddress().setCountry("Germany");
		persons.add(person);
	}

}
