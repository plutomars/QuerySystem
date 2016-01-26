package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約明細照會項目群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailNoticeGroup extends AbstractModelObject {
	private List<NewDetailNotice> newDetailNotices = new ArrayList<NewDetailNotice>();

	public NewDetailNoticeGroup() {
	}

	public List<NewDetailNotice> getNewDetailNotices() {
		return newDetailNotices;
	}

	public void setNewDetailNotices(List<NewDetailNotice> newDetailNotices) {
		this.newDetailNotices = newDetailNotices;
	}

	public void addNewDetailNotice(NewDetailNotice newDetailNotice) {
		List<NewDetailNotice> oldValue = newDetailNotices;
		newDetailNotices = new ArrayList<NewDetailNotice>(newDetailNotices);
		newDetailNotices.add(newDetailNotice);

		firePropertyChange("newDetailNotices", oldValue, newDetailNotices);
	}

	public void removeNewDetailNotice(NewDetailNotice newDetailNotice) {
		newDetailNotices.remove(newDetailNotice);
	}

	public void removeAll() {
		List<NewDetailNotice> oldValue = newDetailNotices;
		newDetailNotices = new ArrayList<NewDetailNotice>(newDetailNotices);
		newDetailNotices.clear();
		firePropertyChange("newDetailNotices", oldValue, newDetailNotices);
	}

	public int getNewDetailNoticeCount() {
		return newDetailNotices.size();
	}

}
