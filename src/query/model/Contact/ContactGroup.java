package query.model.Contact;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @author fyyang<br>
 * 		   100/10/04
 * 
 */
public class ContactGroup extends AbstractModelObject {
	private List<Contact> m_persons = new ArrayList<Contact>();
	private String m_name;
	private String m_id;

	public ContactGroup() {
	}

	public ContactGroup(String id, String name) {
		m_name = name;
		m_id = id;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		String oldValue = m_name;
		m_name = name;
		firePropertyChange("name", oldValue, m_name);
	}

	public String getId() {
		return m_id;
	}

	public void setId(String id) {
		String oldValue = m_id;
		m_id = id;
		firePropertyChange("id", oldValue, m_id);
	}

	public void addPerson(Contact person) {
		List<Contact> oldValue = m_persons;
		m_persons = new ArrayList<Contact>(m_persons);
		m_persons.add(person);
		firePropertyChange("persons", oldValue, m_persons);
		firePropertyChange("personCount", oldValue.size(), m_persons.size());
	}

	public void removePerson(Contact person) {
		List<Contact> oldValue = m_persons;
		m_persons = new ArrayList<Contact>(m_persons);
		m_persons.remove(person);
		firePropertyChange("persons", oldValue, m_persons);
		firePropertyChange("personCount", oldValue.size(), m_persons.size());
	}

	public List<Contact> getPersons() {
		return m_persons;
	}

	public int getPersonCount() {
		return m_persons.size();
	}
}