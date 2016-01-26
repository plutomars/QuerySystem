package query.model.NewDetail;

import java.util.ArrayList;
import java.util.List;

import query.model.AbstractModelObject;

/**
 * 新契約查詢公會索引Group
 * 
 * @author epf
 * 
 */
public class NewDetailNewAssoIndexGroup extends AbstractModelObject {
	private List<NewDetailNewAssoIndex> newDetailNewAssoIndexs = new ArrayList<NewDetailNewAssoIndex>();

	public NewDetailNewAssoIndexGroup() {
	}

	public List<NewDetailNewAssoIndex> getNewDetailNewAssoIndexs() {
		return newDetailNewAssoIndexs;
	}

	public void setNewDetailNewAssoIndexs(
			List<NewDetailNewAssoIndex> newDetailNewAssoIndexs) {
		this.newDetailNewAssoIndexs = newDetailNewAssoIndexs;
	}

	public void addNewDetailNewAssoIndex(
			NewDetailNewAssoIndex newDetailNewAssoIndex) {
		List<NewDetailNewAssoIndex> oldValue = newDetailNewAssoIndexs;
		newDetailNewAssoIndexs = new ArrayList<NewDetailNewAssoIndex>(
				newDetailNewAssoIndexs);
		newDetailNewAssoIndexs.add(newDetailNewAssoIndex);

		firePropertyChange("newDetailNewAssoIndexs", oldValue,
				newDetailNewAssoIndexs);
	}

	public void removeNewDetailNewAssoIndex(
			NewDetailNewAssoIndex newDetailNewAssoIndex) {
		newDetailNewAssoIndexs.remove(newDetailNewAssoIndex);
	}

	public void removeAll() {
		List<NewDetailNewAssoIndex> oldValue = newDetailNewAssoIndexs;
		newDetailNewAssoIndexs = new ArrayList<NewDetailNewAssoIndex>(
				newDetailNewAssoIndexs);
		newDetailNewAssoIndexs.clear();
		firePropertyChange("newDetailNewAssoIndexs", oldValue,
				newDetailNewAssoIndexs);
	}

	public int getNewDetailNewAssoIndexCount() {
		return newDetailNewAssoIndexs.size();
	}

}
