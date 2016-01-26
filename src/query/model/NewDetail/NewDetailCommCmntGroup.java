package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * §åµù¸ê®Æ¸s²Õ(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailCommCmntGroup extends AbstractModelObject {
	private List<NewDetailCommCmnt> newDetailCommCmnts = new ArrayList<NewDetailCommCmnt>();

	public NewDetailCommCmntGroup() {
	}

	public List<NewDetailCommCmnt> getNewDetailCommCmnts() {
		return newDetailCommCmnts;
	}

	public void setNewDetailCommCmnts(List<NewDetailCommCmnt> newDetailCommCmnts) {
		this.newDetailCommCmnts = newDetailCommCmnts;
	}

	public void addNewDetailCommCmnt(NewDetailCommCmnt newDetailCommCmnt) {
		List<NewDetailCommCmnt> oldValue = newDetailCommCmnts;
		newDetailCommCmnts = new ArrayList<NewDetailCommCmnt>(
				newDetailCommCmnts);
		newDetailCommCmnts.add(newDetailCommCmnt);

		firePropertyChange("newDetailCommCmnts", oldValue, newDetailCommCmnts);
	}

	public void removeNewDetailCommCmnt(NewDetailCommCmnt newDetailCommCmnt) {
		newDetailCommCmnts.remove(newDetailCommCmnt);
	}

	public void removeAll() {
		List<NewDetailCommCmnt> oldValue = newDetailCommCmnts;
		newDetailCommCmnts = new ArrayList<NewDetailCommCmnt>(
				newDetailCommCmnts);
		newDetailCommCmnts.clear();
		firePropertyChange("newDetailCommCmnts", oldValue, newDetailCommCmnts);
	}

	public int getNewDetailCommCmntCount() {
		return newDetailCommCmnts.size();
	}

}
