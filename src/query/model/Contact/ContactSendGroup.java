package query.model.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import query.model.AbstractModelObject;

/**
 * @author fyyang<br>
 *         100/10/27
 * 
 */
public class ContactSendGroup extends AbstractModelObject {
	private List<ContactSend> groups = new ArrayList<ContactSend>();
	private Map<String, String> ipMap = new HashMap<String, String>();

	public void addGroup(ContactSend group) {
		if (ipMap.containsKey(group.getId()))
			return;
		else
			ipMap.put(group.getId(), group.getName());
		List<ContactSend> oldValue = groups;
		groups = new ArrayList<ContactSend>(groups);
		groups.add(group);

		firePropertyChange("groups", oldValue, groups);
	}

//	public void removeGroup(ContactSend group) {
//		List<ContactSend> oldValue = groups;
//		groups = new ArrayList<ContactSend>(groups);
//		groups.remove(group);
//
//		firePropertyChange("groups", oldValue, groups);
//	}

	public void removeAll() {
		ipMap.clear();
		List<ContactSend> oldValue = groups;
		groups = new ArrayList<ContactSend>(groups);
		groups.clear();
		firePropertyChange("groups", oldValue, groups);
	}

	public List<ContactSend> getGroups() {
		return groups;
	}
}