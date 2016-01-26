package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 簽收單查詢bean群組
 * 
 * @author epf
 * @version 1.0<br>
 * 
 * @since 100/10/14
 */
public class NewDetailSignPaperGroup extends AbstractModelObject {
	private List<NewDetailSignPaper> newDetailSignPapers = new ArrayList<NewDetailSignPaper>();

	public NewDetailSignPaperGroup() {
	}

	public List<NewDetailSignPaper> getNewDetailSignPapers() {
		return newDetailSignPapers;
	}

	public void setNewDetailSignPapers(
			List<NewDetailSignPaper> newDetailSignPapers) {
		this.newDetailSignPapers = newDetailSignPapers;
	}

	public void addNewDetailSignPaper(NewDetailSignPaper newComm) {
		List<NewDetailSignPaper> oldValue = newDetailSignPapers;
		newDetailSignPapers = new ArrayList<NewDetailSignPaper>(
				newDetailSignPapers);
		newDetailSignPapers.add(newComm);

		firePropertyChange("newDetailSignPapers", oldValue, newDetailSignPapers);
	}

	public void removeNewDetailSignPaper(NewDetailSignPaper newComm) {
		newDetailSignPapers.remove(newComm);
	}

	public void removeAll() {
		List<NewDetailSignPaper> oldValue = newDetailSignPapers;
		newDetailSignPapers = new ArrayList<NewDetailSignPaper>(
				newDetailSignPapers);
		newDetailSignPapers.clear();
		firePropertyChange("newDetailSignPapers", oldValue, newDetailSignPapers);
	}

	public int getNewDetailSignPaperCount() {
		return newDetailSignPapers.size();
	}

}
