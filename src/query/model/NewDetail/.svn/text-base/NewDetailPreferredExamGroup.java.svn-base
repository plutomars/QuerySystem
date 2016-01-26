package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約查詢基本資料 優體保單資料(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 *          100/07/28<br>
 * 
 * @since 1.0
 */
public class NewDetailPreferredExamGroup extends AbstractModelObject {
	private List<NewDetailPreferredExam> newDetailPreferredExams = new ArrayList<NewDetailPreferredExam>();

	public NewDetailPreferredExamGroup() {
	}

	public List<NewDetailPreferredExam> getNewDetailPreferredExams() {
		return newDetailPreferredExams;
	}

	public void setNewDetailPreferredExams(
			List<NewDetailPreferredExam> newDetailPreferredExams) {
		this.newDetailPreferredExams = newDetailPreferredExams;
	}

	public void addNewDetailPreferredExam(NewDetailPreferredExam newDetailComm) {
		List<NewDetailPreferredExam> oldValue = newDetailPreferredExams;
		newDetailPreferredExams = new ArrayList<NewDetailPreferredExam>(
				newDetailPreferredExams);
		newDetailPreferredExams.add(newDetailComm);

		firePropertyChange("newDetailPreferredExams", oldValue,
				newDetailPreferredExams);
	}

	public void removeNewDetailPreferredExam(
			NewDetailPreferredExam newDetailComm) {
		newDetailPreferredExams.remove(newDetailComm);
	}

	public void removeAll() {
		List<NewDetailPreferredExam> oldValue = newDetailPreferredExams;
		newDetailPreferredExams = new ArrayList<NewDetailPreferredExam>(
				newDetailPreferredExams);
		newDetailPreferredExams.clear();
		firePropertyChange("newDetailPreferredExams", oldValue,
				newDetailPreferredExams);
	}

	public int getNewDetailPreferredExamCount() {
		return newDetailPreferredExams.size();
	}

}
