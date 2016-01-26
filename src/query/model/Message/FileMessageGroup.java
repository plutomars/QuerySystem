package query.model.Message;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * @author fyyang<br>
 *         100/11/01
 * 
 */
public class FileMessageGroup extends AbstractModelObject {
	private List<FileMessage> groups = new ArrayList<FileMessage>();

	public void addGroup(FileMessage group) {
		List<FileMessage> oldValue = groups;
		groups = new ArrayList<FileMessage>(groups);
		groups.add(group);

		firePropertyChange("groups", oldValue, groups);
	}

	public void removeGroup(FileMessage group) {
		List<FileMessage> oldValue = groups;
		groups = new ArrayList<FileMessage>(groups);
		groups.remove(group);

		firePropertyChange("groups", oldValue, groups);
	}

	public void removeAll() {
		List<FileMessage> oldValue = groups;
		groups = new ArrayList<FileMessage>(groups);
		groups.clear();
		firePropertyChange("groups", oldValue, groups);
	}

	public List<FileMessage> getGroups() {
		return groups;
	}
}