package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 體檢照會資料群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class NewDetailExamNoticeGroup extends AbstractModelObject {
	private List<NewDetailExamNotice> newDetailExamNotices = new ArrayList<NewDetailExamNotice>();

	public NewDetailExamNoticeGroup() {
	}

	public List<NewDetailExamNotice> getNewDetailExamNotices() {
		return newDetailExamNotices;
	}

	public void setNewDetailExamNotices(
			List<NewDetailExamNotice> newDetailExamNotices) {
		this.newDetailExamNotices = newDetailExamNotices;
	}

	public void addNewDetailExamNotice(NewDetailExamNotice newDetailExamNotice) {
		List<NewDetailExamNotice> oldValue = newDetailExamNotices;
		newDetailExamNotices = new ArrayList<NewDetailExamNotice>(
				newDetailExamNotices);
		newDetailExamNotices.add(newDetailExamNotice);

		firePropertyChange("newDetailExamNotices", oldValue,
				newDetailExamNotices);
	}

	public void removeNewDetailExamNotice(
			NewDetailExamNotice newDetailExamNotice) {
		newDetailExamNotices.remove(newDetailExamNotice);
	}

	public void removeAll() {
		List<NewDetailExamNotice> oldValue = newDetailExamNotices;
		newDetailExamNotices = new ArrayList<NewDetailExamNotice>(
				newDetailExamNotices);
		newDetailExamNotices.clear();
		firePropertyChange("newDetailExamNotices", oldValue,
				newDetailExamNotices);
	}

	public int getNewDetailExamNoticeCount() {
		return newDetailExamNotices.size();
	}

}
