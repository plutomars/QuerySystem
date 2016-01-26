package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約明細理賠記錄群組(JavaBean)
 * 
 * @author epf
 * 
 * @version 1.0<br>
 * @since 1.0
 */
public class NewDetailClaimHistoryGroup extends AbstractModelObject {
	private List<NewDetailClaimHistory> newDetailClaimHistorys = new ArrayList<NewDetailClaimHistory>();

	public NewDetailClaimHistoryGroup() {
	}

	public List<NewDetailClaimHistory> getNewDetailClaimHistorys() {
		return newDetailClaimHistorys;
	}

	public void setNewDetailClaimHistorys(
			List<NewDetailClaimHistory> newDetailClaimHistorys) {
		this.newDetailClaimHistorys = newDetailClaimHistorys;
	}

	public void addNewDetailClaimHistory(
			NewDetailClaimHistory newDetailClaimHistory) {
		List<NewDetailClaimHistory> oldValue = newDetailClaimHistorys;
		newDetailClaimHistorys = new ArrayList<NewDetailClaimHistory>(
				newDetailClaimHistorys);
		newDetailClaimHistorys.add(newDetailClaimHistory);

		firePropertyChange("newDetailClaimHistorys", oldValue,
				newDetailClaimHistorys);
	}

	public void removeNewDetailClaimHistory(
			NewDetailClaimHistory newDetailClaimHistory) {
		newDetailClaimHistorys.remove(newDetailClaimHistory);
	}

	public void removeAll() {
		List<NewDetailClaimHistory> oldValue = newDetailClaimHistorys;
		newDetailClaimHistorys = new ArrayList<NewDetailClaimHistory>(
				newDetailClaimHistorys);
		newDetailClaimHistorys.clear();
		firePropertyChange("newDetailClaimHistorys", oldValue,
				newDetailClaimHistorys);
	}

	public int getNewDetailClaimHistoryCount() {
		return newDetailClaimHistorys.size();
	}

}
