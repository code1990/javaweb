package org.eclipse.rcp.intro.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.rcp.intro.editor.model.Person;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class MyPersonEditorInput implements IEditorInput {

	private final Person person;

	public MyPersonEditorInput(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public Object getAdapter(Class adapter) {
		return null;
	}

	public boolean exists() {
		return false;
	}

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getName() {
		return person.toString();
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return person.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyPersonEditorInput other = (MyPersonEditorInput) obj;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

}
