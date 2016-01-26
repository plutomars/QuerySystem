package query.model.Contact;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @author fyyang<br>
 *         100/10/04
 * 
 */
public class ContactGroups extends AbstractModelObject {
	private List<ContactGroup> m_groups = new ArrayList<ContactGroup>();
	private List<String> groupnames = new ArrayList<String>();

	public void addGroup(ContactGroup group) {
		List<ContactGroup> oldValue = m_groups;
		m_groups = new ArrayList<ContactGroup>(m_groups);
		m_groups.add(group);

		List<String> oldValue2 = groupnames;
		groupnames = new ArrayList<String>(groupnames);
		groupnames.add(group.getName());

		firePropertyChange("groups", oldValue, m_groups);
		firePropertyChange("groupnames", oldValue2, groupnames);
	}

	public void removeGroup(ContactGroup group) {
		List<ContactGroup> oldValue = m_groups;
		m_groups = new ArrayList<ContactGroup>(m_groups);
		m_groups.remove(group);

		List<String> oldValue2 = groupnames;
		groupnames = new ArrayList<String>(groupnames);
		groupnames.remove(group.getName());

		firePropertyChange("groups", oldValue, m_groups);
		firePropertyChange("groupnames", oldValue2, groupnames);
	}

	public void removeAll() {
		List<ContactGroup> oldValue = m_groups;
		m_groups = new ArrayList<ContactGroup>(m_groups);
		m_groups.clear();

		List<String> oldValue2 = groupnames;
		groupnames = new ArrayList<String>(groupnames);
		groupnames.clear();

		firePropertyChange("groups", oldValue, m_groups);
		firePropertyChange("groupnames", oldValue2, groupnames);
	}

	public List<ContactGroup> getGroups() {
		return m_groups;
	}

	public List<String> getGroupnames() {
		return groupnames;
	}
}